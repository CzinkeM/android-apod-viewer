package hu.mczinke.payment_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import hu.mczinke.payment_manager.ui.components.MainScreen
import hu.mczinke.payment_manager.ui.theme.APODViewerTheme
import hu.mczinke.payment_manager.viewmodels.MainViewModel
import hu.mczinke.payment_manager.viewmodels.MainViewModelFactory
import hu.mczinke.payment_manager.viewmodels.Repository

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getAPOD()
        setContent {
            APODViewerTheme {
                MainScreen(viewModel)
            }
        }
    }
}



