package org.example.actions;

import org.example.Exporter;
import org.example.Todo;
import org.example.TodoList;

import java.util.List;

public class DoneAction implements Action {

    private final int index;
    private final TodoList todoList;
    private final Exporter exporter;

    public DoneAction(int index, TodoList todoList, Exporter exporter) {
        this.index = index;
        this.todoList = todoList;
        this.exporter = exporter;
    }

    public void execute() {
        List<Todo> todos = this.todoList.getTodos();
        Todo todo = todos.get(this.index);
        todo.setDone(true);
        todos.set(this.index, todo);
        this.todoList.setTodos(todos);

        this.exporter.export(this.todoList);
    }
}
