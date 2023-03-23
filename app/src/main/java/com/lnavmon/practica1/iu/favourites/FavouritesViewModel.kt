package com.lnavmon.practica1.iu.favourites

import androidx.lifecycle.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.lnavmon.practica1.data.favourites.FavouritesRepository
import com.lnavmon.practica1.databinding.QuotationItemBinding
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.flow.map

class FavouritesViewModel(private val favouritesRepository: FavouritesRepository, private val binding: QuotationItemBinding) : ViewModel() {

    val isDeleteAllVisible = favouritesRepository.getAllFavourites().map{ it.isNotEmpty() }

    fun bind(quotation: Quotation) {
        binding.tvAutorCitaFav.text = quotation.autor
        binding.tvTextoCitaFav.text = quotation.nombre
    }

    val favoriteQuotationsLiveData: LiveData<List<Quotation>> = favouritesRepository.getAllFavourites().asLiveData()

    /*fun deleteAllQuotations() {
        favoriteQuotations.value = mutableListOf()
    }
    fun deleteQuotationAtPosition(position: Int) {
        favoriteQuotations.value ?.let { favourites ->
            val mutableFavourites = favourites.toMutableList()
            mutableFavourites.removeAt(position)
            favoriteQuotations.value  = mutableFavourites
        }
    }*/


}