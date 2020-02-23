package com.neuedu.test4.demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ldamei
 * @date 2020/2/23 21:11
 */
public class SocketTest {
    public static void main(String[] args) {
        Fwq fwq = new Fwq();
        Khd khd = new Khd();

        Thread t = new Thread(fwq);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(khd);
        t2.start();
    }
}
