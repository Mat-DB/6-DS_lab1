package Client;
import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    Socket socket;
    OutputStream output;
    InputStream input;
    byte[] data = {'t', 'e', 's', 't', 'g', 'r', 'o', 'e', 'p', '3' , '\n'};
    String hostname = "127.0.0.1";
    int port = 5000;

    public void ClientSetup() throws IOException {
        socket = new Socket(hostname, port);
    }

    public void sendData() throws IOException {
        output = socket.getOutputStream();
        output.write(data);
        PrintWriter writer = new PrintWriter(output, true);
        writer.println("test message");
    }

    public void readData() throws IOException {
        input = socket.getInputStream();
        input.read(data);

        //InputStreamReader reader = new InputStreamReader(input);
        //int character = reader.read();  // reads a single character

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = reader.readLine();    // reads a line of text
        System.out.println(line);

    }

    public void ClientClose() throws IOException {
        socket.close();
    }

    @Override
    public void run() {
        System.out.println("Client is attempting to connect");
    }
}
