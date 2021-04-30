
//#if 43618683 
// Compilation Unit of /FloorComposite.java 
 

//#if 1743944497 
package de.ovgu.featureide.examples.elevator.ui;
//#endif 


//#if -109021636 
import java.awt.Color;
//#endif 


//#if 1447696866 
import java.awt.Component;
//#endif 


//#if -1985489255 
import java.awt.Dimension;
//#endif 


//#if 1953261456 
import javax.swing.Box;
//#endif 


//#if 520494283 
import javax.swing.JToggleButton;
//#endif 


//#if -1688951840 
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif 


//#if -1017677681 
import java.awt.event.ActionEvent;
//#endif 


//#if -710937703 
import java.awt.event.ActionListener;
//#endif 


//#if -616493912 
import de.ovgu.featureide.examples.elevator.sim.SimulationUnit;
//#endif 


//#if -1429996549 
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
//#endif 


//#if 108123590 
import javax.swing.BoxLayout;
//#endif 


//#if -819874297 
import javax.swing.ImageIcon;
//#endif 


//#if -1116794607 
import javax.swing.JLabel;
//#endif 


//#if -1001920511 
import javax.swing.JPanel;
//#endif 


//#if -2058057046 
import javax.swing.SwingConstants;
//#endif 


//#if 208084047 
import javax.swing.SwingUtilities;
//#endif 


//#if 514195586 
import javax.swing.UIManager;
//#endif 


//#if 369183364 
import javax.swing.border.EmptyBorder;
//#endif 


//#if -847741225 
public class FloorComposite extends 
//#if -882736119 
JPanel
//#endif 

 implements 
//#if 1026165337 
ActionListener
//#endif 

  { 

//#if -643079873 
private static final long serialVersionUID = 4452235677942989047L;
//#endif 


//#if 1039977386 
private final static ImageIcon img_open  = new ImageIcon(FloorComposite.class.getResource("/floor_open.png"));
//#endif 


//#if 490543214 
private final static ImageIcon img_close = new ImageIcon(FloorComposite.class.getResource("/floor_close.png"));
//#endif 


//#if -800349470 
private final JLabel lblFloorImage;
//#endif 


//#if -833366039 
private boolean showsOpen = false;
//#endif 


//#if 1136569167 
private JLabel lblLevel;
//#endif 


//#if -1585874638 
private int level;
//#endif 


//#if 1285721397 
private SimulationUnit simulation;
//#endif 


//#if -2106365964 
private JToggleButton btnFloorUp;
//#endif 


//#if -1303763507 
private JToggleButton btnFloorDown;
//#endif 


//#if -395376941 
private boolean isEnabled = true;
//#endif 


//#if 558489931 
private Color cElevatorIsPresent = UIManager.getDefaults().getColor("Button.select");
//#endif 


//#if 1446081816 
private JToggleButton btnFloorRequest;
//#endif 


//#if -43067669 
public FloorComposite(boolean showsOpen, int level
													//#if CallButtons | FloorPermission
//@													, SimulationUnit simulation
													//#endif
													//#if DirectedCall
//@ 													, boolean isMaxLevel
													//#endif
													) { 

//#if -563489804 
setAlignmentY(Component.BOTTOM_ALIGNMENT);
//#endif 


//#if 6259390 
setMinimumSize(new Dimension(10, 100));
//#endif 


//#if -2103840787 
setMaximumSize(new Dimension(400, 100));
//#endif 


//#if -926311870 
setBorder(new EmptyBorder(0, 0, 0, 0));
//#endif 


//#if -2115203210 
this.showsOpen = showsOpen;
//#endif 


//#if 91117073 
setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//#endif 


//#if -1075682392 
lblLevel = new JLabel(Integer.toString(level));
//#endif 


//#if -1423240112 
lblLevel.setPreferredSize(new Dimension(30, 15));
//#endif 


//#if -427430755 
lblLevel.setMinimumSize(new Dimension(30, 15));
//#endif 


//#if 1981530159 
lblLevel.setMaximumSize(new Dimension(30, 15));
//#endif 


//#if 421445468 
lblLevel.setHorizontalTextPosition(SwingConstants.LEFT);
//#endif 


//#if 1464491993 
lblLevel.setHorizontalAlignment(SwingConstants.LEFT);
//#endif 


//#if -1620260391 
add(lblLevel);
//#endif 


//#if 2001877717 
lblLevel.setForeground(Color.BLACK);
//#endif 


//#if 918397094 
lblLevel.setBorder(new EmptyBorder(0, 0, 0, 0));
//#endif 


//#if -1620126374 
lblFloorImage = new JLabel();
//#endif 


//#if -65161762 
add(lblFloorImage);
//#endif 


//#if 105429217 
lblFloorImage.setIcon(showsOpen ? img_open : img_close);
//#endif 

} 

//#endif 


//#if 2107367591 
public void resetFloorRequest() { 

//#if 1715669737 
resetUp();
//#endif 


//#if 1629849858 
resetDown();
//#endif 


//#if 1667577186 
if(!btnFloorRequest.isEnabled())//1
{ 

//#if 946884341 
btnFloorRequest.setSelected(false);
//#endif 


//#if 750101812 
btnFloorRequest.setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 554174660 
private void toggleElevatorPresent(boolean isOpen) { 

//#if -322798721 
Color color = isOpen ? cElevatorIsPresent : null;
//#endif 


//#if -849330588 
this.setBackground(color);
//#endif 

} 

//#endif 


//#if -1028499425 
public void resetUp() { 

//#if 885094644 
if(btnFloorUp != null && !btnFloorUp.isEnabled())//1
{ 

//#if -1911414075 
btnFloorUp.setSelected(false);
//#endif 


//#if 425340164 
btnFloorUp.setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2117735488 
public void showElevatorNotPresent() { 

//#if 2074072484 
SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				toggleElevatorPresent(false);
			}
		});
//#endif 

} 

//#endif 


//#if -618668229 
public void showElevatorIsPresent() { 

//#if 1733792618 
SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				toggleElevatorPresent(true);
			}
		});
//#endif 

} 

//#endif 


//#if 237998084 
private void changeImage() { 

//#if 847104530 
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


//#if 215131288 
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

//#endif 


//#if -1990819555 
public void showImageOpen() { 

//#if -696624384 
if(!this.showsOpen)//1

//#if 1432822178 
this.changeImage();
//#endif 


//#endif 

} 

//#endif 


//#if -1630385891 
public boolean isFloorRequested() { 

//#if -1750838569 
if(btnFloorUp != null && !btnFloorUp.isEnabled() && btnFloorUp.isSelected())//1
{ 

//#if -1235050597 
return true;
//#endif 

} 

//#endif 


//#if -2047239792 
if(btnFloorDown != null && !btnFloorDown.isEnabled() && btnFloorDown.isSelected())//1
{ 

//#if -1731109458 
return true;
//#endif 

} 

//#endif 


//#if 317480659 
if(!btnFloorRequest.isEnabled() && btnFloorRequest.isSelected())//1
{ 

//#if -120547483 
return true;
//#endif 

} 

//#endif 


//#if 291060261 
return false;
//#endif 

} 

//#endif 


//#if -2098897872 
@Override
	public void actionPerformed(ActionEvent e) { 

//#if 1578712569 
if(simulation.getCurrentFloor() != level)//1
{ 

//#if 798723740 
String actionCmd = e.getActionCommand();
//#endif 


//#if 636860876 
if("UP".equals(actionCmd))//1
{ 

//#if 2117418934 
simulation.floorRequest(new Request(level, ElevatorState.MOVING_UP));
//#endif 


//#if 42835048 
btnFloorUp.setEnabled(false);
//#endif 


//#if -1530591193 
btnFloorUp.setSelected(true);
//#endif 

} 
else
{ 

//#if 1799577650 
simulation.floorRequest(new Request(level, ElevatorState.MOVING_DOWN));
//#endif 


//#if -1953908636 
btnFloorDown.setEnabled(false);
//#endif 


//#if 767632419 
btnFloorDown.setSelected(true);
//#endif 

} 

//#endif 


//#if -1663767802 
simulation.floorRequest(new Request(level));
//#endif 


//#if 735394279 
btnFloorRequest.setEnabled(false);
//#endif 


//#if -838031962 
btnFloorRequest.setSelected(true);
//#endif 

} 
else
{ 

//#if 959093687 
if(btnFloorDown != null)//1

//#if 659537270 
btnFloorDown.setSelected(false);
//#endif 


//#endif 


//#if -1341453072 
if(btnFloorUp != null)//1

//#if -2144168468 
btnFloorUp.setSelected(false);
//#endif 


//#endif 


//#if 929545616 
if(btnFloorRequest != null)//1

//#if -2014565514 
btnFloorRequest.setSelected(false);
//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1030667354 
public void resetDown() { 

//#if -470928913 
if(btnFloorDown != null && !btnFloorDown.isEnabled())//1
{ 

//#if 1314129650 
btnFloorDown.setSelected(false);
//#endif 


//#if -214878095 
btnFloorDown.setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 215601143 
public FloorComposite(boolean showsOpen, int level
													//#if CallButtons | FloorPermission
													, SimulationUnit simulation
													//#endif
													//#if DirectedCall
//@ 													, boolean isMaxLevel
													//#endif
													) { 

//#if 307474125 
setAlignmentY(Component.BOTTOM_ALIGNMENT);
//#endif 


//#if -2083748795 
setMinimumSize(new Dimension(10, 100));
//#endif 


//#if 1825382214 
setMaximumSize(new Dimension(400, 100));
//#endif 


//#if 1422348681 
setBorder(new EmptyBorder(0, 0, 0, 0));
//#endif 


//#if 1172464509 
this.showsOpen = showsOpen;
//#endif 


//#if 1307073240 
setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//#endif 


//#if -1597969343 
lblLevel = new JLabel(Integer.toString(level));
//#endif 


//#if -207283945 
lblLevel.setPreferredSize(new Dimension(30, 15));
//#endif 


//#if 561542948 
lblLevel.setMinimumSize(new Dimension(30, 15));
//#endif 


//#if -1324463434 
lblLevel.setMaximumSize(new Dimension(30, 15));
//#endif 


//#if -994039179 
lblLevel.setHorizontalTextPosition(SwingConstants.LEFT);
//#endif 


//#if -1809222816 
lblLevel.setHorizontalAlignment(SwingConstants.LEFT);
//#endif 


//#if 1190343730 
add(lblLevel);
//#endif 


//#if 1795910766 
lblLevel.setForeground(Color.BLACK);
//#endif 


//#if 396110143 
lblLevel.setBorder(new EmptyBorder(0, 0, 0, 0));
//#endif 


//#if 1513325107 
lblFloorImage = new JLabel();
//#endif 


//#if -1847010523 
add(lblFloorImage);
//#endif 


//#if 554014842 
lblFloorImage.setIcon(showsOpen ? img_open : img_close);
//#endif 


//#if -1120340040 
this.isEnabled = simulation.isDisabledFloor(level);
//#endif 


//#if 867337461 
this.level = level;
//#endif 


//#if -1300648637 
this.simulation = simulation;
//#endif 


//#if -1828287830 
add(Box.createRigidArea(new Dimension(5, 0)));
//#endif 


//#if -1794246879 
btnFloorRequest = new JToggleButton();
//#endif 


//#if -75328908 
btnFloorRequest.setIcon(new ImageIcon(FloorComposite.class.getResource("/circle_small.png")));
//#endif 


//#if 1504859673 
btnFloorRequest.setActionCommand(String.valueOf(level));
//#endif 


//#if -2130652633 
btnFloorRequest.addActionListener(this);
//#endif 


//#if 1536593818 
btnFloorRequest.setEnabled(isEnabled);
//#endif 


//#if -2109934721 
add(btnFloorRequest);
//#endif 

} 

//#endif 


//#if 61115685 
public FloorComposite(boolean showsOpen, int level
													//#if CallButtons | FloorPermission
													, SimulationUnit simulation
													//#endif
													//#if DirectedCall
 													, boolean isMaxLevel
													//#endif
													) { 

//#if 1733581600 
setAlignmentY(Component.BOTTOM_ALIGNMENT);
//#endif 


//#if -13619182 
setMinimumSize(new Dimension(10, 100));
//#endif 


//#if 1574890777 
setMaximumSize(new Dimension(400, 100));
//#endif 


//#if -1194488682 
setBorder(new EmptyBorder(0, 0, 0, 0));
//#endif 


//#if -721970486 
this.showsOpen = showsOpen;
//#endif 


//#if 672492133 
setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//#endif 


//#if -1203253292 
lblLevel = new JLabel(Integer.toString(level));
//#endif 


//#if -841865052 
lblLevel.setPreferredSize(new Dimension(30, 15));
//#endif 


//#if -87161359 
lblLevel.setMinimumSize(new Dimension(30, 15));
//#endif 


//#if -1973167741 
lblLevel.setMaximumSize(new Dimension(30, 15));
//#endif 


//#if -414758520 
lblLevel.setHorizontalTextPosition(SwingConstants.LEFT);
//#endif 


//#if -119675603 
lblLevel.setHorizontalAlignment(SwingConstants.LEFT);
//#endif 


//#if -162034939 
add(lblLevel);
//#endif 


//#if -2016636159 
lblLevel.setForeground(Color.BLACK);
//#endif 


//#if 790826194 
lblLevel.setBorder(new EmptyBorder(0, 0, 0, 0));
//#endif 


//#if -1379584890 
lblFloorImage = new JLabel();
//#endif 


//#if 165204018 
add(lblFloorImage);
//#endif 


//#if 608516365 
lblFloorImage.setIcon(showsOpen ? img_open : img_close);
//#endif 


//#if -1067427835 
this.isEnabled = simulation.isDisabledFloor(level);
//#endif 


//#if -1052354238 
this.level = level;
//#endif 


//#if -786545328 
this.simulation = simulation;
//#endif 


//#if -833800026 
if(!isMaxLevel)//1
{ 

//#if 664432590 
add(Box.createRigidArea(new Dimension(5, 0)));
//#endif 


//#if -196248793 
btnFloorUp = new JToggleButton();
//#endif 


//#if -1822120743 
btnFloorUp.setIcon(new ImageIcon(FloorComposite.class.getResource("/arrow_up_small.png")));
//#endif 


//#if 1173650680 
btnFloorUp.setActionCommand("UP");
//#endif 


//#if 454091233 
btnFloorUp.addActionListener(this);
//#endif 


//#if 2080064980 
btnFloorUp.setEnabled(isEnabled);
//#endif 


//#if -1762393613 
add(btnFloorUp);
//#endif 

} 

//#endif 


//#if 200831461 
if(level != 0)//1
{ 

//#if 847545442 
add(Box.createRigidArea(new Dimension(5, 0)));
//#endif 


//#if 710948482 
btnFloorDown = new JToggleButton();
//#endif 


//#if -142984883 
btnFloorDown.setIcon(new ImageIcon(FloorComposite.class.getResource("/arrow_down_small.png")));
//#endif 


//#if -193513236 
btnFloorDown.setActionCommand("DOWN");
//#endif 


//#if -1782315162 
btnFloorDown.addActionListener(this);
//#endif 


//#if 164890777 
btnFloorDown.setEnabled(isEnabled);
//#endif 


//#if 89110094 
add(btnFloorDown);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 543919847 
public void showImageClose() { 

//#if -1408651004 
if(this.showsOpen)//1

//#if 1414456389 
this.changeImage();
//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

