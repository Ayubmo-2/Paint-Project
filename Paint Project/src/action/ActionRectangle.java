/*
 * TCSS 305 - Assignment 5
 */

package action;

import drawing.Rectangle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import view.DrawingPanel;

/**
 * The action for selecting the rectangle tool.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class ActionRectangle extends AbstractAction {

    private static final long serialVersionUID = -2423885710583729301L;

    /** The Drawing panel for drawing rectangles. */
    
    private final DrawingPanel myPanel;
    
    /** The tool to associate with this action. */
    
    private final Rectangle myTool;
    
    /**
     * Constructs the action for rectangles.
     * 
     * @param thePanel
     * @param theThickness
     * @param theColor
     */
    
    public ActionRectangle(final DrawingPanel thePanel, final int theThickness,
            final Color theColor) {
        super("Rectangle", new ImageIcon("files/rectangle_bw.gif"));
        myPanel = thePanel;
        myTool = new Rectangle(new Point2D.Double(0, 0), new Point2D.Double(0, 0), 
                theThickness, theColor);
        
        putValue(Action.SELECTED_KEY, false);
        
    }
    
    /**
     * {@inheritDoc}
     */
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) { 
        myPanel.setCurrentTool(myTool);
        myPanel.repaint();
        
    }

}
