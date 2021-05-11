// Compilation Unit of /MainWindow.java

package de.ovgu.featureide.examples.elevator.ui;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.io.IOException;
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;

//#if  FloorPermission
import java.util.Arrays;
//#endif


//#if  Service
import java.awt.Dimension;
//#endif


//#if  CallButtons
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
import javax.swing.JToggleButton;
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
import java.awt.event.ActionEvent;
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
import java.awt.event.ActionListener;
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
import java.awt.GridLayout;
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
import de.ovgu.featureide.examples.elevator.sim.SimulationUnit;
//#endif

public class MainWindow implements ITickListener
    ,
//#if  CallButtons
    ActionListener
//#endif

{
    private JFrame frmElevatorSample;
    private JSplitPane splitPane;
    private JLabel lblEvent;
    private List<FloorComposite> listFloorComposites = new ArrayList<>();

//#if  CallButtons
    private List<JToggleButton> listInnerElevatorControls = new ArrayList<>();
//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
    private SimulationUnit sim;
//#endif

    public void initialize(int maxFloors)
    {
        if(frmElevatorSample != null) { //1
            return;
        }

        frmElevatorSample = new JFrame();
        frmElevatorSample.setTitle("Elevator Sample");
        frmElevatorSample.setBounds(100, 50, 900, 650);
        frmElevatorSample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//#if  FloorPermission
        FloorChooseDialog permissionDialog = new FloorChooseDialog(maxFloors, Arrays.asList(0), "Choose disabled floors");
//#endif


//#if  FloorPermission
        List<Integer> disabledFloors = permissionDialog.getSelectedFloors();
//#endif


//#if  FloorPermission
        sim.setDisabledFloors(disabledFloors);
//#endif


//#if  FloorPermission
        permissionDialog.dispose();
//#endif

        createBaseStructure();
        createPanelControlsContent(maxFloors);
        addBuilding(maxFloors);
        frmElevatorSample.setVisible(true);
    }

    private void clearPresent()
    {
        for (FloorComposite fl : listFloorComposites) { //1
            fl.showElevatorNotPresent();
        }

    }

    private void createPanelControlsContent(int maxFloors)
    {
        JPanel panel_control = new JPanel();
        try { //1
            panel_control = new JBackgroundPanel(MainWindow.class.getResourceAsStream("/elevator_inside2.png"));
        } catch (IOException e) { //1
            e.printStackTrace();
        }


        splitPane.setRightComponent(panel_control);
        GridBagLayout gbl_panel_control = new GridBagLayout();
        panel_control.setLayout(gbl_panel_control);
        lblEvent = new JLabel("");
        lblEvent.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEvent.setForeground(Color.WHITE);
        lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_lbl = new GridBagConstraints();
        gbc_lbl.gridwidth = 4;
        gbc_lbl.insets = new Insets(0, 0, 185, 0);
        gbc_lbl.fill = GridBagConstraints.HORIZONTAL;
        gbc_lbl.gridx = 0;
        gbc_lbl.gridy = 0;
        panel_control.add(lblEvent, gbc_lbl);

//#if  Service
        JToggleButton btnService = new JToggleButton("Service");
//#endif


//#if  Service
        btnService.setMinimumSize(new Dimension(80, 30));
//#endif


//#if  Service
        btnService.setPreferredSize(new Dimension(80, 30));
//#endif


//#if  Service
        btnService.setMaximumSize(new Dimension(80, 30));
//#endif


//#if  Service
        GridBagConstraints gbc_btnService = new GridBagConstraints();
//#endif


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons  &&  Service ) ) && ! Sabbath
        gbc_btnService.insets = new Insets(0, 0, 0, 10);
//#endif


//#if  ( Service  &&  Sabbath ) && ! DirectedCall  && ! FIFO  && ! ShortestPath  && ! UndirectedCall  && ! CallButtons
        gbc_btnService.insets = new Insets(0, 0, 0, 0);
//#endif


//#if  ( Service  &&  Sabbath ) && ! DirectedCall  && ! FIFO  && ! ShortestPath  && ! UndirectedCall  && ! CallButtons
        gbc_btnService.gridwidth = 4;
//#endif


//#if  Service
        gbc_btnService.fill = GridBagConstraints.HORIZONTAL;
//#endif


//#if  Service
        gbc_btnService.gridx = 0;
//#endif


//#if  Service
        gbc_btnService.gridy = 4;
//#endif


//#if  Service
        panel_control.add(btnService, gbc_btnService);
//#endif


//#if  Service
        btnService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sim.toggleService();
                if (sim.isInService()) {
                    setEventLabel("Service-Mode!", Color.ORANGE);
                } else {
                    setEventLabel("", Color.WHITE);
                }
            }
        });
//#endif


//#if  CallButtons
        JPanel panel_floors = new JPanel(new GridLayout(0,3));
//#endif


//#if  CallButtons
        panel_floors.setBackground(Color.GRAY);
//#endif


//#if  CallButtons
        JToggleButton btnFloor;
//#endif


//#if  CallButtons
        for (int i = maxFloors; i >= 0; i--) { //1
            btnFloor = new JToggleButton(String.valueOf(i));
            btnFloor.setActionCommand(String.valueOf(i));
            btnFloor.addActionListener(this);

//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ) && ! FIFO  && ! Sabbath
            btnFloor.setEnabled(sim.isDisabledFloor(i));
//#endif

            panel_floors.add(btnFloor);
            listInnerElevatorControls.add(0, btnFloor);
        }

//#endif


//#if  CallButtons
        GridBagConstraints gbc_btnFloor = new GridBagConstraints();
//#endif


//#if  CallButtons
        gbc_btnFloor.insets = new Insets(0, 0, 0, 0);
//#endif


//#if  CallButtons
        gbc_btnFloor.fill = GridBagConstraints.BOTH;
//#endif


//#if  CallButtons
        gbc_btnFloor.gridwidth = 4;
//#endif


//#if  CallButtons
        gbc_btnFloor.gridx = 2;
//#endif


//#if  CallButtons
        gbc_btnFloor.gridy = 4;
//#endif


//#if  CallButtons
        panel_control.add(panel_floors, gbc_btnFloor);
//#endif

    }


//#if  CallButtons
    @Override
    public void onRequestFinished(Elevator elevator, Request request)
    {

//#if  DirectedCall
        switch (request.getDirection()) { //1
        case MOVING_UP://1


//#if  DirectedCall
            listFloorComposites.get(request.getFloor()).resetUp();
//#endif


//#if  DirectedCall
            break;

//#endif


        case MOVING_DOWN://1


//#if  DirectedCall
            listFloorComposites.get(request.getFloor()).resetDown();
//#endif


//#if  DirectedCall
            break;

//#endif


        default://1


//#if  DirectedCall
            break;

//#endif


        }

//#endif


//#if  UndirectedCall
        listFloorComposites.get(request.getFloor()).resetFloorRequest();
//#endif

    }

//#endif


//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
    public MainWindow(SimulationUnit sim)
    {
        this.sim = sim;
    }

//#endif

    private void createBaseStructure()
    {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        frmElevatorSample.setContentPane(contentPane);
        splitPane = new JSplitPane();
        splitPane.setResizeWeight(0.5);
        contentPane.add(splitPane, BorderLayout.CENTER);
    }

    private void addBuilding(int maxFloors)
    {
        JPanel panel_building = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel_building.setLayout(layout);
        JScrollPane scrollPane = new JScrollPane(panel_building);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        for (int i = maxFloors; i >= 0; i--) { //1

//#if  DirectedCall
            FloorComposite floor = new FloorComposite(i == 0, i, sim, i == maxFloors);
//#endif


//#if (  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) && ! DirectedCall
            FloorComposite floor = new FloorComposite(i == 0, i, sim);
//#endif


//#if  Sabbath && ! DirectedCall  && ! FIFO  && ! FloorPermission  && ! ShortestPath  && ! UndirectedCall  && ! CallButtons
            FloorComposite floor = new FloorComposite(i == 0, i);
//#endif

            layout.setConstraints(floor, gbc);
            gbc.gridy += 1;
            panel_building.add(floor);
            listFloorComposites.add(0, floor);
        }

        splitPane.setLeftComponent(scrollPane);
    }

    public void onTick(Elevator elevator)
    {
        ElevatorState state = elevator.getCurrentState();
        int currentFloor = elevator.getCurrentFloor();
        switch (state) { //1
        case MOVING_UP://1

            this.listFloorComposites.get(currentFloor - 1).showImageClose();
            break;


        case MOVING_DOWN://1

            this.listFloorComposites.get(currentFloor + 1).showImageClose();
            break;


        case FLOORING://1

            this.listFloorComposites.get(currentFloor).showImageOpen();

//#if  CallButtons
            JToggleButton btnFloor = listInnerElevatorControls.get(currentFloor);
//#endif


//#if  CallButtons
            if(btnFloor.isSelected()) { //1
                btnFloor.setSelected(false);
                btnFloor.setEnabled(true);
            }

//#endif

            break;


        }

        this.clearPresent();
        this.listFloorComposites.get(currentFloor).showElevatorIsPresent();
    }

    public void setEventLabel(String text, Color color)
    {
        if(lblEvent != null) { //1
            lblEvent.setText(text);
            lblEvent.setForeground(color);
        }

    }


//#if  CallButtons
    @Override
    public void actionPerformed(ActionEvent e)
    {

//#if  DirectedCall
        sim.floorRequest(new Request(Integer.valueOf(e.getActionCommand()), ElevatorState.FLOORING));
//#endif


//#if  UndirectedCall
        sim.floorRequest(new Request(Integer.valueOf(e.getActionCommand())));
//#endif

        listInnerElevatorControls.get(Integer.valueOf(e.getActionCommand())).setEnabled(false);
    }

//#endif

}


