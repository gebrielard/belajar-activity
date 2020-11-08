package pens.lab.app.belajaractivity.modul.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.todolist.TodolistActivity;


/**
 * Created by fahrul on 13/03/19.
 */

public class ProfileFragment extends BaseFragment<ProfileActivity, ProfileContract.Presenter> implements ProfileContract.View {

    TextView tvEmail;
    TextView tvPassword;
    Button btnShowTask;
    Bundle bundle;

    public ProfileFragment(Bundle bundle) {
        this.bundle = bundle;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_profile, container, false);

        tvEmail = fragmentView.findViewById(R.id.tv_email);
        tvPassword = fragmentView.findViewById(R.id.tv_password);

        mPresenter = new ProfilePresenter(this);
        mPresenter.start();
        mPresenter.getProfileInfo(bundle);

        btnShowTask = fragmentView.findViewById(R.id.btn_showTask);
        btnShowTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               goToTaskList();
            }
        });

        setTitle("Profile");

        return fragmentView;
    }

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setProfile(String email, String password) {
           tvEmail.setText(email);
           tvPassword.setText(password);
    }

    @Override
    public void goToTaskList() {
        Intent intent = new Intent(activity, TodolistActivity.class);
        startActivity(intent);
    }
}
