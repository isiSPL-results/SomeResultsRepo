
//#if -1755935053 
// Compilation Unit of /UMLScriptExpressionModel.java 
 

//#if -958316240 
package org.argouml.uml.ui;
//#endif 


//#if -821632865 
import org.argouml.model.Model;
//#endif 


//#if 1130090083 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1168635259 
public class UMLScriptExpressionModel extends 
//#if 2098629141 
UMLExpressionModel2
//#endif 

  { 

//#if 6410855 
public Object getExpression()
    { 

//#if -657084403 
return Model.getFacade().getScript(
                   TargetManager.getInstance().getTarget());
//#endif 

} 

//#endif 


//#if 1386275059 
public UMLScriptExpressionModel(UMLUserInterfaceContainer container,
                                    String propertyName)
    { 

//#if 731132458 
super(container, propertyName);
//#endif 

} 

//#endif 


//#if 1089129905 
public Object newExpression()
    { 

//#if -1055255552 
return Model.getDataTypesFactory().createActionExpression("", "");
//#endif 

} 

//#endif 


//#if -1043604985 
public void setExpression(Object expression)
    { 

//#if 1723685721 
Model.getCommonBehaviorHelper()
        .setScript(TargetManager.getInstance().getTarget(), expression);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

