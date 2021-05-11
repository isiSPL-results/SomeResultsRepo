package org.argouml.ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.presentation.Fig;
import org.tigris.swidgets.LabelledLayout;
public class StylePanel extends AbstractArgoJPanel
 implements TabFigTarget
,ItemListener
,DocumentListener
,ListSelectionListener
,ActionListener
  { 
private Fig panelTarget;
private static final long serialVersionUID = 2183676111107689482L;
public StylePanel(String tag)
    { 
super(Translator.localize(tag));
setLayout(new LabelledLayout());
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
protected Fig getPanelTarget()
    { 
return panelTarget;
} 
public void refresh()
    { 
} 
public void itemStateChanged(ItemEvent e)
    { 
} 
public void removeUpdate(DocumentEvent e)
    { 
insertUpdate(e);
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public Object getTarget()
    { 
return panelTarget;
} 
protected final void addSeperator()
    { 
add(LabelledLayout.getSeperator());
} 
public void valueChanged(ListSelectionEvent lse)
    { 
} 
public boolean shouldBeEnabled(Object target)
    { 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
target =
            (target instanceof Fig) ? target : diagram.getContainingFig(target);
return (target instanceof Fig);
} 
public void insertUpdate(DocumentEvent e)
    { 
} 
public void changedUpdate(DocumentEvent e)
    { 
} 
public void setTarget(Object t)
    { 
if(!(t instanceof Fig))//1
{ 
if(Model.getFacade().isAUMLElement(t))//1
{ 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
if(diagram != null)//1
{ 
t = diagram.presentationFor(t);
} 
if(!(t instanceof Fig))//1
{ 
return;
} 
} 
else
{ 
return;
} 
} 
panelTarget = (Fig) t;
refresh();
} 
public void refresh(PropertyChangeEvent e)
    { 
refresh();
} 
public void actionPerformed(ActionEvent ae)
    { 
} 

 } 
