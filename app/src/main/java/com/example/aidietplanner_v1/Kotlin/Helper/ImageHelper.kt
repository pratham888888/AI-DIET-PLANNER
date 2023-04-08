package com.example.aidietplanner_v1.Kotlin.Helper

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageHelper {

    fun loadImage(context: Context, view: ImageView, imgUrl: String){
        Glide
            .with(context)
            .load(imgUrl)
            .centerCrop()
            .into(view)
    }

    fun loadImageFit(context: Context, view: ImageView, imgUrl: String){
        Glide
            .with(context)
            .load(imgUrl)
            .fitCenter()
            .into(view)
    }
}