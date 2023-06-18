package hu.mczinke.nasa_apod_viewer.core.data

import java.time.format.DateTimeFormatter
import java.util.*

class ApodRepository(
    private val api: ApodApi
) {
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-M-d", Locale.ENGLISH)
    suspend fun getApod(apiKey: String): ApodDto {
        return api.getApod(apiKey)
    }

    suspend fun getApodsInPeriod(
        apiKey: String,
        dateFilter: DateFilter
    ): List<ApodDto> {

        return api.getApodsInPeriod(
            apiKey,
            dateFilter.startDate.format(dateFormatter),
            dateFilter.endDate.format(dateFormatter)
        )
    }

    suspend fun getApodAtSpecificDate(apiKey: String, dateFilter: DateFilter): ApodDto {
        return api.getApodAtSpecificDate(
            apiKey,
            dateFilter.startDate.format(dateFormatter)
        )
    }
}