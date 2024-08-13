package com.comcast.scm.generic.fileutility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonDemo {
	@Test
	public void jsonu() throws IOException, ParseException {
	 JsonUtility ju=new JsonUtility();
	//double data= ju.getDataFromJsonFileint("timeout");
	//System.out.println((int)data);
	       String data = ju.getDataFromJsonFile("timeout");
	       System.out.println(data);
	 
	}
	

}
