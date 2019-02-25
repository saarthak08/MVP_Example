package com.example.mvp_example.root;

import android.app.Application;

import dagger.Component;

public class MVPApp extends Application {
    private MVPComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component= DaggerMVPComponent.builder().mVPModule(new MVPModule(this)).build();
    }

    public MVPComponent getComponent() {
        return component;
    }
}
