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
}
