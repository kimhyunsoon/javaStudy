import java.io.*;
public class A { //DataInputStream & DataOutputStream
    //기본형을 읽을 수 있는 인풋스트림
    //readUTF 유니코드를 읽을 수 있음

    //data source A.java

    String fName = "Adata.txt";
    FileOutputStream fos;
    DataOutputStream dos;
    FileInputStream fis;
    DataInputStream dis;


    
    A(){
        try {
            fos = new FileOutputStream(fName); //파일에 쓰는거니까, node
            dos = new DataOutputStream(fos);
            
            fis = new FileInputStream(fName);
            dis = new DataInputStream(fis);
            
        } catch (FileNotFoundException fe) {
        }
    }
    
    void writeToFile() throws IOException{ //A.java ->File
        byte b = 10;
        short s = 20;
        char c = 'a';
        int i = 30;
        long l = 40L;
        float f = 50.0f;
        double d = 60.0;
        boolean flag = true;
        String str = "여행";
        //총 30바이트+8바이트

        
        dos.writeByte(b); //1바이트
        dos.writeShort(s); //2바이트
        dos.writeChar(c); //2바이트
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeFloat(f);
        dos.writeDouble(d);
        dos.writeBoolean(flag);
        dos.writeUTF(str);
        dos.flush();
    }
    
    void readFromFile()throws IOException{
        byte b = dis.readByte();
        short s = dis.readShort();
        char c = dis.readChar();
        int i = dis.readInt();
        long l = dis.readLong();
        float f = dis.readFloat();
        double d = dis.readDouble();
        boolean flag = dis.readBoolean();
        String str = dis.readUTF();
        System.out.println("b: "+b+"s: "+s+"c: "+c+"i: "+i);
        System.out.println("l: "+l+"f: "+f+"d: "+d+"flag: "+flag);
        System.out.println("str: "+str);
    }

    void closeAll(){
        try {
            if(dis != null) dis.close();
            if(fis != null) fis.close();
            if(dos != null) dos.close();
            if(fos != null) fos.close();
            
        } catch (IOException ie) {

        }

    }

    
    public static void main(String[] args) {
        A a = new A();
        try {
            a.writeToFile();
            a.readFromFile();


        } catch (IOException ie) {

        }
        a.closeAll();


    }
}
