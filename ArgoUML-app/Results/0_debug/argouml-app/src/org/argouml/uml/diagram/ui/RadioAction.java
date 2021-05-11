
//#if 1925480893 
// Compilation Unit of /RadioAction.java 
 

//#if -289899424 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 356583399 
import javax.swing.Action;
//#endif 


//#if 1518367364 
import javax.swing.Icon;
//#endif 


//#if -1497080203 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if 2033564091 
import org.tigris.gef.base.Editor;
//#endif 


//#if 766423390 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1915208356 
import org.tigris.toolbar.toolbutton.AbstractButtonAction;
//#endif 


//#if 1612090611 
public class RadioAction extends 
//#if 1823376287 
AbstractButtonAction
//#endif 

  { 

//#if 9721283 
private Action realAction;
//#endif 


//#if -1140602503 
public Action getAction()
    { 

//#if -1318543328 
return realAction;
//#endif 

} 

//#endif 


//#if 1173868296 
public RadioAction(Action action)
    { 

//#if -1514925900 
super((String) action.getValue(Action.NAME),
              (Icon) action.getValue(Action.SMALL_ICON));
//#endif 


//#if -1697288527 
putValue(Action.SHORT_DESCRIPTION,
                 action.getValue(Action.SHORT_DESCRIPTION));
//#endif 


//#if 471669803 
realAction = action;
//#endif 

} 

//#endif 


//#if -623467863 
public void actionPerformed(java.awt.event.ActionEvent actionEvent)
    { 

//#if -1934590079 
UMLDiagram diagram = (UMLDiagram) DiagramUtils.getActiveDiagram();
//#endif 


//#if -102325159 
if(Globals.getSticky() && diagram.getSelectedAction() == this)//1
{ 

//#if 973307484 
Globals.setSticky(false);
//#endif 


//#if 1437348522 
diagram.deselectAllTools();
//#endif 


//#if 303363419 
Editor ce = Globals.curEditor();
//#endif 


//#if -249132102 
if(ce != null)//1
{ 

//#if -1009871688 
ce.finishMode();
//#endif 

} 

//#endif 


//#if 176849645 
return;
//#endif 

} 

//#endif 


//#if 2297250 
super.actionPerformed(actionEvent);
//#endif 


//#if 1972924865 
realAction.actionPerformed(actionEvent);
//#endif 


//#if -1085668829 
diagram.setSelectedAction(this);
//#endif 


//#if -718629278 
Globals.setSticky(isDoubleClick());
//#endif 


//#if 1425040125 
if(!isDoubleClick())//1
{ 

//#if 1320305006 
Editor ce = Globals.curEditor();
//#endif 


//#if 1625302285 
if(ce != null)//1
{ 

//#if -1192805833 
ce.finishMode();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

