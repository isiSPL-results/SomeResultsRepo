
//#if -702671779
// Compilation Unit of /FloorChooseDialog.java


//#if 224178159
package de.ovgu.featureide.examples.elevator.ui;
//#endif


//#if -1306758880
import java.awt.Component;
//#endif


//#if 577096513
import java.awt.FlowLayout;
//#endif


//#if 1102198313
import java.awt.GridLayout;
//#endif


//#if 1467331021
import java.awt.event.ActionEvent;
//#endif


//#if 2126989723
import java.awt.event.ActionListener;
//#endif


//#if 1414558494
import java.util.ArrayList;
//#endif


//#if 141346947
import java.util.List;
//#endif


//#if 554878913
import javax.swing.JButton;
//#endif


//#if 1968551019
import javax.swing.JDialog;
//#endif


//#if 423716943
import javax.swing.JLabel;
//#endif


//#if 538591039
import javax.swing.JPanel;
//#endif


//#if -507722803
import javax.swing.JToggleButton;
//#endif


//#if 426951656
import javax.swing.SwingConstants;
//#endif


//#if -117212175
public class FloorChooseDialog extends
//#if 446484492
    JDialog
//#endif

{

//#if -1392869807
    private static final long serialVersionUID = 5663011468166401169L;
//#endif


//#if -1362833529
    private JPanel panelFloors;
//#endif


//#if 526477127
    private List<Integer> selectedFloors = new ArrayList<>();
//#endif


//#if -1261891745
    public FloorChooseDialog(int maxFloors,
                             //#if FloorPermission
//@ 			List<Integer> disabledFloors,
                             //#endif
                             String description)
    {

//#if 1243927825
        setModal(true);
//#endif


//#if 1196750907
        setTitle("Choose Floor");
//#endif


//#if 27285877
        setSize(220, 220);
//#endif


//#if -534707933
        setLayout(new FlowLayout());
//#endif


//#if 1995641446
        JPanel panelLevel = new JPanel(new FlowLayout());
//#endif


//#if 1116105047
        JLabel lblLevel = new JLabel(description);
//#endif


//#if 697093796
        lblLevel.setHorizontalTextPosition(SwingConstants.CENTER);
//#endif


//#if 1526906797
        lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
//#endif


//#if 26146889
        panelLevel.add(lblLevel);
//#endif


//#if 237124421
        add(panelLevel);
//#endif


//#if -1439441816
        panelFloors = new JPanel(new GridLayout(0,3));
//#endif


//#if -963231238
        for (int i = 0; i <= maxFloors; i++) { //1

//#if 386689754
            JToggleButton btnFloor = new JToggleButton(String.valueOf(i));
//#endif


//#if -1087024366
            btnFloor.setActionCommand(String.valueOf(i));
//#endif


//#if 852660834
            btnFloor.addActionListener(new SelectFloorActionListener());
//#endif


//#if 669366962
            panelFloors.add(btnFloor);
//#endif

        }

//#endif


//#if -1379365974
        add(panelFloors);
//#endif


//#if 1154402673
        JButton submit = new JButton("Submit");
//#endif


//#if -96720456
        submit.addActionListener(new SubmitFloorActionListener());
//#endif


//#if 1367022333
        add(submit);
//#endif


//#if 1044505132
        setVisible(true);
//#endif

    }

//#endif


//#if 1756725597
    public FloorChooseDialog(int maxFloors,
                             //#if FloorPermission
                             List<Integer> disabledFloors,
                             //#endif
                             String description)
    {

//#if -107239711
        setModal(true);
//#endif


//#if 228929643
        setTitle("Choose Floor");
//#endif


//#if -1364592827
        setSize(220, 220);
//#endif


//#if -782525709
        setLayout(new FlowLayout());
//#endif


//#if -945466730
        JPanel panelLevel = new JPanel(new FlowLayout());
//#endif


//#if -1791455865
        JLabel lblLevel = new JLabel(description);
//#endif


//#if 242416340
        lblLevel.setHorizontalTextPosition(SwingConstants.CENTER);
//#endif


//#if -508067459
        lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
//#endif


//#if 88458777
        panelLevel.add(lblLevel);
//#endif


//#if 1300603765
        add(panelLevel);
//#endif


//#if 1373137048
        panelFloors = new JPanel(new GridLayout(0,3));
//#endif


//#if 38761418
        for (int i = 0; i <= maxFloors; i++) { //1

//#if 1997761429
            if(disabledFloors.contains(i)) { //1

//#if -1477754492
                continue;
//#endif

            }

//#endif


//#if 399362576
            JToggleButton btnFloor = new JToggleButton(String.valueOf(i));
//#endif


//#if -1512344548
            btnFloor.setActionCommand(String.valueOf(i));
//#endif


//#if 1245518316
            btnFloor.addActionListener(new SelectFloorActionListener());
//#endif


//#if -1849593368
            panelFloors.add(btnFloor);
//#endif

        }

//#endif


//#if 1523722618
        add(panelFloors);
//#endif


//#if -1174760639
        JButton submit = new JButton("Submit");
//#endif


//#if -1496860792
        submit.addActionListener(new SubmitFloorActionListener());
//#endif


//#if -977659091
        add(submit);
//#endif


//#if -347373572
        setVisible(true);
//#endif

    }

//#endif


//#if -815856438
    public List<Integer> getSelectedFloors()
    {

//#if -956231383
        return selectedFloors ;
//#endif

    }

//#endif


//#if -458261043
    private static class SelectFloorActionListener implements
//#if 717689942
        ActionListener
//#endif

    {

//#if 204842733
        @Override
        public void actionPerformed(ActionEvent e)
        {

//#if 24669563
            JToggleButton button = (JToggleButton) e.getSource();
//#endif


//#if 307888107
            button.setEnabled(false);
//#endif

        }

//#endif

    }

//#endif


//#if 1278492533
    public class SubmitFloorActionListener implements
//#if 1107934932
        ActionListener
//#endif

    {

//#if 1627140587
        @Override
        public void actionPerformed(ActionEvent e)
        {

//#if -1177901078
            for (Component component : panelFloors.getComponents()) { //1

//#if -423776816
                JToggleButton btn = ((JToggleButton)component);
//#endif


//#if 1338465312
                if(btn.isSelected())//1

//#if 737361304
                {
                    selectedFloors.add(Integer.parseInt(btn.getActionCommand()));
                }
//#endif


//#endif

            }

//#endif


//#if 852007120
            setVisible(false);
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

