package com.example.bt1.model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;

public class User implements Serializable {

    public User() {
    }

    public User(String login, String url, String avatar_url) {
        this.login = login;
        this.url = url;
        this.avatar_url = avatar_url;
    }



    private String login;



    private String url;



    private String avatar_url;



    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getAvatar_url() {
        return this.avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }


}
