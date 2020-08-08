import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TestClietn {
    public static void main(String[] args) throws Exception {

            Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Socket socket = new Socket("127.0.0.1" , 7777);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    System.out.println(reader.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

            thread.start();

        Thread.sleep(1000);
        Socket socket = new Socket("127.0.0.1" , 7777);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(reader.readLine());


    }
}
