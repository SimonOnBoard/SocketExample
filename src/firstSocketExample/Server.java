package firstSocketExample;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket ss;

    public void start(){
        try {
            ss = new ServerSocket(9000);
            Socket clientSocket = ss.accept();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            bufferedWriter.write("Ya teba ne znay poka");
            String greeting = bufferedReader.readLine();
            System.out.println(greeting);
            if(greeting.equals("Hello from client")){
                bufferedWriter.write("Hello my dear client/");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
