package com.example.pokedroid.view

import android.os.Bundle
import com.example.pokedroid.R
import com.example.pokedroid.databinding.ActivityMainBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

class MainActivity : BindingActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    private val pkmAdapter = MainListAdapter {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.loading = true

        val layoutManager = FlexboxLayoutManager(applicationContext)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.SPACE_AROUND

        binding.rvPokemonList.layoutManager = layoutManager
        binding.rvPokemonList.setHasFixedSize(true)
        binding.rvPokemonList.adapter = pkmAdapter
        pkmAdapter.setItems(listOf("Bulbasaur", "Charmander", "Squirtle"))
        binding.loading = false
    }
}
