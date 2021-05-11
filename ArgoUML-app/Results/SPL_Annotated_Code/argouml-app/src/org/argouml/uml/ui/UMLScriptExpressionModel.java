// Compilation Unit of /UMLScriptExpressionModel.java 
 
package org.argouml.uml.ui;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
public class UMLScriptExpressionModel extends UMLExpressionModel2
  { 
public Object getExpression()
    { 
return Model.getFacade().getScript(
                   TargetManager.getInstance().getTarget());
} 

public UMLScriptExpressionModel(UMLUserInterfaceContainer container,
                                    String propertyName)
    { 
super(container, propertyName);
} 

public Object newExpression()
    { 
return Model.getDataTypesFactory().createActionExpression("", "");
} 

public void setExpression(Object expression)
    { 
Model.getCommonBehaviorHelper()
        .setScript(TargetManager.getInstance().getTarget(), expression);
} 

 } 


