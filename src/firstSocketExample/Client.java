package firstSocketExample;

import java.io.*;
import java.net.Socket;
import java.sql.Struct;

public class Client {
    private Socket socket;
    private static final int port = 9000;
    private static final String host = "127.0.0.1";
    private BufferedReader bufferedReader;
    //PrintWriter
    private PrintWriter printWriter;
    public void start(){
        try {
            socket = new Socket(host, port);
            System.out.println("Connected");
            //сделал для себя удобные обёртки для ввода вывода
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            //отправил сообщение
            for (int i = 0; i < 100; i++) {
                printWriter.write("Hello from client");
            }
            //принял сообщение
            String greetingFromServer = bufferedReader.readLine();
            System.out.println(greetingFromServer);
        } catch (IOException e) {
            //что-то пошло не так при работе с сокетом
            throw new IllegalStateException(e);
        }
    }

    public void stop(){
        try {
            printWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
