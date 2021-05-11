
//#if 580394510 
// Compilation Unit of /PropPanelEnumerationLiteral.java 
 

//#if 1312987921 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 649994449 
import javax.swing.DefaultListModel;
//#endif 


//#if -1683055930 
import org.argouml.i18n.Translator;
//#endif 


//#if 570931340 
import org.argouml.model.Model;
//#endif 


//#if 1016574473 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -293564449 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 1815678294 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1818501938 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -1308664125 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -1075724375 
class EnumerationListModel extends 
//#if -130849172 
DefaultListModel
//#endif 

 implements 
//#if -1721513881 
TargetListener
//#endif 

  { 

//#if 1746368245 
public void targetRemoved(TargetEvent e)
    { 

//#if -273640822 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 300763518 
private void setTarget(Object t)
    { 

//#if 625034891 
removeAllElements();
//#endif 


//#if 1327367726 
if(Model.getFacade().isAEnumerationLiteral(t))//1
{ 

//#if 767679917 
addElement(Model.getFacade().getEnumeration(t));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1809414281 
public void targetSet(TargetEvent e)
    { 

//#if 1893429195 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 452933584 
public EnumerationListModel()
    { 

//#if -863717467 
super();
//#endif 


//#if 676360070 
setTarget(TargetManager.getInstance().getModelTarget());
//#endif 


//#if 1776876748 
TargetManager.getInstance().addTargetListener(this);
//#endif 

} 

//#endif 


//#if 566817685 
public void targetAdded(TargetEvent e)
    { 

//#if -979647719 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1357327827 
public class PropPanelEnumerationLiteral extends 
//#if -151270594 
PropPanelModelElement
//#endif 

  { 

//#if -898751792 
private static final long serialVersionUID = 1486642919681744144L;
//#endif 


//#if 1284309707 
public PropPanelEnumerationLiteral()
    { 

//#if -474740800 
super("label.enumeration-literal", lookupIcon("EnumerationLiteral"));
//#endif 


//#if -605651607 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 1416863527 
addField(Translator.localize("label.enumeration"),
                 getSingleRowScroll(new EnumerationListModel()));
//#endif 


//#if -431084842 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 203974680 
addAction(new ActionAddLiteral());
//#endif 


//#if 752730670 
addAction(new ActionNewStereotype());
//#endif 


//#if -1220349973 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

