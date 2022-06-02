package ru.altmanea.edu.server.model

import kotlinx.serialization.*

@Serializable
class Teacher(
    val surname: String,
    val firstname: String,
    val middlename: String
) {
    val fullname: String
        get() = "$surname $firstname $middlename"
    val shortname: String
        get() = "$surname ${firstname[0]}.${middlename[0]}."
}