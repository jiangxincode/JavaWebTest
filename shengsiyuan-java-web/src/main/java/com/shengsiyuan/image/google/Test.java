package com.shengsiyuan.image.google;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Test
{
	public static void main(String[] args) throws Exception
	{
		List<String> list = new ArrayList<String>();
		
		for(int i = 0; i < 8; i++)
		{
			String str = "http://ajax.googleapis.com/ajax/services/search/images?key=ABQIAAAAHMkDJuY1vzGaqUjliVAN-RSo6_Y-lPd_7a5rWdJRsISKKsAXgBQyI4z9PBvV4NjKXO02MH68cek4yA&q=macbook&rsz=large&v=1.0&";
			
			str += "start=" + 8 * i;
			
			URLConnection conn = new URL(str).openConnection();
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			StringBuffer buffer = new StringBuffer();
			
			String line = null;
			
			while(null != (line = br.readLine()))
			{
				buffer.append(line);
			}
			
			list.add(buffer.toString());
			
			br.close();
			isr.close();
			is.close();
		}
		
		System.out.println(list.size());
		
		for(String s : list)
		{
			System.out.println(s);
		}
		
		
		
		
		
		
		
		
	
		
		
	}
}
