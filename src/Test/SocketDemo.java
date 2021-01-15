package Test;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            while (true){
                System.out.println("等待新用户连接");
                Socket socket=serverSocket.accept();//阻塞
                System.out.println("新用户接入系统");
                OutputStream outputStream=socket.getOutputStream();//先找出该行有几个对象，然后在该行上面依次打印对象的值
                //Output输出,发消息
                //Input输入，读消息
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                PrintWriter printWriter=new PrintWriter(outputStreamWriter);
                printWriter.println("你好，欢迎登录");
                printWriter.flush();

                GetMessageThread getMessageThread=new GetMessageThread(socket);
                getMessageThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
