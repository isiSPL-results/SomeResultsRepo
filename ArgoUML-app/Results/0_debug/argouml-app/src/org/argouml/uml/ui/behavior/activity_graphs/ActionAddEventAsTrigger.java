
//#if -221219066 
// Compilation Unit of /ActionAddEventAsTrigger.java 
 

//#if 974192491 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -138890397 
import java.util.ArrayList;
//#endif 


//#if 1328963166 
import java.util.Collection;
//#endif 


//#if -701189858 
import java.util.List;
//#endif 


//#if 591043469 
import org.argouml.i18n.Translator;
//#endif 


//#if 449393875 
import org.argouml.model.Model;
//#endif 


//#if 1591111425 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 1730338146 
public class ActionAddEventAsTrigger extends 
//#if 1072374516 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 1750257339 
public static final ActionAddEventAsTrigger SINGLETON =
        new ActionAddEventAsTrigger();
//#endif 


//#if -1759160380 
protected List getSelected()
    { 

//#if 1426402313 
List vec = new ArrayList();
//#endif 


//#if 1296645677 
Object trigger = Model.getFacade().getTrigger(getTarget());
//#endif 


//#if -272962901 
if(trigger != null)//1
{ 

//#if 777975892 
vec.add(trigger);
//#endif 

} 

//#endif 


//#if 740707978 
return vec;
//#endif 

} 

//#endif 


//#if -31776686 
@Override
    protected void doIt(Collection selected)
    { 

//#if 1678608702 
Object trans = getTarget();
//#endif 


//#if 449052217 
if(selected == null || selected.size() == 0)//1
{ 

//#if -1491609924 
Model.getStateMachinesHelper().setEventAsTrigger(trans, null);
//#endif 

} 
else
{ 

//#if 1405659761 
Model.getStateMachinesHelper().setEventAsTrigger(trans,
                    selected.iterator().next());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1815072651 
protected List getChoices()
    { 

//#if 1765464692 
List vec = new ArrayList();
//#endif 


//#if 1237760426 
vec.addAll(Model.getModelManagementHelper().getAllModelElementsOfKind(
                       Model.getFacade().getModel(getTarget()),
                       Model.getMetaTypes().getEvent()));
//#endif 


//#if -1721856449 
return vec;
//#endif 

} 

//#endif 


//#if -1532864216 
protected ActionAddEventAsTrigger()
    { 

//#if -1387678166 
super();
//#endif 


//#if 1809243179 
setMultiSelect(false);
//#endif 

} 

//#endif 


//#if 210797692 
protected String getDialogTitle()
    { 

//#if -1662997005 
return Translator.localize("dialog.title.add-events");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

