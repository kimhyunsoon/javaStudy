import java.io.*;
class BBUser {//�Է¿��� ����ó��

    void m1(){
        
        FileInputStream fis = null;
        try{
            fis = new FileInputStream("a.txt");

        } catch(FileNotFoundException e) { 
            System.out.println(e); //������ ������ catch ��� ����
            return; //������ �־ �Ʒ� finally ��� ���� ����
        } finally {
            if (fis != null) {
                try{
                    fis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                
            }
            System.out.println("finally ������ �׻� �����");
        }
        System.out.println("���⵵ �����");
    }

    
    


    public static void main(String[] args) {
        BBUser bb = new BBUser();
        bb.m1();
        
    
    }

}
