package hu.mczinke.nasa_apod_viewer.home.presentation

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.mczinke.nasa_apod_viewer.BuildConfig
import hu.mczinke.nasa_apod_viewer.core.domain.Apod
import hu.mczinke.nasa_apod_viewer.core.domain.ApodMapper.toApod
import hu.mczinke.nasa_apod_viewer.home.data.ApodRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File

private const val TAG = "HomeViewModel"
class HomeViewModel(
    private val apodRepository: ApodRepository
) : ViewModel() {

    private val _apod = MutableStateFlow<Apod?>(null)
    val apod = _apod.asStateFlow()

    val imageUri = MutableStateFlow(0L)

    init {
        getApod()
    }

    private fun getApod() {
        viewModelScope.launch {
            val result = apodRepository.getApod(BuildConfig.NASA_API_KEY)
            Log.d("Response", result.toString())
            _apod.value = result.toApod()
        }
    }

    fun downloadImage( context: Context) {
        require(apod.value != null)
        val imageName = "${apod.value!!.title}.jpeg"
        val myPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath + File.separator + imageName
        val imageFile = File(myPath)
        if(imageFile.exists()) {
            Toast.makeText(context, "This image is already downloaded.", Toast.LENGTH_SHORT).show()
        }else {
            val downloadManager = context.getSystemService(DownloadManager::class.java)
            val request = DownloadManager
                .Request(apod.value!!.HDUrl.toUri())
                .setMimeType("image/jpeg")
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
                .setTitle(imageName)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, imageName)
            imageUri.value = downloadManager.enqueue(request)
        }

    }
}