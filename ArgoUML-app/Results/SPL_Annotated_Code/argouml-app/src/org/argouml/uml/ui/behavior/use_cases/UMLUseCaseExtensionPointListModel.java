// Compilation Unit of /UMLUseCaseExtensionPointListModel.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
public class UMLUseCaseExtensionPointListModel extends UMLModelElementOrderedListModel2
  { 
@Override
    protected void moveToTop(int index)
    { 
Object usecase = getTarget();
List c = new ArrayList(Model.getFacade().getExtensionPoints(usecase));
if(index > 0)//1
{ 
Object mem1 = c.get(index);
c.remove(mem1);
c.add(0, mem1);
Model.getUseCasesHelper().setExtensionPoints(usecase, c);
} 

} 

protected void buildModelList()
    { 
setAllElements(Model.getFacade().getExtensionPoints(getTarget()));
} 

@Override
    protected void moveToBottom(int index)
    { 
Object usecase = getTarget();
List c = new ArrayList(Model.getFacade().getExtensionPoints(usecase));
if(index < c.size() - 1)//1
{ 
Object mem1 = c.get(index);
c.remove(mem1);
c.add(c.size(), mem1);
Model.getUseCasesHelper().setExtensionPoints(usecase, c);
} 

} 

protected void moveDown(int index)
    { 
Object usecase = getTarget();
List c = new ArrayList(Model.getFacade().getExtensionPoints(usecase));
if(index < c.size() - 1)//1
{ 
Collections.swap(c, index, index + 1);
Model.getUseCasesHelper().setExtensionPoints(usecase, c);
} 

} 

protected boolean isValidElement(Object o)
    { 
return Model.getFacade().getExtensionPoints(getTarget()).contains(o);
} 

public UMLUseCaseExtensionPointListModel()
    { 
super("extensionPoint");
} 

 } 


