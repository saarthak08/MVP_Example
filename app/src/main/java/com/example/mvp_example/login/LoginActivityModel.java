package com.example.mvp_example.login;

import javax.inject.Inject;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository loginRepository;

    @Inject
    public LoginActivityModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void createUser(String fName, String lName) {
        loginRepository.saveuser(new User(fName,lName));

    }

    @Override
    public User getUser() {
        return loginRepository.getUser();
    }
}
