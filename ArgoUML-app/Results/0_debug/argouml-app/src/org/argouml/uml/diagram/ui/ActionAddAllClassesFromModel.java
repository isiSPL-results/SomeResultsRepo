
//#if 607828209 
// Compilation Unit of /ActionAddAllClassesFromModel.java 
 

//#if -2011341879 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -688387864 
import java.awt.event.ActionEvent;
//#endif 


//#if 708315598 
import java.util.Iterator;
//#endif 


//#if -1907354157 
import org.argouml.model.Model;
//#endif 


//#if 1957938763 
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
//#endif 


//#if -317973928 
import org.argouml.uml.reveng.DiagramInterface;
//#endif 


//#if -955019065 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1109334146 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1579998948 
public class ActionAddAllClassesFromModel extends 
//#if -1633848097 
UndoableAction
//#endif 

  { 

//#if 1633894501 
private Object object;
//#endif 


//#if -1440591484 
public ActionAddAllClassesFromModel(String name, Object o)
    { 

//#if -1878418609 
super(name);
//#endif 


//#if -433092315 
object = o;
//#endif 

} 

//#endif 


//#if 450112135 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1580715962 
super.actionPerformed(ae);
//#endif 


//#if -667810540 
if(object instanceof UMLClassDiagram)//1
{ 

//#if 160969554 
DiagramInterface diagram =
                new DiagramInterface(Globals.curEditor());
//#endif 


//#if 593997038 
diagram.setCurrentDiagram((UMLClassDiagram) object);
//#endif 


//#if 975839416 
Object namespace = ((UMLClassDiagram) object).getNamespace();
//#endif 


//#if 1169855922 
Iterator elements =
                Model.getFacade().getOwnedElements(namespace).iterator();
//#endif 


//#if -1578008940 
while (elements.hasNext()) //1
{ 

//#if 485279192 
Object element = elements.next();
//#endif 


//#if -781711165 
if(Model.getFacade().isAClass(element)
                        && !Model.getFacade().isAAssociationClass(element))//1
{ 

//#if 1213486199 
diagram.addClass(element, false);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 509749732 
public boolean isEnabled()
    { 

//#if -1333827516 
return object instanceof UMLClassDiagram;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

