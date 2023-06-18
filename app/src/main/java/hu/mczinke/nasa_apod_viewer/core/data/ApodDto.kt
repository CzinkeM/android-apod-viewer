package hu.mczinke.nasa_apod_viewer.core.data

import com.google.gson.annotations.SerializedName

data class ApodDto(
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val HDUrl: String?,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val version: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)
