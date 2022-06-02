package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Schedule (
    val Lesson: Lesson,
    val flow: Flow,
    val audience: String,
    @Serializable(with = TypeOfWeekSerializer::class)
    val typeOfWeek: TypeOfWeek,
    @Serializable(with = DayOfWeekSerializer::class)
    val dayOfWeek: DayOfWeek,
    @Serializable(with = ClassNumberSerializer::class)
    val number: ClassNumber
)