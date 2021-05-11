// Compilation Unit of /WizStepCue.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagConstraints;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagLayout;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextArea;
//#endif 


//#if COGNITIVE 
import javax.swing.border.EtchedBorder;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if COGNITIVE 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if COGNITIVE 
public class WizStepCue extends WizStep
  { 
private JTextArea instructions = new JTextArea();
private static final long serialVersionUID = -5886729588114736302L;
public WizStepCue(Wizard w, String cue)
    { 
instructions.setText(cue);
instructions.setWrapStyleWord(true);
instructions.setEditable(false);
instructions.setBorder(null);
instructions.setBackground(getMainPanel().getBackground());
getMainPanel().setBorder(new EtchedBorder());
GridBagLayout gb = new GridBagLayout();
getMainPanel().setLayout(gb);
GridBagConstraints c = new GridBagConstraints();
c.ipadx = 3;
c.ipady = 3;
c.weightx = 0.0;
c.weighty = 0.0;
c.anchor = GridBagConstraints.EAST;
JLabel image = new JLabel("");
image.setIcon(getWizardIcon());
image.setBorder(null);
c.gridx = 0;
c.gridheight = GridBagConstraints.REMAINDER;
c.gridy = 0;
c.anchor = GridBagConstraints.NORTH;
gb.setConstraints(image, c);
getMainPanel().add(image);
c.weightx = 1.0;
c.gridx = 2;
c.gridheight = GridBagConstraints.REMAINDER;
c.gridwidth = 3;
c.gridy = 0;
c.fill = GridBagConstraints.HORIZONTAL;
gb.setConstraints(instructions, c);
getMainPanel().add(instructions);
c.gridx = 1;
c.gridy = 1;
c.weightx = 0.0;
c.gridwidth = 1;
c.fill = GridBagConstraints.NONE;
SpacerPanel spacer2 = new SpacerPanel();
gb.setConstraints(spacer2, c);
getMainPanel().add(spacer2);
} 

 } 

//#endif 


