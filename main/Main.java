package main;

import Client.Client;
import Server.Server;

import java.io.IOException;


public class Main extends Thread {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        Client client = new Client();

        Thread serverthread = new Thread(server);
        Thread clientthread = new Thread(client);

        serverthread.start();
        clientthread.start();

    }
}
