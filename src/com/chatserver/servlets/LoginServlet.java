package com.chatserver.servlets;

import com.chatserver.userdata.User;
import com.chatserver.userdata.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private HttpSession session;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        String userName = request.getParameter("login");
        String password = request.getParameter("pass");
        String room = request.getParameter("room");
        Users userList = Users.getInstance();
        User user = new User();
        String json = "";

        if (userList.getUsersMap().containsKey(userName)) {
            if (userList.getPass(userName).equalsIgnoreCase(password)) {
                json = user.toJson(userList.getUser(userName));

            }
        } else {

            userList.addUser(new User(userName, password, room, true));
            json = user.toJson(userList.getUser(userName));

        }
        if (json != null) {

            try {
                OutputStream os = response.getOutputStream();
                byte[] buf = json.getBytes(StandardCharsets.UTF_8);
                os.write(buf);
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
    }


}

