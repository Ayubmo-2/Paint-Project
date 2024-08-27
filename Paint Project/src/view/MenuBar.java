/*
 * TCSS 305 - Assignment 5
 */

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The Menu Bar that is displayed on the GUI for this program.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public class MenuBar extends JMenuBar implements PropertyChangeListener {
    
    private static final long serialVersionUID = -3003893912415640403L;
    
    /** The slider minor tick spacing. */
    
    private static final int MINOR_TICKS = 1;
    
    /** The slider major tick spacing. */
    
    private static final int MAJOR_TICKS = 5;
    
    /** The minimum thickness of the slider. */
    
    private static final int MIN_THICKNESS = 0;
    
    /** The maximum thickness of the slider. */
    
    private static final int MAX_THICKNESS = 20;
    
    /** The initial thickness of the slider. */
    
    private static final int INITIAL_THICKNESS = 2;
    
    /** The initial spacing of the grid slider. */
    
    private static final int INITIAL_SPACING = 30;
    
    /** The minimum spacing of the grid slider. */
    
    private static final int MINIMUM_SPACING = 10;
    
    /** The maximum spacing of the grid slider. */
    
    private static final int MAXIMUM_SPACING = 50;
    
    /** The grid slider major tick spacing. */
    
    private static final int MAJOR_SPACING = 5;
    
    /** Menu item button for the thickness slider. */
    
    private final JMenuItem myThicknessButton;
    
    /** Menu item button for the grid spacing slider. */
    
    private final JMenuItem myGridSpacingButton;
    
    /** Menu item button for the clearing the panel. */
    
    private final JMenuItem myClearButton;
    
    /** The Drawing panel for this program. */
    
    private final DrawingPanel myPanel;
    
    /** Menu button for the tools. */
    
    private final JMenu myToolsButtonMenu;

    /** The Button Group for this Program. */
    
    private final ButtonGroup myButtonGroup;

    
    /**
     * Constructs the components of the menu bar.
     * 
     * @param theFrame for the JFrame.
     * @param thePanel for the DrawingPanel.
     */
    
    public MenuBar(final JFrame theFrame, final DrawingPanel thePanel,
                    final List<Action> theActions) {
        
        super();        
        myPanel = thePanel;
        myClearButton = new JMenuItem("Clear");
        myToolsButtonMenu = new JMenu("Tools");
        myThicknessButton = new JMenu("Thickness");
        myGridSpacingButton = new JMenu("Grid Spacing");
        myButtonGroup = new ButtonGroup();
        thePanel.addPropertyChangeListener(this);
  
        setupMenu(theFrame, theActions);

    }
    
    /**
     * This is a helper method for creating each menu in the menu bar.
     * 
     * @param theFrame for the JFrame.
     */
    
    private void setupMenu(final JFrame theFrame, final List<Action> theActions) {
        createOptionsMenu();
        createToolsMenu(theFrame, theActions);
        createHelpMenu();
        
    }
    
    /**
     * This creates the Options menu.
     * 
     */
    
    public void createOptionsMenu() {
        
        final JMenu options = new JMenu("Options");       
        
        final JMenuItem color = new JMenuItem("Color..."); 
        
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                
                final Color chosenColor = JColorChooser.showDialog(
                    myPanel, "Choose Color", myPanel.getColor());
                
                if (chosenColor != null) {
                    myPanel.setColor(new Color(chosenColor.getRGB())); 
                }
            }
        });

        myClearButton.setEnabled(false);
        
        myClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {                
                myPanel.clear();
                myPanel.enableClearButton(false);
            }
        });
        
        options.add(myThicknessButton);
        options.addSeparator();
        options.add(myGridSpacingButton);
        options.addSeparator();
        options.add(color);
        options.addSeparator();
        options.add(myClearButton);
        
        add(options);
        
        createSliderMenu();
        createJSliderMenu();
        
    }
   
    /**
     * This creates the Tools menu.
     * 
     * @param theFrame for the JFrame.
     * @param theActions for the List of actions.
     */
    
    public void createToolsMenu(final JFrame theFrame, final List<Action> theActions) { 

        for (final Action action : theActions) {
            final JRadioButtonMenuItem createdButton = new JRadioButtonMenuItem(action);
            myButtonGroup.add(createdButton);
            myToolsButtonMenu.add(createdButton);   
            add(myToolsButtonMenu);
        }
       
    }
    
    /**
     * This creates the Help menu.
     * 
     */
    
    public void createHelpMenu() {              
        
        final JMenu help = new JMenu("Help");
        
        final JMenuItem about = new JMenuItem("About...");
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final ImageIcon icon = new ImageIcon("files/w_small.png");
                JOptionPane.showMessageDialog(myPanel, 
                                              "Ayub Mohamed\nWinter 2024", about.getText(), 
                                              JOptionPane.INFORMATION_MESSAGE, icon);
                
            } 
            
        });
        
        help.add(about);        
        add(help);
   
    }
    
    /**
     * This creates the JSlider for the thickness bar.
     * 
     */
    
    public void createSliderMenu() {
        
        final JSlider thicknessSlider = new JSlider(JSlider.HORIZONTAL, 
                MIN_THICKNESS, MAX_THICKNESS, INITIAL_THICKNESS);
        
        thicknessSlider.setMajorTickSpacing(MAJOR_TICKS);
        thicknessSlider.setMinorTickSpacing(MINOR_TICKS);
        thicknessSlider.setPaintLabels(true);
        thicknessSlider.setPaintTicks(true);
        
        myThicknessButton.add(thicknessSlider);
        thicknessSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {               
                myPanel.setThickness(thicknessSlider.getValue());

            }
        });                
        
    }
    
    /**
     * This creates the JSlider for the grid slider.
     * 
     */

    public void createJSliderMenu() {
        final JSlider gridSpacingSlider = new JSlider(JSlider.HORIZONTAL, 
                MINIMUM_SPACING, MAXIMUM_SPACING, INITIAL_SPACING);
        
        gridSpacingSlider.setMajorTickSpacing(MAJOR_SPACING);
        gridSpacingSlider.setPaintLabels(true);
        gridSpacingSlider.setPaintTicks(true);
        
        myGridSpacingButton.add(gridSpacingSlider);
        gridSpacingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(final ChangeEvent theEvent) {               
                myPanel.setGridSpacing(gridSpacingSlider.getValue());
            }
        }); 
        
    }
    
    @Override
    public void propertyChange(final PropertyChangeEvent theEvt) {
        if ("clearButtonEnabled".equals(theEvt.getPropertyName())) {
            myClearButton.setEnabled((Boolean) theEvt.getNewValue());
        }

    }

}