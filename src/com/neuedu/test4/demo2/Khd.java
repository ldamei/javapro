package com.neuedu.test4.demo2;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ldamei
 * @date 2020/2/23 21:41
 */
public class Khd implements Runnable{
    public static void main(String[] args) {
        OutputStream os = null;
        PrintStream ps = null;
        try {
            Socket socket = new Socket("127.0.0.1", 9999);
            System.out.println("客户端连接");
            Scanner scanner = new Scanner(System.in);
            os = socket.getOutputStream();
            ps = new PrintStream(os);
            while(true){
                String str = scanner.nextLine();
                ps.println(str);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }
}
