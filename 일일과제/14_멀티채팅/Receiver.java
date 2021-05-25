import java.io.*;
import java.net.*;

public class Receiver extends Thread{
    MainServer ms;
    Socket sc;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

   
    Receiver(MainServer ms){
        //소켓에 있는 정보를 읽어야 함
        this.ms = ms; //this의 3번째 용법 : 자신의 생성자를 호출할때
        this.sc = ms.sc; //Socket을 쓸 수 있게 됨
        try {
            is = sc.getInputStream();
            os = sc.getOutputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
        } catch (IOException ie) {}
    }

    public void run(){
        listen();
        
    }
    void listen(){ //Socket에 있는 정보를 ->모니터, 다른 클라이언트
        String name = "";
        String msg = "";
        
        try {
            name = dis.readUTF(); //클라이언트가 입력하는 첫줄은 닉네임으로 받음
            sendMessage(name+"님 입장!");
            pln(name+"님 입장!");
            pln("현재 서버 접속자 수는" + ms.list.size()+"명입니다.");
            while(true){
                msg = dis.readUTF();
                sendMessage(msg);
                pln(msg);
                //메세지가 입력될 동안 수행
            }
        } catch (IOException ie) { //
            ms.list.remove(this);
            sendMessage(name+"님 퇴장!"+ms.list.size()+"명입니다");
            pln(name+"님 퇴장!"+ms.list.size()+"명입니다");
        }
    }

    void sendMessage(String msg){//배열에 입력된 정보를 다 꺼내서 출력
        try {
            for(Receiver receiver: ms.list){
                receiver.dos.writeUTF(msg);
                receiver.dos.flush();
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    void pln(String str){
        System.out.println(str);
    }
    
}
