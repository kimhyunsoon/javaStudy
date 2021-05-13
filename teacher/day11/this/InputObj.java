import java.io.*;

class InputObj 
{
	Grade g;
	InputObj(Grade g){
		this.g = g;
	}
	void input(){
		try{
			String line = "";
			int jumsu = 0;
			for(int i=0; i<g.subjects.length; i++){
				P.p(g.subjects[i]+": ");
				line = g.br.readLine();
				line = line.trim();
				jumsu = Integer.parseInt(line);
				g.is[i] = jumsu;
			}
		}catch(IOException ie){
		}
	}
}
