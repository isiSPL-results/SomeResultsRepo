package org.argouml.uml.ui;
import java.awt.Font;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import org.argouml.model.Model;
import org.argouml.i18n.Translator;
import org.argouml.ui.LookAndFeelMgr;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.tigris.gef.presentation.Fig;
public abstract class UMLRadioButtonPanel extends JPanel
 implements TargetListener
,PropertyChangeListener
  { 
private static Font stdFont =
        LookAndFeelMgr.getInstance().getStandardFont();
private Object panelTarget;
private String propertySetName;
private ButtonGroup buttonGroup = new ButtonGroup();
public void setSelected(String actionCommand)
    { 
Enumeration<AbstractButton> en = buttonGroup.getElements();
if(actionCommand == null)//1
{ 
en.nextElement().setSelected(true);
return;
} 
while (en.hasMoreElements()) //1
{ 
AbstractButton b = en.nextElement();
if(actionCommand.equals(b.getModel().getActionCommand()))//1
{ 
b.setSelected(true);
break;

} 
} 
} 
public UMLRadioButtonPanel(
        boolean isDoubleBuffered,
        String title,
        List<String[]> labeltextsActioncommands,
        String thePropertySetName,
        Action setAction,
        boolean horizontal)
    { 
super(isDoubleBuffered);
setLayout(horizontal ? new GridLayout() : new GridLayout(0, 1));
setDoubleBuffered(true);
if(Translator.localize(title) != null)//1
{ 
TitledBorder border = new TitledBorder(Translator.localize(title));
border.setTitleFont(stdFont);
setBorder(border);
} 
setButtons(labeltextsActioncommands, setAction);
setPropertySetName(thePropertySetName);
} 
private void setButtons(List<String[]> labeltextsActioncommands,
                            Action setAction)
    { 
Enumeration en = buttonGroup.getElements();
while (en.hasMoreElements()) //1
{ 
AbstractButton button = (AbstractButton) en.nextElement();
buttonGroup.remove(button);
} 
removeAll();
buttonGroup.add(new JRadioButton());
for (String[] keyAndLabelX :  labeltextsActioncommands) //1
{ 
JRadioButton button = new JRadioButton(keyAndLabelX[0]);
button.addActionListener(setAction);
String actionCommand = keyAndLabelX[1];
button.setActionCommand(actionCommand);
button.setFont(LookAndFeelMgr.getInstance().getStandardFont());
buttonGroup.add(button);
add(button);
} 
} 
public void setTarget(Object target)
    { 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
if(Model.getFacade().isAModelElement(panelTarget))//1
{ 
Model.getPump().removeModelEventListener(this, panelTarget,
                    propertySetName);
} 
panelTarget = target;
if(Model.getFacade().isAModelElement(panelTarget))//2
{ 
Model.getPump().addModelEventListener(this, panelTarget,
                                                  propertySetName);
} 
if(panelTarget != null)//1
{ 
buildModel();
} 
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public Object getTarget()
    { 
return panelTarget;
} 
public abstract void buildModel();public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void setPropertySetName(String name)
    { 
propertySetName = name;
} 
public void propertyChange(PropertyChangeEvent e)
    { 
if(e.getPropertyName().equals(propertySetName))//1
{ 
buildModel();
} 
} 
public UMLRadioButtonPanel(String title,
                               List<String[]> labeltextsActioncommands,
                               String thePropertySetName,
                               Action setAction,
                               boolean horizontal)
    { 
this(true, title, labeltextsActioncommands,
             thePropertySetName, setAction, horizontal);
} 
public String getPropertySetName()
    { 
return propertySetName;
} 
private static List<String[]> toList(Map<String, String> map)
    { 
List<String[]> list = new ArrayList<String[]>();
for (Map.Entry<String, String> entry : map.entrySet()) //1
{ 
list.add(new String[] {entry.getKey(), entry.getValue()});
} 
return list;
} 

 } 
