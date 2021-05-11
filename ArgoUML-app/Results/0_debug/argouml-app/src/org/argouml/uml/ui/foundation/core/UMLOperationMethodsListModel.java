
//#if 1161515409 
// Compilation Unit of /UMLOperationMethodsListModel.java 
 

//#if 1438471741 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -937168999 
import java.util.Collection;
//#endif 


//#if -1597975112 
import org.argouml.model.Model;
//#endif 


//#if -2066585236 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -364666884 
public class UMLOperationMethodsListModel extends 
//#if 1803341964 
UMLModelElementListModel2
//#endif 

  { 

//#if -1544801180 
private static final long serialVersionUID = -6905298765859760688L;
//#endif 


//#if 1122793560 
public UMLOperationMethodsListModel()
    { 

//#if 1209366516 
super("method");
//#endif 

} 

//#endif 


//#if -1550296786 
protected boolean isValidElement(Object element)
    { 

//#if -1328028944 
Collection methods = null;
//#endif 


//#if -415762811 
Object target = getTarget();
//#endif 


//#if 775150298 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if -701399815 
methods = Model.getFacade().getMethods(target);
//#endif 

} 

//#endif 


//#if 1678331058 
return (methods != null) && methods.contains(element);
//#endif 

} 

//#endif 


//#if -1911249670 
protected void buildModelList()
    { 

//#if 133428983 
if(getTarget() != null)//1
{ 

//#if -211406041 
Collection methods = null;
//#endif 


//#if -1082977028 
Object target = getTarget();
//#endif 


//#if 1657673681 
if(Model.getFacade().isAOperation(target))//1
{ 

//#if 1519571306 
methods = Model.getFacade().getMethods(target);
//#endif 

} 

//#endif 


//#if 6562742 
setAllElements(methods);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

