package dataUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyData {
    private static Properties prop;
    public static void loadData() throws IOException {
        prop = new Properties();
        File file = new File("src/main/resources/data.properties");
        FileInputStream reader = new FileInputStream(file);
        prop.load(reader);
    }
    public static String getURLFromProperty(){
        return prop.getProperty("url");
    }

    public static String getCOUNTFromProperty() { return prop.getProperty("count"); }
}
