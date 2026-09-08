package com.example.ToDo_API.service;

import com.example.ToDo_API.entity.Todo;
import com.example.ToDo_API.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    //------------- Get all To-Dos -----------------------
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    //--------------- Get one To-Do ------------------------
    public Todo getTodoById(Long id){
        return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("Todo not foung with id: " + id));
    }

    //---------------- Create a To-Do -------------------------
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    //------------------- Update a To-Do -----------------------------
    public Todo updateTodo(Long id, Todo updatedTodo){
        Todo existing = getTodoById(id);
        existing.setTitle(updatedTodo.getTitle());
        existing.setDescription(updatedTodo.getDescription());
        existing.setCompleted(updatedTodo.getCompleted());
        return todoRepository.save(existing);
    }

    //------------------- Delete a To-Do ------------------------------
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}