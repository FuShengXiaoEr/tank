import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        Integer initTankCount = Integer.parseInt((String) PropertiesMgr.getObject("tank.number"));
        for (int i = 0;i < initTankCount ;i++){
            tankFrame.enemies.add(new Tank(50+i*60,200,Dir.DOWN,Group.BAD,tankFrame));
        }
        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
