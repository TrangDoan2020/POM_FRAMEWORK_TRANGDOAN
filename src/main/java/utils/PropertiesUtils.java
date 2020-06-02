package utils;

import commons.GlobalConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesUtils {
    public static String readPropertiesValue(String key){
        String filePath = GlobalConstants.projectPath + "/src/main/resources/SendoMessage.properties";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Properties p = new Properties();
            p.load(new InputStreamReader(fis, StandardCharsets.UTF_8));
            String value = p.getProperty(key);
            return value;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

