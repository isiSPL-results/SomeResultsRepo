
//#if -2059885603 
// Compilation Unit of /PropPanelStimulus.java 
 

//#if -396414431 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1562529286 
import org.argouml.i18n.Translator;
//#endif 


//#if -841544756 
import org.argouml.model.Model;
//#endif 


//#if 578174546 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1464639641 
import org.argouml.uml.ui.UMLStimulusActionTextField;
//#endif 


//#if 1801226848 
import org.argouml.uml.ui.UMLStimulusActionTextProperty;
//#endif 


//#if 964985926 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -1351343229 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -445036673 
public class PropPanelStimulus extends 
//#if -617876915 
PropPanelModelElement
//#endif 

  { 

//#if 367771624 
private static final long serialVersionUID = 81659498358156000L;
//#endif 


//#if -470287107 
public Object getSender()
    { 

//#if 1579130337 
Object sender = null;
//#endif 


//#if 69136554 
Object target = getTarget();
//#endif 


//#if 262366674 
if(Model.getFacade().isAStimulus(target))//1
{ 

//#if 56083880 
sender =  Model.getFacade().getSender(target);
//#endif 

} 

//#endif 


//#if -104290656 
return sender;
//#endif 

} 

//#endif 


//#if 1061583515 
public Object getAssociation()
    { 

//#if -1358121884 
Object association = null;
//#endif 


//#if 1720790123 
Object target = getTarget();
//#endif 


//#if -782505871 
if(Model.getFacade().isAStimulus(target))//1
{ 

//#if 276823206 
Object link = Model.getFacade().getCommunicationLink(target);
//#endif 


//#if -252843499 
if(link != null)//1
{ 

//#if 703203040 
association = Model.getFacade().getAssociation(link);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1666675071 
return association;
//#endif 

} 

//#endif 


//#if -1761271689 
public Object getReceiver()
    { 

//#if 1024420208 
Object receiver = null;
//#endif 


//#if -1168233163 
Object target = getTarget();
//#endif 


//#if 237113191 
if(Model.getFacade().isAStimulus(target))//1
{ 

//#if -653795682 
receiver =  Model.getFacade().getReceiver(target);
//#endif 

} 

//#endif 


//#if 43816433 
return receiver;
//#endif 

} 

//#endif 


//#if -14344239 
public void setAssociation(Object element)
    { 

//#if 1122199027 
Object target = getTarget();
//#endif 


//#if 914289129 
if(Model.getFacade().isAStimulus(target))//1
{ 

//#if 1327189081 
Object stimulus = target;
//#endif 


//#if -49237657 
Object link = Model.getFacade().getCommunicationLink(stimulus);
//#endif 


//#if -320786591 
if(link == null)//1
{ 

//#if -1411426154 
link = Model.getCommonBehaviorFactory().createLink();
//#endif 


//#if 970240048 
if(link != null)//1
{ 

//#if -1412581963 
Model.getCommonBehaviorHelper().addStimulus(link, stimulus);
//#endif 


//#if -1897620640 
Model.getCommonBehaviorHelper().setCommunicationLink(
                        stimulus,
                        link);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1512062314 
Object oldAssoc = Model.getFacade().getAssociation(link);
//#endif 


//#if 1842626978 
if(oldAssoc != element)//1
{ 

//#if -382420137 
Model.getCoreHelper().setAssociation(link, element);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 409170028 
public boolean isAcceptableAssociation(Object modelelement)
    { 

//#if -1843457500 
return Model.getFacade().isAAssociation(modelelement);
//#endif 

} 

//#endif 


//#if -505308441 
public void setReceiver(Object element)
    { 

//#if 1333375571 
Object target = getTarget();
//#endif 


//#if 779979145 
if(Model.getFacade().isAStimulus(target))//1
{ 

//#if 450784543 
Model.getCommonBehaviorHelper().setReceiver(target, element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1553363359 
public void setSender(Object element)
    { 

//#if -679597474 
Object target = getTarget();
//#endif 


//#if -798341218 
if(Model.getFacade().isAStimulus(target))//1
{ 

//#if 404698191 
Model.getCollaborationsHelper().setSender(target, element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 818782252 
public PropPanelStimulus()
    { 

//#if -1484857946 
super("label.stimulus", lookupIcon("Stimulus"));
//#endif 


//#if -1548365558 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -713486822 
addField(Translator.localize("label.action"),
                 new UMLStimulusActionTextField(this,
                                                new UMLStimulusActionTextProperty("name")));
//#endif 


//#if -528070608 
addField(Translator.localize("label.sender"),
                 getSingleRowScroll(new UMLStimulusSenderListModel()));
//#endif 


//#if -895122716 
addField(Translator.localize("label.receiver"),
                 getSingleRowScroll(new UMLStimulusReceiverListModel()));
//#endif 


//#if 38453840 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 999275813 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -594393299 
addAction(new ActionNewStereotype());
//#endif 


//#if -2034992180 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

