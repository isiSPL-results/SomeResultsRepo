// Compilation Unit of /UMLClassifierRoleAvailableFeaturesListModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.tigris.gef.presentation.Fig;
public class UMLClassifierRoleAvailableFeaturesListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
setAllElements(Model.getCollaborationsHelper()
                       .allAvailableFeatures(getTarget()));
} 

public UMLClassifierRoleAvailableFeaturesListModel()
    { 
super();
} 

protected boolean isValidElement(Object element)
    { 
return false;
} 

public void setTarget(Object target)
    { 
if(getTarget() != null)//1
{ 
Enumeration enumeration = elements();
while (enumeration.hasMoreElements()) //1
{ 
Object base = enumeration.nextElement();
Model.getPump().removeModelEventListener(
                    this,
                    base,
                    "feature");
} 

Model.getPump().removeModelEventListener(
                this,
                getTarget(),
                "base");
} 

target = target instanceof Fig ? ((Fig) target).getOwner() : target;
if(!Model.getFacade().isAModelElement(target))//1
{ 
return;
} 

setListTarget(target);
if(getTarget() != null)//2
{ 
Collection bases = Model.getFacade().getBases(getTarget());
Iterator it = bases.iterator();
while (it.hasNext()) //1
{ 
Object base = it.next();
Model.getPump().addModelEventListener(
                    this,
                    base,
                    "feature");
} 

Model.getPump().addModelEventListener(
                this,
                getTarget(),
                "base");
removeAllElements();
setBuildingModel(true);
buildModelList();
setBuildingModel(false);
if(getSize() > 0)//1
{ 
fireIntervalAdded(this, 0, getSize() - 1);
} 

} 

} 

public void propertyChange(PropertyChangeEvent e)
    { 
if(e instanceof AddAssociationEvent)//1
{ 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 
Object clazz = getChangedElement(e);
addAll(Model.getFacade().getFeatures(clazz));
Model.getPump().addModelEventListener(
                    this,
                    clazz,
                    "feature");
} 
else
if(e.getPropertyName().equals("feature")
                && Model.getFacade().getBases(getTarget()).contains(
                    e.getSource()))//1
{ 
addElement(getChangedElement(e));
} 


} 
else
if(e instanceof RemoveAssociationEvent)//1
{ 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 
Object clazz = getChangedElement(e);
Model.getPump().removeModelEventListener(
                    this,
                    clazz,
                    "feature");
} 
else
if(e.getPropertyName().equals("feature")
                && Model.getFacade().getBases(getTarget()).contains(
                    e.getSource()))//1
{ 
removeElement(getChangedElement(e));
} 


} 
else
{ 
super.propertyChange(e);
} 


} 

 } 


