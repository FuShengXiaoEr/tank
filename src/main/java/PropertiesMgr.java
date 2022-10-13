import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {
    static Properties pros = new Properties();
    static {
        try {
            pros.load(PropertiesMgr.class.getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getObject(String key) {
        if (key == null || key.length() == 0 ){
            return null;
        }
        return pros.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertiesMgr.getObject("tank.number"));
    }
}
