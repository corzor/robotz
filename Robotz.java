//  Robotz.java
//  A first java program

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Robotz extends Applet
{
    public void init()
    {
        add( new Robot( Color.blue ) );
        add( new Robot( Color.red  ) );
        add( new Robot( Color.green) );
    }
}

class Robot extends    Canvas
            implements MouseMotionListener
{
    private Color myColor;
    private Point myLocation;

    public Robot( Color theColor )
    {
        myColor = theColor;
        setSize( 50, 50 );
        setBackground( theColor );
        addMouseMotionListener( this );
    }

    public void mouseMoved( MouseEvent evt )
    {
        myLocation = getLocation( );
        int dx = evt.getX( ), dy = evt.getY( );
        if ( dx > 25 )
            dx = dx - 50;
        if ( dy > 25 )
            dy = dy - 50;
        
        setLocation( myLocation.x + dx,
                     myLocation.y + dy );
    }

    public void mouseDragged( MouseEvent evt )
    {
        myLocation = getLocation();
        setLocation( myLocation.x + (evt.getX( ) - 25),
                     myLocation.y + (evt.getY( ) - 25));
    }

    public void paint( Graphics g )
    {
        g.drawLine( 10, 40, 40, 40 );
        g.drawRect( 15,  5,  5, 15 );
        g.drawRect( 30,  5,  5, 15 );
    }
}
