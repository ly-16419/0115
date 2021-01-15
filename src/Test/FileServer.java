package Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(9999);
            Socket socket=serverSocket.accept();
            OutputStream outputStream=socket.getOutputStream();
            FileInputStream fileInputStream=new FileInputStream("F:\\cispremium_only_installer.exe");

            byte buff[]=new byte[1024];
            int a=0;
            while ((a=fileInputStream.read(buff))!=-1){
                outputStream.write(buff,0,a);
            }
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
