import java.awt.*;

public class Tank {
    int x;
    int y;
    Dir dir;
    private static final int SPEED = 10;
    private boolean moving = false;
    private TankFrame tankFrame;
    private boolean living = true;
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public Tank(int x,int y,Dir dir,TankFrame tankFrame){
        this.x =x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        if (!living) {
            return;
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        if (!moving){
            tankFrame.enemies.remove(this);
        }
        switch (dir){
            case LEFT:
                x -= SPEED;
                System.out.println(x);
                break;
            case RIGHT:
                x += SPEED;
                System.out.println(x);
                break;
            case UP:
                y -= SPEED;
                System.out.println(x);
                break;
            case DOWN:
                y += SPEED;
                System.out.println(x);
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bulletList.add(new Bullet(bx,by,this.dir,this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}
