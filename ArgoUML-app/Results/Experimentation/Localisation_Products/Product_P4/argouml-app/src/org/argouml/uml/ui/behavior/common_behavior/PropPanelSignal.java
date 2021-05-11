package org.argouml.uml.ui.behavior.common_behavior;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
import org.argouml.uml.ui.AbstractActionRemoveElement;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
class ActionRemoveContextSignal extends AbstractActionRemoveElement
  { 
private static final long serialVersionUID = -3345844954130000669L;
public ActionRemoveContextSignal()
    { 
super(Translator.localize("menu.popup.remove"));
} 
@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object context = getObjectToRemove();
if(context != null)//1
{ 
Object signal = getTarget();
if(Model.getFacade().isASignal(signal))//1
{ 
Model.getCommonBehaviorHelper().removeContext(signal, context);
} 
} 
} 

 } 
class ActionAddReceptionSignal extends AbstractActionAddModelElement2
  { 
private static final long serialVersionUID = -2854099588590429237L;
@Override
    protected void doIt(Collection selected)
    { 
Model.getCommonBehaviorHelper().setReception(getTarget(), selected);
} 
public ActionAddReceptionSignal()
    { 
super();
} 
protected List getChoices()
    { 
List ret = new ArrayList();
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
if(getTarget() != null)//1
{ 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKind(model,
                                                  Model.getMetaTypes().getReception()));
} 
return ret;
} 
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-receptions");
} 
protected List getSelected()
    { 
List ret = new ArrayList();
ret.addAll(Model.getFacade().getReceptions(getTarget()));
return ret;
} 

 } 
class ActionRemoveReceptionSignal extends AbstractActionRemoveElement
  { 
private static final long serialVersionUID = -2630315087703962883L;
@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object reception = getObjectToRemove();
if(reception != null)//1
{ 
Object signal = getTarget();
if(Model.getFacade().isASignal(signal))//1
{ 
Model.getCommonBehaviorHelper().removeReception(signal,
                        reception);
} 
} 
} 
public ActionRemoveReceptionSignal()
    { 
super(Translator.localize("menu.popup.remove"));
} 

 } 
class UMLSignalReceptionListModel extends UMLModelElementListModel2
  { 
private static final long serialVersionUID = 3273212639257377015L;
public UMLSignalReceptionListModel()
    { 
super("reception");
} 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAReception(element)
               && Model.getFacade().getReceptions(getTarget()).contains(element);
} 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getReceptions(getTarget()));
} 
} 

 } 
public class PropPanelSignal extends PropPanelClassifier
  { 
private static final long serialVersionUID = -4496838172438164508L;
public PropPanelSignal(String title, String iconName)
    { 
super(title, lookupIcon(iconName));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
add(getModifiersPanel());
add(getVisibilityPanel());
addSeparator();
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
addSeparator();
AbstractActionAddModelElement2 actionAddContext =
            new ActionAddContextSignal();
AbstractActionRemoveElement actionRemoveContext =
            new ActionRemoveContextSignal();
JScrollPane operationScroll = new JScrollPane(
            new UMLMutableLinkedList(
                new UMLSignalContextListModel(),
                actionAddContext, null,
                actionRemoveContext, true));
addField(Translator.localize("label.contexts"),
                 operationScroll);
AbstractActionAddModelElement2 actionAddReception =
            new ActionAddReceptionSignal();
AbstractActionRemoveElement actionRemoveReception =
            new ActionRemoveReceptionSignal();
JScrollPane receptionScroll = new JScrollPane(
            new UMLMutableLinkedList(
                new UMLSignalReceptionListModel(),
                actionAddReception, null,
                actionRemoveReception, true));
addField(Translator.localize("label.receptions"),
                 receptionScroll);
addAction(new ActionNavigateNamespace());
addAction(new ActionNewSignal());
addAction(new ActionNewStereotype());
addAction(getDeleteAction());
} 
public PropPanelSignal()
    { 
this("label.signal-title", "SignalSending");
} 

 } 
