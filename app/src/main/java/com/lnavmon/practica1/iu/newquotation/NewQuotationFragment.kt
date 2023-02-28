package com.lnavmon.practica1.iu.newquotation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lnavmon.practica1.R
import com.lnavmon.practica1.databinding.FragmentNewQuotationBinding

class NewQuotationFragment : Fragment(R.layout.fragment_new_quotation) {
    private var _buinding : FragmentNewQuotationBinding? = null
    private val binding get()= _buinding!!
    private val viewModel: NewQuotationViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _buinding = FragmentNewQuotationBinding.bind(view)
        viewModel.userName.observe(viewLifecycleOwner) {
            userName->
            binding.tvGreetings.text = getString(R.string.greetings, userName)
        }
        binding.tvGreetings.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE

        viewModel.isRefreshing.observe(viewLifecycleOwner) {
                isRefreshing->
            binding.swipeToRefresh.isRefreshing = isRefreshing
        }

        binding.swipeToRefresh.setOnRefreshListener {
            getNewQuotation()
        }
        viewModel.userName.observe(viewLifecycleOwner) { author ->
            binding.tvAuthor.text = if (author.isEmpty()) "Anonymous" else author
        }

        viewModel.isFabVisible.observe(viewLifecycleOwner) { isVisible ->
            binding.btnFlotante.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
        }
        binding.btnFlotante.setOnClickListener {
            viewModel.addToFavorites()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun getNewQuotation(){
        viewModel.getNewQuotation()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _buinding = null
    }
}