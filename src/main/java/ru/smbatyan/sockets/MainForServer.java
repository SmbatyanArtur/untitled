package ru.smbatyan.sockets;


public class MainForServer {
    public static void main(String[] args) throws Exception{
       EchoServerSocket echoServerSocket  =  new EchoServerSocket();
       echoServerSocket.start(7777);
    }
}
