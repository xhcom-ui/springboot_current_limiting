package com.citydo.dialogue;

import java.net.URI;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

@ClientEndpoint
public class WebSocketTest {

    private String deviceId;

    private Session session;

    public WebSocketTest() {
    }

    public WebSocketTest(String deviceId) {
        this.deviceId = deviceId;
    }

    protected boolean start() {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://158.1.0.155:8082/ASR/realtime";
        System.out.println("Connecting to " + uri);
        try {
            session = container.connectToServer(WebSocketTest.class, URI.create(uri));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int size = 600;
        for (int i = 1; i < size; i++) {
            WebSocketTest wSocketTest = new WebSocketTest(String.valueOf(i));
            if (!wSocketTest.start()) {
                System.out.println("测试结束！");
                break;
            }
        }
        System.out.println("===========客户端启动的线程为：="+size);

    }
}
