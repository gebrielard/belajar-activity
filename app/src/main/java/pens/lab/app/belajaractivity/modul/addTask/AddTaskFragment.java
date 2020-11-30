package pens.lab.app.belajaractivity.modul.addTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.Utils.Database;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.data.model.Task;
import pens.lab.app.belajaractivity.modul.todolist.TodolistActivity;

public class AddTaskFragment extends BaseFragment<AddTaskActivity, AddTaskContract.Presenter> implements AddTaskContract.View{

    EditText etTitle;
    EditText etDescription;
    Button btnSave;
    private ArrayList<Task> taskList;
    private Database database;

    public AddTaskFragment() {
        this.database = Database.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_task, container, false);
        mPresenter = new AddTaskPresenter(this);
        mPresenter.start();

        taskList = database.getTasks();
        etTitle = fragmentView.findViewById(R.id.et_title);
        etDescription = fragmentView.findViewById(R.id.et_description);
        btnSave = fragmentView.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtSaveClick();
            }
        });

        setTitle("Add New Task");
        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(AddTaskContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToTaskList() {
        String taskTitle = etTitle.getText().toString();
        String taskDescription = etDescription.getText().toString();

        if(taskTitle != "" && taskDescription != "") {
            Intent returnIntent = new Intent();

            returnIntent.putExtra("newTask", new Task((int) Math.random() * 10000, taskTitle, taskDescription));

            activity.setResult(Activity.RESULT_OK, returnIntent);

            activity.finish();
        }

    }
}
