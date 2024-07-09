package com.ritense.mockapi.api

import java.util.UUID

data class Thema(
    val id: UUID,
    val key: String,
    val title: String,
    val zaaktypen: List<String>
)
