import java.io.*;
public class DDD {
    String path = "C:/KAEUN/JAVA/02. Advanced/day02";
    File f;

    DDD(){
        f = new File(path);
    }

    void check(){
        boolean b1 = f.exists();
        pln("b1: "+b1);
        boolean b2 = f.isDirectory();
        pln("b2: "+b2);
        boolean b3 = f.isFile();
        pln("b3: "+b3);
    }

    void make(){
        File fc = new File(f,"aa/bb/cc"); //부모 경로로부터 새 파일 인스턴스를 만듬
        fc.mkdirs(); //디렉토리 생성
        File fc2 = new File(fc,"day02.txt");
        FileWriter fw = null;
        try {
            fc.createNewFile();
            fw = new FileWriter(fc2);
            String str = "PrintWriter는 오토 플러쉬가 된다?";
            char cs[] = str.toCharArray();
            fw.write(cs);
            fw.flush();
        } catch (IOException e) {
        } finally{
			try{
				fw.close();
			}catch(IOException ie){}
		}
    }

    void getPath(){
        File f = new File(".");
        try {
            String cpath = f.getCanonicalPath();
            pln(cpath);
            String apath = f.getAbsolutePath();
            pln(apath);
        } catch (IOException e) {

        }

    }

    void pln(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        DDD ddd = new DDD();
        ddd.check();
        ddd.make();
        ddd.getPath();
        
    }
    
}
