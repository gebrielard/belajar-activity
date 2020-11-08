package pens.lab.app.belajaractivity.modul.todolist;

import android.os.Bundle;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.data.model.Task;

/**
 * Created by fahrul on 13/03/19.
 */

public class TodolistPresenter implements TodolistContract.Presenter{
    private final TodolistContract.View view;

    public TodolistPresenter(TodolistContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public ArrayList<Task> getDataSet() {
        //get Data from DB
        ArrayList<Task> data = new ArrayList<Task> ();
        data.add(new Task("1","Task 1", "Kerjakan task satu"));
        data.add(new Task("2", "Task 2", "Kerjakan task dua"));
        return data;
    }

}
