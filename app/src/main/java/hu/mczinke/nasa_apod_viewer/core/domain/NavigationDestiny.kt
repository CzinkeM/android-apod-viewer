package hu.mczinke.nasa_apod_viewer.core.domain

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavigationDestiny {
    fun route(): String

    fun NavGraphBuilder.addGraph()

    fun NavController.navigate()
}