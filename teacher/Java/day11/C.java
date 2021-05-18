class C {
	private int m(int j){
		System.out.println("C¿« m()");
		return j;
	}
}

class CChild extends C{
	public int m(int i){
		System.out.println("CChild¿« m()");
		return i;
	}
}
/*
class CUser{
	public static void main(String[] args) {
		CChild cc = new CChild();
		cc.m();
	}
}*/