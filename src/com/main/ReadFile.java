package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	public static String read(String path) throws IOException {
		File file = new File(path);

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		StringBuilder fileList = new StringBuilder();
		while ((st = br.readLine()) != null) {
			for (String temp : st.split("\"")) {
				if (temp.contains(".aspx")) {
					System.out.println(temp);
					fileList.append(temp);
					fileList.append("\n");
				}
			}
		}
		br.close();
		
	return fileList.toString();
	}
	public static String readNormal(String path) throws IOException {
		File file = new File(path);
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		StringBuilder fileList = new StringBuilder();
		while ((st = br.readLine()) != null) {
					fileList.append(st);
					fileList.append("\n");
		}
		br.close();
		
		return fileList.toString();
	}

}
