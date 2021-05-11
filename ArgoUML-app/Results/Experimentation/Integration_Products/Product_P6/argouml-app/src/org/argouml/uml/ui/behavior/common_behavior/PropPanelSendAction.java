package org.argouml.uml.ui.behavior.common_behavior;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.UMLMutableLinkedList;
public class PropPanelSendAction extends PropPanelAction
  { 
private static final long serialVersionUID = -6002902665554123820L;
public PropPanelSendAction()
    { 
super("label.send-action", lookupIcon("SendAction"));
AbstractActionAddModelElement2 action =
            new ActionAddSendActionSignal();
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLSendActionSignalListModel(), action,
            new ActionNewSignal(), null, true);
list.setVisibleRowCount(2);
JScrollPane signalScroll = new JScrollPane(list);
addFieldBefore(Translator.localize("label.signal"),
                       signalScroll,
                       argumentsScroll);
} 
@Override
    protected void addExtraActions()
    { 
addAction(new ActionNewSignal());
} 

 } 
class ActionAddSendActionSignal extends AbstractActionAddModelElement2
  { 
private Object choiceClass = Model.getMetaTypes().getSignal();
private static final long serialVersionUID = -6172250439307650139L;
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-signal");
} 
@Override
    protected void doIt(Collection selected)
    { 
if(selected != null && selected.size() >= 1)//1
{ 
Model.getCommonBehaviorHelper().setSignal(
                getTarget(),
                selected.iterator().next());
} 
else
{ 
Model.getCommonBehaviorHelper().setSignal(getTarget(), null);
} 
} 
public ActionAddSendActionSignal()
    { 
super();
setMultiSelect(false);
} 
protected List getChoices()
    { 
List ret = new ArrayList();
if(getTarget() != null)//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
Object model = p.getRoot();
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(model, choiceClass));
} 
return ret;
} 
protected List getSelected()
    { 
List ret = new ArrayList();
Object signal = Model.getFacade().getSignal(getTarget());
if(signal != null)//1
{ 
ret.add(signal);
} 
return ret;
} 

 } 
class UMLSendActionSignalListModel extends UMLModelElementListModel2
  { 
private static final long serialVersionUID = -8126377938452286169L;
public UMLSendActionSignalListModel()
    { 
super("signal");
} 
protected boolean isValidElement(Object elem)
    { 
return Model.getFacade().isASignal(elem)
               && Model.getFacade().getSignal(getTarget()) == elem;
} 
protected void buildModelList()
    { 
removeAllElements();
addElement(Model.getFacade().getSignal(getTarget()));
} 

 } 
