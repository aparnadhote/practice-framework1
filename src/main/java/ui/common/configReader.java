package ui.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    private static Properties prop = new Properties();
    static{
        try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/ui.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        String value = System.getProperty(key);

        if(value != null && !value.trim().isEmpty()){
            return value;
        }

        value = prop.getProperty(key);

        if(value == null || value.trim().isEmpty()){
            throw new RuntimeException("Property missing or empty: " + key);
        }

        return value;
    }
}
