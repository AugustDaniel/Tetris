package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler {

    public static final Properties PROPERTIES = new Properties();

    static {
        try {
            PROPERTIES.load(new FileInputStream("res/screen.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
