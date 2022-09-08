package com.pakt_games.personapp.base

import androidx.lifecycle.ViewModel
import com.pakt_games.personapp.repository.PersonsDaoRepository

open class BaseViewModel: ViewModel() {
    open var personsDaoRepository = PersonsDaoRepository()
}