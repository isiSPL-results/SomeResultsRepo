
//#if -1827078587 
// Compilation Unit of /PropPanelStereotype.java 
 

//#if 1572308351 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if -604965434 
import java.awt.event.ActionEvent;
//#endif 


//#if -280836795 
import java.util.ArrayList;
//#endif 


//#if 1223592124 
import java.util.Collection;
//#endif 


//#if -723348025 
import java.util.Collections;
//#endif 


//#if 1002782536 
import java.util.HashSet;
//#endif 


//#if -1956046813 
import java.util.LinkedList;
//#endif 


//#if -562333188 
import java.util.List;
//#endif 


//#if 1228990874 
import java.util.Set;
//#endif 


//#if 408788160 
import javax.swing.DefaultListCellRenderer;
//#endif 


//#if 1938414012 
import javax.swing.JList;
//#endif 


//#if 68258872 
import javax.swing.JPanel;
//#endif 


//#if -2082054619 
import javax.swing.JScrollPane;
//#endif 


//#if 1619897199 
import org.argouml.i18n.Translator;
//#endif 


//#if 961775029 
import org.argouml.model.Model;
//#endif 


//#if -206730909 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 288806365 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if -31899191 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 77220914 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if -1203992177 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1520573808 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -752571523 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1130527951 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementAbstractCheckBox;
//#endif 


//#if 633463827 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementGeneralizationListModel;
//#endif 


//#if 2102658451 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementLeafCheckBox;
//#endif 


//#if -505636721 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementRootCheckBox;
//#endif 


//#if 761276514 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementSpecializationListModel;
//#endif 


//#if -1170837603 
import org.tigris.gef.undo.UndoManager;
//#endif 


//#if 630767392 
public class PropPanelStereotype extends 
//#if -2029939795 
PropPanelModelElement
//#endif 

  { 

//#if -1186160718 
private static final long serialVersionUID = 8038077991746618130L;
//#endif 


//#if -1774562523 
private List<String> metaClasses;
//#endif 


//#if 680406433 
private static UMLGeneralizableElementSpecializationListModel
    specializationListModel =
        new UMLGeneralizableElementSpecializationListModel();
//#endif 


//#if 666401266 
private static UMLGeneralizableElementGeneralizationListModel
    generalizationListModel =
        new UMLGeneralizableElementGeneralizationListModel();
//#endif 


//#if -1351777199 
private static UMLStereotypeTagDefinitionListModel
    tagDefinitionListModel =
        new UMLStereotypeTagDefinitionListModel();
//#endif 


//#if -742435034 
private static UMLExtendedElementsListModel
    extendedElementsListModel =
        new UMLExtendedElementsListModel();
//#endif 


//#if 1075336463 
private JScrollPane generalizationScroll;
//#endif 


//#if 824052512 
private JScrollPane specializationScroll;
//#endif 


//#if -151519740 
private JScrollPane tagDefinitionScroll;
//#endif 


//#if 1445578875 
private JScrollPane extendedElementsScroll;
//#endif 


//#if 2095098391 
void initMetaClasses()
    { 

//#if -114294615 
Collection<String> tmpMetaClasses =
            Model.getCoreHelper().getAllMetatypeNames();
//#endif 


//#if 427277345 
if(tmpMetaClasses instanceof List)//1
{ 

//#if -1564058167 
metaClasses = (List<String>) tmpMetaClasses;
//#endif 

} 
else
{ 

//#if 1562732341 
metaClasses = new LinkedList<String>(tmpMetaClasses);
//#endif 

} 

//#endif 


//#if 1150295484 
try //1
{ 

//#if 592860846 
Collections.sort(metaClasses);
//#endif 

} 

//#if -1155867238 
catch (UnsupportedOperationException e) //1
{ 

//#if 538485607 
metaClasses = new LinkedList<String>(tmpMetaClasses);
//#endif 


//#if -1673633487 
Collections.sort(metaClasses);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -124793475 
protected JScrollPane getTagDefinitionScroll()
    { 

//#if 207691412 
if(tagDefinitionScroll == null)//1
{ 

//#if 775953138 
JList list = new UMLLinkedList(tagDefinitionListModel);
//#endif 


//#if 1107469618 
tagDefinitionScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 1723603047 
return tagDefinitionScroll;
//#endif 

} 

//#endif 


//#if -1016339928 
protected JScrollPane getGeneralizationScroll()
    { 

//#if -357803776 
if(generalizationScroll == null)//1
{ 

//#if 1537200989 
JList list = new UMLLinkedList(generalizationListModel);
//#endif 


//#if -1597604313 
generalizationScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 1293339327 
return generalizationScroll;
//#endif 

} 

//#endif 


//#if -216207817 
protected JScrollPane getSpecializationScroll()
    { 

//#if 2035490688 
if(specializationScroll == null)//1
{ 

//#if -1341499406 
JList list = new UMLLinkedList(specializationListModel);
//#endif 


//#if -1952554822 
specializationScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 1633411841 
return specializationScroll;
//#endif 

} 

//#endif 


//#if 931195260 
protected JScrollPane getExtendedElementsScroll()
    { 

//#if 880694773 
if(extendedElementsScroll == null)//1
{ 

//#if -1728230285 
JList list = new UMLLinkedList(extendedElementsListModel);
//#endif 


//#if 422340197 
extendedElementsScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if -631485684 
return extendedElementsScroll;
//#endif 

} 

//#endif 


//#if -1054409148 
public PropPanelStereotype()
    { 

//#if 131483260 
super("label.stereotype-title", lookupIcon("Stereotype"));
//#endif 


//#if 1294793765 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if 678618517 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 1326525657 
JPanel modifiersPanel = createBorderPanel(
                                    Translator.localize("label.modifiers"));
//#endif 


//#if -1588668592 
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
//#endif 


//#if 665077900 
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
//#endif 


//#if 1491928080 
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
//#endif 


//#if 648661651 
add(modifiersPanel);
//#endif 


//#if -1888070264 
add(getVisibilityPanel());
//#endif 


//#if -712984700 
addSeparator();
//#endif 


//#if -1525995344 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if 1017266192 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if 1904065570 
addField(Translator.localize("label.tagdefinitions"),
                 getTagDefinitionScroll());
//#endif 


//#if -1913872306 
addSeparator();
//#endif 


//#if -536019493 
initMetaClasses();
//#endif 


//#if -752325742 
UMLMutableLinkedList umll = new UMLMutableLinkedList(
            new UMLStereotypeBaseClassListModel(),
            new ActionAddStereotypeBaseClass(),
            null);
//#endif 


//#if 671057936 
umll.setDeleteAction(new ActionDeleteStereotypeBaseClass());
//#endif 


//#if -1482173540 
umll.setCellRenderer(new DefaultListCellRenderer());
//#endif 


//#if 721105935 
addField(Translator.localize("label.base-class"),
                 new JScrollPane(umll));
//#endif 


//#if -1036941288 
addField(Translator.localize("label.extended-elements"),
                 getExtendedElementsScroll());
//#endif 


//#if 640562282 
addAction(new ActionNavigateNamespace());
//#endif 


//#if -1733220110 
addAction(new ActionNewStereotype());
//#endif 


//#if 1757655059 
addAction(new ActionNewTagDefinition());
//#endif 


//#if 1557650855 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1362895207 
class UMLStereotypeBaseClassListModel extends 
//#if -29282690 
UMLModelElementListModel2
//#endif 

  { 

//#if 1948777120 
@Override
        protected void buildModelList()
        { 

//#if -826691278 
removeAllElements();
//#endif 


//#if -613461495 
if(Model.getFacade().isAStereotype(getTarget()))//1
{ 

//#if -484062611 
LinkedList<String> lst = new LinkedList<String>(
                    Model.getFacade().getBaseClasses(getTarget()));
//#endif 


//#if -522588573 
Collections.sort(lst);
//#endif 


//#if 1405382828 
addAll(lst);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1394989115 
UMLStereotypeBaseClassListModel()
        { 

//#if 3791467 
super("baseClass");
//#endif 

} 

//#endif 


//#if -1199070508 
@Override
        protected boolean isValidElement(Object element)
        { 

//#if 935952506 
if(Model.getFacade().isAStereotype(element))//1
{ 

//#if 459244645 
return true;
//#endif 

} 

//#endif 


//#if -1921876337 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 2142811867 
class ActionAddStereotypeBaseClass extends 
//#if -880724620 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -1273531444 
@Override
        protected String getDialogTitle()
        { 

//#if 2012774278 
return Translator.localize("dialog.title.add-baseclasses");
//#endif 

} 

//#endif 


//#if -1909697117 
@Override
        protected List<String> getSelected()
        { 

//#if -456929122 
List<String> result = new ArrayList<String>();
//#endif 


//#if -295768136 
if(Model.getFacade().isAStereotype(getTarget()))//1
{ 

//#if -2103714389 
Collection<String> bases =
                    Model.getFacade().getBaseClasses(getTarget());
//#endif 


//#if 93175855 
result.addAll(bases);
//#endif 

} 

//#endif 


//#if -263187951 
return result;
//#endif 

} 

//#endif 


//#if -1653466676 
@Override
        protected List<String> getChoices()
        { 

//#if 1094190294 
return Collections.unmodifiableList(metaClasses);
//#endif 

} 

//#endif 


//#if -465816878 
@Override
        protected void doIt(Collection selected)
        { 

//#if 350674988 
Object stereo = getTarget();
//#endif 


//#if -227139011 
Set<Object> oldSet = new HashSet<Object>(getSelected());
//#endif 


//#if 604956590 
Set toBeRemoved = new HashSet<Object>(oldSet);
//#endif 


//#if 1325557977 
for (Object o : selected) //1
{ 

//#if -128570543 
if(oldSet.contains(o))//1
{ 

//#if -1507722378 
toBeRemoved.remove(o);
//#endif 

} 
else
{ 

//#if 438952394 
Model.getExtensionMechanismsHelper()
                    .addBaseClass(stereo, o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1576152844 
for (Object o : toBeRemoved) //1
{ 

//#if 74948343 
Model.getExtensionMechanismsHelper().removeBaseClass(stereo, o);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1882550813 
class ActionDeleteStereotypeBaseClass extends 
//#if 20127048 
AbstractActionRemoveElement
//#endif 

  { 

//#if -1401730535 
@Override
        public void actionPerformed(ActionEvent e)
        { 

//#if -1707719790 
UndoManager.getInstance().startChain();
//#endif 


//#if -859465027 
Object baseclass = getObjectToRemove();
//#endif 


//#if 56566633 
if(baseclass != null)//1
{ 

//#if -789842230 
Object st = getTarget();
//#endif 


//#if 740845962 
if(Model.getFacade().isAStereotype(st))//1
{ 

//#if 1820186301 
Model.getExtensionMechanismsHelper().removeBaseClass(st,
                            baseclass);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -297048812 
public ActionDeleteStereotypeBaseClass()
        { 

//#if -1367716084 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

