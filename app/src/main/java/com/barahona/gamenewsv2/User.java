package com.barahona.gamenewsv2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
public class User {

    @PrimaryKey
    private int id_user;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "pass")
    private String password;

    @ColumnInfo(name = "fav")
    private ArrayList<String> fav = new ArrayList<>();


    public User(int id_user, String username, String password, ArrayList<String> fav) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.fav.addAll(fav);
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getFav() {
        return fav;
    }

    public void setFav(ArrayList<String> fav) {
        this.fav = fav;
    }
}
