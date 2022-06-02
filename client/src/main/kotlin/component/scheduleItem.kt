package component

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.Props
import react.dom.*
import react.fc
import react.query.useQuery
import ru.altmanea.edu.server.model.*
import wrappers.QueryError
import wrappers.fetchText

external interface ScheduleItemProps : Props {
    var teacher: Teacher
    var scheduleItem:  List<Item<Schedule>>

}
fun fcScheduleItem() = fc("ScheduleItem") { props:ScheduleItemProps ->
    tr {
        for (type in cellSchplus) {
            if(type.first == null){
                td {
                    +props.teacher.fullname
                }
            }
            else {
                for (day in type.second) {
                    for (num in classNumber) {
                        val sch =
                            props.scheduleItem.find { it.elem.number == num && it.elem.dayOfWeek == day && it.elem.typeOfWeek == type.first }
                        if (sch == null) {
                            td { }
                        } else {
                            td {
                                +"${sch.elem.Lesson.type}\n${sch.elem.flow.groups}${sch.elem.flow.subgroup}"
                                br{}
                                +sch.elem.audience
                            }
                        }
                    }
                }
            }
        }
    }
}

@Serializable
class ClientScheduleItem(
    override val elem: Schedule,
    override val uuid: String,
    override val etag: Long
) : Item<Schedule>

external interface ContainerScheduleItemProps : Props {
    var teacher: Teacher
}

fun fcContainerScheduleItem() = fc("ContainerScheduleItem") { props: ContainerScheduleItemProps ->
    val query = useQuery<String, QueryError, String, String>(
        props.teacher.surname,
        {
            fetchText(
                Config.scheduleURL + "teacher/${props.teacher.surname}"
            )
        }
    )
    if (query.isLoading or query.isLoading) div { +"Loading .." }
    else if (query.isError or query.isError) div { +"Error!" }
    else {
        val schedule: List<ClientScheduleItem> =
            Json.decodeFromString(query.data ?: "")
        child(fcScheduleItem()) {
            attrs.scheduleItem = schedule
            attrs.teacher = props.teacher
        }
    }
}