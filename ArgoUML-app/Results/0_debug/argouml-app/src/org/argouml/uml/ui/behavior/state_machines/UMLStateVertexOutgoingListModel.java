
//#if 41697765 
// Compilation Unit of /UMLStateVertexOutgoingListModel.java 
 

//#if 1998071585 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1693321144 
import java.util.ArrayList;
//#endif 


//#if 880508728 
import org.argouml.model.Model;
//#endif 


//#if -194465812 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1300430638 
public class UMLStateVertexOutgoingListModel extends 
//#if -695770206 
UMLModelElementListModel2
//#endif 

  { 

//#if -1511417974 
public UMLStateVertexOutgoingListModel()
    { 

//#if 1380913975 
super("outgoing");
//#endif 

} 

//#endif 


//#if 2094251280 
protected void buildModelList()
    { 

//#if 1986486098 
ArrayList c =
            new ArrayList(Model.getFacade().getOutgoings(getTarget()));
//#endif 


//#if 1239354208 
if(Model.getFacade().isAState(getTarget()))//1
{ 

//#if -668532585 
ArrayList i =
                new ArrayList(
                Model.getFacade().getInternalTransitions(getTarget()));
//#endif 


//#if -1217238188 
c.removeAll(i);
//#endif 

} 

//#endif 


//#if -40034439 
setAllElements(c);
//#endif 

} 

//#endif 


//#if 264275268 
protected boolean isValidElement(Object element)
    { 

//#if -1081398716 
ArrayList c =
            new ArrayList(Model.getFacade().getOutgoings(getTarget()));
//#endif 


//#if -2067519314 
if(Model.getFacade().isAState(getTarget()))//1
{ 

//#if -217019754 
ArrayList i =
                new ArrayList(
                Model.getFacade().getInternalTransitions(getTarget()));
//#endif 


//#if -383029933 
c.removeAll(i);
//#endif 

} 

//#endif 


//#if -276680924 
return c.contains(element);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

