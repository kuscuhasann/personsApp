package com.pakt_games.personapp.model

/**
 * Kişiler rehberin modeli burada tutulmaktadır.
 *  @author Hasan Kuşçu
 *  @since sep2022
 */

data class Persons(
    val personId: Int,
    val personName: String,
    val personPhoneNumber: String
)