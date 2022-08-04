package hu.mczinke.nasa_apod_viewer.datamanagement

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity

@Dao
interface ApodDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addApod(apod: ApodEntity)

    @Delete
    suspend fun removeApod(apod: ApodEntity)

    @Query("SELECT * FROM favorite_apods")
    fun allApod(): LiveData<List<ApodEntity>>
}