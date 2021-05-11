
//#if 2009514124 
// Compilation Unit of /PropPanelMessage.java 
 

//#if 400307984 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1014689728 
import java.awt.event.ActionEvent;
//#endif 


//#if 191348022 
import javax.swing.Action;
//#endif 


//#if -1306382445 
import javax.swing.Icon;
//#endif 


//#if -1074973077 
import javax.swing.JScrollPane;
//#endif 


//#if -1382001868 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 289599669 
import org.argouml.i18n.Translator;
//#endif 


//#if 1968856571 
import org.argouml.model.Model;
//#endif 


//#if -1577174137 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -513066564 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1637841539 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1999072982 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -246518526 
import org.argouml.uml.ui.UMLSingleRowSelector;
//#endif 


//#if 872969207 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -2120332940 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -568631213 
public class PropPanelMessage extends 
//#if 380669322 
PropPanelModelElement
//#endif 

  { 

//#if -1464407204 
private static final long serialVersionUID = -8433911715875762175L;
//#endif 


//#if -1616061606 
public PropPanelMessage()
    { 

//#if -771892464 
super("label.message", lookupIcon("Message"));
//#endif 


//#if -1645202730 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1906914735 
addField(Translator.localize("label.interaction"),
                 new UMLSingleRowSelector(new UMLMessageInteractionListModel()));
//#endif 


//#if 1028928831 
addField(Translator.localize("label.sender"),
                 new UMLSingleRowSelector(new UMLMessageSenderListModel()));
//#endif 


//#if 344194611 
addField(Translator.localize("label.receiver"),
                 new UMLSingleRowSelector(new UMLMessageReceiverListModel()));
//#endif 


//#if 889746485 
addSeparator();
//#endif 


//#if -1226529240 
addField(Translator.localize("label.activator"),
                 new UMLMessageActivatorComboBox(this,
                         new UMLMessageActivatorComboBoxModel()));
//#endif 


//#if 1970735105 
addField(Translator.localize("label.action"),
                 new UMLSingleRowSelector(new UMLMessageActionListModel()));
//#endif 


//#if -309899398 
JScrollPane predecessorScroll =
            new JScrollPane(
            new UMLMutableLinkedList(new UMLMessagePredecessorListModel(),
                                     ActionAddMessagePredecessor.getInstance(),
                                     null));
//#endif 


//#if -234607031 
addField(Translator.localize("label.predecessor"),
                 predecessorScroll);
//#endif 


//#if -2008917437 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 308929325 
addAction(new ActionToolNewAction());
//#endif 


//#if 990704865 
addAction(new ActionNewStereotype());
//#endif 


//#if -958721896 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1744440361 
private static class ActionToolNewAction extends 
//#if -1688891990 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1042711150 
private static final long serialVersionUID = -6588197204256288453L;
//#endif 


//#if -1797397038 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if -1268210717 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -534157433 
if(Model.getFacade().isAMessage(target))//1
{ 

//#if 1489248111 
Model.getCommonBehaviorFactory().buildAction(target);
//#endif 


//#if 350148509 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1720461071 
public ActionToolNewAction()
        { 

//#if 782543428 
super("button.new-action");
//#endif 


//#if -1360872406 
putValue(Action.NAME, Translator.localize("button.new-action"));
//#endif 


//#if 1675087730 
Icon icon = ResourceLoaderWrapper.lookupIcon("CallAction");
//#endif 


//#if -1650293202 
putValue(Action.SMALL_ICON, icon);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

