import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    Tank tank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    List<Bullet> bulletList = new ArrayList<Bullet>();
    List<Tank> enemies = new ArrayList<>();
    Explode explode = new Explode(100,100,this);
    public TankFrame(){
        // 设置大小
        setSize(WIDTH,HEIGHT);
        // 不允许修改窗口
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        setBackground(Color.BLACK);
        this.addKeyListener(new MyKeyLitener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("现在有"+bulletList.size()+"子弹",10,60);
        g.drawString("现在有"+enemies.size()+"敌人",10,80);
        tank.paint(g);
        for (int i = 0 ;i < bulletList.size();i++ ) {
            bulletList.get(i).paint(g);
        }
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).paint(g);
        }
        explode.paint(g);
        // 检查子弹和坦克是否相撞
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                bulletList.get(i).collideWith(enemies.get(j));
            }
        }
    }

    class MyKeyLitener extends KeyAdapter {
        boolean br = false;
        boolean bl = false;
        boolean bu = false;
        boolean bd = false;
        /**
         * 键盘被按的时候
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 释放按键的时候
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bl && !bd && !br && !bu) {
                tank.setMoving(false);
            }else {
                tank.setMoving(true);
                if (bu) {
                    tank.setDir(Dir.UP);
                }
                if (br) {
                    tank.setDir(Dir.RIGHT);
                }
                if (bd) {
                    tank.setDir(Dir.DOWN);
                }
                if (bl) {
                    tank.setDir(Dir.LEFT);
                }
            }
        }
    }
// 修复屏幕闪烁
//    Image image = null;
//    @Override
//    public void update(Graphics g) {
//        if (image == null) {
//            image = this.createImage(WIDTH,HEIGHT);
//        }
//        Graphics graphics = image.getGraphics();
//        Color color = g.getColor();
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,WIDTH,HEIGHT);
//        g.setColor(color);
//        paint(graphics);
//        g.drawImage(image,0,0,null);
//
//    }
}
