
//#if -1978428305 
// Compilation Unit of /WizStepTextField.java 
 

//#if -2049691868 
package org.argouml.cognitive.ui;
//#endif 


//#if 32865540 
import java.awt.GridBagConstraints;
//#endif 


//#if 562111154 
import java.awt.GridBagLayout;
//#endif 


//#if -668602064 
import javax.swing.JLabel;
//#endif 


//#if 1277479448 
import javax.swing.JTextArea;
//#endif 


//#if 1082003191 
import javax.swing.JTextField;
//#endif 


//#if -1442663269 
import javax.swing.border.EtchedBorder;
//#endif 


//#if -1133801289 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -807316345 
import org.argouml.i18n.Translator;
//#endif 


//#if 835356280 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if -642817100 
public class WizStepTextField extends 
//#if -2135568390 
WizStep
//#endif 

  { 

//#if 1621870873 
private JTextArea instructions = new JTextArea();
//#endif 


//#if -116662861 
private JLabel label = new JLabel(Translator.localize("label.value"));
//#endif 


//#if 267424676 
private JTextField field = new JTextField(20);
//#endif 


//#if -17647365 
private static final long serialVersionUID = -4245718254267840545L;
//#endif 


//#if -1773570877 
private WizStepTextField()
    { 

//#if -784213936 
instructions.setEditable(false);
//#endif 


//#if 259850006 
instructions.setWrapStyleWord(true);
//#endif 


//#if -113842090 
instructions.setBorder(null);
//#endif 


//#if -1241510438 
instructions.setBackground(getMainPanel().getBackground());
//#endif 


//#if 432728294 
getMainPanel().setBorder(new EtchedBorder());
//#endif 


//#if 628857330 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if -1216772133 
getMainPanel().setLayout(gb);
//#endif 


//#if -1561581510 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if -1675534616 
c.ipadx = 3;
//#endif 


//#if -1675504825 
c.ipady = 3;
//#endif 


//#if -1755782857 
c.weightx = 0.0;
//#endif 


//#if -1727153706 
c.weighty = 0.0;
//#endif 


//#if -556995557 
c.anchor = GridBagConstraints.EAST;
//#endif 


//#if -36202686 
JLabel image = new JLabel("");
//#endif 


//#if 540995367 
image.setIcon(getWizardIcon());
//#endif 


//#if -429240660 
image.setBorder(null);
//#endif 


//#if 1137852487 
c.gridx = 0;
//#endif 


//#if 233670310 
c.gridheight = 4;
//#endif 


//#if 1137882278 
c.gridy = 0;
//#endif 


//#if -1654094723 
gb.setConstraints(image, c);
//#endif 


//#if -521679756 
getMainPanel().add(image);
//#endif 


//#if -1755753066 
c.weightx = 1.0;
//#endif 


//#if 1137852549 
c.gridx = 2;
//#endif 


//#if 233670217 
c.gridheight = 1;
//#endif 


//#if -1604635370 
c.gridwidth = 3;
//#endif 


//#if -1525876756 
c.gridy = 0;
//#endif 


//#if -1571822010 
c.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if -814050635 
gb.setConstraints(instructions, c);
//#endif 


//#if -2136272112 
getMainPanel().add(instructions);
//#endif 


//#if 1137852518 
c.gridx = 1;
//#endif 


//#if 1137882309 
c.gridy = 1;
//#endif 


//#if 1879651771 
c.weightx = 0.0;
//#endif 


//#if -1604635432 
c.gridwidth = 1;
//#endif 


//#if -647673614 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if 425510915 
SpacerPanel spacer = new SpacerPanel();
//#endif 


//#if -2021844228 
gb.setConstraints(spacer, c);
//#endif 


//#if -380049769 
getMainPanel().add(spacer);
//#endif 


//#if 1883433901 
c.gridx = 2;
//#endif 


//#if 1137882340 
c.gridy = 2;
//#endif 


//#if 1879651772 
c.weightx = 0.0;
//#endif 


//#if -708103558 
c.gridwidth = 1;
//#endif 


//#if -1383668330 
gb.setConstraints(label, c);
//#endif 


//#if 1798152141 
getMainPanel().add(label);
//#endif 


//#if -1527811844 
c.weightx = 1.0;
//#endif 


//#if 1878975052 
c.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 1137852580 
c.gridx = 3;
//#endif 


//#if -1524029714 
c.gridy = 2;
//#endif 


//#if 489264284 
gb.setConstraints(field, c);
//#endif 


//#if 1000101971 
getMainPanel().add(field);
//#endif 


//#if -39726690 
field.getDocument().addDocumentListener(this);
//#endif 

} 

//#endif 


//#if -140920922 
public WizStepTextField(Wizard w, String instr, String lab, String val)
    { 

//#if -648818288 
this();
//#endif 


//#if -321756600 
instructions.setText(instr);
//#endif 


//#if -817989664 
label.setText(lab);
//#endif 


//#if 1887152122 
field.setText(val);
//#endif 

} 

//#endif 


//#if -1896009200 
public String getText()
    { 

//#if -1273191357 
return field.getText();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

