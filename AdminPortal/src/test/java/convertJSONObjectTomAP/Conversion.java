package convertJSONObjectTomAP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class Conversion {

public static void main(String[] args) throws JSONException, ParseException {
String s1="{\"name\":\"sagar\",\r\n" + 
"\"address\":\"shashikal\"}";

// org.json.JSONObject obj = new JSONObject(s1);
// JSONParser parser = new JSONParser(); 
// JSONObject json = (JSONObject) parser. parse(s1);
JSONObject jsonObject = new JSONObject(s1);
System.out.println(jsonToMap(jsonObject));
}

public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
   Map<String, Object> retMap = new HashMap<String, Object>();

   if(json != JSONObject.NULL) {
       retMap = toMap(json);
   }
   return retMap;
}

public static Map<String, Object> toMap(JSONObject object) throws JSONException {
   Map<String, Object> map = new HashMap<String, Object>();

   Iterator<String> keysItr = object.keys();
   while(keysItr.hasNext()) {
       String key = keysItr.next();
       Object value = object.get(key);

       if(value instanceof JSONArray) {
           value = toList((JSONArray) value);
       }

       else if(value instanceof JSONObject) {
           value = toMap((JSONObject) value);
       }
       map.put(key, value);
   }
   return map;
}

public static List<Object> toList(JSONArray array) throws JSONException {
   List<Object> list = new ArrayList<Object>();
   for(int i = 0; i < array.length(); i++) {
       Object value = array.get(i);
       if(value instanceof JSONArray) {
           value = toList((JSONArray) value);
       }

       else if(value instanceof JSONObject) {
           value = toMap((JSONObject) value);
       }
       list.add(value);
   }
   return list;
}
}