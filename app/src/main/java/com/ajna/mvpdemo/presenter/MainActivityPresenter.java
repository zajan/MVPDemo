package com.ajna.mvpdemo.presenter;

import com.ajna.mvpdemo.model.User;

public class MainActivityPresenter {

    private User user;
    private View view;

    public MainActivityPresenter(View view) {
        user = new User();
        this.view = view;
    }

    public void updateInfo(String login, String password){
        user.setLogin(login);
        view.updateLoginInfo(user.getLogin());

        user.setPassword(password);
        view.updatePasswordInfo(user.getPassword());
    }

    public interface View{
        void updateLoginInfo(String login);
        void updatePasswordInfo(String password);
    }
}
