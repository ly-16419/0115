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
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream);//��ȡ��ȡ������Ϣ
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);//����ȡ������Ϣ���а�װ
                String serviceMassege=bufferedReader.readLine();//����װ�����Ϣ�����ж�ȡ
                System.out.println("�ͻ���˵��" + serviceMassege);//������а�װ�Ķ�ȡ�����Ϣ
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
