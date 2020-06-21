package com.example.cipher;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    String user;
    String pass;
    Context context;
    SharedPreferences sharedPreferences;
    public String getUser() {
        pass=sharedPreferences.getString("user","");
        return user;
    }

    public void setUser(String user) {
        this.user = user;
        sharedPreferences.edit().putString("name",user).commit();
    }

    public String getPass() {
        pass=sharedPreferences.getString("pass","");
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        sharedPreferences.edit().putString("pass",pass).commit();
    }

    public User(Context context) {
        this.context=context;
        sharedPreferences = context.getSharedPreferences("login_deatils",Context.MODE_PRIVATE);

    }

    public void remove(){
        sharedPreferences.edit().clear().commit();
    }
}
