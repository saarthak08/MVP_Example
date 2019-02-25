package com.example.mvp_example.root;

import com.example.mvp_example.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MVPModule.class)
public interface MVPComponent {
    void inject(LoginActivity target);

}
