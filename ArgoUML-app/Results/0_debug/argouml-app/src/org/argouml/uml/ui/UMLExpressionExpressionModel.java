
//#if 13738943 
// Compilation Unit of /UMLExpressionExpressionModel.java 
 

//#if 2116752040 
package org.argouml.uml.ui;
//#endif 


//#if 1100690967 
import org.argouml.model.Model;
//#endif 


//#if -799943189 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -137765098 
public class UMLExpressionExpressionModel extends 
//#if -537528652 
UMLExpressionModel2
//#endif 

  { 

//#if 1243556688 
public Object newExpression()
    { 

//#if -1232586903 
return Model.getDataTypesFactory().createBooleanExpression("", "");
//#endif 

} 

//#endif 


//#if -939791722 
public UMLExpressionExpressionModel(UMLUserInterfaceContainer c,
                                        String name)
    { 

//#if -1495701829 
super(c, name);
//#endif 

} 

//#endif 


//#if 1266335081 
public void setExpression(Object expr)
    { 

//#if 1077019582 
Model.getStateMachinesHelper()
        .setExpression(TargetManager.getInstance().getTarget(), expr);
//#endif 

} 

//#endif 


//#if 160837638 
public Object getExpression()
    { 

//#if 707401479 
return Model.getFacade().getExpression(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

