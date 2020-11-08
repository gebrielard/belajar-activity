package pens.lab.app.belajaractivity.modul.profile;

import android.os.Bundle;

/**
 * Created by fahrul on 13/03/19.
 */

public class ProfilePresenter implements ProfileContract.Presenter{
    private final ProfileContract.View view;

    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {}

    @Override
    public void getProfileInfo(Bundle bundle){
        String email = bundle.getString("email");
        String password = bundle.getString("password");
        view.setProfile(email, password);
    }

}
