//package org.jht.support;
//
//import java.net.URI;
//import org.java_websocket.client.WebSocketClient;
//import org.java_websocket.drafts.Draft;
//import org.java_websocket.drafts.Draft_6455;
//import org.java_websocket.handshake.ServerHandshake;
//
//public class WebSocketClient1 extends WebSocketClient{
//
//    public WebSocketClient1(URI serverUri) {
//        super(serverUri, new Draft_6455());
//    }
//
//    public void sendMessage(String message) {
//        try {
//        this.sendPing();
//
////            session.getBasicRemote().sendText(message);
////            this.send(message);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onOpen(ServerHandshake serverHandshake) {
//
//    }
//
//    @Override
//    public void onMessage(String s) {
////        this.send(s);
////        this.sendPing();
//        System.out.println(s);
//
//    }
//
//    @Override
//    public void onClose(int i, String s, boolean b) {
//
//    }
//
//    @Override
//    public void onError(Exception e) {
//
//    }
//}
//
