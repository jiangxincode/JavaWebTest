package edu.jiangxin.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import org.junit.Assert;
import org.junit.Test;

public class FreeMarkerDemo {

	@Test

	public void testFreeMarker() {
		// 创建Freemarker配置实例
		Configuration cfg = new Configuration(new Version("2.3.23"));
		try {
			cfg.setDirectoryForTemplateLoading(new File(FreeMarkerDemo.class.getResource("").getPath()));
			// 创建数据模型
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("user", "老高");

			User user1 = new User();
			user1.setUname("老马");
			root.put("user1", user1);
			User user2 = new User("老张", new Address("中国", "北京"));
			root.put("user2", user2);

			List<Address> list = new ArrayList<Address>();
			list.add(new Address("中国", "北京"));
			list.add(new Address("中国", "上海"));
			list.add(new Address("美国", "纽约"));
			root.put("lst", list);

			// 普通标量
			root.put("num0", 18);
			root.put("b2", true);
			root.put("date1", new Date());
			root.put("random", new Random().nextInt(100));
			root.put("htm2", "<b>粗体</b>");

			// 加载模板文件
			Template t1 = cfg.getTemplate("a.ftl");
			// 显示生成的数据
			Writer out = new OutputStreamWriter(System.out);
			t1.process(root, out);
			out.flush();
		} catch (IOException | TemplateException e) {
			Assert.fail();
		}
	}
}
