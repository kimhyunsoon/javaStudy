class Lky {
	String name;
	int age;
	String job;
	Lky(){
		name = "길동"; age = 30; job = "프로그래머";
	}
	Lky(String name, int age, String job){
		this.name=name; this.age=age; this.job=job;
	}
	void showInfo(){
		System.out.println("#Lky name: "+ name + ", age: " + age + ", job: "+ job);
	}
}
class LkyChild extends Lky {
	long income;
	LkyChild(String name, int age, String job, long income){
		super(name, age, job);
		this.income = income;
	}
	void earn(){
		System.out.println(income + "원의 돈을 번다");
	}
}
class LkyChildChild extends LkyChild {
	long pMoney;
	LkyChildChild(String name, int age, String job, long income, long pMoney){
		super(name, age, job, income);
		this.pMoney = pMoney;
	}
	void play(){
		System.out.println(pMoney+"원을 쓰면서 논다");
	}
}
