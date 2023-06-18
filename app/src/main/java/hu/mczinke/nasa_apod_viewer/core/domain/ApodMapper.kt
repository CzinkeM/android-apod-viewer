package hu.mczinke.nasa_apod_viewer.core.domain

import hu.mczinke.nasa_apod_viewer.core.data.ApodDto
import hu.mczinke.nasa_apod_viewer.models.MediaType

object ApodMapper {

    fun ApodDto.toApod(): Apod {
        return Apod(
            copyright = copyright,
            date = date,
            title = title,
            explanation = explanation,
            url = url,
            HDUrl = if (HDUrl.isNullOrBlank()) {
                url
            } else {
                HDUrl
            },
            mediaType = getApodMediaType(mediaType)
        )
    }

    private fun getApodMediaType(mediaTypeString: String): MediaType {
        return when {
            mediaTypeString.contains("image") -> MediaType.IMAGE
            mediaTypeString.contains("video") -> MediaType.VIDEO
            else -> throw IllegalArgumentException("Not supported media type.")
        }
    }
}