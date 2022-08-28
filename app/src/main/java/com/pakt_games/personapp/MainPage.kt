package com.pakt_games.personapp

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource

@Composable
fun MainPage() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Rehber")})
        } ,
        content = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                backgroundColor = colorResource(id = R.color.teal_700),
                content = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_person_add_24), contentDescription = "", tint = Color.White)
                }
            )
        }
    )
}