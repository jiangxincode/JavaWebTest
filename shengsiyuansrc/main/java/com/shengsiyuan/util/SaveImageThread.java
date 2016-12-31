package com.shengsiyuan.util;

import java.io.File;

public class SaveImageThread extends Thread
{
	private File directory;

	private String[] imageUrls;

	public SaveImageThread(File directory, String[] imageUrls)
	{
		this.directory = directory;
		this.imageUrls = imageUrls;
	}

	@Override
	public void run()
	{
		long startTime = System.currentTimeMillis();
		
		try
		{
			for (String imageUrl : imageUrls)
			{
				int position = imageUrl.lastIndexOf("/");

				String imageName = imageUrl.substring(position + 1);

				File file = new File(directory, imageName);

				NetworkUtil.write2LocalFromInternet(imageUrl, file);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(this.getName() + ": " + (endTime - startTime));
	}
}
