class Showing 
{
	Grade g;
	Showing(Grade g){
		this.g = g;
	}
	void show(){
		P.pln("����: " + g.grade + " (����: " + g.total +", ���: "+ g.avg+")");
	}
}
