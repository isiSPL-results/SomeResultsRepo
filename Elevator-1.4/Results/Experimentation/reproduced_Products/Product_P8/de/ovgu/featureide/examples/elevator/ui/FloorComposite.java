package de.ovgu.featureide.examples.elevator.ui;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import de.ovgu.featureide.examples.elevator.sim.SimulationUnit;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
public class FloorComposite extends JPanel
{
    private static final long serialVersionUID = 4452235677942989047L;
    private final static ImageIcon img_open  = new ImageIcon(FloorComposite.class.getResource("/floor_open.png"));
    private final static ImageIcon img_close = new ImageIcon(FloorComposite.class.getResource("/floor_close.png"));
    private final JLabel lblFloorImage;
    private boolean showsOpen = false;
    private JLabel lblLevel;
    private boolean isEnabled = true;
    private Color cElevatorIsPresent = UIManager.getDefaults().getColor("Button.select");
    private void toggleElevatorPresent(boolean isOpen)
    {
        Color color = isOpen ? cElevatorIsPresent : null;
        this.setBackground(color);
    }
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
    }
    public void showImageOpen()
    {
        if(!this.showsOpen) { //1
            this.changeImage();
        }
    }
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
        this.isEnabled = simulation.isDisabledFloor(level);
    }
    public void showImageClose()
    {
        if(this.showsOpen) { //1
            this.changeImage();
        }
    }

}
