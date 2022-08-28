package com.pakt_games.personapp

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.pakt_games.personapp.model.Persons

@Composable
fun MainPage() {
    val isSearhActive = remember { mutableStateOf(false) }
    val textFieledSearchResult = remember { mutableStateOf("") }
    val personsList = remember { mutableStateListOf<Persons>() }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(isSearhActive.value) {
                        Text(text = "Arama")
                    } else {
                        Text(text = "Rehber")
                    }
                },
                actions = {
                    if(isSearhActive.value) {
                        IconButton(onClick = {
                            isSearhActive.value = false
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_close_24), contentDescription = "", tint = Color.White)
                        }
                    } else {
                        IconButton(onClick = {
                            isSearhActive.value = true
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "", tint = Color.White)
                        }
                    }
                }
            )
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