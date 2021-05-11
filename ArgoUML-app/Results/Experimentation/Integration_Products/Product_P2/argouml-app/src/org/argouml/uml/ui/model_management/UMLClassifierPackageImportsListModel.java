package org.argouml.uml.ui.model_management;
import java.beans.PropertyChangeEvent;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementListModel2;
class UMLClassifierPackageImportsListModel extends UMLModelElementListModel2
  { 
public UMLClassifierPackageImportsListModel()
    { 
super("elementImport");
} 
protected boolean isValidElement(Object elem)
    { 
if(!Model.getFacade().isAElementImport(elem))//1
{ 
return false;
} 
return Model.getFacade().getPackage(elem) == getTarget();
} 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getImportedElements(getTarget()));
} 
public void propertyChange(PropertyChangeEvent e)
    { 
if(isValidEvent(e))//1
{ 
removeAllElements();
setBuildingModel(true);
buildModelList();
setBuildingModel(false);
if(getSize() > 0)//1
{ 
fireIntervalAdded(this, 0, getSize() - 1);
} 
} 
} 

 } 
