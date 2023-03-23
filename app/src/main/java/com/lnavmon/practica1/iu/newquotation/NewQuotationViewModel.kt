package com.lnavmon.practica1.iu.newquotation

import androidx.lifecycle.*
import com.lnavmon.practica1.data.favourites.FavouritesRepository
import com.lnavmon.practica1.data.newquotation.NewQuotationManager
import com.lnavmon.practica1.data.newquotation.NewQuotationRepository
import com.lnavmon.practica1.data.settings.SettingsRepository
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewQuotationViewModel @Inject constructor(
    private val newQuotationManager: NewQuotationManager,
    private val settingsRepository: SettingsRepository,
    private val favouritesRepository: FavouritesRepository
) : ViewModel() {

    private val _error = MutableLiveData<Throwable?>()
    val error: LiveData<Throwable?> = _error

    fun resetError() {
        _error.value = null
    }

    val userName: LiveData<String> = settingsRepository.getUsername().asLiveData()

    private val _quotation = MutableLiveData<Quotation>()
    val quotation: LiveData<Quotation>
        get() = _quotation

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val isGreetingsVisible = quotation.map() {  it.identificador.isEmpty() }

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
            newQuotationManager.getNewQuotation().fold(
                onSuccess = { quotation ->
                    _quotation.value = quotation
                },
                onFailure = { throwable ->
                    _error.value = throwable
                }
            )
            _isRefreshing.value = false
            _isFabVisible.value = true
        }
    }

    fun addToFavorites(){
        viewModelScope.launch {
            try {
                favouritesRepository.addFavourite(quotation.value!!)
                _isFabVisible.value = false
            } catch (e: Exception) {
                _error.value = e
            }
        }
    }

}