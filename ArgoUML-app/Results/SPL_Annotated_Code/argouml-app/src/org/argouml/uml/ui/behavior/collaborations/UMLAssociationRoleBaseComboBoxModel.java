// Compilation Unit of /UMLAssociationRoleBaseComboBoxModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.util.ArrayList;
import java.util.Collection;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLAssociationRoleBaseComboBoxModel extends UMLComboBoxModel2
  { 
private Collection others = new ArrayList();
@Override
    protected Object getSelectedModelElement()
    { 
Object ar = getTarget();
if(Model.getFacade().isAAssociationRole(ar))//1
{ 
Object base = Model.getFacade().getBase(ar);
if(base != null)//1
{ 
return base;
} 

} 

return null;
} 

@Override
    protected void addOtherModelEventListeners(Object newTarget)
    { 
super.addOtherModelEventListeners(newTarget);
Collection connections = Model.getFacade().getConnections(newTarget);
Collection types = new ArrayList();
for (Object conn : connections) //1
{ 
types.add(Model.getFacade().getType(conn));
} 

for (Object classifierRole : types) //1
{ 
others.addAll(Model.getFacade().getBases(classifierRole));
} 

for (Object classifier : others) //1
{ 
Model.getPump().addModelEventListener(this,
                                                  classifier, "feature");
} 

} 

@Override
    protected boolean isValidElement(Object element)
    { 
Object ar = getTarget();
if(Model.getFacade().isAAssociationRole(ar))//1
{ 
Object base = Model.getFacade().getBase(ar);
if(element == base)//1
{ 
return true;
} 

Collection b =
                Model.getCollaborationsHelper().getAllPossibleBases(ar);
return b.contains(element);
} 

return false;
} 

public UMLAssociationRoleBaseComboBoxModel()
    { 
super("base", true);
} 

@Override
    protected void buildModelList()
    { 
removeAllElements();
Object ar = getTarget();
Object base = Model.getFacade().getBase(ar);
if(Model.getFacade().isAAssociationRole(ar))//1
{ 
setElements(
                Model.getCollaborationsHelper().getAllPossibleBases(ar));
} 

if(base != null)//1
{ 
addElement(base);
} 

} 

@Override
    protected void removeOtherModelEventListeners(Object oldTarget)
    { 
super.removeOtherModelEventListeners(oldTarget);
for (Object classifier : others) //1
{ 
Model.getPump().removeModelEventListener(this,
                    classifier, "feature");
} 

others.clear();
} 

 } 


