package ie.gmit.dip;

import java.io.*;
import java.net.*;

/**
 * Thread to handle messages received from server
 * @author Natalia Jamarino
 */
public class ThreadRead extends Thread {
    private Socket client;
    private InputStreamer inputStreamer;

    public ThreadRead (Socket client, InputStreamer inputStreamer) {
        this.client = client;
        this.inputStreamer = inputStreamer;
    }

    /**
     * Start thread task, waits for message to receive and calls messageReceived function
     */
    public void run() {
        try {
            DataInputStream input = new DataInputStream(this.client.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                this.inputStreamer.messageReceived(line, this.client);
            }
        } catch (IOException e) {

        }
    }
}
