package pens.lab.app.belajaractivity.modul.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import pens.lab.app.belajaractivity.FirstActivity;
import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.base.BaseFragment;
import pens.lab.app.belajaractivity.modul.profile.ProfileActivity;

import static android.content.Context.MODE_PRIVATE;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {

    TextView tvEmail;
    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    private String email;

    public LoginFragment() {
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new LoginPresenter(this);
        mPresenter.start();

        tvEmail = fragmentView.findViewById(R.id.email_tv);
        etEmail = fragmentView.findViewById(R.id.et_email);
        etPassword = fragmentView.findViewById(R.id.et_password);
        btnLogin = fragmentView.findViewById(R.id.bt_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setBtLoginClick();
                tvEmail.setText(etEmail.getText().toString());
                saveData();
            }
        });

        loadData();
        updateViews();

        setTitle("My Login View");

        return fragmentView;

    }

    public void setBtLoginClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email,password);
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, tvEmail.getText().toString());
        editor.apply();

        Toast.makeText(this.activity, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        email = sharedPreferences.getString(TEXT, "");
    }

    public void updateViews(){
        tvEmail.setText(email);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToProfile(String email, String password) {
        Intent intent = new Intent(activity, ProfileActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        startActivity(intent);
    }

}
