
//#if 1782257619 
// Compilation Unit of /UMLCommentAnnotatedElementListModel.java 
 

//#if 1635953672 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1775780867 
import org.argouml.model.Model;
//#endif 


//#if -8820735 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if 1538064023 
public class UMLCommentAnnotatedElementListModel extends 
//#if 2013050402 
UMLModelElementListModel2
//#endif 

  { 

//#if -430190704 
protected void buildModelList()
    { 

//#if 1618475837 
if(getTarget() != null)//1
{ 

//#if -1828782503 
setAllElements(Model.getFacade().getAnnotatedElements(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1345087548 
protected boolean isValidElement(Object element)
    { 

//#if -1994502809 
return Model.getFacade().isAModelElement(element)
               && Model.getFacade().getAnnotatedElements(getTarget())
               .contains(element);
//#endif 

} 

//#endif 


//#if 465757608 
public UMLCommentAnnotatedElementListModel()
    { 

//#if 193377843 
super("annotatedElement");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

