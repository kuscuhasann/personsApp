package com.pakt_games.personapp

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun MainPage() {
    Scaffold(
        topBar = {
                 TopAppBar(title = { Text(text = "Rehber")})
        } ,
        content = {},
        floatingActionButton = 
    ) {
        
    }
}