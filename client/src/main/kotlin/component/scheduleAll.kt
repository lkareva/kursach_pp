package component


import csstype.HtmlAttributes
import kotlinext.js.jso
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.html.*
import kotlinx.html.stream.createHTML
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.khronos.webgl.ArrayBuffer
import org.w3c.dom.url.URL
import org.w3c.files.Blob
import org.w3c.files.BlobPropertyBag
import org.w3c.files.File
import react.Props
import react.createElement
import react.dom.*
import react.dom.html.AnchorTarget
import react.dom.onClick
import react.fc
import react.query.useMutation
import react.query.useQuery
import react.router.dom.Link
import react.useRef
import react.virtual.ScrollToIndexOptions
import react.virtual.VirtualOptions
import react.virtual.useVirtual
import ru.altmanea.edu.server.model.*
import styled.css
import styled.styledH2
import wrappers.QueryError
import wrappers.fetchBlob
import wrappers.fetchText
import kotlin.js.Promise


external interface ScheduleProps : Props {
    var teachers:  List<Item<Teacher>>
    var downloadURL: String
}
fun fcSchedule() = fc("ContainerSchedule") { props: ScheduleProps ->
    div {
        attrs.classes = setOf("btn")
        h2 {
        +"Расписание весеннего семестра 2021/2022 учебного года"
        }
        attrs.classes = setOf("btn")
        a {
            attrs {
                classes = setOf("download")
                href = props.downloadURL
                target = "_blank"
                attributes += "download" to "schedule.xls"
            }
            +"Скачать"
        }
    }
    div {
        attrs.id = "tableAll"
        table {
            tr {
                td {
                    attrs.colSpan = "30"
                    +"${TypeOfWeek.ODD}"
                }
                td {
                    attrs.rowSpan = "3"
                    +"ФИО преподавателя"
                }
                td {
                    attrs.colSpan = "30"
                    +"${TypeOfWeek.EVEN}"
                }
            }
            tr {
                for (i in typeOfWeek) {
                    dayOfWeek.forEach {
                        td {
                            attrs.colSpan = "5"
                            +"$it"
                        }
                    }
                }
            }
            tr {
                for (type in cellSch)
                    for (day in type.second)
                        classNumber.forEach {
                            td {
                                +"$it"
                            }
                        }
            }
            props.teachers.forEach {
                child(fcContainerScheduleItem()) {
                    attrs.teacher = it.elem
                }
            }
        }
    }
}
@Serializable
class ClientTeacherItem(
    override val elem: Teacher,
    override val uuid: String,
    override val etag: Long
) : Item<Teacher>

fun fcContainerSchedule() = fc("ContainerSchedule") { _: Props ->
    val query = useQuery<String, QueryError, String, String>(
        "TeacherSchedule",
        {
            fetchText(
                Config.teacherURL
            )
        }
    )
    val download = useQuery<Blob, QueryError, String, String>(
        "Download",
        {
            fetchBlob(
                Config.scheduleURL + "download/schedule.xls",
                jso{
                    method = "Get"
                    "Content-Type" to "application/vnd.ms-excel"
                }
            )
        }
    )
    if (query.isLoading or download.isLoading) div { +"Loading .." }
    else if (query.isError or download.isError) div { +"Error!" }
    else {
        val teachers: List<ClientTeacherItem> =
            Json.decodeFromString(query.data ?: "")
        val excel =  Blob(arrayOf(download.data))
        val downloadURL =  URL.createObjectURL(excel)//.substringAfterLast("/")
        child(fcSchedule()) {
            attrs.teachers = teachers
            attrs.downloadURL = downloadURL
        }
    }
}
