import java.io.*;
//키보드 입력받은걸 파일로 아웃풋


public class BB {
    InputStream is;
    OutputStream os;
    String fname = "BBtest.txt";

    BB(){
        is = System.in; //InputStream을 반환타입으로 가지는 System.in 이용
        try {
            os = new FileOutputStream(fname); //OutputStream의 subclass
        } catch (FileNotFoundException fe) {

        }
    }

    void rw(){
        int b = 0;
        try {
            while ((b=is.read()) != -1) { // 스트림 끝에 도달하여 바이트를 사용할 수 없는 경우 -1 값이 반환
                os.write(b);

            }
            os.flush(); //비워준다
        } catch (IOException e) {

        } finally{
            try {
                is.close();
                os.close();
            } catch (IOException e) {
            }
        }
    }

    public static void main(String[] args) {
        BB bb=  new BB();
        bb.rw();

    }
    
}
