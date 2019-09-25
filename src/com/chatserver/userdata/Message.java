package com.chatserver.userdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private static ObjectMapper mapper = new ObjectMapper();
    private String date = (new SimpleDateFormat("yyyy.MM.dd hh:mm:ss ")).format(new Date());
    private String from;
    private String to;
    private String text;
    private String room;

    public Message() {
    }

    public Message(String from, String to, String text, String room) {
        this.from = from;
        this.to = to;
        this.text = text;
        this.room = room;
    }

    public static Message fromJSON(String s) {
        Message message = null;
        try {
            message = mapper.readValue(s, Message.class);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;

    }

    public String toJSON() {
        String json = "";
        try {
            json = mapper.writeValueAsString(this);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("[").append(" Date: ").append(date)
                .append(", From: ").append(from).append(", To: ").append(to)
                .append("] ").append(text)
                .toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
