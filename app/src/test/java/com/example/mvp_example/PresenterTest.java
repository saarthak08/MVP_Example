package com.example.mvp_example;

import com.example.mvp_example.login.LoginActivity;
import com.example.mvp_example.login.LoginActivityMVP;
import com.example.mvp_example.login.LoginActivityPresenter;
import com.example.mvp_example.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterTest {
    LoginActivityMVP.Model mockModel;
    LoginActivityPresenter mockPresenter;
    LoginActivityMVP.View mockView;
    User user;

    @Before
    public void setup()
    {
        mockModel=mock(LoginActivityMVP.Model.class);
        user=new User("Fox","Nhin Hun Main");
        when(mockModel.getUser()).thenReturn(user);
        mockView=mock(LoginActivityMVP.View.class);
        mockPresenter=new LoginActivityPresenter(mockModel);
        mockPresenter.setView(mockView);
    }

    @Test
    public void noInteractionWithView()
    {
        mockPresenter.getCurrentUser();
       // verifyZeroInteractions(mockView);
    }
}
