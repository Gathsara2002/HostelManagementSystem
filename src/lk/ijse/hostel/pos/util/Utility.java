/**
 * @author : Gathsara
 * created : 4/17/2023 -- 3:01 PM
 **/

package lk.ijse.hostel.pos.util;

import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader
                    .getSystemClassLoader()
                    .getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("Property file not found!");
            e.printStackTrace();
        }
        return properties;
    }
}
