package com.pakt_games.personapp.viewmodel

import com.pakt_games.personapp.base.BaseViewModel
import com.pakt_games.personapp.repository.PersonsDaoRepository

class GuideBookContactDetailPageViewModel: BaseViewModel() {
    override var personsDaoRepository = PersonsDaoRepository()

    fun personUpdate(personId: Int,personName: String, personPhone: String) {
        personsDaoRepository.personUpdate(personId, personName, personPhone)
    }
}