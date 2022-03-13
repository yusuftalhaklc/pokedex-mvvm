package com.yusuftalhaklc.pokedex.utils

import android.net.Uri
import android.widget.ImageView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

fun ImageView.downloadImageFromUrl(url:String){
    GlideToVectorYou
        .init()
        .with(this.context)
        .load(Uri.parse(url), this)
}
