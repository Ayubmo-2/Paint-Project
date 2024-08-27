/*
 /*
 * TCSS 305 - Assignment 5
 */

package view;

import action.ActionEllipse;
import action.ActionLine;
import action.ActionPencil;
import action.ActionRectangle;
import action.ActionRoundRectangle;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Presents the GUI for the PowerPaint application.
 * 
 * @author Ayub Mohamed ayubmo20@uw.edu
 * @version March 1st 2024
 */

public final class PaintGUI {   

    /** A Toolkit for the size of the GUI. */
    
    private static final Toolkit TOOL_KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimensions of my frame. */
    
    private static final Dimension SCREEN_SIZE = TOOL_KIT.getScreenSize();
    
    /** The Dimensions for the width of the GUI. */
    
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width / 3;
    
    /** The Dimensions for the height of the GUI. */
    
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height / 3;
    
    /** The default UW Husky Purple drawing color. */
    
    private static final Color UW_PURPLE = new Color(50, 0, 110);
    
    /** The initial thickness of the slider. */
    
    private static final int INITIAL_THICKNESS = 2;
    
    /** The frame that is displayed for this program. */
    
    private final JFrame myJFrame;
    
    /** The tool bar for this program. */
    
    private final ToolBar myToolBar;
    
    /** The Drawing panel for this program. */
    
    private final DrawingPanel myPanel;
    
    /** The menu bar for this program. */
    
    private final MenuBar myMenuBar;
    
    /** The color of the shape being drawn. */
    
    private final Color myColor;
    
    /** The thickness of the shape being drawn. */
    
    private final int myThickness;
    
    /** The actions for the program. */
    
    private final List<Action> myActions = new ArrayList<>();

    


    /**
     * Constructs the GUI.
     */
    
    public PaintGUI() {
        super();
        
        myJFrame = new JFrame("TCSS 305 Paint");
        
        myJFrame.setIconImage(new ImageIcon("./files/w_small.png").getImage());
        
        myPanel = new DrawingPanel();        
        
        myMenuBar = new MenuBar(myJFrame, myPanel, myActions);
    
        myToolBar = new ToolBar(myPanel);    
        
        myJFrame.setJMenuBar(myMenuBar);
        

        myColor = UW_PURPLE;
        myThickness = INITIAL_THICKNESS;

        start();
    }

    /**
     * Performs all tasks necessary to display the UI.
     */
    
    protected void start() {
        
        
        myJFrame.setLayout(new BorderLayout());
        
        myJFrame.add(myToolBar, BorderLayout.SOUTH);
        
        myJFrame.add(myPanel, BorderLayout.CENTER);
        
        
        myJFrame.setResizable(true);
        myJFrame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        myJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myJFrame.setVisible(true);
        myJFrame.setLocationRelativeTo(null);

        final List<Action> actions = new ArrayList<>();
        actions.add(new ActionLine(myPanel, myThickness, myColor));
        actions.add(new ActionRectangle(myPanel, myThickness, myColor));
        actions.add(new ActionRoundRectangle(myPanel, myThickness, myColor));
        actions.add(new ActionEllipse(myPanel, myThickness, myColor));
        actions.add(new ActionPencil(myPanel, myThickness, myColor));

        myMenuBar.createToolsMenu(myJFrame, actions);
        myToolBar.createToolBarButton(actions);
    }

}
