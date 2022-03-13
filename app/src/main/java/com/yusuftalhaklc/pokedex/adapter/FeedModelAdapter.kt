package com.yusuftalhaklc.pokedex.adapter

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.yusuftalhaklc.pokedex.R
import com.yusuftalhaklc.pokedex.model.FeedModel
import com.yusuftalhaklc.pokedex.utils.downloadImageFromUrl
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

        try {
            val bitmap = (holder.view.pokedexImage.drawable as? BitmapDrawable)!!.bitmap

            val vibrantSwatch = createPaletteSync(bitmap)
            val defaultValue = 0x000000

            vibrantSwatch?.let{
                holder.view.feedRowLayout.setBackgroundColor(vibrantSwatch.getVibrantColor(defaultValue))
            }
        }
        catch (e : Exception){
            e.printStackTrace()
        }


    }

    override fun getItemCount(): Int {
        return FeedModelList.size
    }

    private fun createPaletteSync(bitmap: Bitmap): Palette = Palette.from(bitmap).generate()

    fun refreshData(newList: List<FeedModel>){
        FeedModelList.clear()
        FeedModelList.addAll(newList)
        notifyDataSetChanged()

    }

}