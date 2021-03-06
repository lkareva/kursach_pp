package ru.altmanea.edu.server.repo

import ru.altmanea.edu.server.model.ClassNumber
import ru.altmanea.edu.server.model.DayOfWeek
import ru.altmanea.edu.server.model.Schedule
import ru.altmanea.edu.server.model.TypeOfWeek

val scheduleRepo = ListRepo<Schedule>()

val schedulesRepoTestData = listOf(
    Schedule(
        programmingLec,
        flow21,
        "1-360",
        TypeOfWeek.ODD,
        DayOfWeek.Mon,
        ClassNumber.THIRD
    ),
    Schedule(
        programmingKrb,
        group21i,
        "1-350",
        TypeOfWeek.ODD,
        DayOfWeek.Tue,
        ClassNumber.SECOND
    ),
    Schedule(
        programmingLab,
        group21i,
        "1-330",
        TypeOfWeek.ODD,
        DayOfWeek.Tue,
        ClassNumber.FOURTH
    ),
    Schedule(
        ITLec,
        flow21,
        "1-112",
        TypeOfWeek.ODD,
        DayOfWeek.Wed,
        ClassNumber.SECOND
    ),
    Schedule(
        ITLab,
        group21i,
        "1-322",
        TypeOfWeek.ODD,
        DayOfWeek.Thu,
        ClassNumber.SECOND
    ),
    Schedule(
        ITLab,
        group21i,
        "1-322",
        TypeOfWeek.EVEN,
        DayOfWeek.Mon,
        ClassNumber.FIFTH
    ),
    Schedule(
        programmingLab,
        group21i,
        "1-330",
        TypeOfWeek.EVEN,
        DayOfWeek.Wed,
        ClassNumber.FOURTH
    ),
    Schedule(
        programmingLec,
        flow21,
        "1-360",
        TypeOfWeek.EVEN,
        DayOfWeek.Thu,
        ClassNumber.SECOND
    ),
    Schedule(
        ITLec,
        flow21,
        "1-112",
        TypeOfWeek.EVEN,
        DayOfWeek.Sat,
        ClassNumber.SECOND
    ),
    Schedule(
        testLab,
        group29z,
        "1-467",
        TypeOfWeek.ODD,
        DayOfWeek.Mon,
        ClassNumber.SECOND
    ),
    Schedule(
        ISSLab,
        group29z,
        "1-325",
        TypeOfWeek.ODD,
        DayOfWeek.Mon,
        ClassNumber.FIFTH
    ),
    Schedule(
        IISLab,
        group29z,
        "1-330",
        TypeOfWeek.ODD,
        DayOfWeek.Mon,
        ClassNumber.FOURTH
    ),
    Schedule(
        IISKSR,
        group29z,
        "1-330",
        TypeOfWeek.ODD,
        DayOfWeek.Tue,
        ClassNumber.FIFTH
    ),
    Schedule(
        KKSLab,
        group29z,
        "1-325",
        TypeOfWeek.ODD,
        DayOfWeek.Tue,
        ClassNumber.SECOND
    ),
    Schedule(
        testLec,
        flow29,
        "1-400",
        TypeOfWeek.ODD,
        DayOfWeek.Wed,
        ClassNumber.FIFTH
    ),
    Schedule(
        KKSLec,
        flow29,
        "1-350",
        TypeOfWeek.ODD,
        DayOfWeek.Wed,
        ClassNumber.SECOND
    ),
    Schedule(
        testLab,
        group29z,
        "1-467",
        TypeOfWeek.ODD,
        DayOfWeek.Wed,
        ClassNumber.THIRD
    ),
    Schedule(
        PPLab,
        group29z,
        "1-325",
        TypeOfWeek.ODD,
        DayOfWeek.Wed,
        ClassNumber.FOURTH
    ),
    Schedule(
        ISSLab,
        group29z,
        "1-325",
        TypeOfWeek.ODD,
        DayOfWeek.Wed,
        ClassNumber.FIFTH
    ),
    Schedule(
        testKSR,
        group29z,
        "1-467",
        TypeOfWeek.ODD,
        DayOfWeek.Thu,
        ClassNumber.SECOND
    ),
    Schedule(
        PPLab,
        group29z,
        "1-325",
        TypeOfWeek.ODD,
        DayOfWeek.Thu,
        ClassNumber.THIRD
    ),
    Schedule(
        PPLec,
        flow29,
        "1-112",
        TypeOfWeek.ODD,
        DayOfWeek.Fri,
        ClassNumber.FIFTH
    ),
    Schedule(
        ISSKSR,
        group29z,
        "1-325",
        TypeOfWeek.ODD,
        DayOfWeek.Fri,
        ClassNumber.SECOND
    ),
    Schedule(
        KKSLab,
        group29z,
        "1-325",
        TypeOfWeek.EVEN,
        DayOfWeek.Tue,
        ClassNumber.SECOND
    ),
    Schedule(
        KKSLec,
        flow29,
        "1-350",
        TypeOfWeek.EVEN,
        DayOfWeek.Tue,
        ClassNumber.THIRD
    ),
    Schedule(
        testLec,
        flow29,
        "1-400",
        TypeOfWeek.EVEN,
        DayOfWeek.Wed,
        ClassNumber.SECOND
    ),
    Schedule(
        testLab,
        group29z,
        "1-467",
        TypeOfWeek.EVEN,
        DayOfWeek.Wed,
        ClassNumber.THIRD
    ),
    Schedule(
        ISSLec,
        flow29,
        "1-112",
        TypeOfWeek.EVEN,
        DayOfWeek.Wed,
        ClassNumber.FOURTH
    ),
    Schedule(
        ISSLab,
        group29z,
        "1-325",
        TypeOfWeek.EVEN,
        DayOfWeek.Wed,
        ClassNumber.FIFTH
    ),
    Schedule(
        IISLec,
        flow29,
        "1-112",
        TypeOfWeek.EVEN,
        DayOfWeek.Thu,
        ClassNumber.SECOND
    ),
    Schedule(
        PPLec,
        flow29,
        "1-112",
        TypeOfWeek.EVEN,
        DayOfWeek.Fri,
        ClassNumber.SECOND
    ),
    Schedule(
        PPLab,
        group29z,
        "1-325",
        TypeOfWeek.EVEN,
        DayOfWeek.Fri,
        ClassNumber.THIRD
    ),
)