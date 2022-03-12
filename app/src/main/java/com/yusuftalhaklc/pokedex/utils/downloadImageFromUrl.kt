package com.yusuftalhaklc.pokedex.utils

import android.content.Context
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.yusuftalhaklc.pokedex.R
import java.io.InputStream

fun ImageView.downloadImageFromUrl(url:String){

    GlideToVectorYou
        .init()
        .with(this.context)
        .load(Uri.parse(url), this)
}
