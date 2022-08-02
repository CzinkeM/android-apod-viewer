package hu.mczinke.nasa_apod_viewer.viewmodels

import hu.mczinke.nasa_apod_viewer.models.DateFilter
import hu.mczinke.nasa_apod_viewer.models.dtos.ApodDto
import java.time.format.DateTimeFormatter
import java.util.*

class Repository {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d", Locale.ENGLISH)
    suspend fun getApod(apiKey: String): ApodDto {
        return RetrofitInstance.api.getApod(apiKey)
    }

    suspend fun getApodsInPeriod(
        apiKey: String,
        dateFilter: DateFilter
    ): List<ApodDto> {

        return RetrofitInstance.api.getApodsInPeriod(
            apiKey,
            dateFilter.startDate.format(dateFormatter),
            dateFilter.endDate.format(dateFormatter)
        )
    }

    suspend fun getApodAtSpecificDate(apiKey: String, dateFilter: DateFilter): ApodDto {
        return RetrofitInstance.api.getApodAtSpecificDate(
            apiKey,
            dateFilter.startDate.format(dateFormatter)
        )
    }
}