package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    InputStream input;


    public Server() throws IOException {
        serverSocket = new ServerSocket(5000);
        socket = serverSocket.accept();
        input = socket.getInputStream();
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
}
