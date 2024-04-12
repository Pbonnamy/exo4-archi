package org.example.model;

import java.util.Date;

public class Todo {
    private final Date date;
    private final String text;
    private boolean done;

    public Todo(String text) {
        this.date = new Date();
        this.text = text;
        this.done = false;
    }

    public Todo(String text, Date date, boolean done) {
        this.date = date;
        this.text = text;
        this.done = done;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
