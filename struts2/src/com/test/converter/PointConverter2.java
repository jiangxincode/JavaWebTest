package com.test.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.test.bean.Point;

public class PointConverter2 extends StrutsTypeConverter
{
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass)
	{
		Point point = new Point();
		
		String value = values[0];
		
		String[] result = value.split(",");
		
		point.setX(Integer.parseInt(result[0]));
		point.setY(Integer.parseInt(result[1]));
		
		return point;
	}

	@Override
	public String convertToString(Map context, Object o)
	{
		Point point = (Point)o;
		
		int x = point.getX();
		int y = point.getY();
		
		String result = "x: " + x + " y: " + y;
		
		return result;
	}

}
