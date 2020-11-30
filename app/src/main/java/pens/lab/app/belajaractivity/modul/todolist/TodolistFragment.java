package pens.lab.app.belajaractivity.modul.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.Utils.Database;
import pens.lab.app.belajaractivity.Utils.RecyclerViewAdapterTodolist;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.data.model.Task;
import pens.lab.app.belajaractivity.modul.addTask.AddTaskActivity;

public class TodolistFragment extends BaseFragment<TodolistActivity, TodolistContract.Presenter> implements TodolistContract.View{

    RecyclerView mRecyclerView;
    Button buttonAdd;
    Button buttonClearAll;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TodolistFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_todolist, container, false);
        mPresenter = new TodolistPresenter(this);
        mPresenter.start();

        buttonAdd = fragmentView.findViewById(R.id.btnAddTask);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNewTask();
            }
        });

        buttonClearAll = fragmentView.findViewById(R.id.btnClearAll);
        buttonClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        setTitle("To do List");

        return fragmentView;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        ArrayList<Task> dataList = new ArrayList<>();
//        dataList.add(new Task(1, "Test", "test 2"));

//        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recyclerViewToDoList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(new RecyclerViewAdapterTodolist(dataList));
    }

    @Override
    public void gotoNewTask() {
        Intent intent = new Intent(activity, AddTaskActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Task newTask = (Task) data.getSerializableExtra("newTask");
        RecyclerViewAdapterTodolist adapter = (RecyclerViewAdapterTodolist) mRecyclerView.getAdapter();

        adapter.addTask(newTask);
    }

    @Override
    public void setPresenter(TodolistContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
