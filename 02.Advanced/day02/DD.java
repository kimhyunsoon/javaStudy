import java.io.*;
//���� �޼ҵ� ����
public class DD {
    String path = "C:/KAEUN/JAVA/teacher/Advanced/day02";
    File f;

    DD(){
        f = new File(path);
    }

    void confirm(){
        boolean b1 = f.exists();
        System.out.println("b1: "+b1);
        boolean b2 = f.isDirectory();
        System.out.println("b2: "+b2);
        boolean b3 = f.isFile();
        System.out.println("b3: "+b3);
    }

    void make(){
        File fc = new File(f,"aa/bb/cc");
        fc.mkdirs(); //���丮 ����
        File fc2 = new File(fc,"happy.txt");
        FileWriter fw = null;
        try {
            fc2.createNewFile(); //���� ����
            fw = new FileWriter(fc2);
            String str = "������ �� ���� ���Դϴ�";
            char cs[] = str.toCharArray(); //��Ʈ���� ���� ��̷� ��ȯ
            fw.write(cs);
            fw.flush();
        } catch (IOException ie) {
        }finally{
			try{
				fw.close();
			}catch(IOException ie){}
		}
    }

    void getPath(){

        File f = new File("."); //�����
        try {
            String cPath = f.getCanonicalPath();
            System.out.println("������: "+cPath);
        } catch (IOException ie) {}

        String aPath = f.getAbsolutePath();
        System.out.println("������: "+aPath);
    }

    void delete(){
        fc2.delete();

    }

    public static void main(String[] args) {
        DD dd = new DD();
        dd.confirm();
        dd.make();
        dd.getPath();
        
    }
    
}
