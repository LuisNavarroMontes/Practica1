package com.lnavmon.practica1.iu.favourites


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import com.lnavmon.practica1.databinding.QuotationItemBinding
import com.lnavmon.practica1.iu.domain.model.Quotation

class QuotationListAdapter(private val itemClickedListener:ItemClicked) :
    ListAdapter<Quotation, QuotationListAdapter.ViewHolder>(QuotationDiff()) {

    class ViewHolder(private val binding: QuotationItemBinding,  private val itemClickedListener:ItemClicked) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {view->
                itemClickedListener.onClick(binding.tvAutorCitaFav.text.toString())
            }
        }

            fun bind(quotation: Quotation) {
                binding.tvAutorCitaFav.text = quotation.autor
                binding.tvTextoCitaFav.text = quotation.nombre
            }





    }

    class QuotationDiff : DiffUtil.ItemCallback<Quotation>() {
        override fun areItemsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem.identificador == newItem.identificador && oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Quotation, newItem: Quotation): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuotationListAdapter.ViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var binding = QuotationItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, itemClickedListener)
    }

    override fun onBindViewHolder(holder: QuotationListAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

    interface ItemClicked {
        fun onClick(author:String)
    }
