package com.chatserver.userdata;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonMessages {


    public static List<Message> jsonMessages(List<Message> sourceList, int fromIndex) {
        List<Message>list = new ArrayList<>();
        for (int i = fromIndex; i < sourceList.size(); i++)
            list.add(sourceList.get(i));
        return list;
    }



}
