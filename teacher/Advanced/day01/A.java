import java.io.*;

//ǥ���Է� & ǥ�����
class A 
{
	BufferedReader br;
	PrintStream ps;
    A(){
		//br = new BufferedReader(new InputStreamReader(System.in)); //���� 
		InputStream is = System.in;//�ٺ���Ʈ��(Ű�����Է�) 
		Reader r = new InputStreamReader(is); //�긴����Ʈ�� 
		br = new BufferedReader(r);//������Ʈ��(==���ͽ�Ʈ��==���뽺Ʈ��) 

        ps = System.out;//�ٺ���Ʈ��(��������) 
	}
    void rw(){
		try{
			String line = br.readLine();
			ps.println("�Է� ������: " + line);
		}catch(IOException ie){}
	}
	public static void main(String[] args) 
	{
		A a= new A();
		a.rw();
	}
}
