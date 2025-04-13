package org.epamLab.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentProperties {

    private static final Logger logger = LogManager.getLogger(EnvironmentProperties.class);
    private final Properties properties = new Properties();

    public EnvironmentProperties(String environment) {
        String filePath = "src/test/resources/env_" + environment + ".properties";
        try {
            properties.load(new FileInputStream(filePath));
            logger.info("Loaded environment properties from: {}", filePath);
        } catch (IOException e) {
            logger.error("Error loading property file: {}", filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}