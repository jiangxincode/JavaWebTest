package edu.jiangxin.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.InputStream;
import java.util.Properties;

public class DatabasePropertyUtils {

    private static final Log log = LogFactory.getLog(DatabasePropertyUtils.class);
    private static Properties pros = new Properties();

    static {
        try {
            InputStream in = DatabasePropertyUtils.class.getClassLoader().getResourceAsStream("database.properties");
            pros.load(in);
        } catch (Exception e) {
            log.error("load configuration error");
        }
    }

    public static String getProperty(String key) {
        return pros.getProperty(key);
    }
}
