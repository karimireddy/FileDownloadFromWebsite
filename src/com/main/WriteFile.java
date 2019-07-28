package com.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

	public static void append(String data, String path) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));//Set true for append
		writer.newLine(); // Add new line
		writer.write(data);
		writer.close();
	}

}
