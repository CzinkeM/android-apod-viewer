package hu.mczinke.nasa_apod_viewer.core.data

import java.time.LocalDate

data class DateFilter(
    var startDate: LocalDate = LocalDate.MIN,
    var endDate: LocalDate = LocalDate.MAX
)
