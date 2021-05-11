
//#if 293968567 
// Compilation Unit of /PropPanelComponentInstance.java 
 

//#if -74977299 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -133476665 
import javax.swing.JList;
//#endif 


//#if 1654693616 
import javax.swing.JScrollPane;
//#endif 


//#if -480997702 
import org.argouml.i18n.Translator;
//#endif 


//#if 403555968 
import org.argouml.model.Model;
//#endif 


//#if 895488622 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 759144898 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 698662855 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1045114203 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -373563464 
import org.argouml.uml.ui.foundation.core.UMLContainerResidentListModel;
//#endif 


//#if 647232079 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -1501093415 
public class PropPanelComponentInstance extends 
//#if 542975702 
PropPanelInstance
//#endif 

  { 

//#if -854350586 
private static final long serialVersionUID = 7178149693694151459L;
//#endif 


//#if 666740539 
public PropPanelComponentInstance()
    { 

//#if 75232791 
super("label.component-instance", lookupIcon("ComponentInstance"));
//#endif 


//#if -408471360 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -701257894 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1054783007 
addSeparator();
//#endif 


//#if -1083044780 
addField(Translator.localize("label.stimili-sent"),
                 getStimuliSenderScroll());
//#endif 


//#if -1837117723 
addField(Translator.localize("label.stimili-received"),
                 getStimuliReceiverScroll());
//#endif 


//#if -1109889170 
JList resList = new UMLLinkedList(new UMLContainerResidentListModel());
//#endif 


//#if 1319164427 
addField(Translator.localize("label.residents"),
                 new JScrollPane(resList));
//#endif 


//#if 1059870675 
addSeparator();
//#endif 


//#if 271962679 
AbstractActionAddModelElement2 action =
            new ActionAddInstanceClassifier(
            Model.getMetaTypes().getComponent());
//#endif 


//#if 1659386210 
JScrollPane classifierScroll =
            new JScrollPane(
            new UMLMutableLinkedList(new UMLInstanceClassifierListModel(),
                                     action, null, null, true));
//#endif 


//#if -1528307956 
addField(Translator.localize("label.classifiers"),
                 classifierScroll);
//#endif 


//#if -2012842963 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1114248905 
addAction(new ActionNewStereotype());
//#endif 


//#if -1162170110 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

