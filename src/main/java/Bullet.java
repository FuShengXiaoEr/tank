import java.awt.*;

public class Bullet {
    private static final int SPEED = 10;
    private int x , y ;
    private Dir dir;
    private int HEIGHT = 30,WIDTH = 30;
    public Bullet(int x,int y,Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
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
}
