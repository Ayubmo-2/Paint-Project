/*
 * TCSS 305 - Assignment 5
 */

package view;

import drawing.DrawingShape;
import drawing.Line;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * The Drawing Panel that is use for drawing the shapes.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 8444575580975344636L;
    
    /** The default size of this panel. */
    
    private static final Dimension INITIAL_SIZE = new Dimension(400, 300);
    
    /** The default UW Husky Purple drawing color. */
    
    private static final Color UW_PURPLE = new Color(50, 0, 110);    
    
    /** The default UW Husky Gold grid color. */
    
    private static final Color UW_GOLD = new Color(232, 211, 162);
    
    /** The default size of grid. */
    
    private static final int GRID_SIZE = 30;
    
    /** Support for firing property change events from this class. */

    private final PropertyChangeSupport myPCS = new PropertyChangeSupport(this);
    
    /** The tool of the shape being drawn. */
    
    private DrawingShape myTool;
    
    /** The color of the shape. */
    
    private Color myColor;
    
    /** The thickness of the shape. */
    
    private int myThickness;
    
    /** The default value for the grid. */
    
    private boolean myGridSelection;
    
    /** */
    
    private int myGridSpacing;
    
    /** Menu item button for the clearing the panel. */
    
    private final JMenuItem myClearButton;
    
    /** The shape being drawn. */
    
    private Shape myShape;

    /** A list of the shapes drawn on the Drawing Panel. */
    
    private final List<Shape> myShapes;
    
    /** A list of the shape colors drawn on the Drawing Panel. */
    
    private final List<Color> myShapeColors;
    
    /** A list of the thickness of shapes drawn on the Drawing Panel. */
    
    private final List<Integer> myShapeThicknesses;

    
    /**
     * Constructs the Drawing Panel.
     * 
     */
    
    public DrawingPanel() {
        super();
        myColor = UW_PURPLE;
        myThickness = 2;
        myClearButton = new JMenuItem();
        myGridSelection = false;
        myGridSpacing = GRID_SIZE;
        myShapes = new ArrayList<>();
        myShapeColors = new ArrayList<>();
        myShapeThicknesses = new ArrayList<>();

        myTool = new Line(new Point(0, 0), new Point(0, 0), myThickness, myColor);
        
        setupListeners();
    }

    /**
     * Sets up the listeners for the Drawing Panel.
     * 
     */
    
    private void setupListeners() {
        setPreferredSize(INITIAL_SIZE);
        setBackground(Color.WHITE);
        
        addMouseListener(new DrawingListener());
        addMouseMotionListener(new DrawingListener());
        
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));        
        
    }

    /** 
     * Sets the current drawing tool.
     * 
     * @param theTool
     */
    
    public void setCurrentTool(final DrawingShape theTool) {
        myTool = theTool;
    }

    /**
     * Sets the thickness of the shape being drawn.
     * 
     * @param theThickness
     */
    
    public void setThickness(final int theThickness) {
        myThickness = theThickness;
    }
    
    /**
     * Sets the color of the shape being drawn.
     * 
     * @param theColor
     */
    
    public void setColor(final Color theColor) {
        myColor = new Color(theColor.getRGB());
    }
    
    /**
     * Gets the color of the shape being drawn.
     * 
     * @return myColor of the shape.
     */
    
    public Color getColor() {
        return myColor;
    }

    /**
     * Sets the thickness of the shape being drawn.
     * 
     * @param theStroke
     */
    
    public void setStroke(final int theStroke) {
        myThickness = theStroke;
        repaint();
    }

    /**
     * This method sets the value to show or hide the grid.
     *  
     * @param theSelection the status of the grid.
     */
    public void setGrid(final boolean theSelection) {
        myGridSelection = theSelection;
        repaint();
    }
    
    /**
     * This method sets the size of the grid.
     *  
     * @param theGridSpacingthe size of the grid.
     */
    
    public void setGridSpacing(final int theGridSpacing) {
        myGridSpacing = theGridSpacing;
        repaint(); 
    }
    
    /**
     * Removes the last drawn shape from the DrawingPanel.
     */
    public void undoLastShape() {
        if (!myShapes.isEmpty()) {
            myShapes.remove(myShapes.size() - 1);
            myShapeColors.remove(myShapeColors.size() - 1);
            myShapeThicknesses.remove(myShapeThicknesses.size() - 1);
            repaint();
        }
    }

    /**
     * Checks if there are any shapes drawn on the DrawingPanel.
     * 
     * @return true if there are no shapes drawn, false otherwise.
     */
    public boolean isShapesEmpty() {
        return myShapes.isEmpty();
    }

    
    /** 
     * Method to clear the DrawingPanel. 
     */
    
    public void clear() {
        myPCS.firePropertyChange("drawingStatus", true, false);
        myShapes.clear(); 
        myShapeColors.clear();
        myShapeThicknesses.clear();
        myPCS.firePropertyChange("ClearedPanel", false, true);
        repaint();
    }

    /** 
     * Helper method to enable the Undo button.
     */
    public void enableUndoButton(final boolean theEnabled) {
        myPCS.firePropertyChange("undoButtonEnabled", null, theEnabled);
    }
    
    /** 
     * Helper method to enable the clear button. 
     */
    
    public void enableClearButton(final boolean theEnabled) {
        myPCS.firePropertyChange("clearButtonEnabled", null, theEnabled);
    }

    /**
     * Adds a listener for property change events from this class.
     * 
     * @param theListener a PropertyChangeListener to remove.
     */
    
    public void addPropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.addPropertyChangeListener(theListener);
    }

    /**
     * Removes a listener for property change events from this class.
     * 
     * @param theListener a PropertyChangeListener to remove.
     */
    
    public void removePropertyChangeListener(final PropertyChangeListener theListener) {
        myPCS.removePropertyChangeListener(theListener);
    }
    
    /** 
     * Helper method to add shapes to the DrawingPanel. 
     */
    
    private void addShape(final Shape theShape) {
        myShapes.add(theShape);
        myShapeColors.add(myColor);
        myShapeThicknesses.add(myThickness);
        myPCS.firePropertyChange("AddedShape", false, true);
    }

    /**
     * Helper method to save and update the color and thickness of the shapes on the
     * DrawingPanel.
     * 
     * @param theIndex.
     */
    
    private void updateShapeColorAndThickness(final int theIndex) {
        myShapeColors.set(theIndex, myColor);
        myShapeThicknesses.set(theIndex, myThickness);
    }

    /**
     * Helper method to set and update the grid using the grid slider.
     * 
     * @param theGraphics.
     */
    
    private void paintGrid(final Graphics theGraphics) {
        if (myGridSelection) {
            final Graphics2D g2d = (Graphics2D) theGraphics.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(1));
            g2d.setColor(UW_GOLD);

            for (int x = 0; x < getWidth(); x += myGridSpacing) {
                g2d.draw(new Line2D.Double(x, 0, x, getHeight()));
            }

            for (int y = 0; y < getHeight(); y += myGridSpacing) {
                g2d.draw(new Line2D.Double(0, y, getWidth(), y));
            }

            g2d.dispose();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        paintGrid(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(myThickness));
        g2d.setPaint(myColor);

        for (int i = 0; i < myShapes.size(); i++) {
            final Shape shape = myShapes.get(i);
            final Color shapeColor = myShapeColors.get(i);
            final int shapeThickness = myShapeThicknesses.get(i);
            g2d.setPaint(shapeColor);
            g2d.setStroke(new BasicStroke(shapeThickness));
            g2d.draw(shape);
        }

        myClearButton.setEnabled(!myShapes.isEmpty());

    }

    /**
     * Inner class that creates the mouse events for the Drawing Panel.
     * 
     * @author Ayub Mohamed ayubmo20@uw.edu
     * @version March 1st 2024
     */

    class DrawingListener extends MouseAdapter {       
        
        /**
         * {@inheritDoc}
         */
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            final Point2D startingPoint = theEvent.getPoint();
            final Point2D endingPoint = startingPoint;
            myTool.setStartingPoint(startingPoint);
            myTool.setEndingPoint(endingPoint);
            myShape = myTool.getShape();
            addShape(myShape); 
            enableClearButton(true);
            repaint();
        }
        
        /**
         * {@inheritDoc}
         */
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            final Point2D endingPoint = theEvent.getPoint();
            myTool.setEndingPoint(endingPoint);
            myShape = myTool.getShape();
            myShapes.set(myShapes.size() - 1, myShape);
            final int lastIndex = myShapes.size() - 1;
            updateShapeColorAndThickness(lastIndex); 
            enableClearButton(true);
            repaint();
        }

    } 
}


