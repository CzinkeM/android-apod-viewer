package hu.mczinke.nasa_apod_viewer.datamanagement

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.mczinke.nasa_apod_viewer.models.entities.ApodEntity

@Dao
interface ApodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApod(apod: ApodEntity)

    @Delete
    suspend fun removeApod(apod: ApodEntity)

    @Query("DELETE FROM favorite_apods WHERE title LIKE :apodTitle")
    suspend fun removeApodByTitle(apodTitle: String)

    @Query("SELECT * FROM favorite_apods")
    fun allApod(): LiveData<List<ApodEntity>>

    @Query("SELECT * FROM favorite_apods WHERE favorite_apods.title LIKE :apodTitle")
    fun getApodByTitle(apodTitle: String): LiveData<List<ApodEntity>>


}