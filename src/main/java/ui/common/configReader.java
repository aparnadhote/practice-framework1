package ui.common;

import java.io.InputStream;
import java.util.Properties;

public class configReader {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream is = configReader.class
                    .getClassLoader()
                    .getResourceAsStream("ui.properties");

            if (is == null) {
                throw new RuntimeException("ui.properties file not found in classpath");
            }

            prop.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String get(String key) {

        // Step 1: Check System property (Jenkins / Maven)
        String value = System.getProperty(key);

        if (value != null && !value.trim().isEmpty()) {
            return value.trim();
        }

        // 🔹 Step 2: Fallback to properties file
        value = prop.getProperty(key);

        if (value != null && !value.trim().isEmpty()) {
            return value.trim();
        }

        //  Step 3: Fail fast if missing
        throw new RuntimeException("Property missing or empty: " + key);
    }
}