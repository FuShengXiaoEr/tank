import java.awt.*;
import java.util.Random;

public class Tank {
    int x;
    int y;
    Dir dir;
    private static final int SPEED = 10;
    private boolean moving = true;
    private TankFrame tankFrame;
    private boolean living = true;
    private Random random;
    private Group group = Group.BAD;
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public Tank(int x,int y,Dir dir,Group group,TankFrame tankFrame){
        this.x =x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        if (this.group == Group.BAD) {
            System.out.println("bad");
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
                if (this.group == Group.BAD) {
                    System.out.println("draw down");
                }
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
        }
        move();
    }

    private void move() {
        if (!living){
            tankFrame.enemies.remove(this);
        }
        if (!moving) {
            return;
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
                System.out.println(y);
                break;
            case DOWN:
                y += SPEED;
                if (this.group == Group.BAD) {
                    System.out.println(y +" bad");
                }
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bulletList.add(new Bullet(bx,by,this.dir,this.group,this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}
