import java.io.*;

class Tip1 
{
	String path = "C:/SOO/학생들의공간/04_로또(컬렉션)";
	
	void listDirInPath(){
        File f = new File(path);
		if(f.exists()){
			//pln("존재하는 디렉토리");
            showListDirs(f);
		}else{
			pln("존재하지않는 디렉토리");
		}
	}
	void showListDirs(File f){
		File kids[] = f.listFiles();
		for(File kid: kids) {
			if(!kid.isFile()){
				String name = kid.getName();
				pln("name: " + name);
			}
		}
	}
	void pln(String str){
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Tip1 t1 = new Tip1();
		t1.listDirInPath();
	}
}
