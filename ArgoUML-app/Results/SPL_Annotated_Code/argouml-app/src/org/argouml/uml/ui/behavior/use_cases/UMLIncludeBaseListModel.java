// Compilation Unit of /UMLIncludeBaseListModel.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import org.argouml.model.Model;
public class UMLIncludeBaseListModel extends UMLIncludeListModel
  { 
protected void buildModelList()
    { 
super.buildModelList();
addElement(Model.getFacade().getBase(getTarget()));
} 

public UMLIncludeBaseListModel()
    { 
super("base");
} 

 } 


