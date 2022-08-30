package com.pakt_games.personapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.pakt_games.personapp.model.Persons
import com.pakt_games.personapp.ui.theme.PersonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PageOrientationControl()
                }
            }
        }
    }
}

@Composable
fun PageOrientationControl() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "mainPage") {
        composable("mainPage") {
            MainPage(navController = navController)
        }
        composable("guideBookContactPage") {
            GuideBookContactPage()
        }
        composable("guideBookDetailPage/{personModel}", arguments = listOf(
            navArgument("personModel") {type = NavType.StringType}
        )) {
            val jsonModel = it.arguments?.getString("personModel")
            val objectModel = Gson().fromJson(jsonModel, Persons::class.java)
            GuideBookContactDetailPage(incomingModel = objectModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PersonAppTheme {

    }
}