package ie.gmit.dip;

import java.net.Socket;

/**
 * Interface for classes that have a data input stream to receive data
 * @author Natalia Jamarino
 */
public interface InputStreamer {
    /**
     * Message received from client
     * @param message
     * @param fromClient
     */
    public void messageReceived(String message, Socket fromClient);
}
