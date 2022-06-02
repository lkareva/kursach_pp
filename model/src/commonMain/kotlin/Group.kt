package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Group(
    val group: String,
    val subgroup: Int = 1
)