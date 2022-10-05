import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    Tank tank = new Tank(200,200,Dir.DOWN,this);
    Bullet bullet = new Bullet(300,300,Dir.DOWN);
    private static final int WIDTH = 600;
    private static final int HEIGHT = 800;
    public TankFrame(){
        // 设置大小
        setSize(WIDTH,HEIGHT);
        // 不允许修改窗口
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
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
        tank.paint(g);
        bullet.paint(g);
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
