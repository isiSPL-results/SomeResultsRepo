
//#if 1044006795 
// Compilation Unit of /UMLModelElementConstraintListModel.java 
 

//#if 1706047770 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -793551851 
import org.argouml.model.Model;
//#endif 


//#if -26972369 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1001840410 
public class UMLModelElementConstraintListModel extends 
//#if -1734780273 
UMLModelElementListModel2
//#endif 

  { 

//#if -221928546 
protected boolean isValidElement(Object o)
    { 

//#if 1527949717 
return Model.getFacade().isAConstraint(o)
               && Model.getFacade().getConstraints(getTarget()).contains(o);
//#endif 

} 

//#endif 


//#if 1711699325 
protected void buildModelList()
    { 

//#if -463175525 
if(getTarget() != null)//1
{ 

//#if 1748474993 
setAllElements(Model.getFacade().getConstraints(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1862726864 
public UMLModelElementConstraintListModel()
    { 

//#if -33289565 
super("constraint");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

