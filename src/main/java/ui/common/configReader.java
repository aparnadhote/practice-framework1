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
        // First priority: Maven command (-Dbrowser)
        String value = System.getProperty(key);
        if(value!= null){
            return value;
        }
        // Second priority: ui.properties
        return prop.getProperty(key);
    }
}
