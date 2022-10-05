import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private int x , y ;
    private Dir dir;
    private int HEIGHT = 30,WIDTH = 30;
    private boolean isLive = true;
    private TankFrame tankFrame;
    public Bullet(int x,int y,Dir dir,TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!isLive){
            tankFrame.bulletList.remove(this);
        }
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(color );
        move();
    }

    private void move() {
        switch (dir){
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.WIDTH || y > TankFrame.HEIGHT) {
            isLive = false;
        }
    }
}
