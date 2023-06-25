import jdk.internal.org.objectweb.asm.ClassReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 8889;

    public static void main(String[] arg) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);

             Socket clientSocket = serverSocket.accept(); // ждем подключения
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Введите имя");
            System.out.println("Новое соединение");
            String name = in.readLine();

            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





