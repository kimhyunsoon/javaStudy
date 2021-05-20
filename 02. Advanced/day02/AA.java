import java.io.*;
public class AA { //주제: DataInputStream & DataOutputStream

    String fname = "AAtest.txt";
    FileOutputStream fos; //노드스트림
    DataOutputStream dos; //필터스트림
    FileInputStream fis; //노드스트림
    DataInputStream dis; //필터스트림

    
    AA(){
        try {
            
            fos = new FileOutputStream(fname); //node, 쓰는게 먼저임
            dos = new DataOutputStream(fos);; //filter
            fis = new FileInputStream(fname); //node A.java에서 읽어오는거
            dis = new DataInputStream(fis); //filter

            
            // System.out.println("fis: "+fis);
            // System.out.println("dis: "+dis);
            // System.out.println("fos: "+fos);
            // System.out.println("dos: "+dos);


        } catch (FileNotFoundException e) {
        }
    }

    void writeToFile() throws IOException{
        //FileOutputStream에 있는 write 메소드를 이용, dos를 통해 쓰는게 먼저임.
        short s = 5; 
        int i = 10;
        String str = "여름";
        boolean flag = true;

        dos.writeInt(i); //FileInputStream의 메소드
        dos.writeShort(s);
        dos.writeUTF(str);
        dos.writeBoolean(flag);
        dos.flush();
    }

    void readFromFile() throws IOException{
        //FileInputStream에 있는 read 메소드를 이용, dis를 통해 만들어진 파일을 읽음
        short s = dis.readByte();
        int i = dis.readInt();
        String str = dis.readUTF();
        boolean flag = dis.readBoolean();
        
        System.out.println(str+"엔"+i+"백원"+s+"도까지 올라가는게"+flag);

    }

    void closeAll(){
        try {
            if(dis != null) dis.close();
            if(dos != null) dos.close();
            if(fis != null) fis.close();
            if(fos != null) fos.close();
            
        } catch (IOException ie) {

        }
    }

    public static void main(String[] args) {
    
        AA aa = new AA();
        try {
            aa.writeToFile();
            aa.readFromFile();
        } catch (IOException ie) {}
        aa.closeAll();

        
    }
}
