package com.chatserver.userdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String password;
    private boolean status;
    private String room;
    private ObjectMapper mapper = new ObjectMapper();

    public User() {
    }

    public User(String name, String password, String room, boolean status) {
        this.name = name;
        this.password = password;
        this.room = room;
        this.status = status;

    }

    public String toJson(User user){
        String json = "";
        try {
            json= mapper.writeValueAsString(user);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return  "{ name = "+name + ", status= " + status + ", room= " + room+"}";
    }

}
