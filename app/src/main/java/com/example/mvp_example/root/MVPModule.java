package com.example.mvp_example.root;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MVPModule {
    private Application application;
    public MVPModule(Application application)
    {
        this.application=application;
    }

    @Provides
    @Singleton
    public Context getContext()
    {
        return application;
    }
}
