package com.main;

import java.io.FileWriter;

public class WriteFile {
	
	public static void write(String data, String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
