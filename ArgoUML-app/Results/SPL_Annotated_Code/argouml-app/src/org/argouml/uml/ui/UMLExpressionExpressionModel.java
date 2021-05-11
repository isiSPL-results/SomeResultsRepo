// Compilation Unit of /UMLExpressionExpressionModel.java 
 
package org.argouml.uml.ui;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
public class UMLExpressionExpressionModel extends UMLExpressionModel2
  { 
public Object newExpression()
    { 
return Model.getDataTypesFactory().createBooleanExpression("", "");
} 

public UMLExpressionExpressionModel(UMLUserInterfaceContainer c,
                                        String name)
    { 
super(c, name);
} 

public void setExpression(Object expr)
    { 
Model.getStateMachinesHelper()
        .setExpression(TargetManager.getInstance().getTarget(), expr);
} 

public Object getExpression()
    { 
return Model.getFacade().getExpression(
                   TargetManager.getInstance().getTarget());
} 

 } 


