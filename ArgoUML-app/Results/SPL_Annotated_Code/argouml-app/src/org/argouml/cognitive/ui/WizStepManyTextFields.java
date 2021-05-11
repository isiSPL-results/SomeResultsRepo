// Compilation Unit of /WizStepManyTextFields.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.Dimension;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagConstraints;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagLayout;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextArea;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextField;
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
public class WizStepManyTextFields extends WizStep
  { 
private JTextArea instructions = new JTextArea();
private List<JTextField> fields = new ArrayList<JTextField>();
private static final long serialVersionUID = -5154002407806917092L;
public WizStepManyTextFields(Wizard w, String instr, List strings)
    { 
instructions.setText(instr);
instructions.setWrapStyleWord(true);
instructions.setLineWrap(true);
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
c.weightx = 0.0;
c.gridx = 2;
c.gridheight = 1;
c.gridwidth = 3;
c.gridy = 0;
c.fill = GridBagConstraints.NONE;
gb.setConstraints(instructions, c);
getMainPanel().add(instructions);
c.gridx = 1;
c.gridy = 1;
c.weightx = 0.0;
c.gridwidth = 1;
c.fill = GridBagConstraints.NONE;
SpacerPanel spacer = new SpacerPanel();
gb.setConstraints(spacer, c);
getMainPanel().add(spacer);
c.gridx = 2;
c.weightx = 1.0;
c.anchor = GridBagConstraints.WEST;
c.gridwidth = 1;
int size = strings.size();
for (int i = 0; i < size; i++) //1
{ 
c.gridy = 2 + i;
String s = (String) strings.get(i);
JTextField tf = new JTextField(s, 50);
tf.setMinimumSize(new Dimension(200, 20));
tf.getDocument().addDocumentListener(this);
fields.add(tf);
gb.setConstraints(tf, c);
getMainPanel().add(tf);
} 

c.gridx = 1;
c.gridy = 3 + strings.size();
c.weightx = 0.0;
c.gridwidth = 1;
c.fill = GridBagConstraints.NONE;
SpacerPanel spacer2 = new SpacerPanel();
gb.setConstraints(spacer2, c);
getMainPanel().add(spacer2);
} 

public List<String> getStringList()
    { 
List<String> result = new ArrayList<String>(fields.size());
for (JTextField tf : fields) //1
{ 
result.add(tf.getText());
} 

return result;
} 

 } 

//#endif 


