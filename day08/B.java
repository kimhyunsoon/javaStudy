class 도형 {

    void draw(){

        System.out.println("도형을 그린다");
    }
    
}


class 사각형 extends 도형 {

    void draw(){

        System.out.println("사각형을 그린다");
    }
    
}

class 삼각형 extends 도형 {

    void draw(){

        System.out.println("삼각형을 그린다");
    }
    
}

class 원형 extends 도형 {

    void draw(){

        System.out.println("원을 그린다");
    }
    
}

class B {

    public static void main(String[] args) {
        
        도형 a = new 사각형();
        도형 b = new 삼각형();
        도형 c = new 원형();
        a.draw();
        b.draw(); 
        c.draw();
            
    }

}



