package com.websocket.client;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String url = "ws://localhost:8080/data/";
        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketSession session = (WebSocketSession) client.doHandshake(new TextWebSocketHandler() {
            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                System.out.println("connect to server");
                while (true) {
                    System.out.println("enter:");
                    String mess = scanner.nextLine();
                    session.sendMessage(new TextMessage(mess));
                    System.out.println("sent: " + mess);

                }
            }

            @Override
            protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
                System.out.println(message.getPayload());
                session.close();
            }
        },String.valueOf(new URI(url))).get();
    }
}
