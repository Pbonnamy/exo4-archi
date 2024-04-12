package org.example.actions;

import org.example.Exporter;
import org.example.Todo;
import org.example.TodoList;

import java.util.List;

public class AddAction implements Action {
    private final String text;
    private final TodoList todoList;
    private final Exporter exporter;

    public AddAction(String text, TodoList todoList, Exporter exporter) {
        this.text = text;
        this.todoList = todoList;
        this.exporter = exporter;
    }

    public void execute() {
        Todo todo = new Todo(this.text);
        List<Todo> todos = this.todoList.getTodos();
        todos.add(todo);
        this.todoList.setTodos(todos);

        this.exporter.export(this.todoList);
    }
}
