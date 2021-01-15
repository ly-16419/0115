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
            System.out.println("�����˵" + serviceMessage);

            //�����˷�����Ϣ
            Scanner reader= new Scanner(System.in);
            while (true){
                System.out.println("�������뷢�͵���Ϣ");
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
