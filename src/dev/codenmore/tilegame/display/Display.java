package dev.codenmore.tilegame.display;

import javax.swing.*;
import java.awt.*;

public class Display
{
    private JFrame frame;
    private Canvas canvas;
    private String title;
    private Integer width,height;
    public Display(String title,Integer width,Integer height)
    {
        this.title=title;
        this.height=height;
        this.width=width;

        createDisplay();
    }
    private void createDisplay()
    {
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }
    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
