package com.pakt_games.personapp.model

/**
 * Kişiler Sınıfı
 *  @author Hasan Kuşçu
 *  @since sep2022
 *  @constructor Burada bulunan parametereler rehber uygulamasında kişilerin verilerini tutmak için tasarlanmıştır.
 */

data class Persons(
    val personId: Int,
    val personName: String,
    val personPhoneNumber: String
)