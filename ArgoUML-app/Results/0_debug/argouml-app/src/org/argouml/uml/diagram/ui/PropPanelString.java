
//#if 47109994 
// Compilation Unit of /PropPanelString.java 
 

//#if 1425535148 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -984106515 
import java.awt.GridBagConstraints;
//#endif 


//#if -1188775895 
import java.awt.GridBagLayout;
//#endif 


//#if -2065786469 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -507599091 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1411065305 
import javax.swing.JLabel;
//#endif 


//#if -668883858 
import javax.swing.JTextField;
//#endif 


//#if -2091029990 
import javax.swing.event.DocumentEvent;
//#endif 


//#if -918056402 
import javax.swing.event.DocumentListener;
//#endif 


//#if -851877835 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1824288400 
import org.argouml.i18n.Translator;
//#endif 


//#if 1480814171 
import org.argouml.ui.TabModelTarget;
//#endif 


//#if 1384800159 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 465461120 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if -1695526400 
public class PropPanelString extends 
//#if 1481104414 
AbstractArgoJPanel
//#endif 

 implements 
//#if -1142715346 
TabModelTarget
//#endif 

, 
//#if -55111262 
PropertyChangeListener
//#endif 

, 
//#if 1899513240 
DocumentListener
//#endif 

  { 

//#if -1928176685 
private FigText target;
//#endif 


//#if -1637671743 
private JLabel nameLabel = new JLabel(Translator.localize("label.text"));
//#endif 


//#if 276090338 
private JTextField nameField = new JTextField();
//#endif 


//#if -1684457969 
public void setTarget(Object t)
    { 

//#if 422741102 
if(target != null)//1
{ 

//#if 733251467 
target.removePropertyChangeListener(this);
//#endif 

} 

//#endif 


//#if -978247061 
if(t instanceof FigText)//1
{ 

//#if -283169789 
target = (FigText) t;
//#endif 


//#if -1900169882 
target.removePropertyChangeListener(this);
//#endif 


//#if 1582293166 
if(isVisible())//1
{ 

//#if 73350461 
target.addPropertyChangeListener(this);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -354170301 
public void insertUpdate(DocumentEvent e)
    { 

//#if -1400417093 
if(e.getDocument() == nameField.getDocument() && target != null)//1
{ 

//#if -1857009978 
target.setText(nameField.getText());
//#endif 


//#if 1525350451 
target.damage();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 92894998 
public void refresh()
    { 

//#if 1006382004 
setTarget(target);
//#endif 

} 

//#endif 


//#if -2047462847 
public PropPanelString()
    { 

//#if 1676751372 
super(Translator.localize("tab.string"));
//#endif 


//#if -655957257 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if 681453290 
setLayout(gb);
//#endif 


//#if 1318204629 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if -900277938 
c.fill = GridBagConstraints.BOTH;
//#endif 


//#if -1621860590 
c.weightx = 0.0;
//#endif 


//#if -148635069 
c.ipadx = 3;
//#endif 


//#if -148605278 
c.ipady = 3;
//#endif 


//#if -1630215262 
c.gridx = 0;
//#endif 


//#if -1470713165 
c.gridwidth = 1;
//#endif 


//#if -1630185471 
c.gridy = 0;
//#endif 


//#if 2140628560 
gb.setConstraints(nameLabel, c);
//#endif 


//#if -640323053 
add(nameLabel);
//#endif 


//#if -1621830799 
c.weightx = 1.0;
//#endif 


//#if -1630215231 
c.gridx = 1;
//#endif 


//#if 490424519 
c.gridwidth = GridBagConstraints.REMAINDER;
//#endif 


//#if 953769676 
c.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if -1660104015 
c.gridy = 0;
//#endif 


//#if -281406122 
gb.setConstraints(nameField, c);
//#endif 


//#if -1438373223 
add(nameField);
//#endif 


//#if 1271150180 
nameField.getDocument().addDocumentListener(this);
//#endif 


//#if -188233406 
nameField.setEditable(true);
//#endif 

} 

//#endif 


//#if -1994941426 
public void targetAdded(TargetEvent e)
    { 

//#if -171303533 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 83453401 
public boolean shouldBeEnabled(Object theTarget)
    { 

//#if -1616100364 
return false;
//#endif 

} 

//#endif 


//#if 1283409202 
public void changedUpdate(DocumentEvent e)
    { 
} 

//#endif 


//#if -1072507458 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1192642775 
if(evt.getPropertyName().equals("editing")
                && evt.getNewValue().equals(Boolean.FALSE))//1
{ 

//#if -968464645 
nameField.setText(target.getText());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -507053520 
public void targetSet(TargetEvent e)
    { 

//#if 1264422244 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -153894633 
public Object getTarget()
    { 

//#if -1756639509 
return target;
//#endif 

} 

//#endif 


//#if 912123182 
public void targetRemoved(TargetEvent e)
    { 

//#if -883783679 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 340575694 
public void removeUpdate(DocumentEvent e)
    { 

//#if -2029151181 
insertUpdate(e);
//#endif 

} 

//#endif 


//#if 525979078 
protected void setTargetName()
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

