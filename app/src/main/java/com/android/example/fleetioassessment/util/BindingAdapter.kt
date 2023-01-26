package com.android.example.fleetioassessment.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.android.example.fleetioassessment.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_fleetio_placeholder)
                    .error(R.drawable.ic_fleetio_error))
            .into(imageView)
    } ?:  imageView.setImageResource(R.drawable.ic_fleetio_placeholder)
}

@BindingAdapter("text")
fun setTitle(textView: TextView, strTitle: String?) {
//    if (strTitle == null) {
//        textView.text = "Unknown"
//    } else {
//        textView.text = strTitle
//    }
//
//    strTitle?.let {
//        textView.text = "UnKnown"
//    }?: run { textView.text = strTitle}

    textView.text = strTitle ?: "Unknown"
}