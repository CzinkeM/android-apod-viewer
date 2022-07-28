package hu.mczinke.nasa_apod_viewer.models

data class DateFilter(var startDate: String, var endDate: String? = null) {

    fun isPeriod(): Boolean {
        return endDate != null
    }
}
