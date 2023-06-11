package ru.naumov.tasker.service;

import ru.naumov.tasker.model.TodoItem;

import java.util.Optional;

public interface TodoItemService {
    Iterable<TodoItem> getAllTodoItem();

    Optional<TodoItem> getTodoItem(long id);

    TodoItem save(TodoItem item);

    void delete(TodoItem item);
}
