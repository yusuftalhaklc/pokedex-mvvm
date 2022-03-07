package com.yusuftalhaklc.pokedex.utils

import android.R
import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.widget.ImageView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import java.io.InputStream


fun ImageView.downloadImageFromUrl(url:String){

    GlideToVectorYou
        .init()
        .with(this.context)
        .load(Uri.parse(url), this)
}