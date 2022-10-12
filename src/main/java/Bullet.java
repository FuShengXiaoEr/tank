import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private int x , y ;
    private Dir dir;
    public static int HEIGHT = ResourceMgr.bulleteD.getHeight();
    public static int WIDTH = ResourceMgr.bulleteD.getWidth();
    private boolean living = true;
    private TankFrame tankFrame;
    private Group group = Group.BAD;
    public Bullet(int x,int y,Dir dir,Group group,TankFrame tankFrame){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
        this.group = group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void paint(Graphics g) {
        if (!living){
            tankFrame.bulletList.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulleteL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulleteR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulleteD,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulleteU,x,y,null);
                break;
        }
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
            living = false;
        }
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) {
            return;
        }
        Rectangle rectangle = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rectangle1 = new Rectangle(tank.x, tank.y, Tank.WIDTH, Tank.HEIGHT);
        if (rectangle.intersects(rectangle1) ) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
