package com.orangehrm.reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static final Properties properties = new Properties();
    private static final String propertiesPath = System.getProperty("user.dir") + "/src/main/resources/config.properties";

    public static String getPropertyByKey(String key) {

        try (FileInputStream inputStream = new FileInputStream(propertiesPath)){
            properties.load(inputStream);

            String value = properties.getProperty(key);

            if (value.isEmpty()) {
                throw new IOException("Property file '" + propertiesPath + "' not found in the classpath");
            }

            return value;
        } catch (IOException e) {
            CustomExceptionHandler.handleExceptions("Could not read property '" + key + "' from file '" + propertiesPath + "'", e);
        }
        return null;
    }
}
