// Compilation Unit of /PropPanelInclude.java 
 
package org.argouml.uml.ui.behavior.use_cases;
import javax.swing.JList;
import org.argouml.model.Model;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.foundation.core.PropPanelRelationship;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelInclude extends PropPanelRelationship
  { 
private static final long serialVersionUID = -8235207258195445477L;
public Object getBase()
    { 
Object base   = null;
Object      target = getTarget();
if(Model.getFacade().isAInclude(target))//1
{ 
base = Model.getFacade().getBase(target);
} 

return base;
} 

public void setBase(Object/*MUseCase*/ base)
    { 
Object target = getTarget();
if(Model.getFacade().isAInclude(target))//1
{ 
Model.getUseCasesHelper().setBase(target, base);
} 

} 

public PropPanelInclude()
    { 
super("label.include", lookupIcon("Include"));
addField("label.name", getNameTextField());
addField("label.namespace", getNamespaceSelector());
addSeparator();
addField("label.usecase-base",
                 getSingleRowScroll(new UMLIncludeBaseListModel()));
addField("label.addition",
                 getSingleRowScroll(new UMLIncludeAdditionListModel()));
addAction(new ActionNavigateNamespace());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

public void setAddition(Object/*MUseCase*/ addition)
    { 
Object target = getTarget();
if(Model.getFacade().isAInclude(target))//1
{ 
Model.getUseCasesHelper().setAddition(target, addition);
} 

} 

public Object getAddition()
    { 
Object addition   = null;
Object target = getTarget();
if(Model.getFacade().isAInclude(target))//1
{ 
addition = Model.getFacade().getAddition(target);
} 

return addition;
} 

public boolean isAcceptableUseCase(Object/*MModelElement*/ modElem)
    { 
return Model.getFacade().isAUseCase(modElem);
} 

 } 


