package com.example.mvp_example.login;


import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {


    @Provides
    public LoginActivityMVP.Presenter getPresenter(LoginActivityMVP.Model model)
    {
        return  new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model getModel(LoginRepository loginRepository)
    {
        return new LoginActivityModel(loginRepository);
    }

    @Provides
    public  LoginRepository getLoginRepository()
    {
        return new MemoryRepository();
    }
}
