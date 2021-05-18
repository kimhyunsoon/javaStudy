class D{ // BMI 계산
	double kg = 49.8;
	double cm = 162.3;


	void bmiCalculate(){
		double m = cm/100;
		System.out.println("당신의 BMI 지수는 " + (int)(kg/(m*m)) + " 입니다.");
	}
	public static void main(String[] args){
		System.out.println("-----BMI 결과-----");
		new D().bmiCalculate();
	}
}