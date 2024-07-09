package com.example.pininterestclones.data.remote.dto


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class ImageDtoItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("urls")
    val urls: Urls,
    @SerializedName("user")
    val user: User? = null,

)

@Serializable
data class Urls(
    @SerializedName("full")
    val full: String,
    @SerializedName("raw")
    val raw: String,
    @SerializedName("regular")
    val regular: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("thumb")
    val thumb: String
)