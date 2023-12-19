//package com.websocket.config;
//
//import com.websocket.ws.DataHandler;
//import com.websocket.ws.StompSessionHandler;
//import org.springframework.messaging.simp.stomp.StompSession;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.util.concurrent.ListenableFutureAdapter;
//import org.springframework.web.socket.client.standard.StandardWebSocketClient;
//import org.springframework.web.socket.messaging.WebSocketStompClient;
//
//import java.util.concurrent.ExecutionException;
//
//public class WebSocketClient {
//    private final String url;
//    private StompSession stompSession;
//
//    public WebSocketClient(String url) {
//        this.url = url;
//    }
//
//    public void connect() throws ExecutionException,InterruptedException {
//        StandardWebSocketClient client = new StandardWebSocketClient();
//        WebSocketStompClient stompClient = new WebSocketStompClient(client);
//        StompSessionHandler stompSessionHandler = new StompSessionHandler();
//        DataHandler dataHandler = new DataHandler();
//        ListenableFuture<StompSession> sessionListenableFuture = (ListenableFuture<StompSession>) stompClient.connectAsync(url,stompSessionHandler);
//        sessionListenableFuture.get();
//    }
//
//    public void disconnect() {
//        stompSession.disconnect();
//    }
//
//    public void send(String destination,String message){
//        stompSession.send(destination,message);
//    }
//
//    public void subscribe(String destination,DataHandler dataHandler){
//        stompSession.subscribe(destination,dataHandler);
//    }
//
//}
