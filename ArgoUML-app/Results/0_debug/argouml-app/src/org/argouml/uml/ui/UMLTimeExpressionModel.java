
//#if -1686700031 
// Compilation Unit of /UMLTimeExpressionModel.java 
 

//#if -293525775 
package org.argouml.uml.ui;
//#endif 


//#if 1185731181 
import org.apache.log4j.Logger;
//#endif 


//#if -1261699616 
import org.argouml.model.Model;
//#endif 


//#if 1524039554 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 390451096 
public class UMLTimeExpressionModel extends 
//#if 1222996430 
UMLExpressionModel2
//#endif 

  { 

//#if 1144424855 
private static final Logger LOG =
        Logger.getLogger(UMLTimeExpressionModel.class);
//#endif 


//#if 63828256 
public Object getExpression()
    { 

//#if -1664015477 
return Model.getFacade().getWhen(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if 1146547306 
public Object newExpression()
    { 

//#if -589872078 
LOG.debug("new time expression");
//#endif 


//#if -133683736 
return Model.getDataTypesFactory().createTimeExpression("", "");
//#endif 

} 

//#endif 


//#if -29671168 
public void setExpression(Object expression)
    { 

//#if 402076676 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -520999845 
if(target == null)//1
{ 

//#if -916335173 
throw new IllegalStateException("There is no target for "
                                            + getContainer());
//#endif 

} 

//#endif 


//#if 772295318 
Model.getStateMachinesHelper().setWhen(target, expression);
//#endif 

} 

//#endif 


//#if -21178386 
public UMLTimeExpressionModel(UMLUserInterfaceContainer container,
                                  String propertyName)
    { 

//#if -1103295841 
super(container, propertyName);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

