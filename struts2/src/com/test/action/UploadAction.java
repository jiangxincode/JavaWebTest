package com.test.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport
{
	private File file; // 对应真正上传的文件

	private String fileFileName; // 对应上传的文件名

	public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	@Override
	public String execute() throws Exception
	{
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream("c:\\" + fileFileName);

		byte[] buffer = new byte[1024];
		int length = 0;

		while (-1 != (length = is.read(buffer)))
		{
			os.write(buffer,0,length);
		}
		
		os.close();
		is.close();

		return SUCCESS;
	}
}
