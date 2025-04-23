package todolist.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todolist.app.entity.Todo;
import todolist.app.service.TodoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;


    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/creater")
    List<Todo> creater(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @PutMapping("/update")
    List<Todo> update(@RequestParam Todo todo) {
        return todoService.update(todo);
    }

    @GetMapping("/list")
    List<Todo> list() {
        return todoService.list();
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
