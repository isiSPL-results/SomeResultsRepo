
//#if 1687719648 
// Compilation Unit of /UMLExtendBaseListModel.java 
 

//#if 727569648 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -1428223816 
import org.argouml.model.Model;
//#endif 


//#if 1034032748 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 634788156 
public class UMLExtendBaseListModel extends 
//#if -1071293220 
UMLModelElementListModel2
//#endif 

  { 

//#if -1437622914 
protected boolean isValidElement(Object element)
    { 

//#if -1969429555 
return Model.getFacade().isAUseCase(element);
//#endif 

} 

//#endif 


//#if 134121802 
protected void buildModelList()
    { 

//#if -1796326613 
if(!isEmpty())//1
{ 

//#if -765752442 
removeAllElements();
//#endif 

} 

//#endif 


//#if -2006670408 
addElement(Model.getFacade().getBase(getTarget()));
//#endif 

} 

//#endif 


//#if -724419960 
public UMLExtendBaseListModel()
    { 

//#if 333216196 
super("base");
//#endif 


//#if -1259939997 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

