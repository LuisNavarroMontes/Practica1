package com.lnavmon.practica1.iu.favourites

import androidx.lifecycle.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.lnavmon.practica1.data.favourites.FavouritesRepository
import com.lnavmon.practica1.databinding.QuotationItemBinding
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FavouritesViewModel(private val favouritesRepository: FavouritesRepository, private val binding: QuotationItemBinding) : ViewModel() {

    val isDeleteAllVisible = favouritesRepository.getAllFavourites().map{ it.isNotEmpty() }

    fun bind(quotation: Quotation) {
        binding.tvAutorCitaFav.text = quotation.autor
        binding.tvTextoCitaFav.text = quotation.nombre
    }
    private val _error = MutableLiveData<Throwable?>()
    val error: LiveData<Throwable?> = _error

    fun resetError() {
        _error.value = null
    }

    val favoriteQuotations: LiveData<List<Quotation>> =
        favouritesRepository.getAllFavourites().asLiveData()

    fun deleteAllQuotations() {
        viewModelScope.launch {
            try {
                favouritesRepository.deleteAllFavourites()
                favoriteQuotations.value = emptyList()
            } catch (e: Exception) {
                _error.value = e
            }
        }
    }



    fun deleteQuotationAtPosition(position: Int) {
        viewModelScope.launch {
            try {
                favoriteQuotations.value?.let { favourites ->
                    favouritesRepository.deleteFavourite(favourites[position])
                }
            } catch (e: Exception) {
                _error.value = e
            }
        }
    }


}