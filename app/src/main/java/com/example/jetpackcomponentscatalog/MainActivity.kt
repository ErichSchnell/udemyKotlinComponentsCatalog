package com.example.jetpackcomponentscatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomponentscatalog.model.Routes
import com.example.jetpackcomponentscatalog.ui.theme.CheckInfo
import com.example.jetpackcomponentscatalog.ui.theme.CheckRadioButton
import com.example.jetpackcomponentscatalog.ui.theme.JetpackComponentsCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentsCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navegationController = rememberNavController()
                    NavHost(navController = navegationController, startDestination = Routes.Pantalla1.route){
                        composable(Routes.Pantalla1.route){ Screen1(navegationController)}
                        composable(Routes.Pantalla2.route){ Screen2(navegationController)}
                        composable(Routes.Pantalla3.route){ Screen3(navegationController)}
                        composable(
                            Routes.Pantalla4.route, arguments = listOf(navArgument("age") { type = NavType.IntType})
                        ){ backStackEntry ->
                            Screen4(
                                navegationController,
                                backStackEntry.arguments?.getInt("age") ?: 0
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun getListRadioButton(titles: List<String>): List<CheckRadioButton> {
    var status by rememberSaveable { mutableStateOf("") }
    return titles.map {
        CheckRadioButton(
            title = it,
            selected = status == it,
            onCheckedChange = { status = it }
        )
    }
}

@Composable
fun getListBox(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentsCatalogTheme {
        //MyBadgeBox()
    }
}

