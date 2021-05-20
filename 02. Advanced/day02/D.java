import java.io.*; 
public class D { //주제 : File

    String path = "C:\\KAEUN\\JAVA\\teacher\\Advanced\\day02";
    File f;
    FileWriter fw;
    D(){
        f = new File(path);
    }

    void test(){
        boolean b1 = f.exists();
        System.out.println("b1: "+b1);
        boolean b2 = f.isDirectory();
        System.out.println("b2: "+b2);
        boolean b3 = f.isFile();
        System.out.println("b3: "+b3);

        File fc = new File(f,"aa/bb/cc");
        fc.mkdirs();
        
        File fc2 = new File(fc,"happy.txt");
        try {
            fc2.createNewFile();
        fw = new FileWriter(fc2);
        // char cs [] = {'h','a','p','p','y'};
        String str = "Happy day~~!";
        char cs[] = str.toCharArray();
        fw.write(cs);
        fw.flush();
        } catch (IOException ie) {
        } finally{
            try {
                fw.close();
            } catch (IOException ie) {
            }
        }

        File f = new File("./"); //상대경로
        try {
            String cPath = f.getCanonicalPath(); //절대경로
            System.out.println("cPath"+cPath);

        } catch (Exception e) {}
        String aPath = f.getAbsolutePath();
        System.out.println("aPath"+aPath);

        fc2.delete();
    }

    public static void main(String [] args) {
        D d = new D();
        d.test();
        
    }
    
}
