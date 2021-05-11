
//#if 386871315 
// Compilation Unit of /PropPanelObject.java 
 

//#if -1867906 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 2106545855 
import javax.swing.JScrollPane;
//#endif 


//#if -176896247 
import org.argouml.i18n.Translator;
//#endif 


//#if 855408207 
import org.argouml.model.Model;
//#endif 


//#if -1370188419 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 846741231 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 1682335530 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -562739552 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -2010876985 
public class PropPanelObject extends 
//#if 1757177741 
PropPanelInstance
//#endif 

  { 

//#if 1422593644 
private static final long serialVersionUID = 3594423150761388537L;
//#endif 


//#if 154904303 
public PropPanelObject()
    { 

//#if 1226870044 
super("label.object", lookupIcon("Object"));
//#endif 


//#if -1844142922 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -1145546716 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1276911125 
addSeparator();
//#endif 


//#if 1510885834 
addField(Translator.localize("label.stimili-sent"),
                 getStimuliSenderScroll());
//#endif 


//#if 106535899 
addField(Translator.localize("label.stimili-received"),
                 getStimuliReceiverScroll());
//#endif 


//#if -65969123 
addSeparator();
//#endif 


//#if 1918957815 
AbstractActionAddModelElement2 action =
            new ActionAddInstanceClassifier(
            Model.getMetaTypes().getClassifier());
//#endif 


//#if -423957160 
JScrollPane classifierScroll =
            new JScrollPane(
            new UMLMutableLinkedList(
                new UMLInstanceClassifierListModel(),
                action, null, null, true));
//#endif 


//#if 170427606 
addField(Translator.localize("label.classifiers"),
                 classifierScroll);
//#endif 


//#if 1730781945 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 1527789313 
addAction(new ActionNewStereotype());
//#endif 


//#if -103812488 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

