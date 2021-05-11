
//#if -1968279051 
// Compilation Unit of /UMLStateVertexIncomingListModel.java 
 

//#if 32860817 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -527004744 
import java.util.ArrayList;
//#endif 


//#if 900258472 
import org.argouml.model.Model;
//#endif 


//#if -986457476 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 187735844 
public class UMLStateVertexIncomingListModel extends 
//#if 1974626527 
UMLModelElementListModel2
//#endif 

  { 

//#if 1539641613 
public UMLStateVertexIncomingListModel()
    { 

//#if 1809846208 
super("incoming");
//#endif 

} 

//#endif 


//#if -665855027 
protected void buildModelList()
    { 

//#if -1631735179 
ArrayList c =
            new ArrayList(Model.getFacade().getIncomings(getTarget()));
//#endif 


//#if -275444969 
if(Model.getFacade().isAState(getTarget()))//1
{ 

//#if -127611717 
ArrayList i =
                new ArrayList(
                Model.getFacade().getInternalTransitions(getTarget()));
//#endif 


//#if -433891464 
c.removeAll(i);
//#endif 

} 

//#endif 


//#if -459995216 
setAllElements(c);
//#endif 

} 

//#endif 


//#if 1755941377 
protected boolean isValidElement(Object element)
    { 

//#if -1915179793 
ArrayList c =
            new ArrayList(Model.getFacade().getIncomings(getTarget()));
//#endif 


//#if 955240925 
if(Model.getFacade().isAState(getTarget()))//1
{ 

//#if -791393120 
ArrayList i =
                new ArrayList(
                Model.getFacade().getInternalTransitions(getTarget()));
//#endif 


//#if -1895530659 
c.removeAll(i);
//#endif 

} 

//#endif 


//#if -1360722477 
return c.contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

