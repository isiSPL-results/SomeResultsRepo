
//#if 1330184474 
// Compilation Unit of /WizStepCue.java 
 

//#if 1592579571 
package org.argouml.cognitive.ui;
//#endif 


//#if -142627821 
import java.awt.GridBagConstraints;
//#endif 


//#if -177502653 
import java.awt.GridBagLayout;
//#endif 


//#if 1638581569 
import javax.swing.JLabel;
//#endif 


//#if -2071515033 
import javax.swing.JTextArea;
//#endif 


//#if 1638974506 
import javax.swing.border.EtchedBorder;
//#endif 


//#if 775152264 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 1876846793 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if -1776778261 
public class WizStepCue extends 
//#if 1911426829 
WizStep
//#endif 

  { 

//#if -534738458 
private JTextArea instructions = new JTextArea();
//#endif 


//#if 1066674466 
private static final long serialVersionUID = -5886729588114736302L;
//#endif 


//#if 144111968 
public WizStepCue(Wizard w, String cue)
    { 

//#if 1177669939 
instructions.setText(cue);
//#endif 


//#if 783181856 
instructions.setWrapStyleWord(true);
//#endif 


//#if -2116725158 
instructions.setEditable(false);
//#endif 


//#if -101632372 
instructions.setBorder(null);
//#endif 


//#if -1957160560 
instructions.setBackground(getMainPanel().getBackground());
//#endif 


//#if 1412409328 
getMainPanel().setBorder(new EtchedBorder());
//#endif 


//#if -2125207640 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if -1204562415 
getMainPanel().setLayout(gb);
//#endif 


//#if -581900476 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if -497614734 
c.ipadx = 3;
//#endif 


//#if -497584943 
c.ipady = 3;
//#endif 


//#if -1620136511 
c.weightx = 0.0;
//#endif 


//#if -1591507360 
c.weighty = 0.0;
//#endif 


//#if 1084829521 
c.anchor = GridBagConstraints.EAST;
//#endif 


//#if -1975720756 
JLabel image = new JLabel("");
//#endif 


//#if -610367523 
image.setIcon(getWizardIcon());
//#endif 


//#if 2128081206 
image.setBorder(null);
//#endif 


//#if -1979194927 
c.gridx = 0;
//#endif 


//#if 53469435 
c.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if -1979165136 
c.gridy = 0;
//#endif 


//#if -459460893 
c.anchor = GridBagConstraints.NORTH;
//#endif 


//#if -1649612749 
gb.setConstraints(image, c);
//#endif 


//#if 1833769470 
getMainPanel().add(image);
//#endif 


//#if -1620106720 
c.weightx = 1.0;
//#endif 


//#if -1979194865 
c.gridx = 2;
//#endif 


//#if -524882057 
c.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if -1468989024 
c.gridwidth = 3;
//#endif 


//#if 2519586 
c.gridy = 0;
//#endif 


//#if 1766563452 
c.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if -1457080769 
gb.setConstraints(instructions, c);
//#endif 


//#if -494447034 
getMainPanel().add(instructions);
//#endif 


//#if -1979194896 
c.gridx = 1;
//#endif 


//#if -1979165105 
c.gridy = 1;
//#endif 


//#if 1355719921 
c.weightx = 0.0;
//#endif 


//#if -1468989086 
c.gridwidth = 1;
//#endif 


//#if -1799036504 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if 1156646147 
SpacerPanel spacer2 = new SpacerPanel();
//#endif 


//#if 1763505950 
gb.setConstraints(spacer2, c);
//#endif 


//#if 1242308393 
getMainPanel().add(spacer2);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

