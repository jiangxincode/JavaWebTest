package com.shengsiyuan.imagetools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shengsiyuan.util.SaveImageThread;

public class SaveImageServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		try
		{
			HttpSession session = req.getSession();

			String categoryName = (String) session.getAttribute("categoryName");
			String picSource = (String) session.getAttribute("picSource");
			List<String> list = (List<String>) session.getAttribute("images");

			String path = req.getSession().getServletContext().getRealPath(
					"/storeImages");

			File directory = new File(path, picSource + "/" + categoryName);

			directory.mkdirs();

//			long startTime = System.currentTimeMillis();
			
			String[] array = null;
			
			for(int i = 0; i < list.size(); i++)
			{
				array = new String[1];
				
				String imageUrl = list.get(i);
				
				int position = imageUrl.lastIndexOf("/");

				// name of the image
				String imageName = imageUrl.substring(position + 1);

				File file = new File(directory, imageName);
				
				array[0] = imageUrl;
				
				new SaveImageThread(directory, array).start();

//				if(i % 4 == 0)
//				{
//					if(0 != i)
//					{
//						new SaveImageThread(directory, array).start();
//					}
//					
//					array = new String[4];
//				}
//				
//				array[i % 4] = imageUrl;
				
//				NetworkUtil.write2LocalFromInternet(imageUrl, file);
			}
			
//			long endTime = System.currentTimeMillis();
//			
//			System.out.println("time elapsed: " + (endTime - startTime));
			
			resp.getWriter().print("success");
			resp.getWriter().flush();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
