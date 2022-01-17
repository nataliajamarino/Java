package ie.gmit.dip;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Thread to handle user inputs
 * Start a DataInputStream from system and waits for user to type anything
 * @author Natalia Jamarino
 */
public class ThreadWrite extends Thread {
    private Chat chat;

    public ThreadWrite(Chat chat) {
        this.chat = chat;
    }

    /**
     * Start thread and wait for user input and calls sendMessage back to Chat
     */
    public void run() {
        try {
            while (true) {
                DataInputStream userInput = new DataInputStream(System.in);
                String line = null;
                line = userInput.readLine();
                if (line.equals("\\q")) {
                    this.chat.quit();
                    break;
                }
                this.chat.sendMessage(line, this.chat.getClient());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
