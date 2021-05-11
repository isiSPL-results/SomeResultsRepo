
//#if 1792160127 
// Compilation Unit of /UMLClassifierPackageImportsListModel.java 
 

//#if 2013315611 
package org.argouml.uml.ui.model_management;
//#endif 


//#if 926178990 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -82964861 
import org.argouml.model.Model;
//#endif 


//#if 2038640001 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 244421276 
class UMLClassifierPackageImportsListModel extends 
//#if 1224446782 
UMLModelElementListModel2
//#endif 

  { 

//#if 562904104 
public UMLClassifierPackageImportsListModel()
    { 

//#if 363242208 
super("elementImport");
//#endif 

} 

//#endif 


//#if -836977369 
protected boolean isValidElement(Object elem)
    { 

//#if -1289298313 
if(!Model.getFacade().isAElementImport(elem))//1
{ 

//#if 1777808458 
return false;
//#endif 

} 

//#endif 


//#if -1294254206 
return Model.getFacade().getPackage(elem) == getTarget();
//#endif 

} 

//#endif 


//#if 875478700 
protected void buildModelList()
    { 

//#if 1023484911 
setAllElements(Model.getFacade().getImportedElements(getTarget()));
//#endif 

} 

//#endif 


//#if -1599379037 
public void propertyChange(PropertyChangeEvent e)
    { 

//#if 1227063296 
if(isValidEvent(e))//1
{ 

//#if -1760622069 
removeAllElements();
//#endif 


//#if 315518608 
setBuildingModel(true);
//#endif 


//#if 1107240060 
buildModelList();
//#endif 


//#if 1156459589 
setBuildingModel(false);
//#endif 


//#if -1372000532 
if(getSize() > 0)//1
{ 

//#if -1469454029 
fireIntervalAdded(this, 0, getSize() - 1);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

