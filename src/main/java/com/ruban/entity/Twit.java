package com.ruban.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "twit_table")
public class Twit {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id_twit;
    public String getPostText() {
        return postText;
    }
    public void setPostText(String postText) {
        this.postText = postText;
    }
    @Column(name = "postText", nullable = false,length = 500)
    private String postText;
    public String getLogin() {return login;}



    public void setLogin(String login) {
        this.login = login;
    }
    @Column(name = "id_user",nullable = false)
    private String login;

    public Twit(){}

    public long getId_twit() {
        return id_twit;
    }
    public void setId_twit(long id_twit) {
        this.id_twit = id_twit;
    }



}
