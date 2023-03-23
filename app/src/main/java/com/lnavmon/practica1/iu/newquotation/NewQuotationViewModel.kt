package com.lnavmon.practica1.iu.newquotation

import androidx.lifecycle.*
import com.lnavmon.practica1.data.favourites.FavouritesRepository
import com.lnavmon.practica1.data.newquotation.NewQuotationManager
import com.lnavmon.practica1.data.newquotation.NewQuotationRepository
import com.lnavmon.practica1.data.settings.SettingsRepository
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

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

    val isAddToFavouritesVisible = quotation.switchMap() { newQuotation ->
        favouritesRepository.getFavouriteById(newQuotation.identificador.toLong()).asLiveData()
    }.map() { favourite ->
        favourite == null
    }

    fun getNewQuotation() {
        _isRefreshing.value = true
        viewModelScope.launch {
            val random = Random.nextInt(2)
            if (random == 0) {
                newQuotationManager.getNewQuotation().fold(
                    onSuccess = { quotation ->
                        _quotation.value = quotation
                    },
                    onFailure = { throwable ->
                        _error.value = throwable
                    }
                )
            } else {
                val manualQuotation = Quotation(
                    identificador = "manualQuotation",
                    nombre = "Esta es una cita creada manualmente",
                    autor = "Yo mismo"
                )
                _quotation.value = manualQuotation
            }
            _isRefreshing.value = false
        }
    }


    fun addToFavorites(){
        viewModelScope.launch {
            try {
                favouritesRepository.addFavourite(quotation.value!!)
            } catch (e: Exception) {
                _error.value = e
            }
        }
    }

}