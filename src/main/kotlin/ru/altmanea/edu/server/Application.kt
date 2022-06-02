package ru.altmanea.edu.server

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import ru.altmanea.edu.server.excel.writeIntoExcel
import ru.altmanea.edu.server.model.Config
import ru.altmanea.edu.server.repo.*
import ru.altmanea.edu.server.rest.schedule
import ru.altmanea.edu.server.rest.teacher

fun main() {
    writeIntoExcel()
    embeddedServer(
        Netty,
        port = Config.serverPort,
        host = Config.serverDomain,
        watchPaths = listOf("classes", "resources")
    ) {
        main()
    }.start(wait = true)
}

fun Application.main(test: Boolean = true) {
    if(test) {
        schedulesRepoTestData.forEach { scheduleRepo.create(it) }
        teacherRepoTest.forEach { teacherRepo.create(it)}
    }
    install(ContentNegotiation) {
        json()
    }
    routing {
        schedule()
        teacher()
        index()
    }
}