package Client;
import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    Socket socket;
    OutputStream output;
    InputStream input;
    String hostname = "127.0.0.1";
    int port = 5000;

    public Client() throws IOException {
        socket = new Socket(hostname, port);
    }

    public void SendOutput(String data) throws IOException {
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(data);
    }

    public String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        return reader.readLine();
    }

    public void ClientClose() throws IOException {
        socket.close();
    }

    @Override
    public void run() {
        System.out.println("Client is attempting to connect");
        try {
            this.SendOutput("testgroep3");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            input = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(this.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
