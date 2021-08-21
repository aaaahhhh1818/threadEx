package threadEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

  //bad code
  public static void main(String[] args) throws Exception {

    Scanner keyScanner = new Scanner(System.in);
    Socket socket = new Socket("192.168.0.19", 9999);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    DataInputStream din = new DataInputStream(socket.getInputStream());

    new Thread(() -> {

      while(true) {
        String serverMsg;
        try {
          serverMsg = din.readUTF();
          System.out.println("SERVER: " + serverMsg);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }//end catch

      }//end while

    }).start();


    while(true) {
      System.out.println("INSERT YOUR MESSAGE");
      String msg = keyScanner.nextLine();
      dos.writeUTF(msg);
    }



  }

}
