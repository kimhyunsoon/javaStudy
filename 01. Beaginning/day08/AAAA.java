class Circle {
    int radius;
    Circle(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return radius;
    }
}

class ChildCircle extends Circle{
    
    String name;
    ChildCircle(int radius, String name){
        super(radius);
        this.name = name;
    }

    void show(){
        System.out.println("반지름 "+radius+"인 원의 이름은 "+name+"이다");
    }

}

class AAAAUser{
    public static void main(String[] args) {
		ChildCircle w = new ChildCircle(5, "Waffle");
		w.show();
	}



}
