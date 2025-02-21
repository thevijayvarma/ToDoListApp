package com.example.todoapp.Service;

import com.example.todoapp.Model.ToDoItem;
import com.example.todoapp.Repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoItemRepository todoItemRepository;

    @Autowired
    public ToDoService(ToDoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public ToDoItem saveToDoItem(ToDoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public List<ToDoItem> getAllToDoItems() {
        return (List<ToDoItem>) todoItemRepository.findAll();
    }

    public ToDoItem getToDoItemById(Long id) {
        return todoItemRepository.findById(id).orElse(null);
    }

    public List<ToDoItem> getCompletedToDoItems() {
        return todoItemRepository.findByCompleted(true);
    }

    public List<ToDoItem> getIncompleteToDoItems() {
        return todoItemRepository.findByCompleted(false);
    }

    public void deleteToDoItem(ToDoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}
