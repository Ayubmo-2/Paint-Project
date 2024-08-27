/*
 * TCSS 305 - Assignment 5
 */

package drawing;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Abstract clss for the drawing tools.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public abstract class AbstractDrawing implements DrawingShape {

    /** My starting point for each shape i'm drawing. */
    
    private Point2D myStartingPoint;
    
    /** My ending point for each shape i'm drawing. */
    
    private Point2D myEndingPoint;
    
    /** The thickness of each shape being drawn. */
    
    private final int myThickness;
    
    /** The color of the shape being drawn. */
    
    private final Color myColor;
    
    /**
     * Constructs the drawing tool.
     * 
     * @param theStartingPoint
     * @param theEndingPoint
     * @param theThickness
     * @param theColor
     */
    
    public AbstractDrawing(final Point2D theStartingPoint, final Point2D theEndingPoint,
                           final int theThickness, final Color theColor) {
        
        myStartingPoint = theStartingPoint;
        myEndingPoint = theEndingPoint;
        myThickness = theThickness;
        myColor = theColor;
        
    }
    
    /** {@inheritDoc} */
    @Override
    public void setStartingPoint(final Point2D theStartingPoint) {
        myStartingPoint = theStartingPoint;
    }

    /** {@inheritDoc} */
    @Override
    public void setEndingPoint(final Point2D theEndingPoint) {
        myEndingPoint = theEndingPoint;
    }

    /** {@inheritDoc} */
    @Override
    public Point2D getStartingPoint() {
        return myStartingPoint;
    }
    
    /** {@inheritDoc} */
    @Override
    public Point2D getEndingPoint() {
        return myEndingPoint;
    }
    
    /** {@inheritDoc} */
    @Override
    public abstract Shape getShape();

    /**
     * This method returns the thickness of the shape.
     * 
     * @return returns the thickness for this shape.
     */
    public int getThickness() {
        return myThickness;
    }
    
    /**
     * This method returns the color of the shape.
     * 
     * @return returns the color for this shape.
     */
    public Color getColor() {
        return myColor;
    }
       
}
