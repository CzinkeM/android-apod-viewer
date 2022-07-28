package hu.mczinke.nasa_apod_viewer.viewmodels

import hu.mczinke.nasa_apod_viewer.models.DTOs.ApodDto
import hu.mczinke.nasa_apod_viewer.models.DateFilter

class Repository {

    suspend fun getApod(apiKey: String): ApodDto {
        return RetrofitInstance.api.getApod(apiKey)
    }

    suspend fun getApodsInPeriod(
        apiKey: String,
        dateFilter: DateFilter
    ): List<ApodDto> {
        return RetrofitInstance.api.getApodsInPeriod(
            apiKey,
            dateFilter.startDate,
            dateFilter.endDate!!
        )
    }

    suspend fun getApodAtSpecificDate(apiKey: String, dateFilter: DateFilter): ApodDto {
        return RetrofitInstance.api.getApodAtSpecificDate(apiKey, dateFilter.startDate)
    }
}