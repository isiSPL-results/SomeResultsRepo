
//#if -345979267 
// Compilation Unit of /StylePanel.java 
 

//#if -587306013 
package org.argouml.ui;
//#endif 


//#if 1135115235 
import java.awt.event.ActionEvent;
//#endif 


//#if 691158981 
import java.awt.event.ActionListener;
//#endif 


//#if 1878063616 
import java.awt.event.ItemEvent;
//#endif 


//#if 1899901064 
import java.awt.event.ItemListener;
//#endif 


//#if 1564670681 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1216008036 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 704455788 
import javax.swing.event.DocumentListener;
//#endif 


//#if -835747249 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -1070165543 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if 1138722163 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -272176910 
import org.argouml.i18n.Translator;
//#endif 


//#if -1669989192 
import org.argouml.model.Model;
//#endif 


//#if -1257452707 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1180879479 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1374750105 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -21496145 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 791714718 
import org.tigris.swidgets.LabelledLayout;
//#endif 


//#if 777441605 
import org.apache.log4j.Logger;
//#endif 


//#if 74868003 
public class StylePanel extends 
//#if -1095785877 
AbstractArgoJPanel
//#endif 

 implements 
//#if 360842710 
TabFigTarget
//#endif 

, 
//#if 475592733 
ItemListener
//#endif 

, 
//#if 797391653 
DocumentListener
//#endif 

, 
//#if -1200811284 
ListSelectionListener
//#endif 

, 
//#if -292146496 
ActionListener
//#endif 

  { 

//#if 409224125 
private Fig panelTarget;
//#endif 


//#if -812953682 
private static final long serialVersionUID = 2183676111107689482L;
//#endif 


//#if -354838773 
private static final Logger LOG = Logger.getLogger(StylePanel.class);
//#endif 


//#if -925601738 
public StylePanel(String tag)
    { 

//#if -2103394948 
super(Translator.localize(tag));
//#endif 


//#if 1578234709 
setLayout(new LabelledLayout());
//#endif 

} 

//#endif 


//#if 672258497 
public void targetRemoved(TargetEvent e)
    { 

//#if -1026783180 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 395659596 
protected Fig getPanelTarget()
    { 

//#if -1847343967 
return panelTarget;
//#endif 

} 

//#endif 


//#if 1813674601 
public void refresh()
    { 
} 

//#endif 


//#if -189122356 
public void itemStateChanged(ItemEvent e)
    { 
} 

//#endif 


//#if 1494705051 
public void removeUpdate(DocumentEvent e)
    { 

//#if -429210265 
insertUpdate(e);
//#endif 

} 

//#endif 


//#if -766142111 
public void targetAdded(TargetEvent e)
    { 

//#if 1388546476 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1426444221 
public void targetSet(TargetEvent e)
    { 

//#if -911051518 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -608378134 
public Object getTarget()
    { 

//#if 128004026 
return panelTarget;
//#endif 

} 

//#endif 


//#if 460120563 
protected final void addSeperator()
    { 

//#if -1608448001 
add(LabelledLayout.getSeperator());
//#endif 

} 

//#endif 


//#if 1846542537 
public void valueChanged(ListSelectionEvent lse)
    { 
} 

//#endif 


//#if 2049536627 
public boolean shouldBeEnabled(Object target)
    { 

//#if -49666369 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if 1252383728 
target =
            (target instanceof Fig) ? target : diagram.getContainingFig(target);
//#endif 


//#if 97479929 
return (target instanceof Fig);
//#endif 

} 

//#endif 


//#if 799959056 
public void insertUpdate(DocumentEvent e)
    { 

//#if 1424670408 
LOG.debug(getClass().getName() + " insert");
//#endif 

} 

//#endif 


//#if -1593286395 
public void changedUpdate(DocumentEvent e)
    { 
} 

//#endif 


//#if 407584796 
public void setTarget(Object t)
    { 

//#if 1958498349 
if(!(t instanceof Fig))//1
{ 

//#if -884470574 
if(Model.getFacade().isAUMLElement(t))//1
{ 

//#if 1468079071 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1437916501 
if(diagram != null)//1
{ 

//#if -660818076 
t = diagram.presentationFor(t);
//#endif 

} 

//#endif 


//#if 860868659 
if(!(t instanceof Fig))//1
{ 

//#if 1678622172 
return;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 340908025 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1062496378 
panelTarget = (Fig) t;
//#endif 


//#if 881594161 
refresh();
//#endif 

} 

//#endif 


//#if 190487801 
public void refresh(PropertyChangeEvent e)
    { 

//#if 380243439 
refresh();
//#endif 

} 

//#endif 


//#if 824137650 
public void actionPerformed(ActionEvent ae)
    { 
} 

//#endif 

 } 

//#endif 


//#endif 

