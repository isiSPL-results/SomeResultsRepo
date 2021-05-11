
//#if 1533537153 
// Compilation Unit of /PropPanelNodeInstance.java 
 

//#if -377375014 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -1942790150 
import javax.swing.JList;
//#endif 


//#if 211140067 
import javax.swing.JScrollPane;
//#endif 


//#if 1055587373 
import org.argouml.i18n.Translator;
//#endif 


//#if -1039997581 
import org.argouml.model.Model;
//#endif 


//#if -1895917663 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -2032261387 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1615315508 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -679344562 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 414314021 
import org.argouml.uml.ui.foundation.core.UMLContainerResidentListModel;
//#endif 


//#if -498154756 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 511704419 
public class PropPanelNodeInstance extends 
//#if -1026354592 
PropPanelInstance
//#endif 

  { 

//#if 1162732444 
private static final long serialVersionUID = -3391167975804021594L;
//#endif 


//#if 2105295226 
public PropPanelNodeInstance()
    { 

//#if 1123693328 
super("label.node-instance", lookupIcon("NodeInstance"));
//#endif 


//#if -1731351361 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 1657160251 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if -2128428002 
addSeparator();
//#endif 


//#if -2006837741 
addField(Translator.localize("label.stimili-sent"),
                 getStimuliSenderScroll());
//#endif 


//#if 2001423716 
addField(Translator.localize("label.stimili-received"),
                 getStimuliReceiverScroll());
//#endif 


//#if -408090865 
JList resList = new UMLLinkedList(new UMLContainerResidentListModel());
//#endif 


//#if 1415682890 
addField(Translator.localize("label.residents"),
                 new JScrollPane(resList));
//#endif 


//#if -1396370060 
addSeparator();
//#endif 


//#if 2071207806 
AbstractActionAddModelElement2 a =
            new ActionAddInstanceClassifier(Model.getMetaTypes().getNode());
//#endif 


//#if 521656632 
JScrollPane classifierScroll =
            new JScrollPane(new UMLMutableLinkedList(
                                new UMLInstanceClassifierListModel(),
                                a, null, null, true));
//#endif 


//#if -1410002323 
addField(Translator.localize("label.classifiers"),
                 classifierScroll);
//#endif 


//#if 146458156 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 394322072 
addAction(new ActionNewStereotype());
//#endif 


//#if 1542640833 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

