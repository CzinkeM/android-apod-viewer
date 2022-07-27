package hu.mczinke.payment_manager.models


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

    companion object StaticApods {
        fun nullApod(): Apod = Apod("", "", "", "", "", "")

        fun dummyApod(): Apod =
            Apod("copyright", "2022-07-24", "explanation", "hdUrl", "title", "url")
    }
}
