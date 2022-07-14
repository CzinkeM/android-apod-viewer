package hu.mczinke.payment_manager.viewmodels

import hu.mczinke.payment_manager.models.DTOs.ApodDto

class Repository {

    suspend fun getApod(apiKey: String): ApodDto {
        return RetrofitInstance.api.getApod(apiKey)
    }
}