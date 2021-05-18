class TV {
    int size;
        
    TV(int size){
        this.size=size;
    }
}

class ColorTV extends TV{
    
    int price;

    ColorTV(int price){
        super(60);
        this.price=price;

    }
    void showSpec(){
        System.out.println(size+"ÀÎÄ¡");
    }
}



class AAAUser{

    public static void main(String[] args) {
        TV tv = new TV(32);
        ColorTV ctv = new ColorTV(60);
        ctv.showSpec();
        
        
    }
}

