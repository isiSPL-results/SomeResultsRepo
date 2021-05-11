package org.argouml.uml.ui.behavior.common_behavior;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLStimulusActionTextField;
import org.argouml.uml.ui.UMLStimulusActionTextProperty;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelStimulus extends PropPanelModelElement
  { 
private static final long serialVersionUID = 81659498358156000L;
public Object getSender()
    { 
Object sender = null;
Object target = getTarget();
if(Model.getFacade().isAStimulus(target))//1
{ 
sender =  Model.getFacade().getSender(target);
} 
return sender;
} 
public Object getAssociation()
    { 
Object association = null;
Object target = getTarget();
if(Model.getFacade().isAStimulus(target))//1
{ 
Object link = Model.getFacade().getCommunicationLink(target);
if(link != null)//1
{ 
association = Model.getFacade().getAssociation(link);
} 
} 
return association;
} 
public Object getReceiver()
    { 
Object receiver = null;
Object target = getTarget();
if(Model.getFacade().isAStimulus(target))//1
{ 
receiver =  Model.getFacade().getReceiver(target);
} 
return receiver;
} 
public void setAssociation(Object element)
    { 
Object target = getTarget();
if(Model.getFacade().isAStimulus(target))//1
{ 
Object stimulus = target;
Object link = Model.getFacade().getCommunicationLink(stimulus);
if(link == null)//1
{ 
link = Model.getCommonBehaviorFactory().createLink();
if(link != null)//1
{ 
Model.getCommonBehaviorHelper().addStimulus(link, stimulus);
Model.getCommonBehaviorHelper().setCommunicationLink(
                        stimulus,
                        link);
} 
} 
Object oldAssoc = Model.getFacade().getAssociation(link);
if(oldAssoc != element)//1
{ 
Model.getCoreHelper().setAssociation(link, element);
} 
} 
} 
public boolean isAcceptableAssociation(Object modelelement)
    { 
return Model.getFacade().isAAssociation(modelelement);
} 
public void setReceiver(Object element)
    { 
Object target = getTarget();
if(Model.getFacade().isAStimulus(target))//1
{ 
Model.getCommonBehaviorHelper().setReceiver(target, element);
} 
} 
public void setSender(Object element)
    { 
Object target = getTarget();
if(Model.getFacade().isAStimulus(target))//1
{ 
Model.getCollaborationsHelper().setSender(target, element);
} 
} 
public PropPanelStimulus()
    { 
super("label.stimulus", lookupIcon("Stimulus"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.action"),
                 new UMLStimulusActionTextField(this,
                                                new UMLStimulusActionTextProperty("name")));
addField(Translator.localize("label.sender"),
                 getSingleRowScroll(new UMLStimulusSenderListModel()));
addField(Translator.localize("label.receiver"),
                 getSingleRowScroll(new UMLStimulusReceiverListModel()));
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
addAction(new ActionNavigateNamespace());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 

 } 
