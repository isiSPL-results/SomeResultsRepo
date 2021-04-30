// Compilation Unit of /FloorChooseDialog.java 
 

//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
package de.ovgu.featureide.examples.elevator.ui;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.awt.Component;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.awt.FlowLayout;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.awt.GridLayout;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.awt.event.ActionEvent;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.awt.event.ActionListener;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.util.ArrayList;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import java.util.List;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import javax.swing.JButton;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import javax.swing.JDialog;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import javax.swing.JLabel;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import javax.swing.JPanel;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import javax.swing.JToggleButton;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
import javax.swing.SwingConstants;
//#endif 


//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
public class FloorChooseDialog extends JDialog
  { 
private static final long serialVersionUID = 5663011468166401169L;
private JPanel panelFloors;
private List<Integer> selectedFloors = new ArrayList<>();

//#if  FIFO  
public FloorChooseDialog(int maxFloors, 
			//#if FloorPermission 
//@ 			List<Integer> disabledFloors,
			//#endif
			String description) { 
setModal(true);
setTitle("Choose Floor");
setSize(220, 220);
setLayout(new FlowLayout());
JPanel panelLevel = new JPanel(new FlowLayout());
JLabel lblLevel = new JLabel(description);
lblLevel.setHorizontalTextPosition(SwingConstants.CENTER);
lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
panelLevel.add(lblLevel);
add(panelLevel);
panelFloors = new JPanel(new GridLayout(0,3));
for (int i = 0; i <= maxFloors; i++) //1
{ 
JToggleButton btnFloor = new JToggleButton(String.valueOf(i));
btnFloor.setActionCommand(String.valueOf(i));
btnFloor.addActionListener(new SelectFloorActionListener());
panelFloors.add(btnFloor);
} 

add(panelFloors);
JButton submit = new JButton("Submit");
submit.addActionListener(new SubmitFloorActionListener());
add(submit);
setVisible(true);
} 

//#endif 


//#if  FloorPermission  
public FloorChooseDialog(int maxFloors, 
			//#if FloorPermission 
 			List<Integer> disabledFloors,
			//#endif
			String description) { 
setModal(true);
setTitle("Choose Floor");
setSize(220, 220);
setLayout(new FlowLayout());
JPanel panelLevel = new JPanel(new FlowLayout());
JLabel lblLevel = new JLabel(description);
lblLevel.setHorizontalTextPosition(SwingConstants.CENTER);
lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
panelLevel.add(lblLevel);
add(panelLevel);
panelFloors = new JPanel(new GridLayout(0,3));
for (int i = 0; i <= maxFloors; i++) //1
{ 
if(disabledFloors.contains(i))//1
{ 
continue;
} 

JToggleButton btnFloor = new JToggleButton(String.valueOf(i));
btnFloor.setActionCommand(String.valueOf(i));
btnFloor.addActionListener(new SelectFloorActionListener());
panelFloors.add(btnFloor);
} 

add(panelFloors);
JButton submit = new JButton("Submit");
submit.addActionListener(new SubmitFloorActionListener());
add(submit);
setVisible(true);
} 

//#endif 

public List<Integer> getSelectedFloors() { 
return selectedFloors ;
} 

private static class SelectFloorActionListener implements ActionListener
  { 
@Override
		public void actionPerformed(ActionEvent e) { 
JToggleButton button = (JToggleButton) e.getSource();
button.setEnabled(false);
} 

 } 

public class SubmitFloorActionListener implements ActionListener
  { 
@Override
		public void actionPerformed(ActionEvent e) { 
for (Component component : panelFloors.getComponents()) //1
{ 
JToggleButton btn = ((JToggleButton)component);
if(btn.isSelected())//1

//#if (  ( DirectedCall  &&  ShortestPath  &&  CallButtons  &&  FloorPermission  &&  Service ) ||  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( FloorPermission  &&  Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ) 
selectedFloors.add(Integer.parseInt(btn.getActionCommand()));
//#endif 


} 

setVisible(false);
} 

 } 

 } 

//#endif 


