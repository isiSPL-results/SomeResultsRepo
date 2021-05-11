// Compilation Unit of /WizStepTextField.java 
 

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
import javax.swing.JTextField;
//#endif 


//#if COGNITIVE 
import javax.swing.border.EtchedBorder;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if COGNITIVE 
public class WizStepTextField extends WizStep
  { 
private JTextArea instructions = new JTextArea();
private JLabel label = new JLabel(Translator.localize("label.value"));
private JTextField field = new JTextField(20);
private static final long serialVersionUID = -4245718254267840545L;
private WizStepTextField()
    { 
instructions.setEditable(false);
instructions.setWrapStyleWord(true);
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
c.gridheight = 4;
c.gridy = 0;
gb.setConstraints(image, c);
getMainPanel().add(image);
c.weightx = 1.0;
c.gridx = 2;
c.gridheight = 1;
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
SpacerPanel spacer = new SpacerPanel();
gb.setConstraints(spacer, c);
getMainPanel().add(spacer);
c.gridx = 2;
c.gridy = 2;
c.weightx = 0.0;
c.gridwidth = 1;
gb.setConstraints(label, c);
getMainPanel().add(label);
c.weightx = 1.0;
c.fill = GridBagConstraints.HORIZONTAL;
c.gridx = 3;
c.gridy = 2;
gb.setConstraints(field, c);
getMainPanel().add(field);
field.getDocument().addDocumentListener(this);
} 

public WizStepTextField(Wizard w, String instr, String lab, String val)
    { 
this();
instructions.setText(instr);
label.setText(lab);
field.setText(val);
} 

public String getText()
    { 
return field.getText();
} 

 } 

//#endif 


