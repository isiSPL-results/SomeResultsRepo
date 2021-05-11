package org.argouml.uml.ui.behavior.state_machines;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
class ActionAddSignalsToSignalEvent extends AbstractActionAddModelElement2
  { 
public static final ActionAddSignalsToSignalEvent SINGLETON =
        new ActionAddSignalsToSignalEvent();
private static final long serialVersionUID = 6890869588365483936L;
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-signal");
} 
protected List getChoices()
    { 
List vec = new ArrayList();
vec.addAll(Model.getModelManagementHelper().getAllModelElementsOfKind(
                       Model.getFacade().getModel(getTarget()),
                       Model.getMetaTypes().getSignal()));
return vec;
} 
protected ActionAddSignalsToSignalEvent()
    { 
super();
setMultiSelect(false);
} 
@Override
    protected void doIt(Collection selected)
    { 
Object event = getTarget();
if(selected == null || selected.size() == 0)//1
{ 
Model.getCommonBehaviorHelper().setSignal(event, null);
} 
else
{ 
Model.getCommonBehaviorHelper().setSignal(event,
                    selected.iterator().next());
} 
} 
protected List getSelected()
    { 
List vec = new ArrayList();
Object signal = Model.getFacade().getSignal(getTarget());
if(signal != null)//1
{ 
vec.add(signal);
} 
return vec;
} 

 } 
