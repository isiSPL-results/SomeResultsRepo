
//#if 1151337115 
// Compilation Unit of /ActionAddSignalsToSignalEvent.java 
 

//#if 760428380 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 97405315 
import java.util.ArrayList;
//#endif 


//#if 64195646 
import java.util.Collection;
//#endif 


//#if -599668994 
import java.util.List;
//#endif 


//#if -303558227 
import org.argouml.i18n.Translator;
//#endif 


//#if 1508293363 
import org.argouml.model.Model;
//#endif 


//#if 1553632545 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -1226124039 
class ActionAddSignalsToSignalEvent extends 
//#if 344347179 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 1090383716 
public static final ActionAddSignalsToSignalEvent SINGLETON =
        new ActionAddSignalsToSignalEvent();
//#endif 


//#if 1768238816 
private static final long serialVersionUID = 6890869588365483936L;
//#endif 


//#if -883213275 
protected String getDialogTitle()
    { 

//#if 1126479970 
return Translator.localize("dialog.title.add-signal");
//#endif 

} 

//#endif 


//#if 1755560436 
protected List getChoices()
    { 

//#if -1115643498 
List vec = new ArrayList();
//#endif 


//#if -553413334 
vec.addAll(Model.getModelManagementHelper().getAllModelElementsOfKind(
                       Model.getFacade().getModel(getTarget()),
                       Model.getMetaTypes().getSignal()));
//#endif 


//#if -1705388067 
return vec;
//#endif 

} 

//#endif 


//#if -810166785 
protected ActionAddSignalsToSignalEvent()
    { 

//#if -1526809624 
super();
//#endif 


//#if 1018690921 
setMultiSelect(false);
//#endif 

} 

//#endif 


//#if -1057554039 
@Override
    protected void doIt(Collection selected)
    { 

//#if 441140591 
Object event = getTarget();
//#endif 


//#if -837911114 
if(selected == null || selected.size() == 0)//1
{ 

//#if 1978491360 
Model.getCommonBehaviorHelper().setSignal(event, null);
//#endif 

} 
else
{ 

//#if -1312501870 
Model.getCommonBehaviorHelper().setSignal(event,
                    selected.iterator().next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 690928251 
protected List getSelected()
    { 

//#if 938473918 
List vec = new ArrayList();
//#endif 


//#if 337885686 
Object signal = Model.getFacade().getSignal(getTarget());
//#endif 


//#if -1498717056 
if(signal != null)//1
{ 

//#if -1960061343 
vec.add(signal);
//#endif 

} 

//#endif 


//#if 2081840821 
return vec;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

