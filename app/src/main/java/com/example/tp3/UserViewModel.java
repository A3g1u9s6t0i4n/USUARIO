package com.example.tp3;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {


    private List<Usuario> userList = new ArrayList<>();

    public List<Usuario> getUserList(){
        return userList;
    }


    public void addUser(Usuario usuario){
        userList.add(usuario);
    }
}
