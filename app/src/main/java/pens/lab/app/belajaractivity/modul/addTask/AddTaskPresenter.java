package pens.lab.app.belajaractivity.modul.addTask;

import pens.lab.app.belajaractivity.data.model.Task;

public class AddTaskPresenter implements AddTaskContract.Presenter {
    private final AddTaskContract.View view;

    public AddTaskPresenter(AddTaskContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void saveData(String title, String description) {
        Task newTask = new Task(3, title, description);
        //save new task
        //then go back to task list
        view.redirectToTaskList();
    }
}
