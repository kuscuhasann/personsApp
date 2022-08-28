package com.pakt_games.personapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

@Composable
fun GuideBookContactDetailPage() {
    val textFieldPersonName = remember { mutableStateOf("") }
    val textFieldPersonPhoneNumber = remember { mutableStateOf("") }
    val localFocusManager = LocalFocusManager.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Rehbere Detay Sayfası") })
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(value = textFieldPersonName.value, onValueChange = {textFieldPersonName.value = it}, label = { Text(
                    text = "Eklemek istediğiniz kişinin adını giriniz."
                )
                })
                TextField(value = textFieldPersonPhoneNumber.value, onValueChange = {textFieldPersonPhoneNumber.value = it}, label = { Text(
                    text = "Eklemek istediğiniz kişinin telefon numarasını giriniz."
                )
                })
                Button(onClick = {
                    val personName = textFieldPersonName.value
                    val personPhoneNumber = textFieldPersonPhoneNumber.value
                    println(personName + personPhoneNumber)

                    localFocusManager.clearFocus()
                }, modifier = Modifier.size(250.dp, 50.dp)) {
                    Text(text = "Kişiyi Güncelle")
                }
            }
        }
    )
}