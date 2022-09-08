package com.pakt_games.personapp.viewmodel

import com.pakt_games.personapp.base.BaseViewModel
import com.pakt_games.personapp.repository.PersonsDaoRepository

class GuideBookContactPageViewModel: BaseViewModel() {
    override var personsDaoRepository = PersonsDaoRepository()

    fun personRegistration(personName: String, personPhone: String) {
        personsDaoRepository.personRegistration(personName, personPhone)
    }
}
