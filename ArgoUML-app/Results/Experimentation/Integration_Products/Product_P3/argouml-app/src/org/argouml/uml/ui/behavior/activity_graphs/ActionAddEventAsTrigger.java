package org.argouml.uml.ui.behavior.activity_graphs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
public class ActionAddEventAsTrigger extends AbstractActionAddModelElement2
  { 
public static final ActionAddEventAsTrigger SINGLETON =
        new ActionAddEventAsTrigger();
protected List getSelected()
    { 
List vec = new ArrayList();
Object trigger = Model.getFacade().getTrigger(getTarget());
if(trigger != null)//1
{ 
vec.add(trigger);
} 
return vec;
} 
@Override
    protected void doIt(Collection selected)
    { 
Object trans = getTarget();
if(selected == null || selected.size() == 0)//1
{ 
Model.getStateMachinesHelper().setEventAsTrigger(trans, null);
} 
else
{ 
Model.getStateMachinesHelper().setEventAsTrigger(trans,
                    selected.iterator().next());
} 
} 
protected List getChoices()
    { 
List vec = new ArrayList();
vec.addAll(Model.getModelManagementHelper().getAllModelElementsOfKind(
                       Model.getFacade().getModel(getTarget()),
                       Model.getMetaTypes().getEvent()));
return vec;
} 
protected ActionAddEventAsTrigger()
    { 
super();
setMultiSelect(false);
} 
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-events");
} 

 } 
