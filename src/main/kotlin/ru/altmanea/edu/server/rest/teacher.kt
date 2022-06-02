package ru.altmanea.edu.server.rest

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.altmanea.edu.server.model.Config
import ru.altmanea.edu.server.repo.teacherRepo

fun Route.teacher() {
    route(Config.teacherPath) {
        get {
            if (!teacherRepo.isEmpty()) {
                call.respond(teacherRepo.findAll())
            } else {
                call.respondText("No lessons found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing or malformed id",
                status = HttpStatusCode.BadRequest
            )
            val teacherItem =
                teacherRepo[id] ?: return@get call.respondText(
                    "No teacher with name $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(teacherItem)
        }
    }
}