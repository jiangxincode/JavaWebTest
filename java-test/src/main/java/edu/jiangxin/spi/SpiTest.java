package edu.jiangxin.spi;

import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
                                          ClassNotFoundException {
        ServiceLoader<SPIService> loader = ServiceLoader.load(SPIService.class);
        for (SPIService service : loader) {
            service.test();
        }

    }
}
