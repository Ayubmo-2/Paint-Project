/*
 * TCSS 305 - Assignment 5
 */

package action;

import drawing.Line;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import view.DrawingPanel;

/**
 * The action for selecting the line tool.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class ActionLine extends AbstractAction {

    private static final long serialVersionUID = -4571366980786666619L;

    /** Panel to associate with this action. */
    
    private final DrawingPanel myPanel;
    
    /** The tool to associate with this action. */
    
    private final Line myTool;
    
    /**
     * Constructs the action for lines.
     *
     * @param thePanel
     * @param theThickness
     * @param theColor
     */
    
    public ActionLine(final DrawingPanel thePanel, final int theThickness,
                      final Color theColor) {
        super("Line", new ImageIcon("files/line_bw.gif"));
        myPanel = thePanel;
        myTool = new Line(new Point2D.Double(0, 0), new Point2D.Double(0, 0), 
                          theThickness, theColor);

        putValue(Action.SELECTED_KEY, true);
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
