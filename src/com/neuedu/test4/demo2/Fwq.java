package com.neuedu.test4.demo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ldamei
 * @date 2020/2/23 21:41
 */
public class Fwq implements Runnable {
    public static void main(String[] args) {
        ServerSocket server = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            server = new ServerSocket(9999);
            Socket socket = server.accept();  // 该方法为阻塞，等待客户端连接
            System.out.println("客户端已连接");
            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = br.readLine();
            while(true){
                System.out.println("客户端说：" + str);
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (isr != null)
                    isr.close();
                if (is != null)
                    is.close();
                if (server != null)
                    server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }
}
