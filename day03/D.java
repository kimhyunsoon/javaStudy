class D{ // BMI ���
	double kg = 49.8;
	double cm = 162.3;


	void bmiCalculate(){
		double m = cm/100;
		System.out.println("����� BMI ������ " + (int)(kg/(m*m)) + " �Դϴ�.");
	}
	public static void main(String[] args){
		System.out.println("-----BMI ���-----");
		new D().bmiCalculate();
	}
}