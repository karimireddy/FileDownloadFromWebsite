package com.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadWebPage {
	
	public static String loadWebPage(String url) throws IOException {
		URL ur = new URL(url);
	    HttpURLConnection yc =(HttpURLConnection) ur.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	    StringBuilder inputLine = new StringBuilder();
	    while (in.readLine() != null) 
	    	inputLine.append(in.readLine());
	    in.close();
		
		return inputLine.toString();
	}

}
