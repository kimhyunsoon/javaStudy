import java.io.*;

//Ű���� �Է¹޾Ƽ� ���Ϸ��ε�
//������ 2byte�� �����
public class BB {
    InputStream is = System.in; //�⺻�Է½�Ʈ��
    Reader r; //���ڱ�ݽ�Ʈ��(�Է�)�� abstract class
    Writer w; //���ڱ�ݽ�Ʈ��(���)�� abstract class
    String fname = "BBtest.txt";

    BB(){
        try {
            r = new InputStreamReader(is); 
            //InputStream(1byte)�� Reader(2byte)�� �ٲٴ� �긴��
            w = new FileWriter(fname); //node
        } catch (IOException ie) {}
    }

    void rw1(){
        try {
            // int c = r.read(); //Reader Ŭ������ �޼ҵ�. Reads a single character.
            // w.write(c); //Writer Ŭ������ �޼ҵ�. Writes a single character.
            // w.flush();
            int c = 0;
            while ((c = r.read()) != -1) {
                w.write(c);
                w.flush();
            }

        } catch (Exception e) {
        } finally{
			try{
				if(r != null) r.close();
				if(w != null) w.close();
			}catch(IOException ie){}
		}
    }

    void rw2(){
        try {
            char cs[] = new char [8];
            int count = 0;
            while ((count=r.read(cs)) != -1) {
                w.write(cs, 0, count);
                w.flush();
                
            }
        } catch (Exception e) {
        }{
			try{
				if(r != null) r.close();
				if(w != null) w.close();
			}catch(IOException ie){}
		}
    }




    public static void main(String[] args) {
        BB bb = new BB();
        // bb.rw1();
        bb.rw2();
        
    }

    
}
