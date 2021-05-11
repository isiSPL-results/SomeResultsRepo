package org.argouml.uml.ui.foundation.core;
import java.util.List;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLModelElementOrderedListModel2;
public class UMLAssociationEndQualifiersListModel extends UMLModelElementOrderedListModel2
  { 
protected void moveDown(int index)
    { 
Object assocEnd = getTarget();
List c = Model.getFacade().getQualifiers(assocEnd);
if(index < c.size() - 1)//1
{ 
Object mem = c.get(index);
Model.getCoreHelper().removeQualifier(assocEnd, mem);
Model.getCoreHelper().addQualifier(assocEnd, index + 1, mem);
} 
} 
public UMLAssociationEndQualifiersListModel()
    { 
super("qualifier");
} 
@Override
    protected void moveToTop(int index)
    { 
Object clss = getTarget();
List c = Model.getFacade().getQualifiers(clss);
if(index > 0)//1
{ 
Object mem = c.get(index);
Model.getCoreHelper().removeQualifier(clss, mem);
Model.getCoreHelper().addQualifier(clss, 0, mem);
} 
} 
@Override
    protected void moveToBottom(int index)
    { 
Object assocEnd = getTarget();
List c = Model.getFacade().getQualifiers(assocEnd);
if(index < c.size() - 1)//1
{ 
Object mem = c.get(index);
Model.getCoreHelper().removeQualifier(assocEnd, mem);
Model.getCoreHelper().addQualifier(assocEnd, c.size() - 1, mem);
} 
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getQualifiers(getTarget()));
} 
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAAttribute(o)
               && Model.getFacade().getQualifiers(getTarget()).contains(o);
} 

 } 
