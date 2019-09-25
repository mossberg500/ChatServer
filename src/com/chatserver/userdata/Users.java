package com.chatserver.userdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Users {
    private static final Users users = new Users();
    private final Map<String, User> usersMap;
    private ObjectMapper mapper;

    private Users() {
        usersMap = new HashMap<>();
        mapper = new ObjectMapper();
    }

    public static Users getInstance() {
        return users;
    }

    public synchronized void addUser(User user) {
        if (null != user) {
            usersMap.putIfAbsent(user.getName(), user);
        }
    }

    public synchronized void removeUser(String name) {
        if (usersMap.containsKey(name)) {
            usersMap.remove(name);
        }
    }

    public User getUser(String name) {
        User user = new User();
        if (usersMap.containsKey(name)) {
            user = usersMap.get(name);
        }

        return user;
    }

    public List<String> getlist() {
        List<String> userList = new ArrayList<>();
        Set<String> keys = usersMap.keySet();
        for (String s : keys) {
            User user = usersMap.get(s);
            userList.add(user.toString());
        }
        return userList;
    }

    public String getPass(String name) {
        String pass = "";
        if (usersMap.containsKey(name)) {
            pass = usersMap.get(name).getPassword();
        }
        return pass;
    }

    public String getStatus(String name) {
        boolean status = usersMap.get(name).isStatus();
        if (status) {
            return "active";
        }
        return "off";
    }

    public String toJson(List<String> usersList) {
        String json = "";
        try {
            json = mapper.writeValueAsString(usersList);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    public List<User> activeUser() {
        List<User> activeUsers = new ArrayList<>();
        Set<String> keys = usersMap.keySet();
        for (String s : keys) {
            User user = usersMap.get(s);
            if (user.isStatus()) {
                activeUsers.add(user);
            }
        }
        return activeUsers;
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

}
