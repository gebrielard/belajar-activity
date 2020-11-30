package pens.lab.app.belajaractivity.modul.todolist;

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

}
