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
                System.out.println("�ȴ����û�����");
                Socket socket=serverSocket.accept();//����
                System.out.println("���û�����ϵͳ");
                OutputStream outputStream=socket.getOutputStream();//���ҳ������м�������Ȼ���ڸ����������δ�ӡ�����ֵ
                //Output���,����Ϣ
                //Input���룬����Ϣ
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                PrintWriter printWriter=new PrintWriter(outputStreamWriter);
                printWriter.println("��ã���ӭ��¼");
                printWriter.flush();

                GetMessageThread getMessageThread=new GetMessageThread(socket);
                getMessageThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
