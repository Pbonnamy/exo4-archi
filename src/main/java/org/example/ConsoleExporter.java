package org.example;

public class ConsoleExporter implements Exporter {

    private final TodoList todoList;

    public ConsoleExporter(TodoList todoList) {
        this.todoList = todoList;
    }

    public void export() {
        for (int i = 0; i < todoList.getTodos().size(); i++) {
            Todo todo = todoList.getTodos().get(i);
            String status = todo.isDone() ? "X" : " ";
            String id = String.format("%02d", i + 1);
            System.out.println("[" + id + "][" + status + "] " + todo.getText() + " (" + todo.getDate() + ")");
        }
    }
}
