public class BB {

    String strs[] = {"À¯»ê±Õ", "ºñÅ¸¹Îµð", "Ä®½·", "¿À¸Þ°¡3"};
    void out(){
        for(int i=0; i<strs.length;i++){
            System.out.println("strs["+i+"]: "+strs[i]);
        }

    }

    public static void main(String[] args){
        BB b = new BB();
        b.out();
    }

    
}
