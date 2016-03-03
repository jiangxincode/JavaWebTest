package edu.jiangxin.utils;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 自定义解析类，处理数据库密码加密
 * @author jiangxin
 *
 */
public class DefaultPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	/**
	* 解密数据库密码
	*/
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {

		//获取加密后字符串
		String afterEncrypt = props.getProperty("jdbc.password");
		String beforeEncrpt = afterEncrypt + "jx";
		props.setProperty("jdbc.password", beforeEncrpt);

	}
}