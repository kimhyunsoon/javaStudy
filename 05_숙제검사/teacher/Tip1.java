import java.io.*;

class Tip1 
{
	String path = "C:/SOO/�л����ǰ���/04_�ζ�(�÷���)";
	
	void listDirInPath(){
        File f = new File(path);
		if(f.exists()){
			//pln("�����ϴ� ���丮");
            showListDirs(f);
		}else{
			pln("���������ʴ� ���丮");
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
