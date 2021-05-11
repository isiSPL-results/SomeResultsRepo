// Compilation Unit of /UMLContainerResidentListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLContainerResidentListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object o)
    { 
return (Model.getFacade().isAComponent(o)
                || Model.getFacade().isAInstance(o));
} 

protected void buildModelList()
    { 
setAllElements(Model.getFacade().getResidents(getTarget()));
} 

public UMLContainerResidentListModel()
    { 
super("resident");
} 

 } 


