import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) throws InterruptedException {
//        Frame frame = new Frame();
//        // 设置大小
//        frame.setSize(600,800);
//        // 不允许修改窗口
//        frame.setResizable(false);
//        frame.setTitle("tank war");
//        frame.setVisible(true);
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        TankFrame tankFrame = new TankFrame();
        for (int i = 0;i < 5 ;i++){
            tankFrame.enemies.add(new Tank(50+i*30,200,Dir.DOWN,tankFrame));
        }
        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
