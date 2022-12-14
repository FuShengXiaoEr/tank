import java.awt.*;
import java.util.Random;

public class Tank {
    int x;
    int y;
    Dir dir;
    private static final int SPEED = 5;
    private boolean moving = true;
    private TankFrame tankFrame;
    private boolean living = true;
    private Random random = new Random();
    private Group group = Group.BAD;
    public Rectangle rectangle = new Rectangle();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public Tank(int x,int y,Dir dir,Group group,TankFrame tankFrame){
        this.x =x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
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
            tankFrame.enemies.remove(this);
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
        if (!living){
            tankFrame.enemies.remove(this);
        }
        if (!moving) {
            return;
        }
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
                if (this.group == Group.BAD) {
                }
                break;
            default:
                break;
        }
        if (this.group==Group.BAD && random.nextInt(100) > 95) {
            fire();
        }
        randomDir();
        boundsCheck();
        rectangle.x = x;
        rectangle.y = y;
    }

    /**
     * ????????????
     */
    private void boundsCheck() {
        if (this.x < 0 ){
            x = 0;
        }else if (this.y < 30) {
            y = 30;
        }else if (this.x > TankFrame.WIDTH-Tank.WIDTH) {
            x = TankFrame.WIDTH - Tank.WIDTH;
        }else if (this.y > TankFrame.HEIGHT-Tank.HEIGHT){
            y = TankFrame.HEIGHT - Tank.HEIGHT;
        }
    }

    private void randomDir() {
        if (group == Group.GOOD) {
            return;
        }
        if (random.nextInt(100) > 95) {
            this.dir = Dir.values()[random.nextInt(4)];
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
