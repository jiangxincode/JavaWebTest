package com.shengsiyuan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class NetworkUtil
{
	public static String getStringContentFromURL(String queryString) throws Exception
	{
		URL url = new URL(queryString);
		
		URLConnection conn = url.openConnection();
		
		InputStream is = conn.getInputStream();
		
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer buffer = new StringBuffer();
		
		String line = null;
		
		while(null != (line = br.readLine()))
		{
			buffer.append(line);
		}
		
		br.close();
		isr.close();
		is.close();
		
		return buffer.toString();
	}
	
	public static void write2LocalFromInternet(String imageUrl, File file) throws Exception
	{
		InputStream is = null;
		OutputStream os = null;
		
		try
		{
			URL url = new URL(imageUrl);
			
			is = url.openStream();
			
			os = new FileOutputStream(file);
			
			int length = -1;
			byte[] buffer = new byte[7092];
			
			while(-1 != (length = is.read(buffer, 0, 7092)))
			{
				os.write(buffer, 0, length);
			}
		}
		catch(Exception ex)
		{
			
		}
		finally
		{
			if(null != is)
			{
				is.close();
			}
			if(null != os)
			{
				os.close();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
