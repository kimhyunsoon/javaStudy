class E{ //증감율 계산

	void increaseCalculate(double a, double b){
		System.out.println("초기값 : " + a);
		System.out.println("결과값 : " + b);
		System.out.println("증감율은 " + (double)((b-a)/a*100) + "% 입니다.");
	}

	public static void main(String[] args){
		System.out.println("-----증감율 계산 결과-----");
		new E().increaseCalculate(556163, 13241);
	}
}