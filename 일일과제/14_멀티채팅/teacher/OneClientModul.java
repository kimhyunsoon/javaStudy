import java.io.*;
import java.net.*;

class OneClientModul extends Thread 
{
	MServer ms;
	Socket s;
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	String chatId;

	OneClientModul(MServer ms){
		this.ms = ms;
		this.s = ms.s;
		try{
			is = s.getInputStream();
			os = s.getOutputStream();
			dis = new DataInputStream(is);
			dos = new DataOutputStream(os);
		}catch(IOException ie){}
	}
	public void run(){
		listen();
	}
    void listen(){ // Socket -> �����, �ٸ� Ŭ���̾�Ʈ�� 
		String msg = "";
		try{
			chatId = dis.readUTF();
            broadcast(chatId + "�� ����!! (�ο�: "+ms.v.size()+"��)");
			ms.pln(chatId + "�� ����!! (�ο�: "+ms.v.size()+"��)");
			while(true){
				msg = dis.readUTF();
				broadcast(msg);
				ms.pln(msg);
			}
		}catch(IOException ie){
			ms.v.remove(this);
			broadcast(chatId + "�� ����!! (�ο�: "+ms.v.size()+"��)");
			ms.pln(chatId + "�� ����!! (�ο�: "+ms.v.size()+"��)");	
		}finally{
			closeAll();
		}
	}
	void broadcast(String msg){
		try{
			for(OneClientModul ocm: ms.v){
				ocm.dos.writeUTF(msg);
				ocm.dos.flush();
			}
		}catch(IOException ie){
		}
	}
	void closeAll(){
		try{
			if(dis != null) dis.close();
			if(dos != null) dos.close();
			if(is != null) is.close();
			if(os != null) os.close();
			if(s != null) s.close();
		}catch(IOException ie){}
	}
}
