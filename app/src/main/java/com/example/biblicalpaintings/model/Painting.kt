package com.example.biblicalpaintings.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Painting(
    val id:Int,
    @DrawableRes val paintingImage: Int,
    @StringRes val paintingName: Int,
    @StringRes val authorName: Int,
    val creationStart: Int?,
    val creationEnd: Int?,
    @StringRes val pictureInfo:Int
)