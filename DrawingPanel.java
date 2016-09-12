 

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Color;
//import java.awt.KeyEvent;
//import javafx.scene.paint.Paint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.*;
//import javafx.scene.shape.Circle;
public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener
{
    private ArrayList<Balloon> b;
    private Balloon balloonl;
    private boolean isMoved;
    private boolean isPicked;
    private boolean clicked = false;
    private boolean isStretched;
    private Color color;
    private ArrayList<Square> s;
    private Square sq;
    public DrawingPanel()
    {
        b = new ArrayList<Balloon>();
        s = new ArrayList<Square>();
        color = Color.BLUE;
        this.setBackground(Color.WHITE);
        color = Color.BLUE;


        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public Color getColor()
    {
        return color;
    }
    
    public void resetClicked()
    {
        clicked = false;
    }

    public Color pickColor()
    {
        Color newColor = JColorChooser.showDialog(
                this,
                "Choose Background Color",
                this.getBackground());
        color = newColor;
        return newColor;
    }

    public void addSquare()
    {
        Random r = new Random();
        int s = r.nextInt(100)+100;
        Square sq = new Square(s,s,350,250,color);
        this.s.add(0,sq);
        this.sq = sq; 
    }

    public void addBalloon()
    {
        Random r = new Random();

        Balloon bal = new Balloon(350,250,(r.nextInt(100)+100),color);
        b.add(0,bal);
        balloonl = bal;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        if(b.size() != 0)
        {
            balloonl = b.get(0);
            
            //Square square = s.get(0);
            //square.paint(g2,true);

            //Balloon picked = balloonl;

            //if (balloonl.equals(ball) == false)
            //{
            balloonl.paint(g2,clicked);
            //}
            //else 
            //{
                //balloonl.paint(g2,false);
            //}
            
            //b.remove(0);
            
        }

        if(s.size() != 0)
        {
            Square square = s.get(0);
            if(square.equals(sq) == false)
            {
                square.paint(g2,true);
            }
            else
            {
                sq.paint(g2,false);
            }

        }
        //repaint();
    }

    public void mousePressed(MouseEvent e) 
    {
        clicked = true;
        repaint();
    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) 
    {
        if(b.size() != 0 && !(balloonl.isOnBorder(e.getX(),e.getY(),this.getWidth(),this.getHeight())) && !(clicked) && sq == null)
        {
            balloonl.move(e.getX(),e.getY());
            repaint();
        }
        if(s.size() != 0 && !(sq.isOnBorder(e.getX(),e.getY(),this.getWidth(),this.getHeight())) && !(clicked)&& balloonl == null)
        {
            sq.move(e.getX(),e.getY());
            repaint();
        }
    }

}