package hu.mczinke.nasa_apod_viewer.core.domain

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NavDestination {
    fun route(): String

    fun addGraph(navGraphBuilder: NavGraphBuilder, navController: NavController)

    fun navigate(navController: NavController)
}