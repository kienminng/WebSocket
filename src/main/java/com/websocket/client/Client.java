package com.websocket.client;


import com.websocket.ws.DataHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URI;


public class Client {
    public static void main(String[] args) throws Exception {
        String serverUrl = "ws://localhost:8080/data/1";
        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketSession session = webSocketClient.doHandshake(new TextWebSocketHandler() {

            @Override
            public void afterConnectionEstablished(WebSocketSession session) throws Exception {
                System.out.println("Connected to server");
                // Send a message to the server
                String message = "Hello from client";
                while (true) {
                    session.sendMessage(new TextMessage(message));
                    System.out.println("Sent: " + message);
                    Thread.sleep(5000);
                }

            }

            @Override
            protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
                System.out.println("Received: " + message.getPayload());
                // Close the session after receiving a message
                session.close();
            }
        }, String.valueOf(new URI(serverUrl))).get();

        session.close();
    }
}
