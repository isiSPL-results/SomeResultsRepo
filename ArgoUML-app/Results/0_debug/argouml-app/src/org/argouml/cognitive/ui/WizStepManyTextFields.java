
//#if -64051600 
// Compilation Unit of /WizStepManyTextFields.java 
 

//#if 60214021 
package org.argouml.cognitive.ui;
//#endif 


//#if 1612137975 
import java.awt.Dimension;
//#endif 


//#if 427861157 
import java.awt.GridBagConstraints;
//#endif 


//#if 600963697 
import java.awt.GridBagLayout;
//#endif 


//#if 760635134 
import java.util.ArrayList;
//#endif 


//#if 345698467 
import java.util.List;
//#endif 


//#if -1814134673 
import javax.swing.JLabel;
//#endif 


//#if -1769308551 
import javax.swing.JTextArea;
//#endif 


//#if 1120855734 
import javax.swing.JTextField;
//#endif 


//#if 847193020 
import javax.swing.border.EtchedBorder;
//#endif 


//#if -1012109770 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -1193542793 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if 1802256991 
public class WizStepManyTextFields extends 
//#if 1383576397 
WizStep
//#endif 

  { 

//#if 305434022 
private JTextArea instructions = new JTextArea();
//#endif 


//#if -1740533319 
private List<JTextField> fields = new ArrayList<JTextField>();
//#endif 


//#if -1223369841 
private static final long serialVersionUID = -5154002407806917092L;
//#endif 


//#if 225004245 
public WizStepManyTextFields(Wizard w, String instr, List strings)
    { 

//#if -1429438734 
instructions.setText(instr);
//#endif 


//#if 1164494054 
instructions.setWrapStyleWord(true);
//#endif 


//#if -2145192933 
instructions.setLineWrap(true);
//#endif 


//#if 1159267872 
instructions.setEditable(false);
//#endif 


//#if -262992762 
instructions.setBorder(null);
//#endif 


//#if -68502006 
instructions.setBackground(getMainPanel().getBackground());
//#endif 


//#if 1438375606 
getMainPanel().setBorder(new EtchedBorder());
//#endif 


//#if -1558717918 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if -1365922805 
getMainPanel().setLayout(gb);
//#endif 


//#if -555934198 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if 1561381048 
c.ipadx = 3;
//#endif 


//#if 1561410839 
c.ipady = 3;
//#endif 


//#if 467591943 
c.weightx = 0.0;
//#endif 


//#if 496221094 
c.weighty = 0.0;
//#endif 


//#if -438601653 
c.anchor = GridBagConstraints.EAST;
//#endif 


//#if 920215826 
JLabel image = new JLabel("");
//#endif 


//#if -1058879657 
image.setIcon(getWizardIcon());
//#endif 


//#if 1090093180 
image.setBorder(null);
//#endif 


//#if 79800855 
c.gridx = 0;
//#endif 


//#if 1304891713 
c.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if 79830646 
c.gridy = 0;
//#endif 


//#if -441187031 
c.anchor = GridBagConstraints.NORTH;
//#endif 


//#if -2069891923 
gb.setConstraints(image, c);
//#endif 


//#if 434738756 
getMainPanel().add(image);
//#endif 


//#if 1452679659 
c.weightx = 0.0;
//#endif 


//#if 79800917 
c.gridx = 2;
//#endif 


//#if 438812281 
c.gridheight = 1;
//#endif 


//#if 618739430 
c.gridwidth = 3;
//#endif 


//#if -1177060324 
c.gridy = 0;
//#endif 


//#if 2047418658 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if -1438806907 
gb.setConstraints(instructions, c);
//#endif 


//#if -2017878208 
getMainPanel().add(instructions);
//#endif 


//#if 79800886 
c.gridx = 1;
//#endif 


//#if 79830677 
c.gridy = 1;
//#endif 


//#if 1452679660 
c.weightx = 0.0;
//#endif 


//#if 618739368 
c.gridwidth = 1;
//#endif 


//#if 1818716656 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if -1762064333 
SpacerPanel spacer = new SpacerPanel();
//#endif 


//#if -2026655540 
gb.setConstraints(spacer, c);
//#endif 


//#if -795846969 
getMainPanel().add(spacer);
//#endif 


//#if -2062716963 
c.gridx = 2;
//#endif 


//#if 467621734 
c.weightx = 1.0;
//#endif 


//#if -421859111 
c.anchor = GridBagConstraints.WEST;
//#endif 


//#if -1135075670 
c.gridwidth = 1;
//#endif 


//#if 354750858 
int size = strings.size();
//#endif 


//#if 1595253347 
for (int i = 0; i < size; i++) //1
{ 

//#if -537582276 
c.gridy = 2 + i;
//#endif 


//#if 1055135734 
String s = (String) strings.get(i);
//#endif 


//#if 1498478839 
JTextField tf = new JTextField(s, 50);
//#endif 


//#if -2109895044 
tf.setMinimumSize(new Dimension(200, 20));
//#endif 


//#if -308149980 
tf.getDocument().addDocumentListener(this);
//#endif 


//#if -2020672732 
fields.add(tf);
//#endif 


//#if 60070200 
gb.setConstraints(tf, c);
//#endif 


//#if 2126987687 
getMainPanel().add(tf);
//#endif 

} 

//#endif 


//#if -2063640484 
c.gridx = 1;
//#endif 


//#if -1545313494 
c.gridy = 3 + strings.size();
//#endif 


//#if 1452679661 
c.weightx = 0.0;
//#endif 


//#if -1135075669 
c.gridwidth = 1;
//#endif 


//#if 1818716657 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if 1537958345 
SpacerPanel spacer2 = new SpacerPanel();
//#endif 


//#if 1602145560 
gb.setConstraints(spacer2, c);
//#endif 


//#if 1098555887 
getMainPanel().add(spacer2);
//#endif 

} 

//#endif 


//#if 152226375 
public List<String> getStringList()
    { 

//#if -1443665920 
List<String> result = new ArrayList<String>(fields.size());
//#endif 


//#if -647151027 
for (JTextField tf : fields) //1
{ 

//#if 1765901155 
result.add(tf.getText());
//#endif 

} 

//#endif 


//#if 587503796 
return result;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

