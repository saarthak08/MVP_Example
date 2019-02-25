package com.example.mvp_example.root;

import android.app.Application;

import com.example.mvp_example.login.LoginModule;

import dagger.Component;

public class MVPApp extends Application {
    private MVPComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component= DaggerMVPComponent.builder().mVPModule(new MVPModule(this)).loginModule(new LoginModule()).build();
    }

    public MVPComponent getComponent() {
        return component;
    }
}
