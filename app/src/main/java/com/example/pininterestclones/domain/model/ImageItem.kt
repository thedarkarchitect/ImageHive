package com.example.pininterestclones.domain.model

data class ImageItem (
    val id: String,
    val imageUrlSmall: String,
    val imageUrlRegular: String,
    val imageUrlRaw: String,
    val photograherName: String?,
    val photograherUsername: String?,
    val photograherProfileImgUrl: String?,
    val photograherProfileLink: String?,
    val width: Int,
    val height: Int,
    val description: String?
)