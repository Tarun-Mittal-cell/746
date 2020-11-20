package com.sam2021.sam2021.controller.PCC;

import java.util.List;

import com.sam2021.sam2021.models.User;

public class memberwrapper {
    private List<User> userlist;

    public List<User> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<User> userlist) {
        this.userlist = userlist;
    }

    public memberwrapper(List<User> userlist) {
        this.userlist = userlist;
    }

    public memberwrapper() {
    }
        
        
}
