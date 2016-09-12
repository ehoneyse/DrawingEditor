 

import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
public class ControlPanel extends JPanel implements ActionListener
{
    private DrawingPanel canvas;
    private JButton b2 = new JButton();

    public void actionPerformed(ActionEvent event)
    {
        if((event.getActionCommand()).equals("Pick Color"))
        {
            b2.setBackground(canvas.pickColor());
            //b2.setOpaque(true);
        }
        
        if((event.getActionCommand()).equals("Add Balloon"))
        {
            canvas.resetClicked();
            canvas.addBalloon();
        }
        
        if((event.getActionCommand()).equals("Add Square"))
        {
            canvas.resetClicked();
            canvas.addSquare();
        }
    }
    
    public ControlPanel(DrawingPanel canvas)
    {
        this.canvas = canvas;
        
        JButton b1 = new JButton("Pick Color");
        this.add(b1);

        this.add(b2);
        JButton b3 = new JButton("Add Balloon");
        this.add(b3);
        
        JButton b4 = new JButton("Add Square");
        this.add(b4);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
}
