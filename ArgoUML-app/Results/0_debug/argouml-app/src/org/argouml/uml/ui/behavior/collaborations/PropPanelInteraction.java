
//#if 995692772 
// Compilation Unit of /PropPanelInteraction.java 
 

//#if -1532015002 
package org.argouml.uml.ui.behavior.collaborations;
//#endif 


//#if 1196455256 
import javax.swing.JList;
//#endif 


//#if -1923558207 
import javax.swing.JScrollPane;
//#endif 


//#if -395611125 
import org.argouml.i18n.Translator;
//#endif 


//#if 735498009 
import org.argouml.uml.ui.ActionNavigateContext;
//#endif 


//#if 843941142 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 599029857 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 919424094 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 673338568 
public class PropPanelInteraction extends 
//#if -660275677 
PropPanelModelElement
//#endif 

  { 

//#if 1700369078 
private static final long serialVersionUID = 8965284617441796326L;
//#endif 


//#if -1032693012 
public PropPanelInteraction()
    { 

//#if 47027151 
super("label.interaction-title", lookupIcon("Interaction"));
//#endif 


//#if -949125472 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -521273990 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1082932976 
addField(Translator.localize("label.context"),
                 getSingleRowScroll(new UMLInteractionContextListModel()));
//#endif 


//#if 389823487 
addSeparator();
//#endif 


//#if -769575537 
JList messagesList =
            new UMLLinkedList(new UMLInteractionMessagesListModel());
//#endif 


//#if 896392681 
JScrollPane messagesScroll = new JScrollPane(messagesList);
//#endif 


//#if 1201709995 
addField(Translator.localize("label.messages"),
                 messagesScroll);
//#endif 


//#if 1154900707 
addAction(new ActionNavigateContext());
//#endif 


//#if -531574953 
addAction(new ActionNewStereotype());
//#endif 


//#if -897028382 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

