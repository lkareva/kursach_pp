package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Lesson(
    val name: String,
    @Serializable(with = TypeLessonSerializer::class)
    val type: TypeLesson,
    val hours: Int,
    val flows: Set<Flow>,
    val teachers: Teacher
)