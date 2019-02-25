package com.example.mvp_example.root;

import com.example.mvp_example.login.LoginActivity;
import com.example.mvp_example.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MVPModule.class, LoginModule.class})
public interface MVPComponent {
    void inject(LoginActivity target);

}
