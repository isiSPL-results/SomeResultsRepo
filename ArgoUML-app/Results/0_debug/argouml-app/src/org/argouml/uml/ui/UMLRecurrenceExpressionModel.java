
//#if -278729861 
// Compilation Unit of /UMLRecurrenceExpressionModel.java 
 

//#if 419864549 
package org.argouml.uml.ui;
//#endif 


//#if 1327804769 
import org.apache.log4j.Logger;
//#endif 


//#if -1119626028 
import org.argouml.model.Model;
//#endif 


//#if 388412430 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -2119519903 
public class UMLRecurrenceExpressionModel extends 
//#if 1433918402 
UMLExpressionModel2
//#endif 

  { 

//#if 1657119624 
private static final Logger LOG =
        Logger.getLogger(UMLRecurrenceExpressionModel.class);
//#endif 


//#if 1666075141 
public UMLRecurrenceExpressionModel(UMLUserInterfaceContainer container,
                                        String propertyName)
    { 

//#if -1018939457 
super(container, propertyName);
//#endif 

} 

//#endif 


//#if 27927134 
public Object newExpression()
    { 

//#if 37655471 
LOG.debug("new boolean expression");
//#endif 


//#if -1593258528 
return Model.getDataTypesFactory().createIterationExpression("", "");
//#endif 

} 

//#endif 


//#if -2140210188 
public void setExpression(Object expression)
    { 

//#if 1757238060 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -374041213 
if(target == null)//1
{ 

//#if 586841604 
throw new IllegalStateException("There is no target for "
                                            + getContainer());
//#endif 

} 

//#endif 


//#if -998004554 
Model.getCommonBehaviorHelper().setRecurrence(target, expression);
//#endif 

} 

//#endif 


//#if -1054791916 
public Object getExpression()
    { 

//#if -1885797475 
return Model.getFacade().getRecurrence(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

