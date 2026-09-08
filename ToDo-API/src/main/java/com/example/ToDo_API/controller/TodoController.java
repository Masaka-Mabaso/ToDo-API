package com.example.ToDo_API.controller;

import com.example.ToDo_API.entity.Todo;
import com.example.ToDo_API.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAll(){
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public Todo getOne(@PathVariable Long id){
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        todoService.deleteTodo(id);
    }
}