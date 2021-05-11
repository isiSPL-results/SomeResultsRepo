
//#if -1224130384 
// Compilation Unit of /UMLConditionExpressionModel.java 
 

//#if -767494821 
package org.argouml.uml.ui;
//#endif 


//#if -1884595241 
import org.apache.log4j.Logger;
//#endif 


//#if -37058742 
import org.argouml.model.Model;
//#endif 


//#if 1238669784 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 622416396 
public class UMLConditionExpressionModel extends 
//#if -1537823864 
UMLExpressionModel2
//#endif 

  { 

//#if -1878486399 
private static final Logger LOG =
        Logger.getLogger(UMLConditionExpressionModel.class);
//#endif 


//#if 2013006970 
public UMLConditionExpressionModel(UMLUserInterfaceContainer container,
                                       String propertyName)
    { 

//#if -263688642 
super(container, propertyName);
//#endif 

} 

//#endif 


//#if -1791505372 
public Object newExpression()
    { 

//#if 1361248739 
LOG.debug("new boolean expression");
//#endif 


//#if -1142404361 
return Model.getDataTypesFactory().createBooleanExpression("", "");
//#endif 

} 

//#endif 


//#if 1420742874 
public Object getExpression()
    { 

//#if -738115920 
return Model.getFacade().getCondition(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if -1307241670 
public void setExpression(Object expression)
    { 

//#if -234156026 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -1672238883 
if(target == null)//1
{ 

//#if 364823403 
throw new IllegalStateException("There is no target for "
                                            + getContainer());
//#endif 

} 

//#endif 


//#if -1347836010 
Model.getUseCasesHelper().setCondition(target, expression);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

