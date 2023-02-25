package com.lnavmon.practica1.iu.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.lnavmon.practica1.iu.domain.model.Quotation

class NewQuotationViewModel : ViewModel(){
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
        val num = (0..99).random().toString()
        val newQuotation = Quotation(num, "Quotation text #$num", "Author #$num")
        _quotation.value = newQuotation
        _isRefreshing.value = false
        _isFabVisible.value = true
    }

    fun addToFavorites(){
        _isFabVisible.value = false
    }
}