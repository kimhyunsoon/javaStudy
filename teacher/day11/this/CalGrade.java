class CalGrade 
{
	Grade g;
	CalGrade(Grade g){
		this.g = g;
	}
	void calG(){
		switch(g.avg/10){
			case 10: 
			case 9: g.grade = "A"; break;
			case 8: g.grade = "B"; break;
			case 7: g.grade = "C"; break;
			case 6: g.grade = "D"; break;
		}
	}
}
