package struts2.test.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import struts2.test.bean.Point;

public class PointConverter3 extends StrutsTypeConverter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		List<Point> list = new ArrayList<Point>();

		for (String value : values) {
			String[] result = value.split(",");
			Point point = new Point();

			point.setX(Integer.parseInt(result[0]));
			point.setY(Integer.parseInt(result[1]));

			list.add(point);
		}

		return list;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String convertToString(Map context, Object o) {
		List<Point> list = (List<Point>) o;

		StringBuffer sb = new StringBuffer();

		int number = 0;

		for (Point point : list) {
			number++;

			int x = point.getX();
			int y = point.getY();

			sb.append(number).append(". x=").append(x).append(" y=").append(y).append(" ");
		}

		return sb.toString();
	}

}
