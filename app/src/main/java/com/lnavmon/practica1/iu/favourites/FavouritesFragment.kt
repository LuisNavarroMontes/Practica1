package com.lnavmon.practica1.iu.favourites

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.lnavmon.practica1.R
import com.lnavmon.practica1.databinding.FragmentFavouritesBinding
import com.lnavmon.practica1.databinding.FragmentNewQuotationBinding



class FavouritesFragment : Fragment(R.layout.fragment_favourites),
    DeleteAllDialogFragment.DeleteAllDialogListener, MenuProvider, ItemClicked {
    private var _buinding: FragmentFavouritesBinding? = null
    private val binding get()= _buinding!!
    private val viewModel: FavouritesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _buinding = FragmentFavouritesBinding.bind(view)
        var adaptador = QuotationListAdapter(this)
        binding.favouritesRecyclerView.adapter = adaptador
        viewModel.isDeleteAllVisible.observe(viewLifecycleOwner) {
            requireActivity().invalidateOptionsMenu()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _buinding = null
    }

    override fun onPositiveClick() {
        viewModel.deleteAllQuotations()
    }

    override fun onNegativeClick() {

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_favourites, menu)

    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

        return when (menuItem.itemId) {
            R.id.deleteQuotations -> {
                DeleteAllDialogFragment(this).show(childFragmentManager, null)
                true
            }
            else -> false
        }
    }

    override fun onPrepareMenu(menu: Menu) {
        val deleteAllMenuItem = menu.findItem(R.id.deleteQuotations)
        deleteAllMenuItem.isVisible = viewModel.isDeleteAllVisible.value ?: false

    }

    override fun onClick(author: String) {
        if (author == "Anonymous") {
            Snackbar.make(requireView(), "Cannot show information for Anonymous authors", Snackbar.LENGTH_SHORT).show()
        } else {
            val url = "https://en.wikipedia.org/wiki/Special:Search?search=$author"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Snackbar.make(requireView(), "Cannot perform the requested action", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
    val simpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.END) {

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            // Devuelve falso para deshabilitar el gesto de drag
            return false
        }

        override fun isLongPressDragEnabled(): Boolean {
            // Devuelve falso para deshabilitar el gesto de drag
            return false
        }

        override fun isItemViewSwipeEnabled(): Boolean {
            // Devuelve true para habilitar el gesto de swipe
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            // Ejecuta el método deleteQuotationAtPosition() del ViewModel pasando la posición del adaptador
            val position = viewHolder.adapterPosition
            viewModel.deleteQuotationAtPosition(position)
        }
    }


}