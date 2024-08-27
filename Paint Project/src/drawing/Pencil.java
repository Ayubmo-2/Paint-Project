/*
 * TCSS 305 - Assignment 5
 */
package drawing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

//import java.awt.geom.GeneralPath;

/**
 * My Pencil class to draw free form curves.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class Pencil extends AbstractDrawing {
    
    /** A Path object represents pencil drawing. */
    
    private final Path2D myPath;
    
//    private final GeneralPath myPath;
    
    /**
     * Constructs the pencil curves.
     * 
     * @param theStartingPoint
     * @param theEndingPoint
     * @param theThickness
     * @param theColor
     */
    
    public Pencil(final Point2D theStartingPoint, final Point2D theEndingPoint, 
                  final int theThickness, final Color theColor) {
        super(theStartingPoint, theEndingPoint, theThickness, theColor);
        myPath = new Path2D.Double();
        myPath.moveTo(getStartingPoint().getX(), getStartingPoint().getY());
   
    }

    /** 
     * {@inheritDoc}
     */
    
    @Override
    public Shape getShape() {      
        myPath.lineTo(getEndingPoint().getX(), getEndingPoint().getY());
        return myPath;
    }

}

