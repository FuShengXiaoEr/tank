import java.awt.*;
import java.awt.event.*;

public class TankFrame extends Frame {
    int x=200,y = 200;
    Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    public TankFrame(){
        // 设置大小
        setSize(600,800);
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
        System.out.println(dir);
        g.fillRect(x,y,50,50);
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
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bu) {
                dir = Dir.UP;
            }
            if (br) {
                dir = Dir.RIGHT;
            }
            if (bd) {
                dir = Dir.DOWN;
            }
            if (bl) {
                dir = Dir.LEFT;
            }
        }
    }
}
