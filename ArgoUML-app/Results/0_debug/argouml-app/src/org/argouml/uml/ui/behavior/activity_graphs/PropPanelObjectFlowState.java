
//#if -1018132176 
// Compilation Unit of /PropPanelObjectFlowState.java 
 

//#if 1400886994 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if -1005110001 
import java.awt.event.ActionEvent;
//#endif 


//#if -1730853371 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 275294819 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1515466268 
import java.util.ArrayList;
//#endif 


//#if 1074412229 
import java.util.Collection;
//#endif 


//#if -123492667 
import java.util.List;
//#endif 


//#if -2035168891 
import javax.swing.Action;
//#endif 


//#if 1573979042 
import javax.swing.Icon;
//#endif 


//#if 1332226164 
import javax.swing.JComboBox;
//#endif 


//#if -1009155204 
import javax.swing.JScrollPane;
//#endif 


//#if 1950166149 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 2100317510 
import org.argouml.i18n.Translator;
//#endif 


//#if 2034674444 
import org.argouml.model.Model;
//#endif 


//#if -1948704774 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 1550717387 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if 1846648486 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if 1940772394 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 160755864 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1776191001 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -2068643181 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if 1383358246 
import org.argouml.uml.ui.behavior.state_machines.AbstractPropPanelState;
//#endif 


//#if -799367841 
public class PropPanelObjectFlowState extends 
//#if -614189027 
AbstractPropPanelState
//#endif 

 implements 
//#if -945360796 
PropertyChangeListener
//#endif 

  { 

//#if 748303502 
private JComboBox classifierComboBox;
//#endif 


//#if 1245405093 
private JScrollPane statesScroll;
//#endif 


//#if 541610303 
private ActionNewClassifierInState actionNewCIS;
//#endif 


//#if 457698986 
private UMLObjectFlowStateClassifierComboBoxModel classifierComboBoxModel =
        new UMLObjectFlowStateClassifierComboBoxModel();
//#endif 


//#if 1312819249 
protected JComboBox getClassifierComboBox()
    { 

//#if 1672731886 
if(classifierComboBox == null)//1
{ 

//#if 2096176050 
classifierComboBox =
                new UMLSearchableComboBox(
                classifierComboBoxModel,
                new ActionSetObjectFlowStateClassifier(), true);
//#endif 

} 

//#endif 


//#if 460587811 
return classifierComboBox;
//#endif 

} 

//#endif 


//#if -614876036 
private static Object getType(Object target)
    { 

//#if -806552499 
Object type = Model.getFacade().getType(target);
//#endif 


//#if 2136793020 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -1511217663 
type = Model.getFacade().getType(type);
//#endif 

} 

//#endif 


//#if 1632989085 
return type;
//#endif 

} 

//#endif 


//#if 1570410807 
static void removeTopStateFrom(Collection ret)
    { 

//#if 912780087 
Collection tops = new ArrayList();
//#endif 


//#if 1375513869 
for (Object state : ret) //1
{ 

//#if -270416454 
if(Model.getFacade().isACompositeState(state)
                    && Model.getFacade().isTop(state))//1
{ 

//#if -126300380 
tops.add(state);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -790254371 
ret.removeAll(tops);
//#endif 

} 

//#endif 


//#if -1253523694 
@Override
    protected void addExtraButtons()
    { 

//#if 883830228 
actionNewCIS = new ActionNewClassifierInState();
//#endif 


//#if -202256863 
actionNewCIS.putValue(Action.SHORT_DESCRIPTION,
                              Translator.localize("button.new-classifierinstate"));
//#endif 


//#if -512525314 
Icon icon = ResourceLoaderWrapper.lookupIcon("ClassifierInState");
//#endif 


//#if -722006808 
actionNewCIS.putValue(Action.SMALL_ICON, icon);
//#endif 


//#if -403776763 
addAction(actionNewCIS);
//#endif 

} 

//#endif 


//#if 414464824 
public PropPanelObjectFlowState()
    { 

//#if -1783350078 
super("label.object-flow-state", lookupIcon("ObjectFlowState"));
//#endif 


//#if 1201698916 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -1400982428 
addField(Translator.localize("label.container"), getContainerScroll());
//#endif 


//#if 275479856 
addField(Translator.localize("label.synch-state"),
                 new UMLActionSynchCheckBox());
//#endif 


//#if -28866711 
addField(Translator.localize("label.type"),
                 new UMLComboBoxNavigator(
                     Translator.localize("label.classifierinstate.navigate.tooltip"),
                     getClassifierComboBox()));
//#endif 


//#if 748907905 
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLOFSStateListModel(),
            new ActionAddOFSState(),
            null,
            new ActionRemoveOFSState(),
            true);
//#endif 


//#if 1136485950 
statesScroll = new JScrollPane(list);
//#endif 


//#if -1553724817 
addField(Translator.localize("label.instate"),
                 statesScroll);
//#endif 


//#if 685460931 
addSeparator();
//#endif 


//#if 467591442 
addField(Translator.localize("label.incoming"),
                 getIncomingScroll());
//#endif 


//#if 1100514846 
addField(Translator.localize("label.outgoing"),
                 getOutgoingScroll());
//#endif 


//#if -747624192 
addField(Translator.localize("label.parameters"),
                 new JScrollPane(
                     new UMLMutableLinkedList(
                         new UMLObjectFlowStateParameterListModel(),
                         new ActionAddOFSParameter(),
                         new ActionNewOFSParameter(),
                         new ActionRemoveOFSParameter(),
                         true)));
//#endif 

} 

//#endif 


//#if 1782048256 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1947596652 
actionNewCIS.setEnabled(actionNewCIS.isEnabled());
//#endif 

} 

//#endif 


//#if -1449770681 
@Override
    public void setTarget(Object t)
    { 

//#if -1563021613 
Object oldTarget = getTarget();
//#endif 


//#if 72248258 
super.setTarget(t);
//#endif 


//#if 280502777 
actionNewCIS.setEnabled(actionNewCIS.isEnabled());
//#endif 


//#if -789572541 
if(Model.getFacade().isAObjectFlowState(oldTarget))//1
{ 

//#if 976828070 
Model.getPump().removeModelEventListener(this, oldTarget, "type");
//#endif 

} 

//#endif 


//#if 605436391 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if 1104612666 
Model.getPump().addModelEventListener(this, t, "type");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1323728454 
static class ActionRemoveOFSParameter extends 
//#if 306161255 
AbstractActionRemoveElement
//#endif 

  { 

//#if 144945962 
public ActionRemoveOFSParameter()
        { 

//#if 1797562878 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 


//#if -705168806 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 1706227824 
super.actionPerformed(e);
//#endif 


//#if -1965940661 
Object param = getObjectToRemove();
//#endif 


//#if -265042365 
if(param != null)//1
{ 

//#if 801771270 
Object t = getTarget();
//#endif 


//#if 1680003766 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -836740951 
Model.getActivityGraphsHelper().removeParameter(t, param);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 504522158 
static class ActionRemoveOFSState extends 
//#if -282668760 
AbstractActionRemoveElement
//#endif 

  { 

//#if 2002452007 
private static final long serialVersionUID = -5113809512624883836L;
//#endif 


//#if 987808313 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if -790571970 
super.actionPerformed(e);
//#endif 


//#if 1109507897 
Object state = getObjectToRemove();
//#endif 


//#if 177073465 
if(state != null)//1
{ 

//#if 266544278 
Object t = getTarget();
//#endif 


//#if -889908154 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -556193031 
Object type = Model.getFacade().getType(t);
//#endif 


//#if 356721983 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -1389500294 
Collection states =
                            new ArrayList(
                            Model.getFacade().getInStates(type));
//#endif 


//#if -1366351259 
states.remove(state);
//#endif 


//#if -1154315225 
Model.getActivityGraphsHelper()
                        .setInStates(type, states);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 925611889 
public ActionRemoveOFSState()
        { 

//#if -1775394122 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1649899225 
static class ActionAddOFSParameter extends 
//#if -853407651 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -402899042 
private Object choiceClass = Model.getMetaTypes().getParameter();
//#endif 


//#if -1999147902 
protected List getChoices()
        { 

//#if -387104336 
List ret = new ArrayList();
//#endif 


//#if -729621132 
Object t = getTarget();
//#endif 


//#if -282373212 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if 1084655449 
Object classifier = getType(t);
//#endif 


//#if -2042173221 
if(Model.getFacade().isAClassifier(classifier))//1
{ 

//#if -994611452 
ret.addAll(Model.getModelManagementHelper()
                               .getAllModelElementsOfKindWithModel(classifier,
                                       choiceClass));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1393365437 
return ret;
//#endif 

} 

//#endif 


//#if 641092659 
protected String getDialogTitle()
        { 

//#if -1277752285 
return Translator.localize("dialog.title.add-state");
//#endif 

} 

//#endif 


//#if 259086765 
protected List getSelected()
        { 

//#if -1945967413 
Object t = getTarget();
//#endif 


//#if -122860485 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -332241617 
return new ArrayList(Model.getFacade().getParameters(t));
//#endif 

} 

//#endif 


//#if -372679549 
return new ArrayList();
//#endif 

} 

//#endif 


//#if 1624583657 
public ActionAddOFSParameter()
        { 

//#if 482368731 
super();
//#endif 


//#if -1524847911 
setMultiSelect(true);
//#endif 

} 

//#endif 


//#if 1383784953 
protected void doIt(Collection selected)
        { 

//#if 762026780 
Object t = getTarget();
//#endif 


//#if -324743348 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -1896684654 
Model.getActivityGraphsHelper().setParameters(t, selected);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1478795201 
static class ActionAddOFSState extends 
//#if 2125345434 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -1896723495 
private Object choiceClass = Model.getMetaTypes().getState();
//#endif 


//#if -723337923 
private static final long serialVersionUID = 7266495601719117169L;
//#endif 


//#if -876670939 
protected List getChoices()
        { 

//#if -116913711 
List ret = new ArrayList();
//#endif 


//#if 1174728947 
Object t = getTarget();
//#endif 


//#if 363001443 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if 368841155 
Object classifier = getType(t);
//#endif 


//#if -217946171 
if(Model.getFacade().isAClassifier(classifier))//1
{ 

//#if -1775796412 
ret.addAll(Model.getModelManagementHelper()
                               .getAllModelElementsOfKindWithModel(classifier,
                                       choiceClass));
//#endif 

} 

//#endif 


//#if -1604285241 
removeTopStateFrom(ret);
//#endif 

} 

//#endif 


//#if -2119138174 
return ret;
//#endif 

} 

//#endif 


//#if -1506842218 
protected String getDialogTitle()
        { 

//#if -1438161776 
return Translator.localize("dialog.title.add-state");
//#endif 

} 

//#endif 


//#if 696134250 
protected List getSelected()
        { 

//#if -1579217430 
Object t = getTarget();
//#endif 


//#if 537476250 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if 2082113475 
Object type = Model.getFacade().getType(t);
//#endif 


//#if 1056753205 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -811803878 
return new ArrayList(Model.getFacade().getInStates(type));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1888331964 
return new ArrayList();
//#endif 

} 

//#endif 


//#if -1116526308 
protected void doIt(Collection selected)
        { 

//#if 1131001634 
Object t = getTarget();
//#endif 


//#if -1763815470 
if(Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -1727446836 
Object type = Model.getFacade().getType(t);
//#endif 


//#if 118439308 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -1206439062 
Model.getActivityGraphsHelper().setInStates(type, selected);
//#endif 

} 
else

//#if 2100744740 
if(Model.getFacade().isAClassifier(type)
                           && (selected != null)
                           && (selected.size() > 0))//1
{ 

//#if -1856850452 
Object cis =
                        Model.getActivityGraphsFactory()
                        .buildClassifierInState(type, selected);
//#endif 


//#if -1452179189 
Model.getCoreHelper().setType(t, cis);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1015554060 
public ActionAddOFSState()
        { 

//#if 923584242 
super();
//#endif 


//#if -960913886 
setMultiSelect(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -406345103 
static class UMLObjectFlowStateParameterListModel extends 
//#if -93189343 
UMLModelElementListModel2
//#endif 

  { 

//#if 582186819 
protected boolean isValidElement(Object element)
        { 

//#if 1073222487 
return Model.getFacade().getParameters(getTarget()).contains(
                       element);
//#endif 

} 

//#endif 


//#if -737112817 
protected void buildModelList()
        { 

//#if 1631139690 
if(getTarget() != null)//1
{ 

//#if -789923466 
setAllElements(Model.getFacade().getParameters(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 835001385 
public UMLObjectFlowStateParameterListModel()
        { 

//#if 148133284 
super("parameter");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -2012012200 
static class ActionNewOFSParameter extends 
//#if 976871662 
AbstractActionNewModelElement
//#endif 

  { 

//#if 586654734 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if 2096325197 
Object target = getTarget();
//#endif 


//#if -919681281 
if(Model.getFacade().isAObjectFlowState(target))//1
{ 

//#if -72570442 
Object type = getType(target);
//#endif 


//#if -122148604 
Object parameter = Model.getCoreFactory().createParameter();
//#endif 


//#if -520500237 
Model.getCoreHelper().setType(parameter, type);
//#endif 


//#if -697322083 
Model.getActivityGraphsHelper().addParameter(target, parameter);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 393025387 
ActionNewOFSParameter()
        { 

//#if 1242941316 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -856307071 
static class UMLOFSStateListModel extends 
//#if 1355327954 
UMLModelElementListModel2
//#endif 

  { 

//#if 1149806330 
private static final long serialVersionUID = -7742772495832660119L;
//#endif 


//#if -407559917 
protected boolean isValidElement(Object elem)
        { 

//#if 776066549 
Object t = getTarget();
//#endif 


//#if 2029233111 
if(Model.getFacade().isAState(elem)
                    && Model.getFacade().isAObjectFlowState(t))//1
{ 

//#if -1227407062 
Object type = Model.getFacade().getType(t);
//#endif 


//#if -1346636178 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if -1648006154 
Collection c = Model.getFacade().getInStates(type);
//#endif 


//#if 287471146 
if(c.contains(elem))//1
{ 

//#if 1295916426 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2123835714 
return false;
//#endif 

} 

//#endif 


//#if -878286016 
protected void buildModelList()
        { 

//#if -695531858 
if(getTarget() != null)//1
{ 

//#if -539280661 
Object classifier = Model.getFacade().getType(getTarget());
//#endif 


//#if -279973343 
if(Model.getFacade().isAClassifierInState(classifier))//1
{ 

//#if -965012121 
Collection c = Model.getFacade().getInStates(classifier);
//#endif 


//#if 905424946 
setAllElements(c);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 578248168 
public UMLOFSStateListModel()
        { 

//#if -268707555 
super("type");
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

