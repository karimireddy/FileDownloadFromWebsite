package com.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadMp3 {
	
	public static void download(String url, String path) throws IOException{
		 URLConnection conn = new URL(url).openConnection();
		    InputStream is = conn.getInputStream();

		    OutputStream outstream = new FileOutputStream(new File(path));
		    byte[] buffer = new byte[4096];
		    int len;
		    while ((len = is.read(buffer)) > 0) {
		        outstream.write(buffer, 0, len);
		    }
		    outstream.close();
	}

}
