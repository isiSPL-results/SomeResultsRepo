
//#if 405676306 
// Compilation Unit of /UMLStateExitListModel.java 
 

//#if -848685505 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1281775274 
import org.argouml.model.Model;
//#endif 


//#if 1750377614 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 406408542 
public class UMLStateExitListModel extends 
//#if 455944925 
UMLModelElementListModel2
//#endif 

  { 

//#if -562204981 
protected void buildModelList()
    { 

//#if 7115227 
removeAllElements();
//#endif 


//#if 666923681 
addElement(Model.getFacade().getExit(getTarget()));
//#endif 

} 

//#endif 


//#if 1576886527 
protected boolean isValidElement(Object element)
    { 

//#if 1638548155 
return element == Model.getFacade().getExit(getTarget());
//#endif 

} 

//#endif 


//#if 1148036631 
public UMLStateExitListModel()
    { 

//#if 59169655 
super("exit");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

