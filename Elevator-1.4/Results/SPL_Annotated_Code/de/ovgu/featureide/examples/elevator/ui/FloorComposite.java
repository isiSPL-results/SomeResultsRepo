// Compilation Unit of /FloorComposite.java

package de.ovgu.featureide.examples.elevator.ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

//#if  CallButtons
import javax.swing.Box;
//#endif


//#if  CallButtons
import javax.swing.JToggleButton;
//#endif


//#if  CallButtons
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif


//#if  CallButtons
import java.awt.event.ActionEvent;
//#endif


//#if  CallButtons
import java.awt.event.ActionListener;
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
import de.ovgu.featureide.examples.elevator.sim.SimulationUnit;
//#endif


//#if  DirectedCall
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
//#endif

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class FloorComposite extends JPanel
    implements
//#if  CallButtons
    ActionListener
//#endif

{
    private static final long serialVersionUID = 4452235677942989047L;
    private final static ImageIcon img_open  = new ImageIcon(FloorComposite.class.getResource("/floor_open.png"));
    private final static ImageIcon img_close = new ImageIcon(FloorComposite.class.getResource("/floor_close.png"));
    private final JLabel lblFloorImage;
    private boolean showsOpen = false;
    private JLabel lblLevel;

//#if  CallButtons
    private int level;
//#endif


//#if  CallButtons
    private SimulationUnit simulation;
//#endif


//#if  DirectedCall
    private JToggleButton btnFloorUp;
//#endif


//#if  DirectedCall
    private JToggleButton btnFloorDown;
//#endif


//#if  FloorPermission
    private boolean isEnabled = true;
//#endif

    private Color cElevatorIsPresent = UIManager.getDefaults().getColor("Button.select");

//#if  UndirectedCall
    private JToggleButton btnFloorRequest;
//#endif


//#if  Sabbath && ! DirectedCall  && ! FIFO  && ! FloorPermission  && ! ShortestPath  && ! UndirectedCall  && ! CallButtons
    public FloorComposite(boolean showsOpen, int level
                          //#if CallButtons | FloorPermission
//@													, SimulationUnit simulation
                          //#endif
                          //#if DirectedCall
//@ 													, boolean isMaxLevel
                          //#endif
                         )
    {
        setAlignmentY(Component.BOTTOM_ALIGNMENT);
        setMinimumSize(new Dimension(10, 100));
        setMaximumSize(new Dimension(400, 100));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        this.showsOpen = showsOpen;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        lblLevel = new JLabel(Integer.toString(level));
        lblLevel.setPreferredSize(new Dimension(30, 15));
        lblLevel.setMinimumSize(new Dimension(30, 15));
        lblLevel.setMaximumSize(new Dimension(30, 15));
        lblLevel.setHorizontalTextPosition(SwingConstants.LEFT);
        lblLevel.setHorizontalAlignment(SwingConstants.LEFT);
        add(lblLevel);
        lblLevel.setForeground(Color.BLACK);
        lblLevel.setBorder(new EmptyBorder(0, 0, 0, 0));
        lblFloorImage = new JLabel();
        add(lblFloorImage);
        lblFloorImage.setIcon(showsOpen ? img_open : img_close);
    }

//#endif


//#if  CallButtons
    public void resetFloorRequest()
    {

//#if  DirectedCall
        resetUp();
//#endif


//#if  DirectedCall
        resetDown();
//#endif


//#if  UndirectedCall
        if(!btnFloorRequest.isEnabled()) { //1
            btnFloorRequest.setSelected(false);
            btnFloorRequest.setEnabled(true);
        }

//#endif

    }

//#endif

    private void toggleElevatorPresent(boolean isOpen)
    {
        Color color = isOpen ? cElevatorIsPresent : null;
        this.setBackground(color);
    }


//#if  DirectedCall
    public void resetUp()
    {
        if(btnFloorUp != null && !btnFloorUp.isEnabled()) { //1
            btnFloorUp.setSelected(false);
            btnFloorUp.setEnabled(true);
        }

    }

//#endif

    public void showElevatorNotPresent()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                toggleElevatorPresent(false);
            }
        });
    }

    public void showElevatorIsPresent()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                toggleElevatorPresent(true);
            }
        });
    }

    private void changeImage()
    {

//#if  FloorPermission
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //#if FloorPermission
                if (isEnabled)
                    //#endif
                    if (showsOpen) {
                        lblFloorImage.setIcon(img_close);
                        showsOpen = false;
                        toggleElevatorPresent(false);
                    } else {
                        lblFloorImage.setIcon(img_open);
                        showsOpen = true;
                        toggleElevatorPresent(true);
                    }
            }
        });
//#endif


//#if (  Sabbath ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) && ! FloorPermission
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //#if FloorPermission
//@ 				if (isEnabled)
                //#endif
                if (showsOpen) {
                    lblFloorImage.setIcon(img_close);
                    showsOpen = false;
                    toggleElevatorPresent(false);
                } else {
                    lblFloorImage.setIcon(img_open);
                    showsOpen = true;
                    toggleElevatorPresent(true);
                }
            }
        });
//#endif

    }

    public void showImageOpen()
    {
        if(!this.showsOpen) { //1
            this.changeImage();
        }

    }


//#if  CallButtons
    public boolean isFloorRequested()
    {

//#if  DirectedCall
        if(btnFloorUp != null && !btnFloorUp.isEnabled() && btnFloorUp.isSelected()) { //1
            return true;
        }

//#endif


//#if  DirectedCall
        if(btnFloorDown != null && !btnFloorDown.isEnabled() && btnFloorDown.isSelected()) { //1
            return true;
        }

//#endif


//#if  UndirectedCall
        if(!btnFloorRequest.isEnabled() && btnFloorRequest.isSelected()) { //1
            return true;
        }

//#endif

        return false;
    }

//#endif


//#if  CallButtons
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(simulation.getCurrentFloor() != level) { //1

//#if  DirectedCall
            String actionCmd = e.getActionCommand();
//#endif


//#if  DirectedCall
            if("UP".equals(actionCmd)) { //1
                simulation.floorRequest(new Request(level, ElevatorState.MOVING_UP));
                btnFloorUp.setEnabled(false);
                btnFloorUp.setSelected(true);
            } else {
                simulation.floorRequest(new Request(level, ElevatorState.MOVING_DOWN));
                btnFloorDown.setEnabled(false);
                btnFloorDown.setSelected(true);
            }

//#endif


//#if  UndirectedCall
            simulation.floorRequest(new Request(level));
//#endif


//#if  UndirectedCall
            btnFloorRequest.setEnabled(false);
//#endif


//#if  UndirectedCall
            btnFloorRequest.setSelected(true);
//#endif

        } else {

//#if  DirectedCall
            if(btnFloorDown != null)//1

//#if  DirectedCall
            {
                btnFloorDown.setSelected(false);
            }
//#endif


//#endif


//#if  DirectedCall
            if(btnFloorUp != null)//1

//#if  DirectedCall
            {
                btnFloorUp.setSelected(false);
            }
//#endif


//#endif


//#if  UndirectedCall
            if(btnFloorRequest != null)//1

//#if  UndirectedCall
            {
                btnFloorRequest.setSelected(false);
            }
//#endif


//#endif

        }

    }

//#endif


//#if  DirectedCall
    public void resetDown()
    {
        if(btnFloorDown != null && !btnFloorDown.isEnabled()) { //1
            btnFloorDown.setSelected(false);
            btnFloorDown.setEnabled(true);
        }

    }

//#endif


//#if (  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) && ! DirectedCall
    public FloorComposite(boolean showsOpen, int level
                          //#if CallButtons | FloorPermission
                          , SimulationUnit simulation
                          //#endif
                          //#if DirectedCall
//@ 													, boolean isMaxLevel
                          //#endif
                         )
    {
        setAlignmentY(Component.BOTTOM_ALIGNMENT);
        setMinimumSize(new Dimension(10, 100));
        setMaximumSize(new Dimension(400, 100));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        this.showsOpen = showsOpen;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        lblLevel = new JLabel(Integer.toString(level));
        lblLevel.setPreferredSize(new Dimension(30, 15));
        lblLevel.setMinimumSize(new Dimension(30, 15));
        lblLevel.setMaximumSize(new Dimension(30, 15));
        lblLevel.setHorizontalTextPosition(SwingConstants.LEFT);
        lblLevel.setHorizontalAlignment(SwingConstants.LEFT);
        add(lblLevel);
        lblLevel.setForeground(Color.BLACK);
        lblLevel.setBorder(new EmptyBorder(0, 0, 0, 0));
        lblFloorImage = new JLabel();
        add(lblFloorImage);
        lblFloorImage.setIcon(showsOpen ? img_open : img_close);

//#if (  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ) && ! DirectedCall  && ! FIFO
        this.isEnabled = simulation.isDisabledFloor(level);
//#endif


//#if  UndirectedCall
        this.level = level;
//#endif


//#if  UndirectedCall
        this.simulation = simulation;
//#endif


//#if  UndirectedCall
        add(Box.createRigidArea(new Dimension(5, 0)));
//#endif


//#if  UndirectedCall
        btnFloorRequest = new JToggleButton();
//#endif


//#if  UndirectedCall
        btnFloorRequest.setIcon(new ImageIcon(FloorComposite.class.getResource("/circle_small.png")));
//#endif


//#if  UndirectedCall
        btnFloorRequest.setActionCommand(String.valueOf(level));
//#endif


//#if  UndirectedCall
        btnFloorRequest.addActionListener(this);
//#endif


//#if  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) && ! DirectedCall  && ! FIFO  && ! Sabbath
        btnFloorRequest.setEnabled(isEnabled);
//#endif


//#if  UndirectedCall
        add(btnFloorRequest);
//#endif

    }

//#endif


//#if  DirectedCall
    public FloorComposite(boolean showsOpen, int level
                          //#if CallButtons | FloorPermission
                          , SimulationUnit simulation
                          //#endif
                          //#if DirectedCall
                          , boolean isMaxLevel
                          //#endif
                         )
    {
        setAlignmentY(Component.BOTTOM_ALIGNMENT);
        setMinimumSize(new Dimension(10, 100));
        setMaximumSize(new Dimension(400, 100));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        this.showsOpen = showsOpen;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        lblLevel = new JLabel(Integer.toString(level));
        lblLevel.setPreferredSize(new Dimension(30, 15));
        lblLevel.setMinimumSize(new Dimension(30, 15));
        lblLevel.setMaximumSize(new Dimension(30, 15));
        lblLevel.setHorizontalTextPosition(SwingConstants.LEFT);
        lblLevel.setHorizontalAlignment(SwingConstants.LEFT);
        add(lblLevel);
        lblLevel.setForeground(Color.BLACK);
        lblLevel.setBorder(new EmptyBorder(0, 0, 0, 0));
        lblFloorImage = new JLabel();
        add(lblFloorImage);
        lblFloorImage.setIcon(showsOpen ? img_open : img_close);

//#if  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) && ! FIFO  && ! Sabbath  && ! UndirectedCall
        this.isEnabled = simulation.isDisabledFloor(level);
//#endif

        this.level = level;
        this.simulation = simulation;
        if(!isMaxLevel) { //1
            add(Box.createRigidArea(new Dimension(5, 0)));
            btnFloorUp = new JToggleButton();
            btnFloorUp.setIcon(new ImageIcon(FloorComposite.class.getResource("/arrow_up_small.png")));
            btnFloorUp.setActionCommand("UP");
            btnFloorUp.addActionListener(this);

//#if  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) && ! FIFO  && ! Sabbath  && ! UndirectedCall
            btnFloorUp.setEnabled(isEnabled);
//#endif

            add(btnFloorUp);
        }

        if(level != 0) { //1
            add(Box.createRigidArea(new Dimension(5, 0)));
            btnFloorDown = new JToggleButton();
            btnFloorDown.setIcon(new ImageIcon(FloorComposite.class.getResource("/arrow_down_small.png")));
            btnFloorDown.setActionCommand("DOWN");
            btnFloorDown.addActionListener(this);

//#if  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) && ! FIFO  && ! Sabbath  && ! UndirectedCall
            btnFloorDown.setEnabled(isEnabled);
//#endif

            add(btnFloorDown);
        }

    }

//#endif

    public void showImageClose()
    {
        if(this.showsOpen) { //1
            this.changeImage();
        }

    }

}


