import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
     final private String serverIP = "127.0.0.1";
 

     public void start(){
          try {
               Socket socket = new Socket(serverIP, 5555);
               System.out.println("Server is Connected....");
   
               Sender sender = new Sender(socket);
               Receiver receiver = new Receiver(socket);
   
               sender.start();
               receiver.start();
   
   
          } catch (UnknownHostException e) {



          } catch (IOException e) {



          }
     }
 

     class Sender extends Thread{
          Socket socket;
          DataOutputStream out;
          String name;
  
          Sender(Socket socket){
               this.socket = socket;
   
               try {
                    out = new DataOutputStream(socket.getOutputStream());
                    name = "[" + socket.getInetAddress() + "]";
        
               } catch (IOException e) {
    
               }
          }
  
          public void run(){
               Scanner scan = new Scanner(System.in);
               while(out != null){
                    try {
                         out.writeUTF(name + scan.nextLine());
                    } catch (IOException e) {



                    }
               }
          }
      }
 
     class Receiver extends Thread{
          Socket socket;
          DataInputStream in;
  
          Receiver(Socket socket){
               this.socket = socket;
               try {
                    in = new DataInputStream(socket.getInputStream());
               } catch (IOException e) {



               }
          }
  
          public void run(){
               while(in != null){
                    try {
                         System.out.println(in.readUTF());
                    } catch (IOException e) {



                    }
               }
          }
     }
 
 
     public static void main(String args[]){
          new Server().start();
     }
}

 