package hu.mczinke.nasa_apod_viewer.core.domain

import hu.mczinke.nasa_apod_viewer.models.MediaType


data class Apod(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val mediaType: MediaType,
    val HDUrl: String,
    val title: String,
    val url: String
) {
    override fun toString(): String {
        return "$copyright: $title($date)"
    }

    companion object StaticApods {
        fun nullApod(): Apod = Apod("", "", "", MediaType.IMAGE,"", "", "")

        fun dummyApod(): Apod =
            Apod("copyright", "2022-07-24", "explanation", MediaType.IMAGE,"hdUrl", "title", "url")
    }
}
