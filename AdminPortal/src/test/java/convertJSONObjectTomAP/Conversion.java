package convertJSONObjectTomAP;

import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class Conversion {

	public static void main(String[] args) throws JSONException, ParseException, JsonMappingException, JsonProcessingException {
		String s1 = "{\"failure_dn\"=[],\r\n"
				+ "order=[settings, validate, user, details, profile, assertions, mappings],\r\n"
				+ "steps={assertions={data=null, desc=SAML assertions, executed=false, msg=null, pass=false},\r\n"
				+ "details={data=null, desc=LDAP user details, executed=false, msg=null, pass=false},\r\n"
				+ "mappings={data=null, desc=User mapped settings, executed=false, msg=null, pass=false},\r\n"
				+ "profile={data=null, desc=Profile Mapping, executed=false, msg=null, pass=false},\r\n"
				+ "settings={data=null, desc=LDAP configuration, executed=true, msg=null, pass=true},\r\n"
				+ "user={data=null, desc=LDAP user found, executed=false, msg=null, pass=false},\r\n"
				+ "validate={data=null, desc=LDAP filter validation, executed=false, msg=null, pass=false}\r\n"
				+ "},\r\n" + "success=1}";
		

		JSONObject jsonObject = new JSONObject(s1);
		@SuppressWarnings("rawtypes")
		HashMap hashMap=(HashMap) jsonToMap(jsonObject);
	
		Object jsonObject1=hashMap.get("steps");
		
		JSONObject jsonObject11 = new JSONObject(jsonObject1.toString());
		
		@SuppressWarnings("rawtypes")
		HashMap map2=(HashMap) jsonToMap(jsonObject11);
		
		Object jsonObject12=map2.get("settings");
		JSONObject jsonObject122 = new JSONObject(jsonObject12.toString());
		@SuppressWarnings("rawtypes")
		HashMap finalMap=(HashMap) jsonToMap(jsonObject122);
		
		Boolean type=(Boolean) finalMap.get("pass");
		
		System.out.println(type);
	}

	public static Map<String, Object> jsonToMap(JSONObject json) throws JSONException {
		Map<String, Object> retMap = new HashMap<String, Object>();

		if (json != JSONObject.NULL) {
			retMap = toMap(json);
		}
		return retMap;
	}

	public static Map<String, Object> toMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		@SuppressWarnings("unchecked")
		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}
}