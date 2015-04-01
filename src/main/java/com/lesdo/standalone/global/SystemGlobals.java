package com.lesdo.standalone.global;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jiangshan on 15/3/31.
 */
public class SystemGlobals {

    private final static Properties properties = new Properties();

    static {
        InputStream inputStream = null;
        try {
            inputStream = SystemGlobals.class.getClassLoader().getResource("config.properties").openStream();
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final static String get(String key){
        return properties.getProperty(key);
    }

    public final static int getInt(String key) {
        String value = get(key);
        try{
            int intValue = Integer.valueOf(value);
            return intValue;
        } catch (Exception ex){
            throw new NullPointerException("get int value from properties. key:" + key + " value:" + value);
        }
    }
}
