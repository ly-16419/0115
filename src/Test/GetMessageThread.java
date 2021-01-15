package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class GetMessageThread extends Thread{

    Socket socket=null;
    public GetMessageThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        while (true){
            try {

                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//读取获取到的信息
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//将读取到的信息进行包装
                String serviceMassege=bufferedReader.readLine();//将封装后的信息按照行读取
                System.out.println("客户端说：" + serviceMassege);//输出按行包装的读取后的信息
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
