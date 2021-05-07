import java.io.*;
import java.util.*;

class soon2 {
    // [1. �л���� �ҷ�����] ���� ��Ʈ��
    String studentListFile = "�츮��.txt";
    Hashtable<String,String> studentList = new Hashtable<String,String>();
    String dirName;

    soon2(){
        studentArrayAdd();
    }
    
    // 1. �л���� �ҷ�����
    void studentArrayAdd(){
        try{
            FileReader fr = new FileReader(studentListFile); 
            BufferedReader br = new BufferedReader(fr);
            String name;
            while((name = br.readLine()) !=null){
                studentList.put(name, "empty");
            }
            dateSelect();

        }catch(FileNotFoundException fe){
            pln("�л����("+studentListFile+") ������ �����ϴ�.");
            return; // ����
        }
        catch(IOException ie){
        }
    }
    
    // 2. ��� �Է� �ޱ�
    void dateSelect(){
        Scanner s = new Scanner(System.in);
        pln(" ");
        pln("--------------------���� �˻� �ϱ�--------------------");
        pln(" ");
        pln("�л����: "+studentListFile);
        pln(" ");
        System.out.print("���� ���� ��θ� �Է��ϼ���.: ");
        
        dirName = s.next();
        dateCheck();
    }

    // 3. �ش� ��¥ ���� �˻�
    void dateCheck(){
        String dirPathArr[] = new File(dirName).list(); // {������}.list() : {������}�� ���������� �Ϲݹ迭�� ��ȯ��

        if(new File(dirName).exists()){ // �Է¹��� ���� ������ �����ϸ�
            if(dirPathArr.length == 0){
                pln(" ");
                pln("--------------------���� �˻� ���--------------------");
                pln(" ");
                pln("�ƹ��� �������� �ʾҾ��....");
                pln(" ");
                return;
            } else {
                for(int i=0; i<dirPathArr.length; i++){
                    if(studentList.containsKey(dirPathArr[i])) { 
                        studentList.replace(dirPathArr[i], dirPathArr[i]);
                    }
                }
            }
            result();
            
        } else { // �Է¹��� ��¥���� ������ �������� ������
            pln(" ");
            pln(dirName + " ������ �����ϴ�.");
            return; // ����
        }
    }

    // 3. �˻� ��� ���
    void result(){ 
        pln(" ");
        pln("--------------------���� �˻� ���--------------------");
        pln(" ");
        if(!studentList.containsValue("empty")){
            pln("�����մϴ�! ���� �� �����߾��!");
            pln(" ");
        }else {
            p("��������: ");
            Enumeration<String> e = studentList.keys();
            while (e.hasMoreElements())
            {
                String key = e.nextElement();
                String val = studentList.get(key);
                if ( val == "empty") {
                    p(" ["+key+"] ");
                }
            }	
            pln(" ");
        }
    }

    void out(){
		Enumeration<String> e = studentList.keys();
		while (e.hasMoreElements())
		{
			String key = e.nextElement();
			String val = studentList.get(key);
			System.out.println("key: "+key+", val"+val);
		}	
	}

    void p(String a){ // ����Լ� 1 (�ζ���)
        System.out.print(a);
    }
    void pln(String a){ // ����Լ� 2
        System.out.println(a);
    }

    public static void main(String[] args) {
        new soon2();
    }
}