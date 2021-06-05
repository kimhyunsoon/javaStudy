package EcardGame;

import java.io.*;
import java.net.*;
import java.util.*;

import EcardGame.GameThread;

public class GameServer extends Thread{

    ServerSocket ss;
    Socket sc;
    public static final int port = 3000;
    public static final int maxclient = 2;
    GameThread client;

    GameServer(){
        try {
            ss = new ServerSocket(port);
            System.out.println(port+"번 포트에서 서버 대기중...");
            while(true){
                sc = ss.accept();
                client = new GameThread(sc);
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
        new GameServer();

        
    }

}