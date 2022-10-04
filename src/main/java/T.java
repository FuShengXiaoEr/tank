import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置大小
        frame.setSize(600,800);
        // 不允许修改窗口
        frame.setResizable(false);
        frame.setTitle("tank war");
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}