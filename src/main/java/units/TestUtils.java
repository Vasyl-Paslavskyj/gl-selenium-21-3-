package units;

import dataUtils.PropertyData;

import java.io.IOException;

public class TestUtils {

    public static String getBASE_URL() {
        try {
            PropertyData.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PropertyData.getURLFromProperty();
    }

    public static String getCOUNT() {
        try {
            PropertyData.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PropertyData.getCOUNTFromProperty();
    }
}
