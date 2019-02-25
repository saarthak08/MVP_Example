package com.example.mvp_example.login;

import android.support.annotation.Nullable;

import javax.inject.Inject;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {
    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    @Inject
    public LoginActivityPresenter(LoginActivityMVP.Model model)
    {
        this.model=model;
    }
    @Override
    public void setView(LoginActivityMVP.View View) {
            this.view=View;
    }

    @Override
    public void LoginButtonClicked() {
        if(view!=null)
        {
            if(view.getFirstName().trim().equals("") ||  view.getLastName().trim().equals(""))
            {
                view.showInputError();
            }
            else
            {
                model.createUser(view.getFirstName(),view.getLastName());
                view.saveUserMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user=model.getUser();
        if(user==null)
        {
            if(view!=null)
            {
                view.showUserNotAvailable();
            }
        }else
        {
         if(view!=null)
         {
             view.setFirstName(user.getFirstName());
             view.setLastName(user.getLastName());
         }
        }

    }
}
