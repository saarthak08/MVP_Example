package com.example.mvp_example;

import com.example.mvp_example.login.LoginActivity;
import com.example.mvp_example.login.LoginActivityMVP;
import com.example.mvp_example.login.LoginActivityPresenter;
import com.example.mvp_example.login.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    @Test
    public void loadUserFromRepositoryWhenValidUserIsPresent()
    {
        mockPresenter.getCurrentUser();
        verify(mockModel,times(1)).getUser();
        verify(mockView,times(1)).setFirstName("Fox");
        verify(mockView,times(1)).setLastName("Nhin Hun Main");
        verify(mockView,never()).showUserNotAvailable();
    }

    @Test
    public void shouldShowErrorWhenUserIsNotAvailable()
    {
        when(mockModel.getUser()).thenReturn(null);
        mockPresenter.getCurrentUser();
        verify(mockModel,times(1)).getUser();
        verify(mockView,never()).setFirstName("Fox");
        verify(mockView,never()).setLastName("Nhin Hun Main");
        verify(mockView,times(1)).showUserNotAvailable();
    }
}
