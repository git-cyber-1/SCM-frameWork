package com.comcast.scm.generic.fileutility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader filer=new FileReader("./ConfigAppData/CommonData.json");
		JSONParser parser= new JSONParser();
		Object obj = parser.parse(filer);
		JSONObject jobj=(JSONObject)obj;
		String data = (String)jobj.get(key);
		return data;
		
	}
	public double getDataFromJsonFileint(String key) throws IOException, ParseException {
		FileReader filer=new FileReader("./ConfigAppData/CommonData.json");
		JSONParser parser= new JSONParser();
		Object obj = parser.parse(filer);
		JSONObject jobj=(JSONObject)obj;
		int data = Integer.valueOf(jobj.get(key).toString());
		return data;
	

}
}
