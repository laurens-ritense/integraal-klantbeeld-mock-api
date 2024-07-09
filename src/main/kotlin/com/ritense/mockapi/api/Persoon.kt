package com.ritense.mockapi.api

data class Persoon(
    val voornaam: String,
    val tussenvoegsel: String,
    val achternaam: String,
    val geboortedatum: String,
    val bsn: Long,
    val woonplaats: String,
    val contactgegevens: String
)
