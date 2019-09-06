package com.example.pokedroid.view

import com.example.pokedroid.R
import com.example.pokedroid.databinding.MainPokemonItemBinding

class MainListAdapter(private val onClick: (String) -> Unit) :
    BindingAdapter<String, MainPokemonItemBinding>(R.layout.main_pokemon_item) {

    override fun onBindViewHolder(holder: BindingViewHolder<MainPokemonItemBinding>, position: Int, item: String) {
        holder.binding.pokemon = item
        holder.binding.onClick = onClick
    }
}