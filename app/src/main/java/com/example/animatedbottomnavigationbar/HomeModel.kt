package com.example.animatedbottomnavigationbar

import androidx.annotation.DrawableRes

class HomeModel(
    var id: Int,
    var title: String = "",
    var subtitle: String = "",
    @DrawableRes var image: Int = -1
)