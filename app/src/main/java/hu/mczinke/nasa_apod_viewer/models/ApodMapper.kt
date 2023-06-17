package hu.mczinke.nasa_apod_viewer.models

import hu.mczinke.nasa_apod_viewer.models.dtos.ApodDto

object ApodMapper {

    fun ApodDto.toApod(): Apod {
        return Apod(
            copyright = copyright,
            date = date,
            title = title,
            explanation = explanation,
            url = url,
            HDUrl = if (HDUrl.isNullOrBlank()) {
                ""
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