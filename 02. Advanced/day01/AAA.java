import java.io.*;

public class AAA {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintStream ps;

    AAA(){

        ps = System.out; //�ٺ���Ʈ��, ǥ�����
        
    }

    void rw(){

        try {
            String line = br.readLine();
            ps.println("�Էµ�����: "+line);
            
        } catch (IOException ie) {
        }

    }

    

    public static void main(String[] args)  {
        AAA aaa = new AAA();
        aaa.rw();
        
    }

}
