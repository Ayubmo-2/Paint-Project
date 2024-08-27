/*
 * TCSS 305 - Assignment 5
 */

package drawing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 * The action for selecting the round rectangle tool.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class RoundRectangle extends AbstractDrawing {
    
    /** The width of the arc to use to round off the corners of the rectangle.*/ 
    
    private static final double ARC_WIDTH = 50;
    
    /** The height of the arc to use to round off the corners of the rectangle.*/ 
    
    private static final double ARC_HEIGHT = 50;
    
    /**
     * Constructs the actions for round rectangles.
     * 
     * @param thePanel
     * @param theThickness
     * @param theColor
     */
    
    public RoundRectangle(final Point2D theStartingPoint, final Point2D theEndingPoint, 
                          final int theThickness, final Color theColor) {
        super(theStartingPoint, theEndingPoint, theThickness, theColor);
        
    }
   
    /**
     * {@inheritDoc}
     */
    
    @Override
    public Shape getShape() {
        final double x1 = getStartingPoint().getX();
        final double y1 = getStartingPoint().getY();
        final double x2 = getEndingPoint().getX();
        final double y2 = getEndingPoint().getY();
        
        final double x = Math.min(x1, x2);
        final double y = Math.min(y1, y2);
        final double width = Math.abs(x2 - x1);
        final double height = Math.abs(y2 - y1);
        
        return new RoundRectangle2D.Double(x, y, width, height, ARC_WIDTH, ARC_HEIGHT);
    }

}





