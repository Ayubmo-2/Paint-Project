/*
 * TCSS 305 - Assignment 5
 */

package drawing;

import java.awt.Shape;
import java.awt.geom.Point2D;

/**
 * Interface used by all tools.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public interface DrawingShape {

    /**
     * This method sets up the starting point of the shape being drawn.
     * 
     * @param theStartPoint the start point.
     */
    void setStartingPoint(Point2D theStartPoint);
    
    /**
     * This method sets up the ending point of the shape being drawn.
     * 
     * @param theEndPoint the end point.
     */
    void setEndingPoint(Point2D theEndPoint);
    
    /**
     * This query returns the start point of the shape.
     * 
     * @return the start point.
     */
    Point2D getStartingPoint();
    
    /**
     * This query returns the end point of the shape.
     * 
     * @return the end point.
     */
    Point2D getEndingPoint();
    
    /**
     * This query returns the drawing shape.
     * 
     * @return shape
     */
    Shape getShape();

}
