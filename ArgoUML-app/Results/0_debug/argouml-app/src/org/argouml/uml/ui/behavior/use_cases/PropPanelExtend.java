
//#if 681800726 
// Compilation Unit of /PropPanelExtend.java 
 

//#if 1628974333 
package org.argouml.uml.ui.behavior.use_cases;
//#endif 


//#if 753939312 
import java.awt.event.ActionEvent;
//#endif 


//#if 1383313638 
import javax.swing.Action;
//#endif 


//#if -1520388910 
import javax.swing.JList;
//#endif 


//#if -38399813 
import javax.swing.JScrollPane;
//#endif 


//#if -182595818 
import javax.swing.JTextArea;
//#endif 


//#if 796271365 
import org.argouml.i18n.Translator;
//#endif 


//#if -1289537461 
import org.argouml.model.Model;
//#endif 


//#if -229236937 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -648701588 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 2076961651 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -1347652163 
import org.argouml.uml.ui.UMLConditionExpressionModel;
//#endif 


//#if -634793757 
import org.argouml.uml.ui.UMLExpressionBodyField;
//#endif 


//#if 2123833618 
import org.argouml.uml.ui.UMLExpressionModel2;
//#endif 


//#if 1465590364 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 17934630 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 335580578 
import org.argouml.uml.ui.foundation.core.PropPanelRelationship;
//#endif 


//#if -1207909084 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1945741214 
public class PropPanelExtend extends 
//#if 1701873423 
PropPanelRelationship
//#endif 

  { 

//#if 467494296 
private static final long serialVersionUID = -3257769932777323293L;
//#endif 


//#if -1508919767 
public PropPanelExtend()
    { 

//#if -186791908 
super("label.extend", lookupIcon("Extend"));
//#endif 


//#if 1831361848 
addField("label.name",
                 getNameTextField());
//#endif 


//#if 1260255768 
addField("label.namespace",
                 getNamespaceSelector());
//#endif 


//#if -361538849 
addSeparator();
//#endif 


//#if 1906434360 
addField("label.usecase-base",
                 getSingleRowScroll(new UMLExtendBaseListModel()));
//#endif 


//#if 1198375110 
addField("label.extension",
                 getSingleRowScroll(new UMLExtendExtensionListModel()));
//#endif 


//#if -2018203823 
JList extensionPointList =
            new UMLMutableLinkedList(new UMLExtendExtensionPointListModel(),
                                     ActionAddExtendExtensionPoint.getInstance(),
                                     ActionNewExtendExtensionPoint.SINGLETON);
//#endif 


//#if -156910526 
addField("label.extension-points",
                 new JScrollPane(extensionPointList));
//#endif 


//#if 1174174483 
addSeparator();
//#endif 


//#if 273284986 
UMLExpressionModel2 conditionModel =
            new UMLConditionExpressionModel(this, "condition");
//#endif 


//#if -568424320 
JTextArea conditionArea =
            new UMLExpressionBodyField(conditionModel, true);
//#endif 


//#if -1685955523 
conditionArea.setRows(5);
//#endif 


//#if 295964846 
JScrollPane conditionScroll =
            new JScrollPane(conditionArea);
//#endif 


//#if 1095822809 
addField("label.condition", conditionScroll);
//#endif 


//#if 766082415 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 1070410070 
addAction(new ActionNewExtensionPoint());
//#endif 


//#if 1717288055 
addAction(new ActionNewStereotype());
//#endif 


//#if -2014313022 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1604798646 
private static class ActionNewExtensionPoint extends 
//#if -1301733341 
AbstractActionNewModelElement
//#endif 

  { 

//#if 144947363 
private static final long serialVersionUID = 2643582245431201015L;
//#endif 


//#if -827627847 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 401045420 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -672375237 
if(Model.getFacade().isAExtend(target)
                    && Model.getFacade().getNamespace(target) != null
                    && Model.getFacade().getBase(target) != null)//1
{ 

//#if -271613216 
Object extensionPoint =
                    Model.getUseCasesFactory().buildExtensionPoint(
                        Model.getFacade().getBase(target));
//#endif 


//#if 311160475 
Model.getUseCasesHelper().addExtensionPoint(target,
                        extensionPoint);
//#endif 


//#if -273142745 
TargetManager.getInstance().setTarget(extensionPoint);
//#endif 


//#if 72254635 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1771517851 
public ActionNewExtensionPoint()
        { 

//#if -244277079 
super("button.new-extension-point");
//#endif 


//#if 1749238301 
putValue(Action.NAME,
                     Translator.localize("button.new-extension-point"));
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

