package org.argouml.uml.ui.behavior.use_cases;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
public class UMLExtendExtensionPointListModel extends UMLModelElementOrderedListModel2
  { 
protected void moveDown(int index1)
    { 
int index2 = index1 + 1;
Object extend = getTarget();
List c = (List) Model.getFacade().getExtensionPoints(extend);
Object mem1 = c.get(index1);
Model.getUseCasesHelper().removeExtensionPoint(extend, mem1);
Model.getUseCasesHelper().addExtensionPoint(extend, index2, mem1);
} 
protected void buildModelList()
    { 
setAllElements(Model.getFacade().getExtensionPoints(getTarget()));
} 
@Override
    protected void moveToTop(int index)
    { 
Object extend = getTarget();
List c = (List) Model.getFacade().getExtensionPoints(extend);
if(index > 0)//1
{ 
Object mem1 = c.get(index);
Model.getUseCasesHelper().removeExtensionPoint(extend, mem1);
Model.getUseCasesHelper().addExtensionPoint(extend, 0, mem1);
} 
} 
@Override
    protected void moveToBottom(int index)
    { 
Object extend = getTarget();
List c = (List) Model.getFacade().getExtensionPoints(extend);
if(index < c.size() - 1)//1
{ 
Object mem1 = c.get(index);
Model.getUseCasesHelper().removeExtensionPoint(extend, mem1);
Model.getUseCasesHelper().addExtensionPoint(extend, c.size(), mem1);
} 
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAExtensionPoint(o)
               && Model.getFacade().getExtensionPoints(getTarget()).contains(o);
} 
public UMLExtendExtensionPointListModel()
    { 
super("extensionPoint");
} 

 } 
