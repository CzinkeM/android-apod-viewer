package hu.mczinke.nasa_apod_viewer.datamanagement

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity

@Database(entities = [ApodEntity::class], version = 1, exportSchema = false)
abstract class ApodDatabase : RoomDatabase() {

    abstract fun apodDao(): ApodDao

    companion object {

        private var INSTANCE: ApodDatabase? = null

        fun getInstance(context: Context): ApodDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ApodDatabase::class.java,
                        "apod_database"
                    )
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}