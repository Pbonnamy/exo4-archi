package org.example;

import java.util.List;

public class TodoList {
    List<Todo> todos;

    public TodoList(List<Todo> todos) {
        this.todos = todos;
    }

    public void add(Todo todo) {
        todos.add(todo);
    }

    public void remove(int index) {
        todos.remove(index);
    }

    public void markAsDone(int index) {
        todos.get(index).setDone(true);
    }
}
