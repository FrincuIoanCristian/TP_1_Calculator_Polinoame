package View;

import java.awt.*;
import javax.swing.*;

public class JGradientButton extends JButton {
    private final Color color1, color2;
    public JGradientButton(String string, Color color1, Color color2) {
        super(string);
        this.color1 = color1;
        this.color2 = color2;
        setContentAreaFilled(false);
        setFocusPainted(false); // used for demonstration
    }

    @Override
    protected void paintComponent(Graphics g) {
        final Graphics2D g2 = (Graphics2D) g.create();
        g2.setPaint(new GradientPaint(new Point(0, 0), color1, new Point(0, getHeight()), color2));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.dispose();
        super.paintComponent(g);
    }

}
