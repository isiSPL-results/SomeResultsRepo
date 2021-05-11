
//#if 417714003 
// Compilation Unit of /WizStepChoice.java 
 

//#if 1261994595 
package org.argouml.cognitive.ui;
//#endif 


//#if -7209853 
import java.awt.GridBagConstraints;
//#endif 


//#if -312168493 
import java.awt.GridBagLayout;
//#endif 


//#if -2070028721 
import java.awt.event.ActionEvent;
//#endif 


//#if 1626633436 
import java.util.ArrayList;
//#endif 


//#if -551409659 
import java.util.List;
//#endif 


//#if -816367919 
import javax.swing.JLabel;
//#endif 


//#if 1384827480 
import javax.swing.JRadioButton;
//#endif 


//#if 1526371543 
import javax.swing.JTextArea;
//#endif 


//#if 2118474906 
import javax.swing.border.EtchedBorder;
//#endif 


//#if -304279528 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -438509991 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if -2023391911 
public class WizStepChoice extends 
//#if 1014670874 
WizStep
//#endif 

  { 

//#if -1465366791 
private JTextArea instructions = new JTextArea();
//#endif 


//#if -1383490929 
private List<String> choices = new ArrayList<String>();
//#endif 


//#if -1135494261 
private int selectedIndex = -1;
//#endif 


//#if 562543929 
private static final long serialVersionUID = 8055896491830976354L;
//#endif 


//#if -1580021221 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 629846955 
super.actionPerformed(e);
//#endif 


//#if -1438614672 
if(e.getSource() instanceof JRadioButton)//1
{ 

//#if 981526300 
String cmd = e.getActionCommand();
//#endif 


//#if 335093184 
if(cmd == null)//1
{ 

//#if -2135604829 
selectedIndex = -1;
//#endif 


//#if 995191805 
return;
//#endif 

} 

//#endif 


//#if -1676183954 
int size = choices.size();
//#endif 


//#if -317884969 
for (int i = 0; i < size; i++) //1
{ 

//#if 1257865522 
String s = choices.get(i);
//#endif 


//#if -342430822 
if(s.equals(cmd))//1
{ 

//#if -1540409735 
selectedIndex = i;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 751821163 
getWizard().doAction();
//#endif 


//#if -1178372930 
enableButtons();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1338127602 
public WizStepChoice(Wizard w, String instr, List<String> ch)
    { 

//#if 1517743084 
choices = ch;
//#endif 


//#if -711316837 
instructions.setText(instr);
//#endif 


//#if -360138865 
instructions.setWrapStyleWord(true);
//#endif 


//#if -1268337335 
instructions.setEditable(false);
//#endif 


//#if 523949565 
instructions.setBorder(null);
//#endif 


//#if -637412031 
instructions.setBackground(getMainPanel().getBackground());
//#endif 


//#if -34138017 
getMainPanel().setBorder(new EtchedBorder());
//#endif 


//#if 608857689 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if -578980478 
getMainPanel().setLayout(gb);
//#endif 


//#if -2028447821 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if 270679201 
c.ipadx = 3;
//#endif 


//#if 270708992 
c.ipady = 3;
//#endif 


//#if 1070742128 
c.weightx = 0.0;
//#endif 


//#if 1099371279 
c.weighty = 0.0;
//#endif 


//#if 1615048258 
c.anchor = GridBagConstraints.EAST;
//#endif 


//#if 1631576827 
JLabel image = new JLabel("");
//#endif 


//#if -721547506 
image.setIcon(getWizardIcon());
//#endif 


//#if -742957339 
image.setBorder(null);
//#endif 


//#if -1210900992 
c.gridx = 0;
//#endif 


//#if -274292438 
c.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if -1210871201 
c.gridy = 0;
//#endif 


//#if -1202549230 
c.anchor = GridBagConstraints.NORTH;
//#endif 


//#if -1492537372 
gb.setConstraints(image, c);
//#endif 


//#if 1146099757 
getMainPanel().add(image);
//#endif 


//#if 1070771919 
c.weightx = 1.0;
//#endif 


//#if -1210900930 
c.gridx = 2;
//#endif 


//#if 1956598832 
c.gridheight = 1;
//#endif 


//#if 1221889615 
c.gridwidth = 3;
//#endif 


//#if 366416787 
c.gridy = 0;
//#endif 


//#if 683359469 
c.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 2094798190 
gb.setConstraints(instructions, c);
//#endif 


//#if 35771703 
getMainPanel().add(instructions);
//#endif 


//#if -1210900961 
c.gridx = 1;
//#endif 


//#if -1210871170 
c.gridy = 1;
//#endif 


//#if -243325470 
c.weightx = 0.0;
//#endif 


//#if 1221889553 
c.gridwidth = 1;
//#endif 


//#if -1910216487 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if 405511274 
SpacerPanel spacer = new SpacerPanel();
//#endif 


//#if -1308533643 
gb.setConstraints(spacer, c);
//#endif 


//#if -218492418 
getMainPanel().add(spacer);
//#endif 


//#if -519239852 
c.gridx = 2;
//#endif 


//#if 644178211 
c.weightx = 1.0;
//#endif 


//#if 1631790800 
c.anchor = GridBagConstraints.WEST;
//#endif 


//#if 1463886497 
c.gridwidth = 1;
//#endif 


//#if -1649594692 
int size = ch.size();
//#endif 


//#if -598556838 
for (int i = 0; i < size; i++) //1
{ 

//#if -2061680193 
c.gridy = 2 + i;
//#endif 


//#if -1398864422 
String s = ch.get(i);
//#endif 


//#if 1054137525 
JRadioButton rb = new JRadioButton(s);
//#endif 


//#if -1478645233 
rb.setActionCommand(s);
//#endif 


//#if -4830868 
rb.addActionListener(this);
//#endif 


//#if -1965229575 
gb.setConstraints(rb, c);
//#endif 


//#if -291746430 
getMainPanel().add(rb);
//#endif 

} 

//#endif 


//#if -520163373 
c.gridx = 1;
//#endif 


//#if -1613348132 
c.gridy = 3 + ch.size();
//#endif 


//#if -243325469 
c.weightx = 0.0;
//#endif 


//#if 1463886498 
c.gridwidth = 1;
//#endif 


//#if 1057354457 
c.fill = GridBagConstraints.NONE;
//#endif 


//#if 13325426 
SpacerPanel spacer2 = new SpacerPanel();
//#endif 


//#if -1905879409 
gb.setConstraints(spacer2, c);
//#endif 


//#if 1816677784 
getMainPanel().add(spacer2);
//#endif 

} 

//#endif 


//#if -220453938 
public int getSelectedIndex()
    { 

//#if -2045420150 
return selectedIndex;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

