package ru.naumov.tasker.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.naumov.tasker.model.TodoItem;
import ru.naumov.tasker.service.TodoItemService;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService service;

    @GetMapping("/create-todo")
    public String showCreateForm(){
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model){
        TodoItem item = new TodoItem();
        item.setDescription(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());
        service.save(item);
        return "redirect:/";
    }
}
