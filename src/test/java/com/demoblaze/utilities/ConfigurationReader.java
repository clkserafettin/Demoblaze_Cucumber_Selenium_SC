package com.demoblaze.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * Bu class configuration.properties altında yer alan verileri okumaya yarar.
     */

    private static Properties properties;

    static {
        try {
            String path = "configuration.properties";

            /**
             * fileInputStream() dışarıdan java ya bir veri almak istedğimizde kullandığımız bir yöntem
             */
            FileInputStream input = new FileInputStream(path);

            properties = new Properties();

            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
