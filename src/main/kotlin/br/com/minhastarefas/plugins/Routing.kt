package br.com.minhastarefas.plugins

import br.com.minhastarefas.models.Task
import br.com.minhastarefas.repositories.TasksRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = TasksRepository()
    routing {
        get("/tasks") {
            call.respond(repository.tasks)
        }

        post(path = "/tasks") {
            val task = call.receive<Task>()
            repository.save(task)
            call.respondText ( "Task was create", status = HttpStatusCode.Created )

        }
    }
}
