import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Test1 {

    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(Test1.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            Assert.assertNotNull(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
