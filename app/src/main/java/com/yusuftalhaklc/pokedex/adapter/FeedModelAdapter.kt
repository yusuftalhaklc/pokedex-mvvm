package com.yusuftalhaklc.pokedex.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusuftalhaklc.pokedex.R
import com.yusuftalhaklc.pokedex.model.FeedModel
import com.yusuftalhaklc.pokedex.model.Result
import com.yusuftalhaklc.pokedex.utils.downloadImageFromUrl
import kotlinx.android.synthetic.main.feed_row.view.*

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
        holder.view.pokedexName.text = FeedModelList[position].name
        holder.view.pokedexImage.downloadImageFromUrl(FeedModelList[position].imageUrl)
    }

    override fun getItemCount(): Int {
        return FeedModelList.size
    }

    fun refreshData(newList: List<FeedModel>){
        FeedModelList.clear()
        FeedModelList.addAll(newList)
        notifyDataSetChanged()

    }


}