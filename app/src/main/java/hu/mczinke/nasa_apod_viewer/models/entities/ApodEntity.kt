package hu.mczinke.nasa_apod_viewer.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import hu.mczinke.nasa_apod_viewer.models.Apod

@Entity(tableName = "favorite_apods")
data class ApodEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "copyright")
    val copyright: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "explanation")
    val explanation: String,
    @ColumnInfo(name = "HDUrl")
    val HDUrl: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String
) {
    override fun toString(): String {
        return "$id $title"
    }
}

fun ApodEntity.toApod(): Apod {
    return Apod(this.copyright, this.date, this.explanation, this.HDUrl, this.title, this.url)
}
