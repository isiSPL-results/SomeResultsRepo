
//#if -1561682885
// Compilation Unit of /MainWindow.java


//#if -1070059437
package de.ovgu.featureide.examples.elevator.ui;
//#endif


//#if 621984870
import java.awt.Font;
//#endif


//#if -1380170271
import java.awt.GridBagConstraints;
//#endif


//#if -194149451
import java.awt.GridBagLayout;
//#endif


//#if -929850337
import java.awt.Insets;
//#endif


//#if 125107258
import java.util.ArrayList;
//#endif


//#if 73792999
import java.util.List;
//#endif


//#if 1472950362
import javax.swing.JFrame;
//#endif


//#if 1629047731
import javax.swing.JLabel;
//#endif


//#if 1743921827
import javax.swing.JPanel;
//#endif


//#if 965350042
import javax.swing.JScrollPane;
//#endif


//#if -1497631547
import javax.swing.JSplitPane;
//#endif


//#if 636438239
import javax.swing.ScrollPaneConstants;
//#endif


//#if 863175500
import javax.swing.SwingConstants;
//#endif


//#if 688824870
import javax.swing.border.EmptyBorder;
//#endif


//#if 2015711710
import java.awt.Color;
//#endif


//#if -1828206305
import java.awt.BorderLayout;
//#endif


//#if -1898600060
import java.io.IOException;
//#endif


//#if 78866167
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
//#endif


//#if 2003511468
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
//#endif


//#if 173289497
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
//#endif


//#if 1279225419
import java.util.Arrays;
//#endif


//#if 760353083
import java.awt.Dimension;
//#endif


//#if -251759614
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif


//#if -1463482391
import javax.swing.JToggleButton;
//#endif


//#if 1903554865
import java.awt.event.ActionEvent;
//#endif


//#if 1100488631
import java.awt.event.ActionListener;
//#endif


//#if -187252923
import java.awt.GridLayout;
//#endif


//#if 1738157894
import de.ovgu.featureide.examples.elevator.sim.SimulationUnit;
//#endif


//#if 464378791
public class MainWindow implements
//#if -168787379
    ITickListener
//#endif

    ,
//#if 817091991
    ActionListener
//#endif

{

//#if 281076699
    private JFrame frmElevatorSample;
//#endif


//#if 869824519
    private JSplitPane splitPane;
//#endif


//#if -1076468681
    private JLabel lblEvent;
//#endif


//#if 950837763
    private List<FloorComposite> listFloorComposites = new ArrayList<>();
//#endif


//#if -1623986550
    private List<JToggleButton> listInnerElevatorControls = new ArrayList<>();
//#endif


//#if -383123131
    private SimulationUnit sim;
//#endif


//#if 141656863
    public void initialize(int maxFloors)
    {

//#if 1051060063
        if(frmElevatorSample != null) { //1

//#if -1380440108
            return;
//#endif

        }

//#endif


//#if 938296801
        frmElevatorSample = new JFrame();
//#endif


//#if -1884187951
        frmElevatorSample.setTitle("Elevator Sample");
//#endif


//#if -1840487002
        frmElevatorSample.setBounds(100, 50, 900, 650);
//#endif


//#if 1739978719
        frmElevatorSample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//#endif


//#if -185982998
        FloorChooseDialog permissionDialog = new FloorChooseDialog(maxFloors, Arrays.asList(0), "Choose disabled floors");
//#endif


//#if 1212847735
        List<Integer> disabledFloors = permissionDialog.getSelectedFloors();
//#endif


//#if -1206162091
        sim.setDisabledFloors(disabledFloors);
//#endif


//#if -351553460
        permissionDialog.dispose();
//#endif


//#if 2086858298
        createBaseStructure();
//#endif


//#if -706160330
        createPanelControlsContent(maxFloors);
//#endif


//#if 801147588
        addBuilding(maxFloors);
//#endif


//#if 1461431773
        frmElevatorSample.setVisible(true);
//#endif

    }

//#endif


//#if -654260743
    private void clearPresent()
    {

//#if 1302079634
        for (FloorComposite fl : listFloorComposites) { //1

//#if -1124290473
            fl.showElevatorNotPresent();
//#endif

        }

//#endif

    }

//#endif


//#if -1314481270
    private void createPanelControlsContent(int maxFloors)
    {

//#if -508403807
        JPanel panel_control = new JPanel();
//#endif


//#if -2107385726
        try { //1

//#if 509023173
            panel_control = new JBackgroundPanel(MainWindow.class.getResourceAsStream("/elevator_inside2.png"));
//#endif

        }

//#if 1925214159
        catch (IOException e) { //1

//#if -1385650636
            e.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 1720058711
        splitPane.setRightComponent(panel_control);
//#endif


//#if 112692133
        GridBagLayout gbl_panel_control = new GridBagLayout();
//#endif


//#if 1595173746
        panel_control.setLayout(gbl_panel_control);
//#endif


//#if -1185300579
        lblEvent = new JLabel("");
//#endif


//#if 1040905705
        lblEvent.setFont(new Font("Tahoma", Font.BOLD, 15));
//#endif


//#if -1678006513
        lblEvent.setForeground(Color.WHITE);
//#endif


//#if -91957225
        lblEvent.setHorizontalAlignment(SwingConstants.CENTER);
//#endif


//#if -918899900
        GridBagConstraints gbc_lbl = new GridBagConstraints();
//#endif


//#if -1039993921
        gbc_lbl.gridwidth = 4;
//#endif


//#if 1138555662
        gbc_lbl.insets = new Insets(0, 0, 185, 0);
//#endif


//#if -1784058756
        gbc_lbl.fill = GridBagConstraints.HORIZONTAL;
//#endif


//#if 241357777
        gbc_lbl.gridx = 0;
//#endif


//#if 241387568
        gbc_lbl.gridy = 0;
//#endif


//#if -1850983896
        panel_control.add(lblEvent, gbc_lbl);
//#endif


//#if 277474409
        JToggleButton btnService = new JToggleButton("Service");
//#endif


//#if -1078782086
        btnService.setMinimumSize(new Dimension(80, 30));
//#endif


//#if -830122899
        btnService.setPreferredSize(new Dimension(80, 30));
//#endif


//#if 1330178828
        btnService.setMaximumSize(new Dimension(80, 30));
//#endif


//#if 1674843667
        GridBagConstraints gbc_btnService = new GridBagConstraints();
//#endif


//#if -1386366452
        gbc_btnService.insets = new Insets(0, 0, 0, 10);
//#endif


//#if -737459321
        gbc_btnService.insets = new Insets(0, 0, 0, 0);
//#endif


//#if -1257024074
        gbc_btnService.gridwidth = 4;
//#endif


//#if -314784603
        gbc_btnService.fill = GridBagConstraints.HORIZONTAL;
//#endif


//#if 1223215432
        gbc_btnService.gridx = 0;
//#endif


//#if 1223245347
        gbc_btnService.gridy = 4;
//#endif


//#if 1317832982
        panel_control.add(btnService, gbc_btnService);
//#endif


//#if -1205284790
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


//#if 1878461087
        JPanel panel_floors = new JPanel(new GridLayout(0,3));
//#endif


//#if 1767340920
        panel_floors.setBackground(Color.GRAY);
//#endif


//#if 686717415
        JToggleButton btnFloor;
//#endif


//#if -488203930
        for (int i = maxFloors; i >= 0; i--) { //1

//#if 2038840496
            btnFloor = new JToggleButton(String.valueOf(i));
//#endif


//#if 797350948
            btnFloor.setActionCommand(String.valueOf(i));
//#endif


//#if 1203022391
            btnFloor.addActionListener(this);
//#endif


//#if 1504016618
            btnFloor.setEnabled(sim.isDisabledFloor(i));
//#endif


//#if -288136159
            panel_floors.add(btnFloor);
//#endif


//#if -970955189
            listInnerElevatorControls.add(0, btnFloor);
//#endif

        }

//#endif


//#if 907314652
        GridBagConstraints gbc_btnFloor = new GridBagConstraints();
//#endif


//#if -910362096
        gbc_btnFloor.insets = new Insets(0, 0, 0, 0);
//#endif


//#if -931928001
        gbc_btnFloor.fill = GridBagConstraints.BOTH;
//#endif


//#if 1641365503
        gbc_btnFloor.gridwidth = 4;
//#endif


//#if 969228367
        gbc_btnFloor.gridx = 2;
//#endif


//#if 969258220
        gbc_btnFloor.gridy = 4;
//#endif


//#if 1230850372
        panel_control.add(panel_floors, gbc_btnFloor);
//#endif

    }

//#endif


//#if 230685371
    @Override
    public void onRequestFinished(Elevator elevator, Request request)
    {

//#if 923209282
        switch (request.getDirection()) { //1
        case MOVING_UP://1


//#if 784570978
            listFloorComposites.get(request.getFloor()).resetUp();
//#endif


//#if -496458451
            break;

//#endif


        case MOVING_DOWN://1


//#if 1770165463
            listFloorComposites.get(request.getFloor()).resetDown();
//#endif


//#if -271303991
            break;

//#endif


        default://1


//#if 852990170
            break;

//#endif


        }

//#endif


//#if 244169338
        listFloorComposites.get(request.getFloor()).resetFloorRequest();
//#endif

    }

//#endif


//#if -991357626
    public MainWindow(SimulationUnit sim)
    {

//#if -1701030490
        this.sim = sim;
//#endif

    }

//#endif


//#if -936717443
    private void createBaseStructure()
    {

//#if -702394494
        JPanel contentPane = new JPanel();
//#endif


//#if -470418905
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//#endif


//#if 1632427918
        contentPane.setLayout(new BorderLayout(0, 0));
//#endif


//#if -1283089909
        frmElevatorSample.setContentPane(contentPane);
//#endif


//#if 894343241
        splitPane = new JSplitPane();
//#endif


//#if 1896842391
        splitPane.setResizeWeight(0.5);
//#endif


//#if 810233333
        contentPane.add(splitPane, BorderLayout.CENTER);
//#endif

    }

//#endif


//#if -553507888
    private void addBuilding(int maxFloors)
    {

//#if -362110664
        JPanel panel_building = new JPanel();
//#endif


//#if -1206535829
        GridBagLayout layout = new GridBagLayout();
//#endif


//#if -1583226309
        panel_building.setLayout(layout);
//#endif


//#if 1401631237
        JScrollPane scrollPane = new JScrollPane(panel_building);
//#endif


//#if 2078324580
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//#endif


//#if 664769847
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//#endif


//#if 1503153466
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
//#endif


//#if -1287354901
        GridBagConstraints gbc = new GridBagConstraints();
//#endif


//#if 1835531447
        gbc.insets = new Insets(0, 0, 0, 0);
//#endif


//#if 35491896
        gbc.fill = GridBagConstraints.BOTH;
//#endif


//#if -107843914
        gbc.gridx = 2;
//#endif


//#if -107814185
        gbc.gridy = 0;
//#endif


//#if -2075160894
        gbc.anchor = GridBagConstraints.SOUTH;
//#endif


//#if -764333610
        for (int i = maxFloors; i >= 0; i--) { //1

//#if -953143196
            FloorComposite floor = new FloorComposite(i == 0, i, sim, i == maxFloors);
//#endif


//#if 2000935662
            FloorComposite floor = new FloorComposite(i == 0, i, sim);
//#endif


//#if -251458301
            FloorComposite floor = new FloorComposite(i == 0, i);
//#endif


//#if 1098859670
            layout.setConstraints(floor, gbc);
//#endif


//#if -1330847851
            gbc.gridy += 1;
//#endif


//#if 595984332
            panel_building.add(floor);
//#endif


//#if 446652179
            listFloorComposites.add(0, floor);
//#endif

        }

//#endif


//#if -1541500461
        splitPane.setLeftComponent(scrollPane);
//#endif

    }

//#endif


//#if 1719560715
    public void onTick(Elevator elevator)
    {

//#if -209159749
        ElevatorState state = elevator.getCurrentState();
//#endif


//#if -1761506344
        int currentFloor = elevator.getCurrentFloor();
//#endif


//#if 178038923
        switch (state) { //1
        case MOVING_UP://1


//#if -1194270996
            this.listFloorComposites.get(currentFloor - 1).showImageClose();
//#endif


//#if 900744730
            break;

//#endif


        case MOVING_DOWN://1


//#if -1169908138
            this.listFloorComposites.get(currentFloor + 1).showImageClose();
//#endif


//#if -1693178746
            break;

//#endif


        case FLOORING://1


//#if -633882377
            this.listFloorComposites.get(currentFloor).showImageOpen();
//#endif


//#if 301684911
            JToggleButton btnFloor = listInnerElevatorControls.get(currentFloor);
//#endif


//#if -1718372790
            if(btnFloor.isSelected()) { //1

//#if -489965706
                btnFloor.setSelected(false);
//#endif


//#if -64800267
                btnFloor.setEnabled(true);
//#endif

            }

//#endif


//#if -1500970203
            break;

//#endif


        }

//#endif


//#if -1728441510
        this.clearPresent();
//#endif


//#if -525270652
        this.listFloorComposites.get(currentFloor).showElevatorIsPresent();
//#endif

    }

//#endif


//#if -1517222927
    public void setEventLabel(String text, Color color)
    {

//#if 690370933
        if(lblEvent != null) { //1

//#if -1556525088
            lblEvent.setText(text);
//#endif


//#if 1906927050
            lblEvent.setForeground(color);
//#endif

        }

//#endif

    }

//#endif


//#if 482007022
    @Override
    public void actionPerformed(ActionEvent e)
    {

//#if 1578190706
        sim.floorRequest(new Request(Integer.valueOf(e.getActionCommand()), ElevatorState.FLOORING));
//#endif


//#if -208581833
        sim.floorRequest(new Request(Integer.valueOf(e.getActionCommand())));
//#endif


//#if 911515452
        listInnerElevatorControls.get(Integer.valueOf(e.getActionCommand())).setEnabled(false);
//#endif

    }

//#endif

}

//#endif


//#endif

