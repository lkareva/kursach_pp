package ru.altmanea.edu.server.repo

import ru.altmanea.edu.server.model.Schedule
import ru.altmanea.edu.server.model.Teacher

val altman = Teacher("Альтман", "Евгений", "Анатольевич")
val vaseeva = Teacher("Васеева", "Татьяна", "Валериевна")
val ponomarev = Teacher("Пономарев", "Антон", "Витальевич")
val okishev = Teacher("Окишев", "Андрей", "Сергеевич")
val malutin = Teacher("Малютин", "Андрей", "Геннадьевич")
val kashtanov = Teacher("Каштанов", "Алексей", "Леонидович")
val elizarov = Teacher("Елизаров", "Дмитрий", "Александрович")

val teacherRepo = ListRepo<Teacher>()

val teacherRepoTest = listOf(altman, vaseeva, ponomarev, okishev, malutin, kashtanov, elizarov)