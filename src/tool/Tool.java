package tool;

import net.sf.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class Tool {
    public static Map<String,Object> testLayui(Object o,int page ,int limit){
        Map<String,Object> returnTable =new HashMap<>();
        returnTable.put("code",0);
        returnTable.put("msg","");
        returnTable.put("count",1000);
        JSONArray data = JSONArray.fromObject(o);
        returnTable.put("data",data);
        return returnTable;
    }
}
