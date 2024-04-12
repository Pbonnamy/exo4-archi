package org.example;

import org.example.exporter.ConsoleExporter;
import org.example.exporter.Exporter;
import org.example.exporter.JsonExporter;
import org.example.exporter.ReportExporter;
import org.example.model.Action;
import org.example.model.Todo;
import org.example.model.TodoList;
import org.example.parser.JsonParser;
import org.example.parser.Parser;

public class Main {
    public static void main(String[] args) {
        String json = "todos.json";
        String report = "report.txt";
        Parser jsonParser = new JsonParser(json);
        TodoList todoList = jsonParser.parse();

        Exporter consoleExporter = new ConsoleExporter();
        Exporter jsonExporter = new JsonExporter(json);
        Exporter reportExporter = new ReportExporter(report);

        switch (Action.fromString(args[0])) {
            case ADD:
                todoList.add(new Todo(args[1]));
                break;
            case LIST:
                consoleExporter.export(todoList);
                break;
            case REMOVE:
                todoList.remove(Integer.parseInt(args[1]) - 1);
                jsonExporter.export(todoList);
                break;
            case DONE:
                todoList.markAsDone(Integer.parseInt(args[1]) - 1);
                jsonExporter.export(todoList);
                break;
            case REPORT:
                reportExporter.export(todoList);
                break;
            case null:
                break;
        }
    }
}