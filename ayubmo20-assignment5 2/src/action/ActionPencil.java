/*
 * TCSS 305 - Assignment 5
 */

package action;

import drawing.Pencil;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import view.DrawingPanel;

/**
 * The action for selecting the pencil tool.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class ActionPencil extends AbstractAction {

    private static final long serialVersionUID = -3988144858549387115L;

    /** The Drawing panel for drawing ellipses. */
    
    private final DrawingPanel myPanel;
    
    /** The ellipse to associate with this action. */
    
    private final Pencil myTool;
    
    /**
     * Constructs the actions for pencils.
     * 
     * @param thePanel
     * @param theThickness
     * @param theColor
     */
    
    public ActionPencil(final DrawingPanel thePanel, final int theThickness,
            final Color theColor) {
        super("Pencil", new ImageIcon("files/pencil_bw.gif"));
        myPanel = thePanel;
        myTool = new Pencil(new Point2D.Double(0, 0), new Point2D.Double(0, 0), 
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
