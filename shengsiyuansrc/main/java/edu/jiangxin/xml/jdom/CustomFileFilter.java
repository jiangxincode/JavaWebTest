package edu.jiangxin.xml.jdom;

import java.io.File;
import java.io.FileFilter;

public class CustomFileFilter implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.getName().startsWith("values");
	}

}
