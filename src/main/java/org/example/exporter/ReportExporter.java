package org.example.exporter;

import org.example.model.Todo;
import org.example.model.TodoList;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportExporter implements Exporter {
    private final String filename;

    public ReportExporter(String filename) {
        this.filename = filename;
    }

    public void export(TodoList todoList) {

        try {
            FileWriter file = new FileWriter(filename, false);
            file.write("# Report\n");
            file.write("## Tasks done:\n");
            file.write("\n");

            for (int i = 0; i < todoList.getTodos().size(); i++) {
                Todo todo = todoList.getTodos().get(i);
                String date = formatDate(todo.getDate());

                if (todo.isDone()) {
                    file.write("- " + todo.getText() + " (" + date + ")\n");
                }
            }

            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
}
