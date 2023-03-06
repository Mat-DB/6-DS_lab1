package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private final ServerSocket serverSocket;
    private Socket socket;
    private InputStream input;


    public Server() throws IOException {
        serverSocket = new ServerSocket(5000);
    }

    public String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        return reader.readLine();
    }

    public void SendOutput(String data) throws IOException {
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(data);
    }

    public void close() throws IOException {
        serverSocket.close();
    }

    @Override
    public void run() {
        System.out.println("server is listening on port 5000");
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            input = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(this.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.SendOutput("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
