import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

public class AA {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // System.out.println();
    // ��ü�غ���

    BufferedReader br;
    PrintStream ps;
    
    AA(){
        //InputStream : �߻�Ŭ����, ����Ʈ�� �Է� ��Ʈ���� ��Ÿ���� ��� Ŭ������ ���� Ŭ�����Դϴ�.
        InputStream is = System.in; // in : Ű����� �Է¹޴� �ٺ���Ʈ��, ǥ���Է�
        Reader r = new InputStreamReader(is); // �긴�� ��Ʈ�� ��ǲ��Ʈ���� ���� ����
        br = new BufferedReader(r); //������Ʈ��

        ps = System.out;

    }

    void rw(){
        try {
            String line = br.readLine();
            ps.println("�Էµ�����: "+line); 
            
        } catch (IOException ie) {
        }
    }

    public static void main(String[] args) {
        AA aa = new AA();
        aa.rw();
        
    }

}
