package com.ritense.mockapi.api

data class Voertuig(
    val kenteken: String,
    val merk: String,
    val model: String,
    val bouwjaar: Long,
    val kleur: String,
    val brandstof: String,
    val eigenaar: Persoon,
    val apk_vervaldatum: String
)
