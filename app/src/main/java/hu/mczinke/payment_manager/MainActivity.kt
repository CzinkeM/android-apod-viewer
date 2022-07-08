package hu.mczinke.payment_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.skydoves.landscapist.glide.GlideImage
import hu.mczinke.payment_manager.models.APOD
import hu.mczinke.payment_manager.ui.theme.PaymentmanagerTheme
import hu.mczinke.payment_manager.viewmodels.MainViewModel
import hu.mczinke.payment_manager.viewmodels.MainViewModelFactory
import hu.mczinke.payment_manager.viewmodels.Repository

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAPOD()
        setContent {
            PaymentmanagerTheme {
                ScaffoldWithBottomMenu()
                MainScreen(viewModel)
            }
        }
    }
}

@Composable
fun MainScreen(myViewModel: MainViewModel) {
    val apod: APOD by myViewModel.apod.observeAsState(APOD("", "", "", "", "", "", "", ""))
    val imageUrl = "https://apod.nasa.gov/apod/image/2207/StarTreels.jpg"
    Column(Modifier.height(200.dp)) {
        Text(text = apod.toString())
        GlideImage(
            imageModel = imageUrl,
            contentDescription = "Daily Picture",
            contentScale = ContentScale.FillHeight,

            )
    }
}

@Preview
@Composable
fun BottomAppBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "")
        },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite, "")
        },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })
    }
}

@Preview
@Composable
fun ScaffoldWithBottomMenu() {
    Scaffold(bottomBar = { BottomAppBar() }) {}
}

