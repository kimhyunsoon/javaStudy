class AUser
{
	A a;
	AUser(A a){
		this.a = a;
	}
	void use(){
		System.out.println("#name: " + a.name);
		a.m();
	}
}