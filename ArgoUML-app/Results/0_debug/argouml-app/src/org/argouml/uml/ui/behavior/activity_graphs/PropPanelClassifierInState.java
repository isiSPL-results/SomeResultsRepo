
//#if 1453843876 
// Compilation Unit of /PropPanelClassifierInState.java 
 

//#if -954039740 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if 1053049089 
import java.awt.event.ActionEvent;
//#endif 


//#if 748355831 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -258615702 
import java.util.ArrayList;
//#endif 


//#if 1912446007 
import java.util.Collection;
//#endif 


//#if -843714132 
import java.util.Collections;
//#endif 


//#if -145652297 
import java.util.List;
//#endif 


//#if 1541469506 
import javax.swing.JComboBox;
//#endif 


//#if -1789766454 
import javax.swing.JScrollPane;
//#endif 


//#if 1478739860 
import org.argouml.i18n.Translator;
//#endif 


//#if 1421209721 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1805735355 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if -484827943 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1254063194 
import org.argouml.model.Model;
//#endif 


//#if -1666069560 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if -2085145192 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if -1239632124 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if -486528803 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1431515906 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if -1759097992 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 2100796426 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1181094091 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -800508155 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if 1338244266 
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
//#endif 


//#if 212072087 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 624245060 
class UMLClassifierInStateTypeComboBoxModel extends 
//#if 535830731 
UMLComboBoxModel2
//#endif 

  { 

//#if -2147076866 
private static final long serialVersionUID = 1705685511742198305L;
//#endif 


//#if 29086314 
public void modelChanged(PropertyChangeEvent evt)
    { 

//#if 1505861063 
if(evt instanceof AttributeChangeEvent)//1
{ 

//#if 1468170753 
if(evt.getPropertyName().equals("type"))//1
{ 

//#if 2075928526 
if(evt.getSource() == getTarget()
                        && (getChangedElement(evt) != null))//1
{ 

//#if -1008956212 
Object elem = getChangedElement(evt);
//#endif 


//#if -1958093751 
setSelectedItem(elem);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1738691033 
protected Object getSelectedModelElement()
    { 

//#if -365234160 
if(getTarget() != null)//1
{ 

//#if -1069340039 
Object type = Model.getFacade().getType(getTarget());
//#endif 


//#if -947586892 
return type;
//#endif 

} 

//#endif 


//#if 48953116 
return null;
//#endif 

} 

//#endif 


//#if 213988653 
protected void buildModelList()
    { 

//#if 270965011 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if -1946693636 
Collection classifiers =
            new ArrayList(Model.getCoreHelper().getAllClassifiers(model));
//#endif 


//#if -1215308680 
Collection newList = new ArrayList();
//#endif 


//#if 19694637 
for (Object classifier : classifiers) //1
{ 

//#if -1400513131 
if(!Model.getFacade().isAClassifierInState(classifier))//1
{ 

//#if -1967153349 
newList.add(classifier);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -211041738 
if(getTarget() != null)//1
{ 

//#if 307173319 
Object type = Model.getFacade().getType(getTarget());
//#endif 


//#if 325386821 
if(Model.getFacade().isAClassifierInState(type))//1
{ 

//#if 549057594 
type = Model.getFacade().getType(type);
//#endif 

} 

//#endif 


//#if -307987387 
if(type != null)//1

//#if -748941317 
if(!newList.contains(type))//1
{ 

//#if 2144957711 
newList.add(type);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1501034125 
setElements(newList);
//#endif 

} 

//#endif 


//#if 1534852612 
public UMLClassifierInStateTypeComboBoxModel()
    { 

//#if -974298961 
super("type", false);
//#endif 

} 

//#endif 


//#if -140998834 
protected boolean isValidElement(Object o)
    { 

//#if -1878857767 
return Model.getFacade().isAClassifier(o)
               && !Model.getFacade().isAClassifierInState(o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1447720728 
public class PropPanelClassifierInState extends 
//#if 1243034420 
PropPanelClassifier
//#endif 

  { 

//#if 831021999 
private static final long serialVersionUID = 609338855898756817L;
//#endif 


//#if 998442162 
private JComboBox typeComboBox;
//#endif 


//#if -168829758 
private JScrollPane statesScroll;
//#endif 


//#if 145519630 
private UMLClassifierInStateTypeComboBoxModel typeComboBoxModel =
        new UMLClassifierInStateTypeComboBoxModel();
//#endif 


//#if 1685374358 
protected JComboBox getClassifierInStateTypeSelector()
    { 

//#if 1398892503 
if(typeComboBox == null)//1
{ 

//#if -1341558988 
typeComboBox = new UMLSearchableComboBox(
                typeComboBoxModel,
                new ActionSetClassifierInStateType(), true);
//#endif 

} 

//#endif 


//#if -758104070 
return typeComboBox;
//#endif 

} 

//#endif 


//#if -1267560446 
public PropPanelClassifierInState()
    { 

//#if 456024892 
super("label.classifier-in-state", lookupIcon("ClassifierInState"));
//#endif 


//#if 674534092 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if 696048334 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1652873259 
addSeparator();
//#endif 


//#if 1687443636 
addField(Translator.localize("label.type"),
                 new UMLComboBoxNavigator(
                     Translator.localize("label.class.navigate.tooltip"),
                     getClassifierInStateTypeSelector()));
//#endif 


//#if 1196448312 
AbstractActionAddModelElement2 actionAdd =
            new ActionAddCISState();
//#endif 


//#if 1749928874 
AbstractActionRemoveElement actionRemove =
            new ActionRemoveCISState();
//#endif 


//#if 1080865776 
UMLMutableLinkedList list =
            new UMLMutableLinkedList(
            new UMLCISStateListModel(), actionAdd, null,
            actionRemove, true);
//#endif 


//#if 1187164886 
statesScroll = new JScrollPane(list);
//#endif 


//#if 1396984071 
addField(Translator.localize("label.instate"),
                 statesScroll);
//#endif 


//#if -455914077 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -565817842 
addAction(getDeleteAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 791653322 
class UMLCISStateListModel extends 
//#if -1601300544 
UMLModelElementListModel2
//#endif 

  { 

//#if 734795518 
private static final long serialVersionUID = -8786823179344335113L;
//#endif 


//#if 1467452645 
protected boolean isValidElement(Object elem)
    { 

//#if -1213342015 
Object cis = getTarget();
//#endif 


//#if 1657413834 
if(Model.getFacade().isAClassifierInState(cis))//1
{ 

//#if 477181616 
Collection c = Model.getFacade().getInStates(cis);
//#endif 


//#if -1000337819 
if(c.contains(elem))//1
{ 

//#if 1543909074 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1639094713 
return false;
//#endif 

} 

//#endif 


//#if -1106824658 
protected void buildModelList()
    { 

//#if 581785567 
Object cis = getTarget();
//#endif 


//#if 61268200 
if(Model.getFacade().isAClassifierInState(cis))//1
{ 

//#if 780115491 
Collection c = Model.getFacade().getInStates(cis);
//#endif 


//#if 1001753082 
setAllElements(c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -599518581 
public UMLCISStateListModel()
    { 

//#if 1513142070 
super("inState");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 695586736 
class ActionSetClassifierInStateType extends 
//#if 1530422989 
UndoableAction
//#endif 

  { 

//#if -554607074 
private static final long serialVersionUID = -7537482435346517599L;
//#endif 


//#if 244415795 
ActionSetClassifierInStateType()
    { 

//#if 1357494145 
super();
//#endif 

} 

//#endif 


//#if 1457489908 
public void actionPerformed(ActionEvent e)
    { 

//#if 2085198381 
Object source = e.getSource();
//#endif 


//#if 2058716664 
Object oldClassifier = null;
//#endif 


//#if 1235840881 
Object newClassifier = null;
//#endif 


//#if -1694989667 
Object cis = null;
//#endif 


//#if -796918797 
if(source instanceof UMLComboBox2)//1
{ 

//#if -1322778058 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -363135214 
Object obj = box.getTarget();
//#endif 


//#if -1051987496 
if(Model.getFacade().isAClassifierInState(obj))//1
{ 

//#if 1509614820 
try //1
{ 

//#if 122072948 
oldClassifier = Model.getFacade().getType(obj);
//#endif 

} 

//#if -838694713 
catch (InvalidElementException e1) //1
{ 

//#if 846495688 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -76595742 
cis = obj;
//#endif 

} 

//#endif 


//#if 1812821655 
Object cl = box.getSelectedItem();
//#endif 


//#if 1554812706 
if(Model.getFacade().isAClassifier(cl))//1
{ 

//#if -446544771 
newClassifier = cl;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -752800694 
if(newClassifier != oldClassifier
                && cis != null
                && newClassifier != null)//1
{ 

//#if 131694312 
Model.getCoreHelper().setType(cis, newClassifier);
//#endif 


//#if -241658443 
super.actionPerformed(e);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1672588469 
class ActionRemoveCISState extends 
//#if 1190156990 
AbstractActionRemoveElement
//#endif 

  { 

//#if -664780390 
private static final long serialVersionUID = -1431919084967610562L;
//#endif 


//#if 569335850 
public ActionRemoveCISState()
    { 

//#if -140058798 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 


//#if -2006409589 
public void actionPerformed(ActionEvent e)
    { 

//#if 698168431 
super.actionPerformed(e);
//#endif 


//#if 819131880 
Object state = getObjectToRemove();
//#endif 


//#if 2076045864 
if(state != null)//1
{ 

//#if -1965162516 
Object cis = getTarget();
//#endif 


//#if -891673739 
if(Model.getFacade().isAClassifierInState(cis))//1
{ 

//#if -191838668 
Collection states = new ArrayList(
                    Model.getFacade().getInStates(cis));
//#endif 


//#if 746562310 
states.remove(state);
//#endif 


//#if 420700433 
Model.getActivityGraphsHelper().setInStates(cis, states);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1455725992 
class ActionAddCISState extends 
//#if -1194525986 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -790861290 
private static final long serialVersionUID = -3892619042821099432L;
//#endif 


//#if 928807189 
private Object choiceClass = Model.getMetaTypes().getState();
//#endif 


//#if 1028468065 
protected List getChoices()
    { 

//#if 1725689954 
List ret = new ArrayList();
//#endif 


//#if -645055799 
Object cis = getTarget();
//#endif 


//#if -1890633457 
Object classifier = Model.getFacade().getType(cis);
//#endif 


//#if -993687686 
if(Model.getFacade().isAClassifier(classifier))//1
{ 

//#if -1395245281 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(classifier,
                               choiceClass));
//#endif 

} 

//#endif 


//#if 605308497 
return ret;
//#endif 

} 

//#endif 


//#if -1343641134 
protected String getDialogTitle()
    { 

//#if -1813394626 
return Translator.localize("dialog.title.add-state");
//#endif 

} 

//#endif 


//#if -374098770 
protected List getSelected()
    { 

//#if 1469906390 
Object cis = getTarget();
//#endif 


//#if -428704161 
if(Model.getFacade().isAClassifierInState(cis))//1
{ 

//#if 2038018592 
return new ArrayList(Model.getFacade().getInStates(cis));
//#endif 

} 

//#endif 


//#if 1046310702 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if 2120350911 
public ActionAddCISState()
    { 

//#if -342356031 
super();
//#endif 


//#if 253320627 
setMultiSelect(true);
//#endif 

} 

//#endif 


//#if 141773912 
protected void doIt(Collection selected)
    { 

//#if -766803284 
Object cis = getTarget();
//#endif 


//#if 1790707253 
if(Model.getFacade().isAClassifierInState(cis))//1
{ 

//#if 1158541827 
Model.getActivityGraphsHelper().setInStates(cis, selected);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

