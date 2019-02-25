package com.example.mvp_example.login;

public interface LoginRepository {
    void saveuser(User user);
    User getUser();
}
