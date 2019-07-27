package com.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainRun {

	public static Set<String> songUrls = new HashSet<>();
	public static Set<String> pdfUrls = new HashSet<>();
	public static List<String> songUrlsD = new ArrayList<>();
	public static List<String> pdfUrlsD = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		
		Arrays.asList(ReadFile.readNormal("finalList").split("\n")).parallelStream().forEach(temp ->  {
			if(!temp.isEmpty()) {
				String path = "songs/"+temp.replace("http://media.srichaganti.net/audio/", "").replace("%20", "").replace("/", "_");
				System.out.println("Downloading......: "+path);
				try {
					DownloadMp3.download(temp, path);
				} catch (IOException e) {
					System.out.println("Exception while downloading song: "+temp);
				}
				System.out.println("Downloaded: "+path);
			}
		});

	}

	public static void finalList() throws IOException {

		String file1 = ReadFile.readNormal("mp3Files1");
		String file2 = ReadFile.readNormal("songUrls");
		Set<String> finalList = new HashSet<>();
		for (String temp : file1.split("\n")) {
			finalList.add(temp);
		}
		for (String temp : file2.split("\n")) {
			finalList.add(temp);
		}
		StringBuilder sbFinalList = new StringBuilder();

		finalList.forEach(temp -> sbFinalList.append(temp + "\n"));

		WriteFile.write(sbFinalList.toString(), "finalList");

	}

	public static void mainProcess() throws IOException {
		String url = "http://english.srichaganti.net/Pravachanams.aspx";
		String prefix = "http://english.srichaganti.net";
		Set<String> remainingUrls = new HashSet<>();
		Set<String> remainingUrls1 = new HashSet<>();
		Set<String> remainingUrls2 = new HashSet<>();
		Set<String> remainingUrls3 = new HashSet<>();

		System.out.println("Started Main");

		Set<String> urlList = GetUrls.get(url);

		for (String temp : urlList) {
			if (temp.contains(".mp3")) {
				songUrls.add(temp);
				songUrlsD.add(temp);
			} else {
				Set<String> secondLevel = GetUrls.get(prefix + temp);
				for (String temp1 : secondLevel) {
					if (temp1.contains(".mp3")) {
						songUrls.add(temp1);
						songUrlsD.add(temp1);
					} else if (temp1.contains(".pdf")) {
						pdfUrls.add(temp1);
						pdfUrlsD.add(temp1);
					} else {
						remainingUrls.add(temp1);
					}
				}
			}
		}
		for (String temp : remainingUrls) {
			if (temp.contains(".mp3")) {
				songUrls.add(temp);
				songUrlsD.add(temp);
			} else if (temp.contains(".pdf")) {
				pdfUrls.add(temp);
				pdfUrlsD.add(temp);
			} else {
				Set<String> secondLevel = GetUrls.get(prefix + temp);
				for (String temp1 : secondLevel) {
					if (temp1.contains(".mp3")) {
						songUrls.add(temp1);
						songUrlsD.add(temp1);
					} else if (temp1.contains(".pdf")) {
						pdfUrls.add(temp1);
						pdfUrlsD.add(temp1);
					} else {
						remainingUrls1.add(temp1);
					}
				}
			}
		}
		for (String temp : remainingUrls1) {
			if (temp.contains(".mp3")) {
				songUrls.add(temp);
				songUrlsD.add(temp);
			} else if (temp.contains(".pdf")) {
				pdfUrls.add(temp);
				pdfUrlsD.add(temp);
			} else {
				Set<String> secondLevel = GetUrls.get(prefix + temp);
				for (String temp1 : secondLevel) {
					if (temp1.contains(".mp3")) {
						songUrls.add(temp1);
						songUrlsD.add(temp1);
					} else if (temp1.contains(".pdf")) {
						pdfUrls.add(temp1);
						pdfUrlsD.add(temp1);
					} else {
						remainingUrls2.add(temp1);
					}
				}
			}
		}
		for (String temp : remainingUrls2) {
			if (temp.contains(".mp3")) {
				songUrls.add(temp);
				songUrlsD.add(temp);
			} else if (temp.contains(".pdf")) {
				pdfUrls.add(temp);
				pdfUrlsD.add(temp);
			} else {
				Set<String> secondLevel = GetUrls.get(prefix + temp);
				for (String temp1 : secondLevel) {
					if (temp1.contains(".mp3")) {
						songUrls.add(temp1);
						songUrlsD.add(temp1);
					} else if (temp1.contains(".pdf")) {
						pdfUrls.add(temp1);
						pdfUrlsD.add(temp1);
					} else {
						remainingUrls3.add(temp1);
					}
				}
			}
		}

		StringBuilder secondUrls = new StringBuilder();
		for (String temp : remainingUrls3) {
			secondUrls.append(temp + "\n");
		}
		StringBuilder songUrl = new StringBuilder();
		for (String temp : songUrls) {
			songUrl.append(temp + "\n");
		}
		StringBuilder pdfUrl = new StringBuilder();
		for (String temp : pdfUrls) {
			pdfUrl.append(temp + "\n");
		}
		StringBuilder songUrlD = new StringBuilder();
		for (String temp : songUrlsD) {
			songUrlD.append(temp + "\n");
		}
		StringBuilder pdfUrlD = new StringBuilder();
		for (String temp : pdfUrlsD) {
			pdfUrlD.append(temp + "\n");
		}
		WriteFile.write(secondUrls.toString(), "secondUrls");
		WriteFile.write(songUrl.toString(), "songUrls");
		WriteFile.write(pdfUrl.toString(), "pdfUrls");
		WriteFile.write(songUrlD.toString(), "songUrlsD");
		WriteFile.write(pdfUrlD.toString(), "pdfUrlsD");

		System.out.println("Success...");
	}

	public static void mainPage() throws IOException {
		String url = "http://english.srichaganti.net/Pravachanams.aspx";
		String data = LoadWebPage.loadWebPage(url);
		StringBuilder processed = new StringBuilder();
		for (String temp : data.split("\"")) {
			if (temp.contains(".aspx")) {
				processed.append(temp + "\n");
			}
		}

		WriteFile.write(processed.toString(), "allUrls");
		System.out.println(processed.toString());

	}

	public static void subPage() throws IOException {
		String url = "http://english.srichaganti.net";
		String data = LoadWebPage.loadWebPage(url);
		StringBuilder processed = new StringBuilder();
		StringBuilder songs = new StringBuilder();

		for (String temp : data.split("\"")) {
			if (temp.contains(".aspx")) {
				processed.append(temp + "\n");
			}
		}

		WriteFile.write(processed.toString(), "allUrls");
		System.out.println(processed.toString());

	}

	public static void processLink() throws IOException {

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

	public static void processmp3File() throws IOException {
		String path = "mp3Files";

		String mp3File = ReadFile.readNormal(path);
		StringBuilder dataToWrite = new StringBuilder();

		for (String temp : mp3File.split("\n")) {
			if (!temp.contains("playerID")) {
				dataToWrite.append(temp);
				dataToWrite.append("\n");
				System.out.println(temp);
			}
		}

		WriteFile.write(dataToWrite.toString(), "mp3Files1");

	}

}
