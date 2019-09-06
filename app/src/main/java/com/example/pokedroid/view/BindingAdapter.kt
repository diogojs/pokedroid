package com.example.pokedroid.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindingAdapter<T, B>(private val layoutId: Int) :
    RecyclerView.Adapter<BindingViewHolder<B>>() where B : ViewDataBinding {
    private var data: List<T> = emptyList()
    private var filteredData: List<T> = emptyList()

    abstract fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int, item: T)

    open fun setItems(newItems: List<T>) {
        data = newItems
        filteredData = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<B> {
        val inflater = LayoutInflater.from(parent.context)
        val binding: B = DataBindingUtil.inflate(inflater, layoutId, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int) {
        onBindViewHolder(holder, position, filteredData[position])
    }

    override fun getItemCount(): Int = filteredData.size
}

class BindingViewHolder<B>(val binding: B) :
    RecyclerView.ViewHolder(binding.root) where B : ViewDataBinding {}