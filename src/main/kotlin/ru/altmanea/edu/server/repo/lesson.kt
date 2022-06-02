package ru.altmanea.edu.server.repo

import ru.altmanea.edu.server.model.Lesson
import ru.altmanea.edu.server.model.TypeLesson

val programmingKrb = Lesson(
    "Программирование",
    TypeLesson.KRB,
    172,
    setOf(group21i, group21m1, group21m2, group21z1, group21z2),
    ponomarev)
val programmingLec = Lesson(
    "Программирование",
    TypeLesson.LECTURE,
    172,
    setOf(flow21),
    ponomarev)
val programmingLab = Lesson(
    "Программирование",
    TypeLesson.LAB,
    172,
    setOf(group21i, group21m1, group21m2, group21z1, group21z2),
    ponomarev)
val ITLec = Lesson(
    "Информ. технологии",
    TypeLesson.LECTURE,
    172,
    setOf(flow21),
    altman)
val ITLab = Lesson(
    "Информ. технологии",
    TypeLesson.LAB,
    172,
    setOf(group21i, group21m1, group21m2, group21z1, group21z2),
    vaseeva)
val testLab = Lesson(
    "Тестиров. програм. пр.",
    TypeLesson.LAB,
    172,
    setOf(group29z, group29m),
    elizarov)
val ISSLab = Lesson(
    "Инфоком.системы и сети",
    TypeLesson.LAB,
    172,
    setOf(group29z, group29m),
    malutin)
val IISLab = Lesson(
    "Инженер.инф.сист.",
    TypeLesson.LAB,
    172,
    setOf(group29z, group29m),
    kashtanov)
val IISKSR = Lesson(
    "Инженер.инф.сист.",
    TypeLesson.KSR,
    172,
    setOf(group29z, group29m),
    kashtanov)
val KKSLab = Lesson(
    "Комп.компл.и сети",
    TypeLesson.LAB,
    172,
    setOf(group29z, group29m),
    okishev)
val ISSLec = Lesson(
    "Инфоком.системы и сети",
    TypeLesson.LECTURE,
    172,
    setOf(flow29),
    malutin)
val IISLec = Lesson(
    "Инженер.инф.сист.",
    TypeLesson.LECTURE,
    172,
    setOf(flow29),
    kashtanov)
val testLec = Lesson(
    "Тестиров. програм. пр.",
    TypeLesson.LECTURE,
    172,
    setOf(flow29),
    elizarov)
val KKSLec = Lesson(
    "Комп.компл.и сети",
    TypeLesson.LECTURE,
    172,
    setOf(flow29),
    okishev)
val testKSR = Lesson(
    "Тестиров. програм. пр.",
    TypeLesson.KSR,
    172,
    setOf(group29z, group29m),
    elizarov)
val PPLab = Lesson(
    "прикладн.програм",
    TypeLesson.LAB,
    172,
    setOf(group29z, group29m),
    altman)
val PPKRB = Lesson(
    "прикладн.програм",
    TypeLesson.KRB,
    172,
    setOf(group29z, group29m),
    altman)
val PPLec = Lesson(
    "прикладн.програм",
    TypeLesson.LECTURE,
    172,
    setOf(flow29),
    altman)
val ISSKSR = Lesson(
    "Инфоком.системы и сети",
    TypeLesson.KSR,
    172,
    setOf(group29z, group29m),
    malutin)