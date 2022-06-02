package component

import kotlinx.html.classes
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.Props
import react.dom.*
import react.fc
import react.query.useQuery
import react.query.useQueryClient
import react.router.useParams
import ru.altmanea.edu.server.model.*
import wrappers.QueryError
import wrappers.fetchText
import kotlin.text.Typography.ndash

external interface TeacherProps : Props {
    var teacher: Teacher
    var scheduleItem:  List<Item<Schedule>>

}
fun fcTeacher() = fc("Teacher"){ props: TeacherProps ->
    h3{
        +props.teacher.fullname
    }
    table {
        attrs.classes = setOf("tableItem")
        tr {
            td{
                +"Пары"
            }
            para.forEach {
                td{
                    +it
                }
            }
        }
        tr {
            td{
                +"Время"
            }
            classNumber.forEach {
                td{
                    +"$it"
                }
            }
        }
        for( type in cellSch){
            for (day in type.second){
                tr {
                    if(type.first == TypeOfWeek.EVEN) attrs.classes = setOf("even")
                    td {
                        +"${day}"
                    }
                    for (num in classNumber){
                        val sch =
                            props.scheduleItem.find { it.elem.number == num && it.elem.dayOfWeek == day && it.elem.typeOfWeek == type.first }
                        if (sch == null) {
                            td {
                                +"$ndash"
                            }
                        } else {
                            td {
                                +"${sch.elem.Lesson.name}\n${sch.elem.Lesson.type}\n${sch.elem.flow.groups}${sch.elem.flow.subgroup}\n${sch.elem.audience}"
                            }
                        }
                    }
                }
            }
        }
    }
}
fun fcContainerTeacher() = fc("ContainerTeacher") {_: Props ->
    val lessonParams = useParams()
    val teacherSurname = lessonParams["surname"] ?: "Route param error"
    val query = useQuery<String, QueryError, String, String>(
        "$teacherSurname schedule",
        { fetchText(
            Config.scheduleURL + "teacher/${teacherSurname}"
        )}
    )
    if (query.isLoading or query.isLoading) div { +"Loading .." }
    else if (query.isError or query.isError) div { +"Error!" }
    else {
        val schedule: List<ClientScheduleItem> =
            Json.decodeFromString(query.data ?: "")
        child(fcTeacher()) {
            attrs.scheduleItem = schedule
            attrs.teacher = schedule.findLast { it.elem.Lesson.teachers.surname == teacherSurname }!!.elem.Lesson.teachers
        }
    }
}