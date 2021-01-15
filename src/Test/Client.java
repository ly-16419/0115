package Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",8888);
            InputStream inputStream=socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String serviceMessage=bufferedReader.readLine();
            System.out.println("服务端说" + serviceMessage);

            //向服务端发送信息
            Scanner reader= new Scanner(System.in);
            while (true){
                System.out.println("输入你想发送的信息");
                String message=reader.next();
                OutputStream outputStream=socket.getOutputStream();
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                PrintWriter printWriter=new PrintWriter(outputStreamWriter);
                printWriter.println(message);
                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
