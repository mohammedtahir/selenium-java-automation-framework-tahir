package com.tahir.automation.utils;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigReader {
    private static final Properties props = new Properties();

    static {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new RuntimeException("config.properties not found in classpath (src/test/resources)");
            }
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}