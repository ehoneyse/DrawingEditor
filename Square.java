 

import java.awt.geom.Ellipse2D;
import java.awt.*;
public class Square
{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Square(int ax, int ay, int w,int h, Color acolor)
    {
        x = ax;
        y = ay;
        width = w;
        height = h;
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

    public int getHeight()
    {
        return height;
    }
    
    public int getWidth()
    {
        return width;
    }

    public double distance(int x, int y)
    {
        return Math.sqrt(Math.pow((x-this.x),2)-Math.pow((y-this.y),2));
    }

    public void move(int x,int y)
    {
        this.x = x;    
        this.y = y;
    }

    public void setHeight(int r)
    {
        height = r;
    }

    public void setWidth(int r)
    {
        width = r;
    }
    
    public boolean isInside(int x, int y)
    {
        if(this.distance(x,y) < height - 1)
        {
            return true;
        }
        return false;
    }

    public boolean isOnBorder(int x, int y, int w, int h)
    {
        if(x + this.getWidth() < w && y + this.getHeight() < h)
        {
            return false;
        }
        return true;
    }

    public void paint(Graphics2D g, boolean filled)
    {
       Rectangle balloon = new Rectangle(x,y,width,height);
       g.setColor(color);
        // g.fill(balloon);
       g.draw(balloon);
        //if(filled)
       // {
           
       // }

    }
}
