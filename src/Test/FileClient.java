package Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",9999);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
