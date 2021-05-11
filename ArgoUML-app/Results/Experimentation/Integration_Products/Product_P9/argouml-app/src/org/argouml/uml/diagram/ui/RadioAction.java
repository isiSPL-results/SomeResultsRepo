package org.argouml.uml.diagram.ui;
import javax.swing.Action;
import javax.swing.Icon;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.toolbar.toolbutton.AbstractButtonAction;
public class RadioAction extends AbstractButtonAction
  { 
private Action realAction;
public Action getAction()
    { 
return realAction;
} 
public RadioAction(Action action)
    { 
super((String) action.getValue(Action.NAME),
              (Icon) action.getValue(Action.SMALL_ICON));
putValue(Action.SHORT_DESCRIPTION,
                 action.getValue(Action.SHORT_DESCRIPTION));
realAction = action;
} 
public void actionPerformed(java.awt.event.ActionEvent actionEvent)
    { 
UMLDiagram diagram = (UMLDiagram) DiagramUtils.getActiveDiagram();
if(Globals.getSticky() && diagram.getSelectedAction() == this)//1
{ 
Globals.setSticky(false);
diagram.deselectAllTools();
Editor ce = Globals.curEditor();
if(ce != null)//1
{ 
ce.finishMode();
} 
return;
} 
super.actionPerformed(actionEvent);
realAction.actionPerformed(actionEvent);
diagram.setSelectedAction(this);
Globals.setSticky(isDoubleClick());
if(!isDoubleClick())//1
{ 
Editor ce = Globals.curEditor();
if(ce != null)//1
{ 
ce.finishMode();
} 
} 
} 

 } 
