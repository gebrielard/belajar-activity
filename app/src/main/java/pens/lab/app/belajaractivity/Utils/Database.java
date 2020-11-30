package pens.lab.app.belajaractivity.Utils;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.data.model.Task;

public class Database {
    private ArrayList<Task> tasks;
    private static Database instance;
    private static int id = 1;

    public Database(){
        tasks = new ArrayList<>();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(String title, String desc){
        Task newTask = new Task(id, title, desc);
        tasks.add(newTask);
        id++;
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
}
