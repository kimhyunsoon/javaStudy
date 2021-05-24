import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Server {
     public void start(){ 

          ServerSocket serverSocket = null;
          Socket socket = null;
  
           try {
               serverSocket = new ServerSocket(5555);
               System.out.println("Server is Waiting...");
               socket = serverSocket.accept();

               System.out.println("Server is Start...");
   
               Sender sender = new Sender(socket);
               Receiver receiver = new Receiver(socket);
   
               sender.start();
               receiver.start();
   
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

