package com.pakt_games.personapp

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson
import com.pakt_games.personapp.model.Persons

@Composable
fun MainPage(navController: NavController) {
    val isSearchActive = remember { mutableStateOf(false) }
    val textFieledSearchResult = remember { mutableStateOf("") }
    val personsList = remember { mutableStateListOf<Persons>() }

    LaunchedEffect(key1 = true) {
        val person1 = Persons(1,"Hasan","1234")
        val person2 = Persons(2,"Bedri","12345")
        val person3 = Persons(3,"Hatice","123456")
        val person4 = Persons(4,"Hilal","1234567")
        personsList.add(person1)
        personsList.add(person2)
        personsList.add(person3)
        personsList.add(person4)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if(isSearchActive.value) {
                        TextField(
                            value = textFieledSearchResult.value,
                            onValueChange = {textFieledSearchResult.value = it},
                            label = { Text(text = "Aramak istediğiniz kelimeyi giriniz.") },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedLabelColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                unfocusedLabelColor = Color.White
                            )
                        )
                    } else {
                        Text(text = "Rehber")
                    }
                },
                actions = {
                    if(isSearchActive.value) {
                        IconButton(onClick = {
                            isSearchActive.value = false
                            textFieledSearchResult.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_close_24), contentDescription = "", tint = Color.White)
                        }
                    } else {
                        IconButton(onClick = {
                            isSearchActive.value = true
                            textFieledSearchResult.value = ""
                        }) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "", tint = Color.White)
                        }
                    }
                }
            )
        } ,
        content = {
            LazyColumn{
                items(
                    count = personsList.count(),
                    itemContent = {
                        val person = personsList[it]
                        Card(modifier = Modifier
                            .padding(all = 5.dp)
                            .fillMaxWidth()) {
                            Row(modifier = Modifier.clickable {
                                val personJson = Gson().toJson(person)
                                navController.navigate("guideBookDetailPage/${personJson}")
                            }) {
                                Row(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(text = "${person.personName} - ${person.personPhoneNumber}")

                                    IconButton(onClick = {
                                        Log.e("Kişi Sil","${person.personId}")
                                    }) {
                                        Icon(painter = painterResource(id = R.drawable.ic_baseline_delete_outline_24),
                                            contentDescription = "",tint = Color.Gray)
                                    }
                                }
                            }
                        }
                    }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                       navController.navigate("guideBookContactPage")
                },
                backgroundColor = colorResource(id = R.color.teal_700),
                content = {
                    Icon(painter = painterResource(id = R.drawable.ic_baseline_person_add_24), contentDescription = "", tint = Color.White)
                }
            )
        }
    )
}
