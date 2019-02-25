package com.example.mvp_example.login;

public interface LoginActivityMVP {
    interface View{
        String getFirstName();
        String getLastName();
        void showUserNotAvailable();
        void saveUserMessage();
        void showInputError();
        void setFirstName(String fName);
        void setLastName(String lName);
    }

    interface Presenter{
        void setView(LoginActivityMVP.View View);
        void LoginButtonClicked();
        void getCurrentUser();
    }
    interface Model{
        void createUser(String fName, String lName);
        User getUser();

    }
}
