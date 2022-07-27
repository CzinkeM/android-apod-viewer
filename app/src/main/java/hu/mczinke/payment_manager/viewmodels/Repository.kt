package hu.mczinke.payment_manager.viewmodels

import hu.mczinke.payment_manager.models.DTOs.ApodDto

class Repository {

    suspend fun getApod(apiKey: String): ApodDto {
        return RetrofitInstance.api.getApod(apiKey)
    }

    suspend fun getApodsInPeriod(
        apiKey: String,
        startDate: String,
        endDate: String
    ): List<ApodDto> {
        return RetrofitInstance.api.getApodsInPeriod(apiKey, startDate, endDate)
    }

    suspend fun getApodAtSpecificDate(apiKey: String, date: String): ApodDto {
        return RetrofitInstance.api.getApodAtSpecificDate(apiKey, date)
    }
}