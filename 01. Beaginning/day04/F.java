class F{ // BMI ���
    String[][] arr = new String[4][3];
    String[][] bmiArr = { 
        {"0", "18", "��ü��", "������������."},
        {"18", "23", "����", "�� �����ϴ�."},
        {"23", "25", "��ü��", "�ణ ��������, ���� �����ƿ�."},
        {"25", "30", "��", "���� �ȴʾ����, ��սô�!"},
        {"30","35", "����", "�컩."},
        {"35", "100", "�ʰ���", "����� �������� �����ϴ�.."},
    };

    void bmiCalculate(double cm, double kg){
        double m = cm/100;
        int bmi = (int)(kg/(m*m));
        
        System.out.println("���� : " + cm + "cm");
        System.out.println("ü�� : " + kg + "kg");
        if(kg > cm || kg > 300 || cm > 220 || kg < 30 || cm < 80) {
            System.out.println("�� ��ġ�� �³���? ��ü������ ��Ȯ�� �Է����ּ���.");
        } else {
            System.out.println("---------------BMI ���---------------");
            System.out.println("����� BMI ������ " + bmi + " �Դϴ�.");
            for(int i = 0; i< bmiArr.length; i++){
                if(bmi < Integer.parseInt(bmiArr[i][1]) && bmi >= Integer.parseInt(bmiArr[i][0])) {
                    System.out.println(bmiArr[i][2] + "�̽ñ���." + bmiArr[i][3]);
                }
            }
        }
    }
    public static void main(String[] args){
        
        new F().bmiCalculate(162, 400);
    }
}