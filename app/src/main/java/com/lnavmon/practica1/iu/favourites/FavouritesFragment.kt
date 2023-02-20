package com.lnavmon.practica1.iu.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lnavmon.practica1.R
import com.lnavmon.practica1.databinding.FragmentFavouritesBinding
import com.lnavmon.practica1.databinding.FragmentNewQuotationBinding

class FavouritesFragment : Fragment(R.layout.fragment_favourites) {
    private var _buinding: FragmentFavouritesBinding? = null
    private val binding get()= _buinding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _buinding = FragmentFavouritesBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _buinding = null
    }
}