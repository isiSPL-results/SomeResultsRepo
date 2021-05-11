// Compilation Unit of /UMLClassifierRoleAvailableContentsListModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.presentation.Fig;
public class UMLClassifierRoleAvailableContentsListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return false;
} 

public UMLClassifierRoleAvailableContentsListModel()
    { 
super();
} 

protected void buildModelList()
    { 
setAllElements(
            Model.getCollaborationsHelper().allAvailableContents(getTarget()));
} 

public void setTarget(Object theNewTarget)
    { 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
if(Model.getFacade().isAModelElement(theNewTarget)
                || theNewTarget instanceof Diagram)//1
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
                        "ownedElement");
} 

Model.getPump().removeModelEventListener(
                    this,
                    getTarget(),
                    "base");
} 

setListTarget(theNewTarget);
if(getTarget() != null)//2
{ 
Collection bases = Model.getFacade().getBases(getTarget());
Iterator it = bases.iterator();
while (it.hasNext()) //1
{ 
Object base =  it.next();
Model.getPump().addModelEventListener(
                        this,
                        base,
                        "ownedElement");
} 

Model.getPump().addModelEventListener(
                    this,
                    getTarget(),
                    "base");
} 

if(getTarget() != null)//3
{ 
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

} 

public void propertyChange(PropertyChangeEvent e)
    { 
if(e instanceof AddAssociationEvent)//1
{ 
if(e.getPropertyName().equals("base")
                    && e.getSource() == getTarget())//1
{ 
Object clazz = getChangedElement(e);
addAll(Model.getFacade().getOwnedElements(clazz));
Model.getPump().addModelEventListener(
                    this,
                    clazz,
                    "ownedElement");
} 
else
if(e.getPropertyName().equals("ownedElement")
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
                    "ownedElement");
} 
else
if(e.getPropertyName().equals("ownedElement")
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


