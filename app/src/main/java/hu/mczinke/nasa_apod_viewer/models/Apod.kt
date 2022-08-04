package hu.mczinke.nasa_apod_viewer.models

import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity


data class Apod(
    val copyright: String,
    val date: String,
    val explanation: String,
    val HDUrl: String,
    val title: String,
    val url: String
) {
    override fun toString(): String {
        return "$copyright: $title($date)"
    }

    fun toEntity(): ApodEntity {
        return ApodEntity(0, copyright, date, explanation, HDUrl, title, url)
    }

    companion object StaticApods {
        fun nullApod(): Apod = Apod("", "", "", "", "", "")

        fun dummyApod(): Apod =
            Apod("copyright", "2022-07-24", "explanation", "hdUrl", "title", "url")
    }
}
