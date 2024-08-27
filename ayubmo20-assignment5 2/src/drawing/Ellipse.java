/*
 * TCSS 305 - Assignment 5
 */

package drawing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * My Ellipse class for drawing ellipses.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class Ellipse extends AbstractDrawing {

    /**
     * Constructs the Ellipses.
     * 
     * @param theStartingPoint
     * @param theEndingPoint
     * @param theThickness
     * @param theColor
     */
    
    public Ellipse(final Point2D theStartingPoint, final Point2D theEndingPoint, 
                   final int theThickness, final Color theColor) {
        super(theStartingPoint, theEndingPoint, theThickness, theColor);

    }

    /**
     * {@inheritDoc}
     */
    
    @Override
    public Shape getShape() {

        final Ellipse2D.Double elli = new Ellipse2D.Double();
        elli.setFrameFromDiagonal(getStartingPoint().getX(), getStartingPoint().getY(), 
                                  getEndingPoint().getX(), getEndingPoint().getY());
        return elli;
        
    }
    
    

}
