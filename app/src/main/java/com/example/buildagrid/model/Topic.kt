package com.example.buildagrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringId: Int,
    val count: Int,
    @DrawableRes val imageId: Int,

)
