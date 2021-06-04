package Test;

import java.io.*;
import java.net.*;
import java.util.*;

//import Test.TestThread;


public class TestServer extends Thread{

    
    ServerSocket ss;
    Socket sc;
    int port = 3000;
    TestThread client;

    TestServer(){
        try {
            ss = new ServerSocket(port);
            while(true){
                sc = ss.accept();
                client = new TestThread(sc);
                client.start();
            }
        } catch (IOException ie) {
        } finally{
            try {
                if(ss !=null) ss.close();
            } catch (IOException ie) {
            }
        }
    }

    public static void main(String[] args) {
        new TestServer();

        
    }

}