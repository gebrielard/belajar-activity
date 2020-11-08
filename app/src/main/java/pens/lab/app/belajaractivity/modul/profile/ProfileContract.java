package pens.lab.app.belajaractivity.modul.profile;

import android.os.Bundle;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void setProfile(String email, String password);
        void goToTaskList();
    }

    interface Presenter extends BasePresenter {
        void getProfileInfo(Bundle bundle);
    }
}
