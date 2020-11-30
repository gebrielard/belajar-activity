package pens.lab.app.belajaractivity.modul.todolist;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface TodolistContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter {

    }
}
