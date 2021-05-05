class AAA{
    String strs[]; //선언
    AAA(){
        strs = new String[4]; //방의 크기가 4개인 배열 생성
    }
    void input(){//초기화
        strs[0] = "치킨";
        strs[1] = "피자";
        strs[2] = "떡볶이";
        strs[3] = "닭발";
    }

    void output(){//원할 때 꺼내서 사용
        System.out.println("strs[0]: "+strs[0]);
        System.out.println("strs[1]: "+strs[1]);
        System.out.println("strs[2]: "+strs[2]);
        System.out.println("strs[3]: "+strs[3]);

    }

    void out1(){ //for문으로 꺼내쓰기
        for(int i=0;i<strs.length;i++){ //strs.length strs배열의 길이가 4
            System.out.println("strs["+i+"]: "+strs[i]);
        }
    }

    public static void main(String[] args){
        AAA a = new AAA();
        a.input();
        a.out1();
    }  










}