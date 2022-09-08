package com.pakt_games.personapp.repository

import android.app.Person
import kotlinx.coroutines.flow.MutableStateFlow

class PersonsDaoRepository {
    var persons = MutableStateFlow<List<Person>>(arrayListOf())
}