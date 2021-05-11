
//#if -397611308 
// Compilation Unit of /UMLStubStateComboBoxModel.java 
 

//#if 393195051 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1563520834 
import org.argouml.model.Model;
//#endif 


//#if 829608726 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1652915538 
import java.util.ArrayList;
//#endif 


//#if -1764604161 
import java.util.Iterator;
//#endif 


//#if 1382792375 
public class UMLStubStateComboBoxModel extends 
//#if 2100961021 
UMLComboBoxModel2
//#endif 

  { 

//#if 1519745119 
protected void buildModelList()
    { 

//#if 851614904 
removeAllElements();
//#endif 


//#if 1646675070 
Object stateMachine = null;
//#endif 


//#if 2112344143 
if(Model.getFacade().isASubmachineState(
                    Model.getFacade().getContainer(getTarget())))//1
{ 

//#if 534070985 
stateMachine = Model.getFacade().getSubmachine(
                               Model.getFacade().getContainer(getTarget()));
//#endif 

} 

//#endif 


//#if -1518730758 
if(stateMachine != null)//1
{ 

//#if -38871912 
ArrayList v = (ArrayList) Model.getStateMachinesHelper()
                          .getAllPossibleSubvertices(
                              Model.getFacade().getTop(stateMachine));
//#endif 


//#if 681779197 
ArrayList v2 = (ArrayList) v.clone();
//#endif 


//#if -1623949962 
Iterator it = v2.iterator();
//#endif 


//#if 363165170 
while (it.hasNext()) //1
{ 

//#if -1160405919 
Object o = it.next();
//#endif 


//#if -1659476294 
if(!isValidElement(o))//1
{ 

//#if -1839213771 
v.remove(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1451385967 
setElements(v);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1350388952 
public UMLStubStateComboBoxModel()
    { 

//#if -47365970 
super("stubstate", true);
//#endif 

} 

//#endif 


//#if 486791093 
protected Object getSelectedModelElement()
    { 

//#if -301211045 
String objectName = null;
//#endif 


//#if -2061578480 
Object container = null;
//#endif 


//#if -618646191 
if(getTarget() != null)//1
{ 

//#if -342687392 
objectName = Model.getFacade().getReferenceState(getTarget());
//#endif 


//#if 1003332738 
container = Model.getFacade().getContainer(getTarget());
//#endif 


//#if -782656581 
if(container != null
                    && Model.getFacade().isASubmachineState(container)
                    && Model.getFacade().getSubmachine(container) != null)//1
{ 

//#if -832593105 
return Model.getStateMachinesHelper()
                       .getStatebyName(objectName,
                                       Model.getFacade().getTop(Model.getFacade()
                                               .getSubmachine(container)));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1050262469 
return null;
//#endif 

} 

//#endif 


//#if 1159185043 
protected boolean isValidElement(Object element)
    { 

//#if 1198442410 
return (Model.getFacade().isAStateVertex(element)
                && !Model.getFacade().isAConcurrentRegion(element)
                && Model.getFacade().getName(element) != null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

