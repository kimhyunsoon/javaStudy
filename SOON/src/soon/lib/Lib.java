package soon.lib;
import java.util.HashMap;

public class Lib {
    HashMap<String, String> pathMap = new HashMap<>();
    
    public void msg(String a) {
        System.out.print(a);
    }
    public void msgln(String a) {
        System.out.println(a);
    }

    public String pathFunc(String a){
        pathMap.put("res", "../src/soon/res");
        return pathMap.get(a);
    }
}
