package com.lnavmon.practica1.iu.newquotation

import androidx.lifecycle.*
import com.lnavmon.practica1.data.newquotation.NewQuotationRepository
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationViewModel @Inject constructor(
    private val newQuotationRepository: NewQuotationRepository) : ViewModel() {

    private val _error = MutableLiveData<Throwable?>()
    val error: LiveData<Throwable?> = _error

    fun resetError() {
        _error.value = null
    }

    private val _userName = MutableLiveData<String>().apply {
        value = getUserName()
    }

    private fun getUserName(): String {
        return setOf("Alice", "Bob", "Charlie", "David", "Emma").random()
    }
    val userName: LiveData<String>
        get() = _userName

    private val _quotation = MutableLiveData<Quotation>()
    val quotation: LiveData<Quotation>
        get() = _quotation

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val isGreetingsVisible = Transformations.map(quotation) { it == null }

    private val _isRefreshing = MutableLiveData<Boolean>().apply {
        value = false
    }
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing
    // Propiedad privada que almacena la visibilidad del botón flotante
    private val _isFabVisible = MutableLiveData(false)

    // Propiedad pública que se expone como LiveData para observar cambios en la visibilidad del botón flotante
    val isFabVisible: LiveData<Boolean>
        get() = _isFabVisible


    fun getNewQuotation() {
        _isRefreshing.value = true
        viewModelScope.launch {
            newQuotationRepository.getNewQuotation().fold(
                onSuccess = { quotation ->
                    _quotation.value = quotation
                },
                onFailure = { throwable ->
                    _error.value = throwable
                }
            )
        }
        _isRefreshing.value = false
        _isFabVisible.value = true
    }

    fun addToFavorites(){
        _isFabVisible.value = false
    }
}