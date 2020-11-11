package firstSocketExample;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientX {

    public static void main(String [] args) throws IOException {

        final String HOST = "127.0.0.1";
        final int PORT = 1234;
        System.out.println("Connecting to server " + HOST + ":" + PORT);
        Socket s = new Socket(HOST, PORT);
        System.out.println("Connected");
        InputStream is = s.getInputStream();
        int x = is.read();
        System.out.println("Received from server: " + x);

    }

}