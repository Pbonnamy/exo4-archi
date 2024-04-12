package org.example;

import java.util.List;

public class TodoList {
    List<Todo> todos;

    public TodoList(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
