package hu.mczinke.nasa_apod_viewer.models.DTOs

import com.google.gson.annotations.SerializedName
import hu.mczinke.nasa_apod_viewer.models.Apod

data class ApodDto(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val HDUrl: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val version: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) {

    fun toApod(): Apod {
        val copyright = if (copyright.isNullOrEmpty()) {
            ""
        } else {
            copyright
        }
        return Apod(
            copyright = copyright,
            date = date,
            title = title,
            explanation = explanation,
            url = url,
            HDUrl = HDUrl
        )
    }
}
