// Compilation Unit of /UMLIncludeAdditionListModel.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
public class UMLIncludeAdditionListModel extends UMLIncludeListModel
  { 
public UMLIncludeAdditionListModel()
    { 
super("addition");
} 

protected void buildModelList()
    { 
super.buildModelList();
addElement(Model.getFacade().getAddition(getTarget()));
} 

 } 


