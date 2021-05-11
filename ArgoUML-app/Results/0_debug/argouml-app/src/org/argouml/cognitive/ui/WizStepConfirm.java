
//#if -471793309 
// Compilation Unit of /WizStepConfirm.java 
 

//#if 1028177276 
package org.argouml.cognitive.ui;
//#endif 


//#if -1367354020 
import java.awt.GridBagConstraints;
//#endif 


//#if 113701722 
import java.awt.GridBagLayout;
//#endif 


//#if 1593726424 
import javax.swing.JLabel;
//#endif 


//#if 1678656624 
import javax.swing.JTextArea;
//#endif 


//#if -562487053 
import javax.swing.border.EtchedBorder;
//#endif 


//#if -1019012257 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -1943952096 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if 13884687 
public class WizStepConfirm extends 
//#if 1212734641 
WizStep
//#endif 

  { 

//#if 1516122818 
private JTextArea instructions = new JTextArea();
//#endif 


//#if 849005034 
private static final long serialVersionUID = 9145817515169354813L;
//#endif 


//#if 1393282430 
public WizStepConfirm(Wizard w, String instr)
    { 

//#if 1612192987 
this();
//#endif 


//#if -1620532259 
instructions.setText(instr);
//#endif 

} 

//#endif 


//#if -289484051 
private WizStepConfirm()
    { 

//#if -1967016937 
instructions.setEditable(false);
//#endif 


//#if -1212745233 
instructions.setBorder(null);
//#endif 


//#if 149687731 
instructions.setBackground(getMainPanel().getBackground());
//#endif 


//#if 176922461 
instructions.setWrapStyleWord(true);
//#endif 


//#if 187978285 
getMainPanel().setBorder(new EtchedBorder());
//#endif 


//#if -343649077 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if 1979292020 
getMainPanel().setLayout(gb);
//#endif 


//#if -1806331519 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if 51923439 
c.ipadx = 3;
//#endif 


//#if 51953230 
c.ipady = 3;
//#endif 


//#if -2092633922 
c.weightx = 0.0;
//#endif 


//#if -2064004771 
c.weighty = 0.0;
//#endif 


//#if 1430817076 
c.anchor = GridBagConstraints.EAST;
//#endif 


//#if -599944119 
JLabel image = new JLabel("");
//#endif 


//#if 1057029760 
image.setIcon(getWizardIcon());
//#endif 


//#if 1491986227 
image.setBorder(null);
//#endif 


//#if -1429656754 
c.gridx = 0;
//#endif 


//#if -1618778113 
c.gridheight = 4;
//#endif 


//#if -1429626963 
c.gridy = 0;
//#endif 


//#if -1950209962 
gb.setConstraints(image, c);
//#endif 


//#if -1085421189 
getMainPanel().add(image);
//#endif 


//#if -2092604131 
c.weightx = 1.0;
//#endif 


//#if -1429656692 
c.gridx = 2;
//#endif 


//#if -1618778206 
c.gridheight = 1;
//#endif 


//#if -1941486435 
c.gridwidth = 3;
//#endif 


//#if -1121100923 
c.gridy = 0;
//#endif 


//#if 152391391 
c.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 678598844 
gb.setConstraints(instructions, c);
//#endif 


//#if -148459479 
getMainPanel().add(instructions);
//#endif 


//#if -1429656723 
c.gridx = 1;
//#endif 


//#if -1429626932 
c.gridy = 1;
//#endif 


//#if -206822188 
c.weightx = 0.0;
//#endif 


//#if -1941486497 
c.gridwidth = 1;
//#endif 


//#if -131639221 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if -546995492 
SpacerPanel spacer = new SpacerPanel();
//#endif 


//#if 1683485251 
gb.setConstraints(spacer, c);
//#endif 


//#if -676165008 
getMainPanel().add(spacer);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

