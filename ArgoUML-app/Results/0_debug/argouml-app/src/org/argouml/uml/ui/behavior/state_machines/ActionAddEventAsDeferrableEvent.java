
//#if -333915523 
// Compilation Unit of /ActionAddEventAsDeferrableEvent.java 
 

//#if -1005521535 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -1386748248 
import java.util.ArrayList;
//#endif 


//#if 1300075449 
import java.util.Collection;
//#endif 


//#if -1845901639 
import java.util.List;
//#endif 


//#if 1651030482 
import org.argouml.i18n.Translator;
//#endif 


//#if -1151124072 
import org.argouml.model.Model;
//#endif 


//#if -1227334778 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -241673969 
public class ActionAddEventAsDeferrableEvent extends 
//#if 1875085154 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 2111467069 
public static final ActionAddEventAsDeferrableEvent SINGLETON =
        new ActionAddEventAsDeferrableEvent();
//#endif 


//#if -963355906 
private static final long serialVersionUID = 1815648968597093974L;
//#endif 


//#if 1380772862 
protected ActionAddEventAsDeferrableEvent()
    { 

//#if -262481885 
super();
//#endif 


//#if 302171281 
setMultiSelect(true);
//#endif 

} 

//#endif 


//#if 1070408498 
protected List getSelected()
    { 

//#if 2054987999 
List vec = new ArrayList();
//#endif 


//#if 1398040944 
Collection events = Model.getFacade().getDeferrableEvents(getTarget());
//#endif 


//#if -738091694 
if(events != null)//1
{ 

//#if -1840394332 
vec.addAll(events);
//#endif 

} 

//#endif 


//#if 1338226164 
return vec;
//#endif 

} 

//#endif 


//#if -2119636800 
@Override
    protected void doIt(Collection selected)
    { 

//#if 554723655 
Object state = getTarget();
//#endif 


//#if 324702861 
if(!Model.getFacade().isAState(state))//1
{ 

//#if 245849210 
return;
//#endif 

} 

//#endif 


//#if -649254324 
Collection oldOnes = new ArrayList(Model.getFacade()
                                           .getDeferrableEvents(state));
//#endif 


//#if -2003958345 
Collection toBeRemoved = new ArrayList(oldOnes);
//#endif 


//#if 512553557 
for (Object o : selected) //1
{ 

//#if 1243036090 
if(oldOnes.contains(o))//1
{ 

//#if -263380304 
toBeRemoved.remove(o);
//#endif 

} 
else
{ 

//#if 1039743203 
Model.getStateMachinesHelper().addDeferrableEvent(state, o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1824720376 
for (Object o : toBeRemoved) //1
{ 

//#if 325531268 
Model.getStateMachinesHelper().removeDeferrableEvent(state, o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -674976306 
protected String getDialogTitle()
    { 

//#if -2979231 
return Translator.localize("dialog.title.add-events");
//#endif 

} 

//#endif 


//#if 382328413 
protected List getChoices()
    { 

//#if -2020822833 
List vec = new ArrayList();
//#endif 


//#if 685650863 
vec.addAll(Model.getModelManagementHelper().getAllModelElementsOfKind(
                       Model.getFacade().getModel(getTarget()),
                       Model.getMetaTypes().getEvent()));
//#endif 


//#if -1540849660 
return vec;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

