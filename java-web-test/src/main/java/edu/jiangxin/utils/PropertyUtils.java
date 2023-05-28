package edu.jiangxin.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    private static final Log log = LogFactory.getLog(PropertyUtils.class);
    private static Properties pros = new Properties();

    static {
        try {
            InputStream in = PropertyUtils.class.getClassLoader().getResourceAsStream("javawebtest.properties");
            pros.load(in);
        } catch (Exception e) {
            log.error("load configuration error");
        }
    }

    public static String getProperty(String key) {
        return pros.getProperty(key);
    }
}
