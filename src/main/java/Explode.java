import java.awt.*;

public class Explode {
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    private int x;
    private int y;
    private int step=0;
    private TankFrame tankFrame;
    public Explode(int x,int y ,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tankFrame = tf;
    }

    public void paint(Graphics graphics){
        graphics.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if (step >= ResourceMgr.explodes.length) {
            step = 0;
        }
    }


}
