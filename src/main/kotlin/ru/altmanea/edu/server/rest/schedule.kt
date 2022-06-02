package ru.altmanea.edu.server.rest

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.altmanea.edu.server.model.Config.Companion.schedulePath
import ru.altmanea.edu.server.model.Lesson
import ru.altmanea.edu.server.model.Schedule
import ru.altmanea.edu.server.repo.RepoItem
import ru.altmanea.edu.server.repo.scheduleRepo
import java.io.File

fun Route.schedule() {
    route(schedulePath) {
        get {
            if (!scheduleRepo.isEmpty()) {
                call.respond(scheduleRepo.findAll())
            } else {
                call.respondText("No lessons found", status = HttpStatusCode.NotFound)
            }
        }
        get("download/schedule.xls"){
            val file = File("src/main/resources/schedule.xls")
            if(file.exists()) {
                call.respondFile(file)
            }
            else call.respond(HttpStatusCode.NotFound)
        }
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val scheduleItem =
                scheduleRepo[id] ?: return@get call.respondText(
                    "No schedule with name $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(scheduleItem)
        }
        get("teacher/{surname}") {
            val teacherSurname = call.parameters["surname"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val scheduleItem =
                scheduleRepo.find { it.Lesson.teachers.surname == teacherSurname }
            call.respond(scheduleItem.sortedWith(compareBy({ it.elem.typeOfWeek}, { it.elem.dayOfWeek}, {it.elem.number})))
        }
    }
}