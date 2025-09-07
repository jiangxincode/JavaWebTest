package edu.jiangxin;

import java.nio.charset.Charset;

public class EncodingTest {
    public static void main(String[] args) {
        System.out.println("Java Runtime version " + System.getProperty("java.runtime.version"));
        System.out.println("----------------------------------------------------------");
        //全局默认编码 JDK21是UTF
        System.out.println("Charset.defaultCharset()                    = " + Charset.defaultCharset());
        //默认文件的编码，这个应该是字节码文件
        System.out.println("System.getProperty(\"file.encoding\")       = " + Charset.defaultCharset().displayName());
        //获取的是本地的字符集编码，中文windows系统应该是GBK
        System.out.println("System.getProperty(\"native.encoding\")     = " + System.getProperty("native.encoding"));
        System.out.println("System.getProperty(\"sun.jnu.encoding\")    = " + System.getProperty("sun.jnu.encoding"));
        //这个是输出流的默认字符集编码
        System.out.println("System.getProperty(\"sun.stdout.encoding\") = " + System.getProperty("sun.stdout.encoding"));
        //这个是错误流的默认编码
        System.out.println("System.getProperty(\"sun.stderr.encoding\") = " + System.getProperty("sun.stderr.encoding"));
        System.out.println("System.getProperty(\"stdout.encoding\") = " + System.getProperty("stdout.encoding"));
        System.out.println("System.getProperty(\"stderr.encoding\") = " + System.getProperty("stderr.encoding"));
        //console默认编码
        if (System.console() != null) {
            System.out.println("System.console().charset()                  = " + System.console().charset());
        }
        //当前输出流的编码
        System.out.println("System.out.charset()                        = " + System.out.charset());
        System.out.println("----------------------------------------------------------");
    }
}
