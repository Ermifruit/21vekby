package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

    private Properties properties = new Properties();

    /**
     * Get value from config.properties file by propertyKey
     *
     * @param propertyKey   parameter from config.properties file
     * @return  value from config.properties file by propertyKey
     * @throws IOException
     */
    public String getConfigProperty(String propertyKey) throws IOException {
        FileInputStream inStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(inStream);
        inStream.close();
        return properties.getProperty(propertyKey);
    }
}

