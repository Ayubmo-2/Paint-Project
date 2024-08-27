/*
 * TCSS 305 - Assignment 5
 */

package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The Tool Bar that is displayed on the GUI for this program.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class ToolBar extends JToolBar implements PropertyChangeListener {

    private static final long serialVersionUID = 4268951943328073987L;
    
    /** The Drawing panel for this program. */
    
    private final DrawingPanel myPanel;
    
    /** The grid check box to have a grid on the DrawingPanel. */
    
    private final JCheckBoxMenuItem myGridButton;
    
    /** The Undo button. */
    
    private final JButton myUndoButton;
    
    /** The Button Group for the tool bar. */
    
    private final ButtonGroup myButtonGroup;
    
    /**
     * Constructs the Tool Bar.
     * 
     * @param theDrawingPanel
     */

    public ToolBar(final DrawingPanel theDrawingPanel) {
        super();         
        myPanel = theDrawingPanel;
        myGridButton = new JCheckBoxMenuItem("Grid");
        myUndoButton = new JButton("Undo");
        myButtonGroup = new ButtonGroup();
        
        myPanel.addPropertyChangeListener(this);
        
    }
    
    /**
     * This creates the Tool Bar Buttons.
     *     
     * @param theActions
     */
    
    public void createToolBarButton(final List<Action> theActions) {
        for (final Action action : theActions) {
            final JToggleButton button = new JToggleButton(action);
            myButtonGroup.add(button);

            add(button);        
        }        
        
        myUndoButton.setEnabled(false);
        myUndoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.undoLastShape();
                myUndoButton.setEnabled(!myPanel.isShapesEmpty());
            }
        });
    
        add(myUndoButton);
        add(myGridButton);
        
        myGridButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                if (theEvent.getSource().equals(myGridButton) && myGridButton.isSelected()) {
                    myPanel.setGrid(true);                    
                } else {
                    myPanel.setGrid(false);
                }
            }
        });
               
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if ("AddedShape".equals(theEvt.getPropertyName())
               || "ClearedPanel".equals(theEvt.getPropertyName())) {
            myUndoButton.setEnabled(!myPanel.isShapesEmpty());
        }
    }

}
