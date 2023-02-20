package com.lnavmon.practica1.iu.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lnavmon.practica1.R
import com.lnavmon.practica1.databinding.FragmentNewQuotationBinding
import com.lnavmon.practica1.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _buinding: FragmentSettingsBinding? = null
    private val binding get()= _buinding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _buinding = FragmentSettingsBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _buinding = null
    }
}