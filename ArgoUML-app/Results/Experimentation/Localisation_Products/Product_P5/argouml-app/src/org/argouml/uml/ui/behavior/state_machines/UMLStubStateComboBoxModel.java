package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
import java.util.ArrayList;
import java.util.Iterator;
public class UMLStubStateComboBoxModel extends UMLComboBoxModel2
  { 
protected void buildModelList()
    { 
removeAllElements();
Object stateMachine = null;
if(Model.getFacade().isASubmachineState(
                    Model.getFacade().getContainer(getTarget())))//1
{ 
stateMachine = Model.getFacade().getSubmachine(
                               Model.getFacade().getContainer(getTarget()));
} 
if(stateMachine != null)//1
{ 
ArrayList v = (ArrayList) Model.getStateMachinesHelper()
                          .getAllPossibleSubvertices(
                              Model.getFacade().getTop(stateMachine));
ArrayList v2 = (ArrayList) v.clone();
Iterator it = v2.iterator();
while (it.hasNext()) //1
{ 
Object o = it.next();
if(!isValidElement(o))//1
{ 
v.remove(o);
} 
} 
setElements(v);
} 
} 
public UMLStubStateComboBoxModel()
    { 
super("stubstate", true);
} 
protected Object getSelectedModelElement()
    { 
String objectName = null;
Object container = null;
if(getTarget() != null)//1
{ 
objectName = Model.getFacade().getReferenceState(getTarget());
container = Model.getFacade().getContainer(getTarget());
if(container != null
                    && Model.getFacade().isASubmachineState(container)
                    && Model.getFacade().getSubmachine(container) != null)//1
{ 
return Model.getStateMachinesHelper()
                       .getStatebyName(objectName,
                                       Model.getFacade().getTop(Model.getFacade()
                                               .getSubmachine(container)));
} 
} 
return null;
} 
protected boolean isValidElement(Object element)
    { 
return (Model.getFacade().isAStateVertex(element)
                && !Model.getFacade().isAConcurrentRegion(element)
                && Model.getFacade().getName(element) != null);
} 

 } 
