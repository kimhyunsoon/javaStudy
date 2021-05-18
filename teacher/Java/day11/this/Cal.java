class Cal 
{
	Grade g;
	Cal(Grade g){
		this.g = g;
	}
	void cal(){
		for(int jumsu : g.is) g.total += jumsu;
		g.avg = g.total/g.is.length;
	}
}
