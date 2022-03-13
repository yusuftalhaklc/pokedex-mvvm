package com.yusuftalhaklc.pokedex.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yusuftalhaklc.pokedex.R
import com.yusuftalhaklc.pokedex.model.FeedModel
import com.yusuftalhaklc.pokedex.utils.PokemonColorUtil
import com.yusuftalhaklc.pokedex.utils.downloadImageFromUrl
import com.yusuftalhaklc.pokedex.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.feed_row.view.*
import java.util.*

class FeedModelAdapter(private val FeedModelList: ArrayList<FeedModel>) :
    RecyclerView.Adapter<FeedModelAdapter.FeedModelViewHolder>() {

    class FeedModelViewHolder( var view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedModelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.feed_row, parent, false)
        return FeedModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedModelViewHolder, position: Int) {

        holder.view.pokedexName.text = FeedModelList[position].name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
        holder.view.pokedexImage.downloadImageFromUrl(FeedModelList[position].imageUrl)

        val background:Drawable =  holder.view.feedRowLayout.background
        val colorID = PokemonColorUtil(holder.view.context).getPokemonColor(FeedModelList[position].imagecode)
        background.setTint(colorID)

        holder.view.feedRowLayout.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToDetailsFragment(FeedModelList[position].name,colorID)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return FeedModelList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(newList: List<FeedModel>){
        FeedModelList.clear()
        FeedModelList.addAll(newList)
        notifyDataSetChanged()
    }

}