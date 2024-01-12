package com.example.eccpizza.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    val product_no: String,
    val pname: String,
    val category: String,
    val price : String,
    val image_url : String,
    val detail : String
) : Parcelable
