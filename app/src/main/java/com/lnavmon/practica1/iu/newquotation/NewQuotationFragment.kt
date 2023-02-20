package com.lnavmon.practica1.iu.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lnavmon.practica1.R
import com.lnavmon.practica1.databinding.FragmentNewQuotationBinding

class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation) {
    private var _buinding: FragmentNewQuotationBinding? = null
    private val binding get()= _buinding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _buinding = FragmentNewQuotationBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _buinding = null
    }
}