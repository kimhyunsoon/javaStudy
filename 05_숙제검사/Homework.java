import java.io.*;
import java.util.*;

class Homework {
    
    String path = "C:/KAEUN/JAVA/05_�����˻�_soon/����/1��";

    void confirmDir(){
        File f = new File(path); //File class
        if(f.exists()){ //���丮�� �����ϸ� true, �������� ������ false
            pln("�����ϴ� ���丮");
            
        }else{
            pln("�������� �ʴ� ���丮");
        }

    }

    void showDirs(File f){
        File kids[] = f.listFiles(); //listFiles() ���丮�� �̸��� �迭�� ��ȯ. kids �迭�� ����
        for(File kid: kids){//kids�� �ִ� ��Ұ� ������ ������ �ݺ����� ���� kid�� ����
            if(!kid.isFile){ //isFile() ��ο� �ִ� ������ ���丮�� false�� ��ȯ, 
                String name = kid.getName();
            }

        }




    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        Homework test = new Homework();
        test.confirmDir();}

}









// ���� ���� (���丮���)
// -> File ���Ϻ���  = new File(���丮 ���);

// ���Ϻ����� ���� ���丮�� �迭�� ��� �Լ�
// -> FIle ���丮�迭[] = ���Ϻ���.listFile();
