import java.io.*;
public class AAA {
    String fname = "AAAtest.txt";
    FileOutputStream fos;
    DataOutputStream dos;
    FileInputStream fis;
    DataInputStream dis;

    AAA(){
        try {
            fos = new FileOutputStream(fname);
            dos = new DataOutputStream(fos);

            fis = new FileInputStream(fname);
            dis = new DataInputStream(fis);
        } catch (FileNotFoundException fe) {
        }
    }

    void writeToFile() throws IOException{
        byte b = 10;
        short s = 20;
        char c = 'a';
        int i = 30;
        long l = 40L;
        boolean flag = true;
        String str = "¼øÀÌ";

        dos.writeByte(b);
        dos.writeShort(s);
        dos.writeChar(c);
        dos.writeInt(i);
        dos.writeLong(l);
        dos.writeBoolean(flag);
        dos.writeUTF(str);
    }

    void readFromFile() throws IOException{
        byte b = dis.readByte();
        short s = dis.readShort();
        char c = dis.readChar();
        int i = dis.readInt();
        long l = dis.readLong();
        boolean flag = dis.readBoolean();
        String str = dis.readUTF();
        System.out.println("b: "+b+"s"+s+"c"+c);
        System.out.println("boolean"+flag+"String"+str);

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
        AAA aaa = new AAA();
        try {
            aaa.writeToFile();
            aaa.readFromFile();
        } catch (IOException ie) {}
        aaa.closeAll();        
    }
    
}
