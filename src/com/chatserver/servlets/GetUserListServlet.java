package com.chatserver.servlets;

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
import java.util.List;

@WebServlet("/users")
public class GetUserListServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
            Users users = Users.getInstance();
            List<String> userList = users.getlist();
            String toJson = users.toJson(userList);
            if (null != toJson) {
                try {
                    OutputStream os = response.getOutputStream();
                    byte[] buf = toJson.getBytes(StandardCharsets.UTF_8);
                    os.write(buf);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    }

}
