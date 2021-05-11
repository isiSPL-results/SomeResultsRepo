
//#if -496485646 
// Compilation Unit of /UMLMessageActionListModel.java 
 

//#if -1621455207 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1592726532 
import org.argouml.model.Model;
//#endif 


//#if 1649037984 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -807900034 
public class UMLMessageActionListModel extends 
//#if -531667452 
UMLModelElementListModel2
//#endif 

  { 

//#if -2077245838 
protected void buildModelList()
    { 

//#if 1684002201 
removeAllElements();
//#endif 


//#if 2145703307 
addElement(Model.getFacade().getAction(getTarget()));
//#endif 

} 

//#endif 


//#if 461115169 
protected boolean isValidElement(Object elem)
    { 

//#if 809091068 
return Model.getFacade().isAAction(elem)
               && Model.getFacade().getAction(getTarget()) == elem;
//#endif 

} 

//#endif 


//#if -1512413008 
public UMLMessageActionListModel()
    { 

//#if -1244442996 
super("action");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

