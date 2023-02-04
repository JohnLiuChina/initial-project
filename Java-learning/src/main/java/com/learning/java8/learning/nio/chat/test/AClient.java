package com.learning.java8.learning.nio.chat.test;

import com.learning.java8.learning.nio.chat.client.ChatClient;

import java.io.IOException;

public class AClient {

    public static void main(String[] args) {
        try {
            new ChatClient("A").startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
