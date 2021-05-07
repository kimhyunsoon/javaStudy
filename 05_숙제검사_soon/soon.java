import java.io.*;
import java.util.*;

class soon {
    // [1. �л���� �ҷ�����] ���� ��Ʈ��
    String studentListFile = "�츮��.txt";
    ArrayList<String> studentList = new ArrayList<String>();

    // [2. ��¥ �Է� �ޱ�] ���� ��Ʈ��
    String defaltPath ="����/";
    File defaltPathArr[] = new File(defaltPath).listFiles();
    
    String dirName;

    soon(){
        studentArrayAdd();
    }
    
    // 1. �л���� �ҷ�����
    void studentArrayAdd(){
        try{
            FileReader fr = new FileReader(studentListFile); 
            BufferedReader br = new BufferedReader(fr);
            String name;
            while((name = br.readLine()) !=null){
                studentList.add(name);
            }
            dateSelect(); // �л���� ������ ������ [2. ��¥ �Է� �ޱ�] �� �Ѿ

        }catch(FileNotFoundException fe){
            pln("�л����("+studentListFile+") ������ �����ϴ�.");
            return; // ����
        }
        catch(IOException ie){
        }
    }
    
    // 2. ��¥ �Է� �ޱ�
    void dateSelect(){
        Scanner s = new Scanner(System.in);
        pln(" ");
        pln("--------------------���� �˻� �ϱ�--------------------");
        pln(" ");
        pln("�л����: "+studentListFile);
        p("�������: ");

        for (int i=0; i<defaltPathArr.length; i++){
            p("["+defaltPathArr[i].getName()+"] ");
        }
        
        pln(" ");
        pln(" ");
        System.out.print("�� ���� ������ �˻��ұ��?: ");
        
        dirName = defaltPath + s.next();
        dateCheck();
    }

    // 3. �ش� ��¥ ���� �˻�
    void dateCheck(){
        String dirPathArr[] = new File(dirName).list(); // {������}.list() : {������}�� ���������� �Ϲݹ迭�� ��ȯ��

        if(new File(dirName).exists()){ // �Է¹��� ��¥���� ������ �����ϸ�
            if(dirPathArr.length == 0){
                pln(" ");
                pln("--------------------���� �˻� ���--------------------");
                pln(" ");
                pln("�ƹ��� �������� �ʾҾ��....");
                pln(" ");
                return;
            } else {
                for(int i=0; i<dirPathArr.length; i++){
                    // {ã���迭}.indexOf({ã�°�}) : �ִ� ��� -1����ȯ��
                    if(studentList.indexOf(dirPathArr[i]) != -1) { 
                        studentList.remove(dirPathArr[i]);
                    }
                }
            }
            result();
            
        } else { // �Է¹��� ��¥���� ������ �������� ������
            pln(" ");
            pln(dirName + " ������ �����ϴ�.");
            studentArrayAdd(); // ó������ ���ư�
        }
    }

    // 3. �˻� ��� ���
    void result(){ 
        pln(" ");
        pln("--------------------�˻� ���--------------------");
        pln(" ");
        if(studentList.size() == 0){
            pln("�����մϴ�! ���� �� �����߾��!");
            pln(" ");
        }else {
            p("��������: ");
            for(String notSubmitName : studentList) {
                p(" [" + notSubmitName + "] ");
            }
            pln(" ");
        }
    }

    void p(String a){ // ����Լ� 1 (�ζ���)
        System.out.print(a);
    }
    void pln(String a){ // ����Լ� 2
        System.out.println(a);
    }

    public static void main(String[] args) {
        new soon();
    }
}