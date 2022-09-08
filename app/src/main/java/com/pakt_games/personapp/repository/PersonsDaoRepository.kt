package com.pakt_games.personapp.repository

import com.pakt_games.personapp.model.Persons
import kotlinx.coroutines.flow.MutableStateFlow

class PersonsDaoRepository {
    var personsList = MutableStateFlow<List<Persons>>(arrayListOf())

    init {
        personsList = MutableStateFlow(arrayListOf())
    }

    fun getPersons(): MutableStateFlow<List<Persons>> {
        return personsList
    }

    fun takePersons() {
        val list = mutableListOf<Persons>()
        val person1 = Persons(1,"Hasan","1234")
        val person2 = Persons(1,"Bedri","12345")
        list.add(person1)
        list.add(person2)
        personsList.value = list
    }

    fun findPerson(personParameterForFinding: String) {

    }
    fun personRegistration(personName: String, personPhone: String) {

    }
    fun personUpdate(personId: Int,personName: String, personPhone: String) {

    }
    fun deletePerson(personId: Int) {

    }
}