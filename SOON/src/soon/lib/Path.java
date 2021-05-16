package soon.lib;
import java.util.HashMap;

public class Path {
    HashMap<String, String> pathMap = new HashMap<>();
    
    void put(){
        pathMap.put("bin", "../src/soon/res");
    }
    public String PathFunc(String a){
        put();
        return pathMap.get(a);
    }
}
