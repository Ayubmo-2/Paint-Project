/*
 * TCSS 305 - Assignment 5
 */

package drawing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * My Line class to draw lines.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class Line extends AbstractDrawing {

    /**
     * Constructs the Lines.
     * 
     * @param theStartingPoint
     * @param theEndingPoint
     * @param theThickness
     * @param theColor
     */

    public Line(final Point2D theStartingPoint, final Point2D theEndingPoint, 
                final int theThickness, final Color theColor) {
       
        super(theStartingPoint, theEndingPoint, theThickness, theColor);

    }

    /** 
     * {@inheritDoc}
     */
    
    @Override
    public Shape getShape() {

        return new Line2D.Double(getStartingPoint().getX(), getStartingPoint().getY(),
                                 getEndingPoint().getX(), getEndingPoint().getY());
        
    }

}

