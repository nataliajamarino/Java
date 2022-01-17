package ie.gmit.dip;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Implementation of ChatClient, responsible to connect to server and send messages
 * @author Natalia Jamarino
 */
public class ChatClient implements Chat, InputStreamer {
    /**
     * Server port
     */
    private int SERVER_PORT = 5000;
    /**
     * Chat user name
     */
    private String userName;
    private Socket client;

    public static void main (String args[]) {
        new ChatClient().start();
    }

    /**
     * Connect to server and starts read and write threads
     */
    public void start() {
        try {
            this.client = new Socket("localhost", SERVER_PORT);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
            this.userName = userName;

            System.out.println("Chat started");
            new ThreadRead(this.client, this).start();
            new ThreadWrite(this).start();
        } catch (ConnectException e) {
            System.out.println("Server is not running, please run server first.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Send user message to the server
     * @param message Message to be send
     * @param fromClient
     * @throws IOException
     */
    public void sendMessage(String message, Socket fromClient) throws IOException {
        PrintStream p = new PrintStream(this.client.getOutputStream());
        p.println("[" + this.userName + "]: " + message);
    }

    public Socket getClient() {
        return this.client;
    }

    public void quit() throws IOException {
        this.client.close();
        System.out.println("chat ended");
    }

    /**
     * Message received from server, just printing to console
     * @param message Message received
     * @param fromClient Which client sent
     */
    public void messageReceived(String message, Socket fromClient) {
        System.out.println(message);
    }
}
