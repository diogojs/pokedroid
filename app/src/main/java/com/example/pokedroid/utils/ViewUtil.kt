package com.example.pokedroid.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleIf")
fun visibleIf(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}