// Compilation Unit of /UMLMessageActivatorComboBoxModel.java 
 
package org.argouml.uml.ui.behavior.collaborations;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLComboBoxModel2;
public class UMLMessageActivatorComboBoxModel extends UMLComboBoxModel2
  { 
private Object interaction = null;
protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
return Model.getFacade().getActivator(getTarget());
} 

return null;
} 

public void setTarget(Object target)
    { 
if(Model.getFacade().isAMessage(getTarget()))//1
{ 
if(interaction != null)//1
{ 
Model.getPump().removeModelEventListener(
                    this,
                    interaction,
                    "message");
} 

} 

super.setTarget(target);
if(Model.getFacade().isAMessage(target))//1
{ 
interaction = Model.getFacade().getInteraction(target);
if(interaction != null)//1
{ 
Model.getPump().addModelEventListener(
                    this,
                    interaction,
                    "message");
} 

} 

} 

protected void buildModelList()
    { 
Object target = getTarget();
if(Model.getFacade().isAMessage(target))//1
{ 
Object mes = target;
removeAllElements();
setElements(Model.getCollaborationsHelper()
                        .getAllPossibleActivators(mes));
} 

} 

protected boolean isValidElement(Object m)
    { 
try //1
{ 
return ((Model.getFacade().isAMessage(m))
                    && m != getTarget()
                    && !Model.getFacade().getPredecessors(getTarget())
                    .contains(m)
                    && Model.getFacade().getInteraction(m) == Model
                    .getFacade().getInteraction(getTarget()));
} 
catch (InvalidElementException e) //1
{ 
return false;
} 


} 

public UMLMessageActivatorComboBoxModel()
    { 
super("activator", false);
} 

 } 


