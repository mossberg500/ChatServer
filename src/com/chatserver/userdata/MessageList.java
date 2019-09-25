package com.chatserver.userdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.LinkedList;
import java.util.List;

public class MessageList {
    private static final MessageList msgList = new MessageList();

    private static final int LIMIT = 100;
    private final List<Message> alllist = new LinkedList<Message>();
    private final List<Message> list_1 = new LinkedList<Message>();
    private final List<Message> list_2 = new LinkedList<Message>();
    private ObjectMapper mapper;

    private MessageList() {
        mapper = new ObjectMapper();
    }

    public static MessageList getInstance() {
        return msgList;
    }

    public synchronized void add(Message m) {
        if (m.getRoom().equalsIgnoreCase("all")) {
            addToList(alllist, m);
        } else if (m.getRoom().equalsIgnoreCase("1")) {
            addToList(list_1, m);
        } else if (m.getRoom().equalsIgnoreCase("2")) {
            addToList(list_2, m);
        }
    }

    private void addToList(List<Message> list, Message m) {
        if (list.size() + 1 == LIMIT) {
            list.remove(0);
        }
        list.add(m);
    }

    public synchronized String toJSON(int n, String room) {
        if (room.equals("all")) {
            return listToJson(alllist, n);
        } else if (room.equals("1")) {
            return listToJson(list_1, n);
        } else if (room.equals("2")) {
            return listToJson(list_2, n);
        }
        return "";
    }

    private String listToJson(List<Message> list, int n) {
        if (n == list.size()) {
            return null;
        }
        String json = "";
        try {
            json = mapper.writeValueAsString(JsonMessages.jsonMessages(list, n));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
