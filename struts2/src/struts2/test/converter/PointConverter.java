package struts2.test.converter;

import java.util.Map;

import ognl.DefaultTypeConverter;
import struts2.test.bean.Point;

public class PointConverter extends DefaultTypeConverter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		if (Point.class == toType) {
			String[] str = (String[]) value;

			String firstValue = str[0];

			String[] resultValue = firstValue.split(",");

			Point point = new Point();
			point.setX(Integer.parseInt(resultValue[0]));
			point.setY(Integer.parseInt(resultValue[1]));

			return point;
		} else if (String.class == toType) {
			Point point = (Point) value;

			int x = point.getX();
			int y = point.getY();

			String result = "x: " + x + " y: " + y;

			return result;
		}

		return null;
	}
}
