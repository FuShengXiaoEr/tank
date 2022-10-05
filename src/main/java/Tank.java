import java.awt.*;

public class Tank {
    int x;
    int y;
    Dir dir;
    private static final int SPEED = 10;
    private boolean moving = false;
    private TankFrame tankFrame;
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
        System.out.println(dir);
        g.fillRect(x,y,50,50);
        move();
    }

    private void move() {
        if (!moving){
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
        tankFrame.bullet = new Bullet(this.x,this.y,this.dir);
    }
}
