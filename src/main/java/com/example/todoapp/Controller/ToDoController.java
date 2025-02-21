package com.example.todoapp.Controller;

import com.example.todoapp.Model.ToDoItem;
import com.example.todoapp.Service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/toDos")
@CrossOrigin(origins = "http://localhost:63342")
public class ToDoController {

    private final ToDoService todoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<ToDoItem> getAllToDos() {
        return todoService.getAllToDoItems();
    }

    @PostMapping("/")
    public ToDoItem createToDoItem(@RequestBody ToDoItem todoItem) {
        return todoService.saveToDoItem(todoItem);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ToDoItem> updateToDoItem(@PathVariable Long id, @RequestBody ToDoItem updatedItem) {
        ToDoItem existingItem = todoService.getToDoItemById(id);
        if (existingItem != null) {
            existingItem.setCompleted(updatedItem.isCompleted());
            return ResponseEntity.ok(todoService.saveToDoItem(existingItem));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteToDoItem(@PathVariable Long id) {
        ToDoItem existingItem = todoService.getToDoItemById(id);
        if (existingItem != null) {
            todoService.deleteToDoItem(existingItem);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
