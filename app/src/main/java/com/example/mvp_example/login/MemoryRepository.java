package com.example.mvp_example.login;

import javax.inject.Inject;

public class MemoryRepository implements LoginRepository {

    private User user;
    @Override
    public void saveuser(User user) {
        if(user==null)
        {
            user=getUser();
        }
        this.user=user;

    }

    @Override
    public User getUser() {

        if(user==null)
        {
            User user=new User("Fox","Mulder");
            user.setId(0);
            return user;
        }else
            return  user;
    }
}
