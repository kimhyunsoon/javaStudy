class E{ //������ ���

	void increaseCalculate(double a, double b){
		System.out.println("�ʱⰪ : " + a);
		System.out.println("����� : " + b);
		System.out.println("�������� " + (double)((b-a)/a*100) + "% �Դϴ�.");
	}

	public static void main(String[] args){
		System.out.println("-----������ ��� ���-----");
		new E().increaseCalculate(556163, 13241);
	}
}