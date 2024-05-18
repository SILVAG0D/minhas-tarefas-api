package br.com.minhastarefas.repositories

import br.com.minhastarefas.models.Task

class TasksRepository {

    val tasks get() = _tasks.toList()

    fun save(task: Task){
        _tasks.add(task)
    }

    companion object{
        private val _tasks = mutableListOf<Task>()

    }
}