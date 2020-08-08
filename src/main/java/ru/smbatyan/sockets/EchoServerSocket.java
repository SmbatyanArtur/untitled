package ru.smbatyan.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class EchoServerSocket {
    private ServerSocket serverSocket;
    private Socket socket1;
    private ArrayList<Socket> socketArrayList;
    private Thread thread;
    private int a;

    public EchoServerSocket() {
    }

    public void start(int port) throws Exception  {
         serverSocket = new ServerSocket(port);
         socketArrayList = new ArrayList<Socket>();
         System.out.println("Сервер запущен .............. "+ "\n" + "Сервер ждет подключения...");

          while (!serverSocket.isClosed()){
                  socket1 = serverSocket.accept();

              if (!socketArrayList.contains(socket1)){
                  socketArrayList.add(socket1);
                  a++;
                  System.out.println("Количество подключеных клиентов : " + a +" hash "+ socket1.hashCode());
              }

              thread = new Thread(new Runnable() {
                  @Override
                  public void run() {
                      for (int i = 0 ; i < socketArrayList.size() ; i++){
                            Socket socket2 = socketArrayList.get(i);
                         try {
                            BufferedWriter writer = new BufferedWriter(new PrintWriter(socket2.getOutputStream() , true));
                            writer.write("Вы подключились к нашему серверу красава. А вот ваш hash : " + socket2.hashCode());
                            writer.close();
                         }catch (Exception e){
                             e.getStackTrace();
                          }
                      }
                  }
              });
              thread.start();
          }
    }
}
