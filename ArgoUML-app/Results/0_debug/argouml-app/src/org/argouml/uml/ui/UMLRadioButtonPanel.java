
//#if 1527897338 
// Compilation Unit of /UMLRadioButtonPanel.java 
 

//#if 2021686037 
package org.argouml.uml.ui;
//#endif 


//#if -1830106432 
import java.awt.Font;
//#endif 


//#if -790814177 
import java.awt.GridLayout;
//#endif 


//#if 1684556301 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 969591131 
import java.beans.PropertyChangeListener;
//#endif 


//#if -478453996 
import java.util.ArrayList;
//#endif 


//#if 1012771172 
import java.util.Enumeration;
//#endif 


//#if 1368373965 
import java.util.List;
//#endif 


//#if 321257711 
import java.util.Map;
//#endif 


//#if -1720294001 
import javax.swing.AbstractButton;
//#endif 


//#if -1545299571 
import javax.swing.Action;
//#endif 


//#if 710552486 
import javax.swing.ButtonGroup;
//#endif 


//#if 1585904777 
import javax.swing.JPanel;
//#endif 


//#if 559252256 
import javax.swing.JRadioButton;
//#endif 


//#if -1312318311 
import javax.swing.border.TitledBorder;
//#endif 


//#if -922968060 
import org.argouml.model.Model;
//#endif 


//#if 1718814270 
import org.argouml.i18n.Translator;
//#endif 


//#if -425772 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1550866031 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -2136011945 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -600009221 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1264150793 
public abstract class UMLRadioButtonPanel extends 
//#if -203731522 
JPanel
//#endif 

 implements 
//#if -1725188247 
TargetListener
//#endif 

, 
//#if -2086873155 
PropertyChangeListener
//#endif 

  { 

//#if 1833153255 
private static Font stdFont =
        LookAndFeelMgr.getInstance().getStandardFont();
//#endif 


//#if -579379868 
private Object panelTarget;
//#endif 


//#if -1590830637 
private String propertySetName;
//#endif 


//#if 136196111 
private ButtonGroup buttonGroup = new ButtonGroup();
//#endif 


//#if -465670255 
public void setSelected(String actionCommand)
    { 

//#if -1077870283 
Enumeration<AbstractButton> en = buttonGroup.getElements();
//#endif 


//#if -268132575 
if(actionCommand == null)//1
{ 

//#if 674404774 
en.nextElement().setSelected(true);
//#endif 


//#if -354018755 
return;
//#endif 

} 

//#endif 


//#if 2032367689 
while (en.hasMoreElements()) //1
{ 

//#if 1744696639 
AbstractButton b = en.nextElement();
//#endif 


//#if 1232412176 
if(actionCommand.equals(b.getModel().getActionCommand()))//1
{ 

//#if -290782928 
b.setSelected(true);
//#endif 


//#if -2003957419 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2058125253 
public UMLRadioButtonPanel(
        boolean isDoubleBuffered,
        String title,
        List<String[]> labeltextsActioncommands,
        String thePropertySetName,
        Action setAction,
        boolean horizontal)
    { 

//#if 934942755 
super(isDoubleBuffered);
//#endif 


//#if -1417352452 
setLayout(horizontal ? new GridLayout() : new GridLayout(0, 1));
//#endif 


//#if 2003771232 
setDoubleBuffered(true);
//#endif 


//#if 1079017160 
if(Translator.localize(title) != null)//1
{ 

//#if -1348652283 
TitledBorder border = new TitledBorder(Translator.localize(title));
//#endif 


//#if 1194023537 
border.setTitleFont(stdFont);
//#endif 


//#if -1334442422 
setBorder(border);
//#endif 

} 

//#endif 


//#if 1327864589 
setButtons(labeltextsActioncommands, setAction);
//#endif 


//#if -1464525535 
setPropertySetName(thePropertySetName);
//#endif 

} 

//#endif 


//#if -1025135104 
private void setButtons(List<String[]> labeltextsActioncommands,
                            Action setAction)
    { 

//#if 1322468390 
Enumeration en = buttonGroup.getElements();
//#endif 


//#if 1054350028 
while (en.hasMoreElements()) //1
{ 

//#if -1165564302 
AbstractButton button = (AbstractButton) en.nextElement();
//#endif 


//#if 1023103623 
buttonGroup.remove(button);
//#endif 

} 

//#endif 


//#if -1084307448 
removeAll();
//#endif 


//#if -964109757 
buttonGroup.add(new JRadioButton());
//#endif 


//#if 1329602713 
for (String[] keyAndLabelX :  labeltextsActioncommands) //1
{ 

//#if 508822926 
JRadioButton button = new JRadioButton(keyAndLabelX[0]);
//#endif 


//#if -1195863666 
button.addActionListener(setAction);
//#endif 


//#if 515961798 
String actionCommand = keyAndLabelX[1];
//#endif 


//#if 2140262801 
button.setActionCommand(actionCommand);
//#endif 


//#if -1592693643 
button.setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 1905490537 
buttonGroup.add(button);
//#endif 


//#if -1096837112 
add(button);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1056332835 
public void setTarget(Object target)
    { 

//#if -2035571560 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
//#endif 


//#if 958078866 
if(Model.getFacade().isAModelElement(panelTarget))//1
{ 

//#if 1265876824 
Model.getPump().removeModelEventListener(this, panelTarget,
                    propertySetName);
//#endif 

} 

//#endif 


//#if 1021304845 
panelTarget = target;
//#endif 


//#if 2069891551 
if(Model.getFacade().isAModelElement(panelTarget))//2
{ 

//#if 1295113972 
Model.getPump().addModelEventListener(this, panelTarget,
                                                  propertySetName);
//#endif 

} 

//#endif 


//#if 568279274 
if(panelTarget != null)//1
{ 

//#if 1383786843 
buildModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1083841227 
public void targetSet(TargetEvent e)
    { 

//#if 116654874 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 2057820627 
public void targetAdded(TargetEvent e)
    { 

//#if 522353043 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1285996124 
public Object getTarget()
    { 

//#if 492980013 
return panelTarget;
//#endif 

} 

//#endif 


//#if -801069921 
public abstract void buildModel();
//#endif 


//#if 81118643 
public void targetRemoved(TargetEvent e)
    { 

//#if -910164859 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1734625436 
public void setPropertySetName(String name)
    { 

//#if -683109959 
propertySetName = name;
//#endif 

} 

//#endif 


//#if 1888287383 
public void propertyChange(PropertyChangeEvent e)
    { 

//#if -20456194 
if(e.getPropertyName().equals(propertySetName))//1
{ 

//#if -658437911 
buildModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1968808603 
public UMLRadioButtonPanel(String title,
                               List<String[]> labeltextsActioncommands,
                               String thePropertySetName,
                               Action setAction,
                               boolean horizontal)
    { 

//#if 1678437077 
this(true, title, labeltextsActioncommands,
             thePropertySetName, setAction, horizontal);
//#endif 

} 

//#endif 


//#if 29394049 
public String getPropertySetName()
    { 

//#if 1490487497 
return propertySetName;
//#endif 

} 

//#endif 


//#if -1164463180 
private static List<String[]> toList(Map<String, String> map)
    { 

//#if 315947545 
List<String[]> list = new ArrayList<String[]>();
//#endif 


//#if -2093933737 
for (Map.Entry<String, String> entry : map.entrySet()) //1
{ 

//#if 1699972463 
list.add(new String[] {entry.getKey(), entry.getValue()});
//#endif 

} 

//#endif 


//#if 2127283382 
return list;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

