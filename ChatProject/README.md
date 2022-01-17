Network Programming Project

This project is a Chat implementation in Java using Sockets and Threads.
There are two main Classes, ChatServer and ChatClient.

ChatServer is responsible to handle incoming messages and broadcast them to all users connected, it opens a connection on port 5000 and waits for clients.

ChatClient is responsible to connect users to the server and handle user messages, the client asks for the user name to send it together with the messages typed.

I created two Threads, one for Reading input from clients and another one to receive messages from the server, it's using Threads because streams (DataInputStream) are blocking resources and it would block any user inputs.

To run the program just execute on terminal:

javac src/ie.gmit.dip/*.class
cd src

Start the Chat server

java ie.gmit.dip.ChatServer

And then can open any number of clients

java ie.gmit.dip.ChatClient
