
//#if -634226474 
// Compilation Unit of /UMLChangeExpressionModel.java 
 

//#if -230333273 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1915686987 
import org.apache.log4j.Logger;
//#endif 


//#if -531743810 
import org.argouml.model.Model;
//#endif 


//#if -1702786844 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 2910527 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if 2130415661 
import org.argouml.uml.ui.UMLUserInterfaceContainer;
//#endif 


//#if 718111296 
class UMLChangeExpressionModel extends 
//#if -522193671 
UMLExpressionModel2
//#endif 

  { 

//#if 124288767 
private static final Logger LOG =
        Logger.getLogger(UMLChangeExpressionModel.class);
//#endif 


//#if 782046357 
public Object newExpression()
    { 

//#if 1946846888 
LOG.debug("new boolean expression");
//#endif 


//#if -1439601262 
return Model.getDataTypesFactory().createBooleanExpression("", "");
//#endif 

} 

//#endif 


//#if 339287548 
public UMLChangeExpressionModel(UMLUserInterfaceContainer container,
                                    String propertyName)
    { 

//#if -229552125 
super(container, propertyName);
//#endif 

} 

//#endif 


//#if -300672693 
public Object getExpression()
    { 

//#if 307828946 
return Model.getFacade().getChangeExpression(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if -696892949 
public void setExpression(Object expression)
    { 

//#if -997415197 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 77530874 
if(target == null)//1
{ 

//#if -1339356899 
throw new IllegalStateException("There is no target for "
                                            + getContainer());
//#endif 

} 

//#endif 


//#if 1340564293 
Model.getStateMachinesHelper().setChangeExpression(target, expression);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

