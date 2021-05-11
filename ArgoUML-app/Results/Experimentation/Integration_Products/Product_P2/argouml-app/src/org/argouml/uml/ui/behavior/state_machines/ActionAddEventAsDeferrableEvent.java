package org.argouml.uml.ui.behavior.state_machines;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
public class ActionAddEventAsDeferrableEvent extends AbstractActionAddModelElement2
  { 
public static final ActionAddEventAsDeferrableEvent SINGLETON =
        new ActionAddEventAsDeferrableEvent();
private static final long serialVersionUID = 1815648968597093974L;
protected ActionAddEventAsDeferrableEvent()
    { 
super();
setMultiSelect(true);
} 
protected List getSelected()
    { 
List vec = new ArrayList();
Collection events = Model.getFacade().getDeferrableEvents(getTarget());
if(events != null)//1
{ 
vec.addAll(events);
} 
return vec;
} 
@Override
    protected void doIt(Collection selected)
    { 
Object state = getTarget();
if(!Model.getFacade().isAState(state))//1
{ 
return;
} 
Collection oldOnes = new ArrayList(Model.getFacade()
                                           .getDeferrableEvents(state));
Collection toBeRemoved = new ArrayList(oldOnes);
for (Object o : selected) //1
{ 
if(oldOnes.contains(o))//1
{ 
toBeRemoved.remove(o);
} 
else
{ 
Model.getStateMachinesHelper().addDeferrableEvent(state, o);
} 
} 
for (Object o : toBeRemoved) //1
{ 
Model.getStateMachinesHelper().removeDeferrableEvent(state, o);
} 
} 
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-events");
} 
protected List getChoices()
    { 
List vec = new ArrayList();
vec.addAll(Model.getModelManagementHelper().getAllModelElementsOfKind(
                       Model.getFacade().getModel(getTarget()),
                       Model.getMetaTypes().getEvent()));
return vec;
} 

 } 
