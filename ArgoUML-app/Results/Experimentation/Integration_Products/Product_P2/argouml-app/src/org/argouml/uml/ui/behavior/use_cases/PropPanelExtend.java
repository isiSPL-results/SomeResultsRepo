package org.argouml.uml.ui.behavior.use_cases;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLConditionExpressionModel;
import org.argouml.uml.ui.UMLExpressionBodyField;
import org.argouml.uml.ui.UMLExpressionModel2;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.foundation.core.PropPanelRelationship;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
public class PropPanelExtend extends PropPanelRelationship
  { 
private static final long serialVersionUID = -3257769932777323293L;
public PropPanelExtend()
    { 
super("label.extend", lookupIcon("Extend"));
addField("label.name",
                 getNameTextField());
addField("label.namespace",
                 getNamespaceSelector());
addSeparator();
addField("label.usecase-base",
                 getSingleRowScroll(new UMLExtendBaseListModel()));
addField("label.extension",
                 getSingleRowScroll(new UMLExtendExtensionListModel()));
JList extensionPointList =
            new UMLMutableLinkedList(new UMLExtendExtensionPointListModel(),
                                     ActionAddExtendExtensionPoint.getInstance(),
                                     ActionNewExtendExtensionPoint.SINGLETON);
addField("label.extension-points",
                 new JScrollPane(extensionPointList));
addSeparator();
UMLExpressionModel2 conditionModel =
            new UMLConditionExpressionModel(this, "condition");
JTextArea conditionArea =
            new UMLExpressionBodyField(conditionModel, true);
conditionArea.setRows(5);
JScrollPane conditionScroll =
            new JScrollPane(conditionArea);
addField("label.condition", conditionScroll);
addAction(new ActionNavigateNamespace());
addAction(new ActionNewExtensionPoint());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 
private static class ActionNewExtensionPoint extends AbstractActionNewModelElement
  { 
private static final long serialVersionUID = 2643582245431201015L;
@Override
        public void actionPerformed(ActionEvent e)
        { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAExtend(target)
                    && Model.getFacade().getNamespace(target) != null
                    && Model.getFacade().getBase(target) != null)//1
{ 
Object extensionPoint =
                    Model.getUseCasesFactory().buildExtensionPoint(
                        Model.getFacade().getBase(target));
Model.getUseCasesHelper().addExtensionPoint(target,
                        extensionPoint);
TargetManager.getInstance().setTarget(extensionPoint);
super.actionPerformed(e);
} 
} 
public ActionNewExtensionPoint()
        { 
super("button.new-extension-point");
putValue(Action.NAME,
                     Translator.localize("button.new-extension-point"));
} 

 } 

 } 
