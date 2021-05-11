// Compilation Unit of /UMLAttributeInitialValueListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLAttributeInitialValueListModel extends UMLModelElementListModel2
  { 
public UMLAttributeInitialValueListModel()
    { 
super("initialValue");
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
removeAllElements();
addElement(Model.getFacade().getInitialValue(getTarget()));
} 

} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().getInitialValue(getTarget()) == element;
} 

 } 


