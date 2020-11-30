package pens.lab.app.belajaractivity.modul.addTask;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

public interface AddTaskContract {
    interface View extends BaseView<Presenter> {
        void redirectToTaskList();
    }

    interface Presenter extends BasePresenter {
        void saveData(String title, String description);
    }
}