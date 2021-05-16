package soon.test;
import soon.lib.*;
import java.io.*;
import java.util.*;

public class Test {
    public static void main(String arg[]){
        Path p = new Path();

        File dir = new File(p.PathFunc("bin"));
        File files[] = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            System.out.println("file: " + files[i]);
        }
        System.out.println(p.PathFunc("bin"));
    }
}
