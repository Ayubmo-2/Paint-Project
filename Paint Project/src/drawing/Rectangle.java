/*
 * TCSS 305 - Assignment 5
 */

package drawing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * My Rectangle class to draw rectangle.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class Rectangle extends AbstractDrawing {

    /**
     * Constructs the Rectangles.
     * 
     * @param theStartingPoint
     * @param theEndingPoint
     * @param theThickness
     * @param theColor
     */
    
    public Rectangle(final Point2D theStartingPoint, final Point2D theEndingPoint, 
                     final int theThickness, final Color theColor) {
        super(theStartingPoint, theEndingPoint, theThickness, theColor);
        
    }

    /**
     * {@inheritDoc}
     */
    
    @Override
    public Shape getShape() {
        
        final Rectangle2D.Double rect = new Rectangle2D.Double();
        rect.setFrameFromDiagonal(getStartingPoint().getX(), getStartingPoint().getY(), 
                                  getEndingPoint().getX(), getEndingPoint().getY());
        return rect;

        
    }
    
}
