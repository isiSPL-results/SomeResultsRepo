// Compilation Unit of /PropPanelObjectFlowState.java 
 
package org.argouml.uml.ui.behavior.activity_graphs;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
import org.argouml.uml.ui.AbstractActionNewModelElement;
import org.argouml.uml.ui.AbstractActionRemoveElement;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.argouml.uml.ui.behavior.state_machines.AbstractPropPanelState;
public class PropPanelObjectFlowState extends AbstractPropPanelState
 implements PropertyChangeListener
  { 
private JComboBox classifierComboBox;
private JScrollPane statesScroll;
private ActionNewClassifierInState actionNewCIS;
private UMLObjectFlowStateClassifierComboBoxModel classifierComboBoxModel =
        new UMLObjectFlowStateClassifierComboBoxModel();
protected JComboBox getClassifierComboBox()
    { 
if(classifierComboBox == null)//1
{ 
classifierComboBox =
                new UMLSearchableComboBox(
                classifierComboBoxModel,
                new ActionSetObjectFlowStateClassifier(), true);
} 

return classifierComboBox;
} 

private static Object getType(Object target)
    { 
Object type = Model.getFacade().getType(target);
if(Model.getFacade().isAClassifierInState(type))//1
{ 
type = Model.getFacade().getType(type);
} 

return type;
} 

static void removeTopStateFrom(Collection ret)
    { 
Collection tops = new ArrayList();
for (Object state : ret) //1
{ 
if(Model.getFacade().isACompositeState(state)
                    && Model.getFacade().isTop(state))//1
{ 
tops.add(state);
} 

} 

ret.removeAll(tops);
} 

@Override
    protected void addExtraButtons()
    { 
actionNewCIS = new ActionNewClassifierInState();
actionNewCIS.putValue(Action.SHORT_DESCRIPTION,
                              Translator.localize("button.new-classifierinstate"));
Icon icon = ResourceLoaderWrapper.lookupIcon("ClassifierInState");
actionNewCIS.putValue(Action.SMALL_ICON, icon);
addAction(actionNewCIS);
} 

public PropPanelObjectFlowState()
    { 
super("label.object-flow-state", lookupIcon("ObjectFlowState"));
addField(Translator.localize("label.name"), getNameTextField());
addField(Translator.localize("label.container"), getContainerScroll());
addField(Translator.localize("label.synch-state"),
                 new UMLActionSynchCheckBox());
addField(Translator.localize("label.type"),
                 new UMLComboBoxNavigator(
                     Translator.localize("label.classifierinstate.navigate.tooltip"),
                     getClassifierComboBox()));
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLOFSStateListModel(),
            new ActionAddOFSState(),
            null,
            new ActionRemoveOFSState(),
            true);
statesScroll = new JScrollPane(list);
addField(Translator.localize("label.instate"),
                 statesScroll);
addSeparator();
addField(Translator.localize("label.incoming"),
                 getIncomingScroll());
addField(Translator.localize("label.outgoing"),
                 getOutgoingScroll());
addField(Translator.localize("label.parameters"),
                 new JScrollPane(
                     new UMLMutableLinkedList(
                         new UMLObjectFlowStateParameterListModel(),
                         new ActionAddOFSParameter(),
                         new ActionNewOFSParameter(),
                         new ActionRemoveOFSParameter(),
                         true)));
} 

public void propertyChange(PropertyChangeEvent evt)
    { 
actionNewCIS.setEnabled(actionNewCIS.isEnabled());
} 

@Override
    public void setTarget(Object t)
    { 
Object oldTarget = getTarget();
super.setTarget(t);
actionNewCIS.setEnabled(actionNewCIS.isEnabled());
if(Model.getFacade().isAObjectFlowState(oldTarget))//1
{ 
Model.getPump().removeModelEventListener(this, oldTarget, "type");
} 

if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Model.getPump().addModelEventListener(this, t, "type");
} 

} 

static class ActionRemoveOFSParameter extends AbstractActionRemoveElement
  { 
public ActionRemoveOFSParameter()
        { 
super(Translator.localize("menu.popup.remove"));
} 

@Override
        public void actionPerformed(ActionEvent e)
        { 
super.actionPerformed(e);
Object param = getObjectToRemove();
if(param != null)//1
{ 
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Model.getActivityGraphsHelper().removeParameter(t, param);
} 

} 

} 

 } 

static class ActionRemoveOFSState extends AbstractActionRemoveElement
  { 
private static final long serialVersionUID = -5113809512624883836L;
@Override
        public void actionPerformed(ActionEvent e)
        { 
super.actionPerformed(e);
Object state = getObjectToRemove();
if(state != null)//1
{ 
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Object type = Model.getFacade().getType(t);
if(Model.getFacade().isAClassifierInState(type))//1
{ 
Collection states =
                            new ArrayList(
                            Model.getFacade().getInStates(type));
states.remove(state);
Model.getActivityGraphsHelper()
                        .setInStates(type, states);
} 

} 

} 

} 

public ActionRemoveOFSState()
        { 
super(Translator.localize("menu.popup.remove"));
} 

 } 

static class ActionAddOFSParameter extends AbstractActionAddModelElement2
  { 
private Object choiceClass = Model.getMetaTypes().getParameter();
protected List getChoices()
        { 
List ret = new ArrayList();
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Object classifier = getType(t);
if(Model.getFacade().isAClassifier(classifier))//1
{ 
ret.addAll(Model.getModelManagementHelper()
                               .getAllModelElementsOfKindWithModel(classifier,
                                       choiceClass));
} 

} 

return ret;
} 

protected String getDialogTitle()
        { 
return Translator.localize("dialog.title.add-state");
} 

protected List getSelected()
        { 
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
return new ArrayList(Model.getFacade().getParameters(t));
} 

return new ArrayList();
} 

public ActionAddOFSParameter()
        { 
super();
setMultiSelect(true);
} 

protected void doIt(Collection selected)
        { 
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Model.getActivityGraphsHelper().setParameters(t, selected);
} 

} 

 } 

static class ActionAddOFSState extends AbstractActionAddModelElement2
  { 
private Object choiceClass = Model.getMetaTypes().getState();
private static final long serialVersionUID = 7266495601719117169L;
protected List getChoices()
        { 
List ret = new ArrayList();
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Object classifier = getType(t);
if(Model.getFacade().isAClassifier(classifier))//1
{ 
ret.addAll(Model.getModelManagementHelper()
                               .getAllModelElementsOfKindWithModel(classifier,
                                       choiceClass));
} 

removeTopStateFrom(ret);
} 

return ret;
} 

protected String getDialogTitle()
        { 
return Translator.localize("dialog.title.add-state");
} 

protected List getSelected()
        { 
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Object type = Model.getFacade().getType(t);
if(Model.getFacade().isAClassifierInState(type))//1
{ 
return new ArrayList(Model.getFacade().getInStates(type));
} 

} 

return new ArrayList();
} 

protected void doIt(Collection selected)
        { 
Object t = getTarget();
if(Model.getFacade().isAObjectFlowState(t))//1
{ 
Object type = Model.getFacade().getType(t);
if(Model.getFacade().isAClassifierInState(type))//1
{ 
Model.getActivityGraphsHelper().setInStates(type, selected);
} 
else
if(Model.getFacade().isAClassifier(type)
                           && (selected != null)
                           && (selected.size() > 0))//1
{ 
Object cis =
                        Model.getActivityGraphsFactory()
                        .buildClassifierInState(type, selected);
Model.getCoreHelper().setType(t, cis);
} 


} 

} 

public ActionAddOFSState()
        { 
super();
setMultiSelect(true);
} 

 } 

static class UMLObjectFlowStateParameterListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
        { 
return Model.getFacade().getParameters(getTarget()).contains(
                       element);
} 

protected void buildModelList()
        { 
if(getTarget() != null)//1
{ 
setAllElements(Model.getFacade().getParameters(getTarget()));
} 

} 

public UMLObjectFlowStateParameterListModel()
        { 
super("parameter");
} 

 } 

static class ActionNewOFSParameter extends AbstractActionNewModelElement
  { 
@Override
        public void actionPerformed(ActionEvent e)
        { 
Object target = getTarget();
if(Model.getFacade().isAObjectFlowState(target))//1
{ 
Object type = getType(target);
Object parameter = Model.getCoreFactory().createParameter();
Model.getCoreHelper().setType(parameter, type);
Model.getActivityGraphsHelper().addParameter(target, parameter);
} 

} 

ActionNewOFSParameter()
        { 
super();
} 

 } 

static class UMLOFSStateListModel extends UMLModelElementListModel2
  { 
private static final long serialVersionUID = -7742772495832660119L;
protected boolean isValidElement(Object elem)
        { 
Object t = getTarget();
if(Model.getFacade().isAState(elem)
                    && Model.getFacade().isAObjectFlowState(t))//1
{ 
Object type = Model.getFacade().getType(t);
if(Model.getFacade().isAClassifierInState(type))//1
{ 
Collection c = Model.getFacade().getInStates(type);
if(c.contains(elem))//1
{ 
return true;
} 

} 

} 

return false;
} 

protected void buildModelList()
        { 
if(getTarget() != null)//1
{ 
Object classifier = Model.getFacade().getType(getTarget());
if(Model.getFacade().isAClassifierInState(classifier))//1
{ 
Collection c = Model.getFacade().getInStates(classifier);
setAllElements(c);
} 

} 

} 

public UMLOFSStateListModel()
        { 
super("type");
} 

 } 

 } 


