import java.io.*;
//���� �޾Ƽ� ����ͷ�

public class CC {
    String fname = "CC.java";
    FileReader fr; //node ���ڱ�ݽ�Ʈ��
    BufferedReader br; //filter
    PrintStream ps = System.out; //node
    PrintWriter pw; //filter
    
    CC(){
        try {
            fr = new FileReader(fname);
            br = new BufferedReader(fr,2048); 

            pw = new PrintWriter(ps,true); //auto flush ����
        } catch (FileNotFoundException fe) {
        }
    }

    void rw(){
        String line = "";
        try {
            while((line = br.readLine()) != null){//��Ʈ�� ���� ������ ��� null�� ��ȯ
                pw.println(line); //PrintWriter�� println �޼ҵ� �̿�
            }
            pw.println("��� �Ϸ�!");
        } catch (IOException ie) {
        } finally{
			try{
				if(pw != null) pw.close();
				if(ps != null) ps.close();
				if(br != null) br.close();
				if(fr != null) fr.close();
			}catch(IOException ie){}
		}

    }

    public static void main(String[] args) {
        CC cc = new CC();
        cc.rw();
        
    }
    
}
