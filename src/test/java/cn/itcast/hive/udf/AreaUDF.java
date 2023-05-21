package cn.itcast.hive.udf;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class AreaUDF extends UDF{

	private static Map<Integer, String> areaMap = new HashMap<Integer, String>();
	
	static {
		areaMap.put(1, "北京");
		areaMap.put(2, "上海");
		areaMap.put(3, "广州");
	}
	
	public Text evaluate(Text in){
		String result = areaMap.get(Integer.parseInt(in.toString()));
		if(result == null){
			result = "其他";
		}
		return new Text(result);
	}
}
