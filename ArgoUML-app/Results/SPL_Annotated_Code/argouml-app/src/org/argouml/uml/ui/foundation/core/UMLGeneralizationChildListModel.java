// Compilation Unit of /UMLGeneralizationChildListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
public class UMLGeneralizationChildListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object o)
    { 
return (Model.getFacade().getSpecific(getTarget()) == o);
} 

public UMLGeneralizationChildListModel()
    { 
super("child");
} 

protected void buildModelList()
    { 
if(getTarget() == null)//1
{ 
return;
} 

removeAllElements();
addElement(Model.getFacade().getSpecific(getTarget()));
} 

 } 


