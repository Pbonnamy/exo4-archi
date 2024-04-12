package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonExporter implements Exporter {
    private String filename;
    private TodoList todoList;

    public JsonExporter(String filename, TodoList todoList) {
        this.filename = filename;
        this.todoList = todoList;
    }

    public void export() {
        JSONArray jsonArray = new JSONArray();

        for (Todo todo : todoList.getTodos()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("text", todo.getText());
            jsonObject.put("date", todo.getDate().getTime());
            jsonObject.put("done", todo.isDone());

            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toJSONString());
        try {

            FileWriter file = new FileWriter(filename, false);
            file.write(jsonArray.toJSONString());
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
