package ru.altmanea.edu.server.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object TypeOfWeekSerializer : KSerializer<TypeOfWeek> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("TypeOfWeek", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "Четная" -> TypeOfWeek.EVEN
            else -> TypeOfWeek.ODD
        }

    override fun serialize(encoder: Encoder, value: TypeOfWeek) =
        encoder.encodeString(
            when (value) {
                TypeOfWeek.EVEN -> "Четная"
                TypeOfWeek.ODD -> "Нечетная"
            }
        )
}

object SubgroupSerializer : KSerializer<Subgroup> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Subgroup", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "1 п/г" -> Subgroup.FIRST
            "2 п/г" -> Subgroup.SECOND
            else -> Subgroup.ALL
        }
    override fun serialize(encoder: Encoder, value: Subgroup) =
        encoder.encodeString(
            when (value) {
                Subgroup.FIRST -> "1 п/г"
                Subgroup.SECOND -> "2 п/г"
                Subgroup.ALL -> ""
            }
        )
}



object DayOfWeekSerializer : KSerializer<DayOfWeek> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("DayOfWeek", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "Пн" -> DayOfWeek.Mon
            "Вт" -> DayOfWeek.Tue
            "Ср" -> DayOfWeek.Wed
            "Чт" -> DayOfWeek.Thu
            "Пт" -> DayOfWeek.Fri
            "Сб" -> DayOfWeek.Sat
            else -> DayOfWeek.Sun
        }

    override fun serialize(encoder: Encoder, value: DayOfWeek) =
        encoder.encodeString(
            when (value) {
                DayOfWeek.Mon -> "Пн"
                DayOfWeek.Tue -> "Вт"
                DayOfWeek.Wed -> "Ср"
                DayOfWeek.Thu -> "Чт"
                DayOfWeek.Fri -> "Пт"
                DayOfWeek.Sat -> "Сб"
                DayOfWeek.Sun -> "Вс"
            }
        )
}



object TypeLessonSerializer : KSerializer<TypeLesson> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("TypeLesson", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "Лек" -> TypeLesson.LECTURE
            "Пр" -> TypeLesson.PRACTICE
            "Лаб" -> TypeLesson.LAB
            "КСР" -> TypeLesson.KSR
            else -> TypeLesson.KRB
        }

    override fun serialize(encoder: Encoder, value: TypeLesson) =
        encoder.encodeString(
            when (value) {
                TypeLesson.LECTURE -> "Лек"
                TypeLesson.PRACTICE -> "Пр"
                TypeLesson.LAB -> "Лаб"
                TypeLesson.KSR -> "КСР"
                TypeLesson.KRB -> "КРБ"
            }
        )
}

object ClassNumberSerializer : KSerializer<ClassNumber> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ClassNumber", PrimitiveKind.STRING)
    override fun deserialize(decoder: Decoder) =
        when (decoder.decodeString()) {
            "08:00-09:30" -> ClassNumber.FIRST
            "09:45-11:15" -> ClassNumber.SECOND
            "11:30-13:00" -> ClassNumber.THIRD
            "13:55-15:25" -> ClassNumber.FOURTH
            else -> ClassNumber.FIFTH
        }
    override fun serialize(encoder: Encoder, value: ClassNumber) =
        encoder.encodeString(
            when (value) {
                ClassNumber.FIRST -> "08:00-09:30"
                ClassNumber.SECOND ->"09:45-11:15"
                ClassNumber.THIRD -> "11:30-13:00"
                ClassNumber.FOURTH -> "13:55-15:25"
                ClassNumber.FIFTH ->"15:40-17:15"
            }
        )
}