import java.io.*;
import java.util.*;

class Lotto_soon {
    String fname = "����/�츮��.txt"; // ���� ���
    BufferedReader br = null; // ���� �д� �������� �ε�
    FileReader fr = null; // ���� �д� �������� �ε�

    Lotto_soon() {
        String name = ""; // �л��̸� �� ����

        try{
            // ������ �л��� ����
            fr = new FileReader(fname); // ���� ��������
            br = new BufferedReader(fr); // ���� ��������
            int i =0; 
            while(br.readLine() != null){ // ������ ���� ������� ������ ����
                i++; // �� ���� (�л���) ��ŭ i�� ������Ŵ
            };
            

            //�迭�� �����ϰ� ������ �̸����� ������
            fr = new FileReader(fname); // ���� ��������
            br = new BufferedReader(fr); // ���� ��������
            int j=0;
            String[] List = new String[i]; // ���̰� i�� �� �迭 ����

            while((name = br.readLine()) != null){ // ������ ���� ������ name�� ������� ������ ����
                List[j] = name; // List�迭 j��° ��ҿ� ������ j��° ���� ������
                j++; // �� ���� (�л���) ��ŭ j�� ������Ŵ
            };


            //�������� �����
            Random r = new Random();
            int k = r.nextInt(i); // 0 ���� i(�л���) ������ �� �߿� �������� �Ѱ��� ������
            System.out.println("�����л��̸�: " + List[k]);

            

        }catch(FileNotFoundException fe){
            System.out.println(fname+"������ ã�� ������");
        }catch(IOException ie){
        }
    }
    
	
    public static void main(String[] args) 
	{
        new Lotto_soon();
	}
}