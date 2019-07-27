package com.main;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class GetUrls {
	
	public static Set<String> get(String url) throws IOException{
		Set<String> urls = new HashSet<>();
		
		String data = LoadWebPage.loadWebPage(url.replace(".aspx.aspx", ".aspx"));
		
		for(String temp : data.split("\"")) {
			if((temp.contains(".aspx") || temp.contains(".mp3") || temp.contains(".pdf"))&&temp.contains("/")&&!temp.contains("playerID")) {
				urls.add(temp.replace("./", "/"));
			}
		}
		return urls;
	}

}
