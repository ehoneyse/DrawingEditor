 

import java.awt.geom.Ellipse2D;
import java.awt.*;
public class Balloon
{
    private int x;
    private int y;
    private int radius;
    private Color color;

    public Balloon(int ax, int ay, int aradius, Color acolor)
    {
        x = ax;
        y = ay;
        radius = aradius;
        color = acolor;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getRadius()
    {
        return radius;
    }

    public double distance(int x, int y)
    {
        return Math.sqrt(Math.pow((x-this.x),2)-Math.pow((y-this.y),2));
    }

    public void move(int x,int y)
    {
        this.x = x; //- (radius/2);    
        this.y = y;// - (radius /2);
    }

    public void setRadius(int r)
    {
        radius = r;
    }

    public boolean isInside(int x, int y)
    {
        if(this.distance(x,y) < radius - 1)
        {
            return true;
        }
        return false;
    }

    public boolean isOnBorder(int x, int y, int frameWidth, int frameHeight)
    {
        if(x + this.getRadius() < frameWidth && y + this.getRadius() < frameHeight)
        {
            return false;
        }
        return true;
    }

    public void paint(Graphics2D g, boolean filled)
    {
        Ellipse2D.Double balloon = new Ellipse2D.Double(x,y,radius,radius);
        g.setColor(color);
        if(filled)
        {
            g.fill(balloon);
        }
        g.draw(balloon);
        //if(filled)
       // {
           
       // }

    }
}
