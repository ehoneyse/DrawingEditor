 

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

public class BalloonDraw extends JFrame
{
    /**
     * Constructor for objects of class BalloonDraw
     */
    public BalloonDraw()
    {
        this.setTitle("Drawing Editor");
        DrawingPanel canvas = new DrawingPanel();
        ControlPanel controls = new ControlPanel(canvas);
        
        Container con = this.getContentPane();
        con.add(canvas,BorderLayout.CENTER);
        con.add(controls,BorderLayout.PAGE_END);
        
        this.setSize(1000,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
         BalloonDraw b = new BalloonDraw();
    }
}
