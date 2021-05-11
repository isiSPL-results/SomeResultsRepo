
//#if -1219175350 
// Compilation Unit of /PropPanelExtensionPoint.java 
 

//#if -1954454598 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if -1773150803 
import java.awt.event.ActionEvent;
//#endif 


//#if 1806428195 
import javax.swing.Action;
//#endif 


//#if 987111925 
import javax.swing.JList;
//#endif 


//#if 706729886 
import javax.swing.JScrollPane;
//#endif 


//#if 2118515318 
import javax.swing.JTextField;
//#endif 


//#if -234110872 
import org.argouml.i18n.Translator;
//#endif 


//#if -544407762 
import org.argouml.model.Model;
//#endif 


//#if -1013207180 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -16037911 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 885144816 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 2075093721 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1699650795 
import org.argouml.uml.ui.UMLTextField2;
//#endif 


//#if 2143421732 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1750583265 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1337383544 
public class PropPanelExtensionPoint extends 
//#if -1157309241 
PropPanelModelElement
//#endif 

  { 

//#if -1445342319 
private static final long serialVersionUID = 1835785842490972735L;
//#endif 


//#if 900812797 
public PropPanelExtensionPoint()
    { 

//#if 233085710 
super("label.extension-point",  lookupIcon("ExtensionPoint"));
//#endif 


//#if -924782085 
addField("label.name", getNameTextField());
//#endif 


//#if 37449634 
JTextField locationField = new UMLTextField2(
            new UMLExtensionPointLocationDocument());
//#endif 


//#if -1202216943 
addField("label.location",
                 locationField);
//#endif 


//#if 1829501948 
addSeparator();
//#endif 


//#if -677531078 
addField("label.usecase-base",
                 getSingleRowScroll(new UMLExtensionPointUseCaseListModel()));
//#endif 


//#if -738062151 
JList extendList = new UMLLinkedList(
            new UMLExtensionPointExtendListModel());
//#endif 


//#if 4580549 
addField("label.extend",
                 new JScrollPane(extendList));
//#endif 


//#if -1961032182 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 991564505 
addAction(new ActionNewExtensionPoint());
//#endif 


//#if 1246224250 
addAction(new ActionNewStereotype());
//#endif 


//#if -868880353 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 361442217 
@Override
    public void navigateUp()
    { 

//#if -360015110 
Object target = getTarget();
//#endif 


//#if -256990617 
if(!(Model.getFacade().isAExtensionPoint(target)))//1
{ 

//#if 487029906 
return;
//#endif 

} 

//#endif 


//#if 8430329 
Object owner = Model.getFacade().getUseCase(target);
//#endif 


//#if -8362631 
if(owner != null)//1
{ 

//#if -163741364 
TargetManager.getInstance().setTarget(owner);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1473566937 
private static class ActionNewExtensionPoint extends 
//#if 145741351 
AbstractActionNewModelElement
//#endif 

  { 

//#if -874485574 
private static final long serialVersionUID = -4149133466093969498L;
//#endif 


//#if 1225292959 
public ActionNewExtensionPoint()
        { 

//#if 134022792 
super("button.new-extension-point");
//#endif 


//#if 2121426044 
putValue(Action.NAME,
                     Translator.localize("button.new-extension-point"));
//#endif 

} 

//#endif 


//#if 60049973 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 344998796 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 326154986 
if(Model.getFacade().isAExtensionPoint(target))//1
{ 

//#if -865739536 
TargetManager.getInstance().setTarget(
                    Model.getUseCasesFactory().buildExtensionPoint(
                        Model.getFacade().getUseCase(target)));
//#endif 


//#if 1339572622 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

