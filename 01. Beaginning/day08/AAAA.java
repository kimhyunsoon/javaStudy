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
        System.out.println("������ "+radius+"�� ���� �̸��� "+name+"�̴�");
    }

}

class AAAAUser{
    public static void main(String[] args) {
		ChildCircle w = new ChildCircle(5, "Waffle");
		w.show();
	}



}
