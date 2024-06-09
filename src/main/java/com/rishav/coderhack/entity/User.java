package com.rishav.coderhack.entity;

import java.util.ArrayList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "users")
public class User {

    @Id
    private String userId;
    private String username;
    private int score;
    private ArrayList<String> badges;

    public User() {
        this.badges = new ArrayList<>();
        this.score = 0;
    }

    public User(String userId, String username) {
        this.userId = userId;
        this.username = username;
        this.badges = new ArrayList<>();
        this.score = 0;
    }

    public ArrayList<String> getBadges(){
        return badges;
    }

    public String getUserId(){
        return this.userId;
    }

    public String getUsername(){
        return this.username;
    }

    public int getScore(){
        return this.score;
    }

    public void setScore(int new_score){
        this.score = new_score;
    }

    public void setBadges(ArrayList<String> badges) {
        this.badges = badges;
    }
    
}


