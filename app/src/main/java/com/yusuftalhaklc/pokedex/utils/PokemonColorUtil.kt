package com.yusuftalhaklc.pokedex.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.yusuftalhaklc.pokedex.R
import java.util.*

class PokemonColorUtil(private var context: Context) {
    @ColorInt
    fun getPokemonColor(typeOfPokemon: String): Int {
        val color = when (typeOfPokemon) {
            "grass" -> R.color.lightTeal
            "bug" -> R.color.lightTeal
            "bug" -> R.color.lightTeal
            "fire" -> R.color.lightRed
            "water" -> R.color.lightBlue
            "fighting" -> R.color.lightBlue
            "normal" -> R.color.lightBlue
            "electric" -> R.color.lightYellow
            "psychic" -> R.color.lightYellow
            "poison"-> R.color.lightPurple
            "ghost" -> R.color.lightPurple
            "ground"-> R.color.lightBrown
            "rock" -> R.color.lightBrown
            "dark" -> R.color.black
            else -> R.color.lightBlue
        }
        return convertColor(color)
    }

    @ColorInt
    fun convertColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}