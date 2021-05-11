package org.argouml.uml.ui.behavior.activity_graphs;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
import org.argouml.uml.ui.AbstractActionRemoveElement;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
import org.tigris.gef.undo.UndoableAction;
class UMLClassifierInStateTypeComboBoxModel extends UMLComboBoxModel2
  { 
private static final long serialVersionUID = 1705685511742198305L;
public void modelChanged(PropertyChangeEvent evt)
    { 
if(evt instanceof AttributeChangeEvent)//1
{ 
if(evt.getPropertyName().equals("type"))//1
{ 
if(evt.getSource() == getTarget()
                        && (getChangedElement(evt) != null))//1
{ 
Object elem = getChangedElement(evt);
setSelectedItem(elem);
} 
} 
} 
} 
protected Object getSelectedModelElement()
    { 
if(getTarget() != null)//1
{ 
Object type = Model.getFacade().getType(getTarget());
return type;
} 
return null;
} 
protected void buildModelList()
    { 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
Collection classifiers =
            new ArrayList(Model.getCoreHelper().getAllClassifiers(model));
Collection newList = new ArrayList();
for (Object classifier : classifiers) //1
{ 
if(!Model.getFacade().isAClassifierInState(classifier))//1
{ 
newList.add(classifier);
} 
} 
if(getTarget() != null)//1
{ 
Object type = Model.getFacade().getType(getTarget());
if(Model.getFacade().isAClassifierInState(type))//1
{ 
type = Model.getFacade().getType(type);
} 
if(type != null)//1
if(!newList.contains(type))//1
{ 
newList.add(type);
} 
} 
setElements(newList);
} 
public UMLClassifierInStateTypeComboBoxModel()
    { 
super("type", false);
} 
protected boolean isValidElement(Object o)
    { 
return Model.getFacade().isAClassifier(o)
               && !Model.getFacade().isAClassifierInState(o);
} 

 } 
public class PropPanelClassifierInState extends PropPanelClassifier
  { 
private static final long serialVersionUID = 609338855898756817L;
private JComboBox typeComboBox;
private JScrollPane statesScroll;
private UMLClassifierInStateTypeComboBoxModel typeComboBoxModel =
        new UMLClassifierInStateTypeComboBoxModel();
protected JComboBox getClassifierInStateTypeSelector()
    { 
if(typeComboBox == null)//1
{ 
typeComboBox = new UMLSearchableComboBox(
                typeComboBoxModel,
                new ActionSetClassifierInStateType(), true);
} 
return typeComboBox;
} 
public PropPanelClassifierInState()
    { 
super("label.classifier-in-state", lookupIcon("ClassifierInState"));
addField(Translator.localize("label.name"),
                 getNameTextField());
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
addSeparator();
addField(Translator.localize("label.type"),
                 new UMLComboBoxNavigator(
                     Translator.localize("label.class.navigate.tooltip"),
                     getClassifierInStateTypeSelector()));
AbstractActionAddModelElement2 actionAdd =
            new ActionAddCISState();
AbstractActionRemoveElement actionRemove =
            new ActionRemoveCISState();
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLCISStateListModel(), actionAdd, null,
            actionRemove, true);
statesScroll = new JScrollPane(list);
addField(Translator.localize("label.instate"),
                 statesScroll);
addAction(new ActionNavigateNamespace());
addAction(getDeleteAction());
} 

 } 
class UMLCISStateListModel extends UMLModelElementListModel2
  { 
private static final long serialVersionUID = -8786823179344335113L;
protected boolean isValidElement(Object elem)
    { 
Object cis = getTarget();
if(Model.getFacade().isAClassifierInState(cis))//1
{ 
Collection c = Model.getFacade().getInStates(cis);
if(c.contains(elem))//1
{ 
return true;
} 
} 
return false;
} 
protected void buildModelList()
    { 
Object cis = getTarget();
if(Model.getFacade().isAClassifierInState(cis))//1
{ 
Collection c = Model.getFacade().getInStates(cis);
setAllElements(c);
} 
} 
public UMLCISStateListModel()
    { 
super("inState");
} 

 } 
class ActionSetClassifierInStateType extends UndoableAction
  { 
private static final long serialVersionUID = -7537482435346517599L;
ActionSetClassifierInStateType()
    { 
super();
} 
public void actionPerformed(ActionEvent e)
    { 
Object source = e.getSource();
Object oldClassifier = null;
Object newClassifier = null;
Object cis = null;
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object obj = box.getTarget();
if(Model.getFacade().isAClassifierInState(obj))//1
{ 
try//1
{ 
oldClassifier = Model.getFacade().getType(obj);
} 
catch (InvalidElementException e1) //1
{ 
return;
} 
cis = obj;
} 
Object cl = box.getSelectedItem();
if(Model.getFacade().isAClassifier(cl))//1
{ 
newClassifier = cl;
} 
} 
if(newClassifier != oldClassifier
                && cis != null
                && newClassifier != null)//1
{ 
Model.getCoreHelper().setType(cis, newClassifier);
super.actionPerformed(e);
} 
} 

 } 
class ActionRemoveCISState extends AbstractActionRemoveElement
  { 
private static final long serialVersionUID = -1431919084967610562L;
public ActionRemoveCISState()
    { 
super(Translator.localize("menu.popup.remove"));
} 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object state = getObjectToRemove();
if(state != null)//1
{ 
Object cis = getTarget();
if(Model.getFacade().isAClassifierInState(cis))//1
{ 
Collection states = new ArrayList(
                    Model.getFacade().getInStates(cis));
states.remove(state);
Model.getActivityGraphsHelper().setInStates(cis, states);
} 
} 
} 

 } 
class ActionAddCISState extends AbstractActionAddModelElement2
  { 
private static final long serialVersionUID = -3892619042821099432L;
private Object choiceClass = Model.getMetaTypes().getState();
protected List getChoices()
    { 
List ret = new ArrayList();
Object cis = getTarget();
Object classifier = Model.getFacade().getType(cis);
if(Model.getFacade().isAClassifier(classifier))//1
{ 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(classifier,
                               choiceClass));
} 
return ret;
} 
protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-state");
} 
protected List getSelected()
    { 
Object cis = getTarget();
if(Model.getFacade().isAClassifierInState(cis))//1
{ 
return new ArrayList(Model.getFacade().getInStates(cis));
} 
return Collections.EMPTY_LIST;
} 
public ActionAddCISState()
    { 
super();
setMultiSelect(true);
} 
protected void doIt(Collection selected)
    { 
Object cis = getTarget();
if(Model.getFacade().isAClassifierInState(cis))//1
{ 
Model.getActivityGraphsHelper().setInStates(cis, selected);
} 
} 

 } 
