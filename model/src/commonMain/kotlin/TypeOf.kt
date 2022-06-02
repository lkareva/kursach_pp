package ru.altmanea.edu.server.model

import kotlinx.serialization.Serializable

@Serializable
enum class TypeOfWeek(private val type: String){
    ODD("Нечетная"),
    EVEN("Четная");

    override fun toString() = type
}
val typeOfWeek = listOf(TypeOfWeek.ODD, TypeOfWeek.EVEN)

@Serializable
enum class Subgroup (private val type: String){
    FIRST("1 п/г"),
    SECOND("2 п/г"),
    ALL("");

    override fun toString() = type
}

@Serializable
enum class TypeLesson(private val type: String) {
    LECTURE("Лек"),
    PRACTICE("Пр"),
    LAB("Лаб"),
    KSR("КСР"),
    KRB("КРБ");

    override fun toString() = type
}

@Serializable
enum class DayOfWeek(private val type: String) {
    Mon("Пн"),
    Tue("Вт"),
    Wed("Ср"),
    Thu("Чт"),
    Fri("Пт"),
    Sat("Сб"),
    Sun("Вс");

    override fun toString() = type
}
val dayOfWeek = listOf(DayOfWeek.Mon, DayOfWeek.Tue, DayOfWeek.Wed, DayOfWeek.Thu,DayOfWeek.Fri, DayOfWeek.Sat)
@Serializable
enum class ClassNumber(private val type: String) {
    FIRST("08:00-09:30"),
    SECOND("09:45-11:15"),
    THIRD("11:30-13:00"),
    FOURTH("13:55-15:25"),
    FIFTH("15:40-17:15");

    override fun toString() = type
}
val classNumber =  listOf(ClassNumber.FIRST, ClassNumber.SECOND, ClassNumber.THIRD, ClassNumber.FOURTH,
    ClassNumber.FIFTH)

val cellSch = listOf(TypeOfWeek.ODD to dayOfWeek, TypeOfWeek.EVEN to dayOfWeek)

val cellSchplus: List<Pair<TypeOfWeek?, List<DayOfWeek>>> = listOf(TypeOfWeek.ODD to dayOfWeek, null to dayOfWeek, TypeOfWeek.EVEN to dayOfWeek)

val para = listOf("1-я", "2-я", "3-я","4-я","5-я")