package component

import kotlinx.html.js.onClickFunction
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.Props
import react.dom.*
import react.fc
import react.query.useQuery
import react.router.dom.Link
import ru.altmanea.edu.server.model.Config
import ru.altmanea.edu.server.model.Item
import ru.altmanea.edu.server.model.Teacher
import wrappers.QueryError
import wrappers.fetchText

external interface  TeacherListProps: Props {
    var teachers: List<Item<Teacher>>
}
fun fcTeacherList() = fc("TeacherList0") { props: TeacherListProps ->
    h3 { +"Преподаватели" }
    ol {
        props.teachers.map { teacher ->
            li {
                Link {
                    attrs.to = "/teachers/${teacher.elem.surname}"
                    +"${teacher.elem.shortname} \t"
                }
            }
        }
    }
}

fun fcContainerTeachersList() = fc("ContainerTeacherList") { _: Props ->
    val query = useQuery<String, QueryError, String, String>(
        "TeacherList",
        {
            fetchText(
                Config.teacherURL
            )
        }
    )
    if (query.isLoading or query.isLoading) div { +"Loading .." }
    else if (query.isError or query.isError) div { +"Error!" }
    else {
        val teachers: List<ClientTeacherItem> =
            Json.decodeFromString(query.data ?: "")
        child(fcTeacherList()) {
            attrs.teachers = teachers
        }
    }
}