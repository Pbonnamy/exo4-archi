package org.example.actions;

import org.example.Exporter;
import org.example.Todo;
import org.example.TodoList;

import java.util.List;

public class RemoveAction implements Action {
    private final int index;
    private final TodoList todoList;
    private final Exporter exporter;

    public RemoveAction(int index, TodoList todoList, Exporter exporter) {
        this.index = index;
        this.todoList = todoList;
        this.exporter = exporter;
    }

    public void execute() {
        List<Todo> todos = this.todoList.getTodos();
        todos.remove(this.index);
        this.todoList.setTodos(todos);

        this.exporter.export(this.todoList);
    }
}
