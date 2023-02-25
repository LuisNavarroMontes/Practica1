package com.lnavmon.practica1.iu.favourites

import androidx.lifecycle.*
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.lnavmon.practica1.databinding.QuotationItemBinding
import com.lnavmon.practica1.iu.domain.model.Quotation

class FavouritesViewModel(private val binding: QuotationItemBinding): ViewModel() {

    private var favoriteQuotations = MutableLiveData<List<Quotation>>()
    private val EINSTEIN_QUOTE = "La imaginación es más importante que el conocimiento."
    private val ANONYMOUS_QUOTE = "La vida es como una caja de chocolates, nunca sabes lo que te va a tocar."

    init {
        favoriteQuotations.value = getFavoriteQuotations()
    }
    val isDeleteAllVisible = Transformations.map(favoriteQuotations) { it.isNotEmpty() }


    fun bind(quotation: Quotation) {
        binding.tvAutorCitaFav.text = quotation.autor
        binding.tvTextoCitaFav.text = quotation.nombre
    }

    private fun getFavoriteQuotations(): List<Quotation> {
        val quotations = mutableListOf<Quotation>()
        for (i in 1..20) {
            val author = "Author $i"
            val quote = "Quote $i"
            val identificador = "Identificador $i"
            quotations.add(Quotation(identificador,author, quote))

        }
        quotations.add(Quotation("21","Albert Einstein", EINSTEIN_QUOTE))
        quotations.add(Quotation("22","Anonymous", ANONYMOUS_QUOTE))
        return quotations
    }
    val favoriteQuotationsLiveData: LiveData<List<Quotation>>
        get() = favoriteQuotations

    fun deleteAllQuotations() {
        favoriteQuotations.value = mutableListOf()
    }
    fun deleteQuotationAtPosition(position: Int) {
        favoriteQuotations.value ?.let { favourites ->
            val mutableFavourites = favourites.toMutableList()
            mutableFavourites.removeAt(position)
            favoriteQuotations.value  = mutableFavourites
        }
    }


}