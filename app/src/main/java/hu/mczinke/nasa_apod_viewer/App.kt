package hu.mczinke.nasa_apod_viewer

import android.app.Application
import hu.mczinke.nasa_apod_viewer.home.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules (
                homeModule
            )
        }
    }
}