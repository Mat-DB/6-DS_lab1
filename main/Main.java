package main;

import Server.Server;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        while (true){
            Server server = new Server();
            System.out.println(server.getInput());
            server.SendOutput("hello world");
        }

    }
}