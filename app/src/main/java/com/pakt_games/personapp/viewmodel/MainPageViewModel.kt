package com.pakt_games.personapp.viewmodel

import com.pakt_games.personapp.base.BaseViewModel
import com.pakt_games.personapp.model.Persons
import com.pakt_games.personapp.repository.PersonsDaoRepository
import kotlinx.coroutines.flow.MutableStateFlow

class MainPageViewModel: BaseViewModel() {
    override var personsDaoRepository = PersonsDaoRepository()
    var personsList = MutableStateFlow<List<Persons>>(arrayListOf())

    init {
        takePersons()
        personsList = personsDaoRepository.getPersons()
    }

    fun takePersons() {
        personsDaoRepository.takePersons()
    }
    fun findPerson(personParameterForFinding: String) {
        personsDaoRepository.findPerson(personParameterForFinding)
    }
    fun deletePerson(personId: Int) {
        personsDaoRepository.deletePerson(personId = personId)
    }
}