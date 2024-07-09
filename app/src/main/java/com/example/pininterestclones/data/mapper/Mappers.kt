package com.example.pininterestclones.data.mapper

import com.example.pininterestclones.data.remote.dto.ImageDtoItem
import com.example.pininterestclones.domain.model.ImageItem

fun ImageDtoItem.toDomainModel(): ImageItem {
    return ImageItem(
        id = this.id,
        imageUrlSmall = this.urls.small,
        imageUrlRegular = this.urls.regular,
        imageUrlRaw = this.urls.raw,
        photograherName = this.user?.name,
        photograherUsername = this.user?.username,
        photograherProfileLink = this.user?.links?.html,
        photograherProfileImgUrl = this.user?.profileImage?.small,
        width = this.width,
        height = this.height,
        description = description
    )
}

fun List<ImageDtoItem>.toDomainModelList(): List<ImageItem> {
    return this.map {
        it.toDomainModel()
    }
}