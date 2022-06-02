package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Audience(
    val classNumber: Int,
    val building: Int
){
    val number: String
        get() = "$building-$classNumber"
}