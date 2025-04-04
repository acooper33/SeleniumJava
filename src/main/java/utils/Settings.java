package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = Settings.class.getClassLoader().getResourceAsStream("settings.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find settings.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}