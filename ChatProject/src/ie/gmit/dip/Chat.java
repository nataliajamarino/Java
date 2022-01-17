package ie.gmit.dip;

import java.io.IOException;
import java.net.Socket;

public interface Chat {
    public void sendMessage(String message, Socket fromClient) throws IOException;
    public void quit() throws IOException;
    public Socket getClient();
}
