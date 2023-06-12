package ru.naumov.tasker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.naumov.tasker.model.TodoItem;
import ru.naumov.tasker.repository.TodoItemRepository;

import java.time.Instant;
import java.util.Optional;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    private TodoItemRepository repository;

    public Iterable<TodoItem> getAllTodoItem() {
        return repository.findAll();
    }

    public Optional<TodoItem> getTodoItem(long id) {
        return repository.findById(id);
    }

    public TodoItem save(TodoItem item) {
        if (item.getId() == null) {
            item.setCreatedAt(Instant.now());
        }
        item.setUpdatedAt(Instant.now());
        return repository.save(item);
    }

    public void delete(TodoItem item) {
        repository.delete(item);
    }
}