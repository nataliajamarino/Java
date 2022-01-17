package ie.gmit.dip;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Chat server class to start server socket and handle users connected.
 * @author Natalia Jamarino
 */
public class ChatServer {
    private int SERVER_PORT = 5000;
    /**
     * Set to save clients connected
     */
    private Set<Socket> users = new HashSet<>();

    /**
     * Starts a new ServerSocket and runs server in a Thread
     */
    public void run() {
        try {
            ServerSocket server = new ServerSocket(SERVER_PORT);
            System.out.println("Server running on port: " + SERVER_PORT);

            while(true) {
                Socket client = server.accept();
                System.out.println("New client connected");
                this.users.add(client);
                this.broadcast("New user entered", client);
                new ThreadedChatServer(client, this).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Broadcast message received to all clients, excluding the user that sent the message
     * @param message Message to send
     * @param fromUser From which user
     */
    public void broadcast(String message, Socket fromUser) {
        for (Socket user : users) {
            if (user != fromUser) {
                try {
                    PrintStream p = new PrintStream(user.getOutputStream());
                    p.println(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main (String[] args) {
        new ChatServer().run();
    }
}
