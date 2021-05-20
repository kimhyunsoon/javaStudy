import java.io.*;
public class AA { //����: DataInputStream & DataOutputStream

    String fname = "AAtest.txt";
    FileOutputStream fos; //��彺Ʈ��
    DataOutputStream dos; //���ͽ�Ʈ��
    FileInputStream fis; //��彺Ʈ��
    DataInputStream dis; //���ͽ�Ʈ��

    
    AA(){
        try {
            
            fos = new FileOutputStream(fname); //node, ���°� ������
            dos = new DataOutputStream(fos);; //filter
            fis = new FileInputStream(fname); //node A.java���� �о���°�
            dis = new DataInputStream(fis); //filter

            
            // System.out.println("fis: "+fis);
            // System.out.println("dis: "+dis);
            // System.out.println("fos: "+fos);
            // System.out.println("dos: "+dos);


        } catch (FileNotFoundException e) {
        }
    }

    void writeToFile() throws IOException{
        //FileOutputStream�� �ִ� write �޼ҵ带 �̿�, dos�� ���� ���°� ������.
        short s = 5; 
        int i = 10;
        String str = "����";
        boolean flag = true;

        dos.writeInt(i); //FileInputStream�� �޼ҵ�
        dos.writeShort(s);
        dos.writeUTF(str);
        dos.writeBoolean(flag);
        dos.flush();
    }

    void readFromFile() throws IOException{
        //FileInputStream�� �ִ� read �޼ҵ带 �̿�, dis�� ���� ������� ������ ����
        short s = dis.readByte();
        int i = dis.readInt();
        String str = dis.readUTF();
        boolean flag = dis.readBoolean();
        
        System.out.println(str+"��"+i+"���"+s+"������ �ö󰡴°�"+flag);

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
