import java.io.*;
public class A {

    
    BufferedReader br;
    PrintStream ps;
    A(){
        
        // InputStream �ý����̶�� Ŭ������ in�̶�� ����� �����ؼ� ������ ��ȯŸ��
        InputStream is = System.in; //�ٺ���Ʈ��(Ű���� �Է�), ǥ�� �Է�
        Reader r = new InputStreamReader(is); //�긴����Ʈ��
        br = new BufferedReader(r); //������Ʈ��(���ͽ�Ʈ��==���뽺Ʈ��)
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //��� : br�� Ű����� ����Ǿ� �ִ�
        //�������� ������ �ִ�

        ps = System.out; //�ٺ���Ʈ��(��������), ǥ�����dd


    }
    void readw(){
        try {
            String line = br.readLine();
            ps.println("�Էµ�����: "+line);
        } catch (IOException ie) {
            //TODO: handle exception
        }


    }

    public static void main(String[] args) {
        A a = new A();
        a.readw();
        
    }
}
