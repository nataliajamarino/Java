package ie.gmit.dip;

import java.net.Socket;

/**
 * Threaded chat server, handle message received from clients and starts a read thread
 * @author Natalia Jamarino
 */
public class ThreadedChatServer extends Thread implements InputStreamer {
    private Socket client;
    private ChatServer server;

    public ThreadedChatServer(Socket client, ChatServer server) {
        this.server = server;
        this.client = client;
    }

    public void run() {
        try {
            new ThreadRead(this.client, this).start();
        } catch (Exception e) {
            System.out.println("Chat disconnected");
        }
    }

    @Override
    public void messageReceived(String message, Socket fromClient) {
        server.broadcast(message, fromClient);
    }
}
