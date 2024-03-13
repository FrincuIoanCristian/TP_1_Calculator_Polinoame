package View;

import java.awt.*;
import javax.swing.JPanel;

public class GradientPanel extends JPanel {

    private final Color color1, color2;

    public GradientPanel(Color color1, Color color2) {
        super();
        this.color1 = color1;
        this.color2 = color2;
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        GradientPaint gradientPaint = new GradientPaint(0, 0, color1, 0, getHeight(), color2);

        graphics2D.setPaint(gradientPaint);
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
    }
}
