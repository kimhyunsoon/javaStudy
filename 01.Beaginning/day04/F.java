class F{ // BMI 계산
    String[][] arr = new String[4][3];
    String[][] bmiArr = { 
        {"0", "18", "저체중", "밥좀먹으세요."},
        {"18", "23", "정상", "딱 좋습니다."},
        {"23", "25", "과체중", "약간 무겁지만, 아직 괜찮아요."},
        {"25", "30", "비만", "아직 안늦었어요, 운동합시다!"},
        {"30","35", "고도비만", "살빼."},
        {"35", "100", "초고도비만", "당신은 죽을수도 있읍니다.."},
    };

    void bmiCalculate(double cm, double kg){
        double m = cm/100;
        int bmi = (int)(kg/(m*m));
        
        System.out.println("신장 : " + cm + "cm");
        System.out.println("체중 : " + kg + "kg");
        if(kg > cm || kg > 300 || cm > 220 || kg < 30 || cm < 80) {
            System.out.println("위 수치가 맞나요? 신체정보를 정확히 입력해주세요.");
        } else {
            System.out.println("---------------BMI 결과---------------");
            System.out.println("당신의 BMI 지수는 " + bmi + " 입니다.");
            for(int i = 0; i< bmiArr.length; i++){
                if(bmi < Integer.parseInt(bmiArr[i][1]) && bmi >= Integer.parseInt(bmiArr[i][0])) {
                    System.out.println(bmiArr[i][2] + "이시군요." + bmiArr[i][3]);
                }
            }
        }
    }
    public static void main(String[] args){
        
        new F().bmiCalculate(162, 400);
    }
}