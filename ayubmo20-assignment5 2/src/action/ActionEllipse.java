/*
 * TCSS 305 - Assignment 5
 */

package action;

import drawing.Ellipse;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import view.DrawingPanel;

/**
 * The action for selecting the ellipse tool.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class ActionEllipse extends AbstractAction {

    private static final long serialVersionUID = -935887259983986782L;

    /** The Drawing panel for drawing rectangles. */
    
    private final DrawingPanel myPanel;
    
    /** The ellipse to associate with this action. */
    
    private final Ellipse myTool;
    
    /**
     * Constructs the action for ellipse.
     * 
     * @param thePanel
     * @param theThickness
     * @param theColor
     */
    
    public ActionEllipse(final DrawingPanel thePanel, final int theThickness,
            final Color theColor) {
        super("Ellipse", new ImageIcon("files/ellipse_bw.gif"));
        myPanel = thePanel;
        myTool = new Ellipse(new Point2D.Double(0, 0), new Point2D.Double(0, 0), 
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
