
//#if -1722605807 
// Compilation Unit of /UMLTransitionStatemachineListModel.java 
 

//#if 1616344441 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 2017421712 
import org.argouml.model.Model;
//#endif 


//#if 856894612 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1669544932 
public class UMLTransitionStatemachineListModel extends 
//#if -858292189 
UMLModelElementListModel2
//#endif 

  { 

//#if -500218847 
public UMLTransitionStatemachineListModel()
    { 

//#if -1268550887 
super("statemachine");
//#endif 

} 

//#endif 


//#if -771860667 
protected boolean isValidElement(Object element)
    { 

//#if -1359746344 
return Model.getFacade().getStateMachine(getTarget()) == element;
//#endif 

} 

//#endif 


//#if 1557115153 
protected void buildModelList()
    { 

//#if 167743258 
removeAllElements();
//#endif 


//#if -334253014 
addElement(Model.getFacade().getStateMachine(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

