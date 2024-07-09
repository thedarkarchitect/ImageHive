package com.example.pininterestclones.data.remote.dto


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerializedName("links")
    val links: LinksX? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("profile_image")
    val profileImage: ProfileImageDto? = null,
    @SerializedName("username")
    val username: String? = null
)

@Serializable
data class ProfileImageDto(
    @SerializedName("small")
    val small: String? = null
)

@Serializable
data class LinksX(
    @SerializedName("html")
    val html: String? = null,
    @SerializedName("likes")
    val likes: String? = null,
    @SerializedName("photos")
    val photos: String? = null,
    @SerializedName("portfolio")
    val portfolio: String? = null,
    @SerializedName("self")
    val self: String? = null
)