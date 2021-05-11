// Compilation Unit of /UMLClassOperationListModel.java 
 
package org.argouml.uml.ui.foundation.core;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
public class UMLClassOperationListModel extends UMLModelElementOrderedListModel2
  { 
@Override
    protected void moveToTop(int index)
    { 
Object clss = getTarget();
List c = Model.getFacade().getOperationsAndReceptions(clss);
if(index > 0)//1
{ 
Object mem1 = c.get(index);
Model.getCoreHelper().removeFeature(clss, mem1);
Model.getCoreHelper().addFeature(clss, 0, mem1);
} 

} 

protected void moveDown(int index1)
    { 
int index2 = index1 + 1;
Object clss = getTarget();
List c = Model.getFacade().getOperationsAndReceptions(clss);
if(index1 < c.size() - 1)//1
{ 
Object op1 = c.get(index1);
Object op2 = c.get(index2);
List f = Model.getFacade().getFeatures(clss);
index2 = f.indexOf(op2);
Model.getCoreHelper().removeFeature(clss, op1);
Model.getCoreHelper().addFeature(clss, index2, op1);
} 

} 

public UMLClassOperationListModel()
    { 
super("feature");
} 

protected boolean isValidElement(Object element)
    { 
return (Model.getFacade().getOperationsAndReceptions(getTarget())
                .contains(element));
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
List opsAndReceps =
                Model.getFacade().getOperationsAndReceptions(getTarget());
setAllElements(opsAndReceps);
} 

} 

@Override
    protected void moveToBottom(int index)
    { 
Object clss = getTarget();
List c = Model.getFacade().getOperationsAndReceptions(clss);
if(index < c.size() - 1)//1
{ 
Object mem1 = c.get(index);
Model.getCoreHelper().removeFeature(clss, mem1);
Model.getCoreHelper().addFeature(clss, c.size() - 1, mem1);
} 

} 

 } 


