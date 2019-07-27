package com.main;

import java.io.IOException;

public class MainRun {

	public static void main(String[] args) throws IOException {

		System.out.println("Started Main");
		
		processLink();
		
		
		System.out.println("Success...");
	}
	
	public static void processLink() throws IOException{
		
		String urlPrefix = "http://english.srichaganti.net";
		StringBuilder dataToWrite = new StringBuilder();
		String fileName = "mp3Files2";

		String path = "fileList";

		String readData = ReadFile.readNormal(path);
		

		for (String temp : readData.split("\n")) {
			if (!temp.isEmpty()) {
				String url = urlPrefix + temp;
				System.out.println(url);
				String data = LoadWebPage.loadWebPage(url);
				System.out.println(data);
				for (String temp1 : data.split("\"")) {
					if (temp1.contains("mp3") && !temp1.contains("playerID")) {
						dataToWrite.append(temp1);
						dataToWrite.append("\n");
						System.out.println(temp1);
					}
				}
			}
		}


		WriteFile.write(dataToWrite.toString(), fileName);
		
	}
	
	public static void downloadFile() {
		String path = "mp3Files";
	}
	
	public static void processmp3File() throws IOException{
		String path = "mp3Files";
		
		String mp3File = ReadFile.readNormal(path);
		StringBuilder dataToWrite = new StringBuilder();
		
		for(String temp : mp3File.split("\n")) {
			if(!temp.contains("playerID")) {
				dataToWrite.append(temp);
				dataToWrite.append("\n");
				System.out.println(temp);
			}
		}
		
		WriteFile.write(dataToWrite.toString(), "mp3Files1");
		
	}

}
