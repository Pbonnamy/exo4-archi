package org.example.exporter;

import org.example.model.Todo;
import org.example.model.TodoList;

import java.util.Date;

public class ConsoleExporter implements Exporter {

    public void export(TodoList todoList) {
        for (int i = 0; i < todoList.getTodos().size(); i++) {
            Todo todo = todoList.getTodos().get(i);

            String status = todo.isDone() ? "X" : " ";
            String id = String.format("%02d", i + 1);
            String timeLeft = formatDate(todo.getDate());

            System.out.println("[" + id + "][" + status + "] " + todo.getText() + " (" + timeLeft + ")");
        }
    }

    private String formatDate(Date date) {
        long diff = Math.abs(date.getTime() - new Date().getTime());
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        if (diffDays > 0) {
            return diffDays + " day" + (diffDays > 1 ? "s" : "");
        } else if (diffHours > 0) {
            return diffHours + " hour" + (diffHours > 1 ? "s" : "");
        } else if (diffMinutes > 0) {
            return diffMinutes + " minute" + (diffMinutes > 1 ? "s" : "");
        } else {
            return diffSeconds + " second" + (diffSeconds > 1 ? "s" : "");
        }
    }
}
