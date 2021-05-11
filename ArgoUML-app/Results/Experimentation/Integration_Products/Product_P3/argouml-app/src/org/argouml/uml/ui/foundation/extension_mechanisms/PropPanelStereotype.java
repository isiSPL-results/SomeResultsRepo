package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
import org.argouml.uml.ui.AbstractActionRemoveElement;
import org.argouml.uml.ui.ActionNavigateNamespace;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.UMLMutableLinkedList;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementAbstractCheckBox;
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementGeneralizationListModel;
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementLeafCheckBox;
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementRootCheckBox;
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementSpecializationListModel;
import org.tigris.gef.undo.UndoManager;
public class PropPanelStereotype extends PropPanelModelElement
  { 
private static final long serialVersionUID = 8038077991746618130L;
private List<String> metaClasses;
private static UMLGeneralizableElementSpecializationListModel
    specializationListModel =
        new UMLGeneralizableElementSpecializationListModel();
private static UMLGeneralizableElementGeneralizationListModel
    generalizationListModel =
        new UMLGeneralizableElementGeneralizationListModel();
private static UMLStereotypeTagDefinitionListModel
    tagDefinitionListModel =
        new UMLStereotypeTagDefinitionListModel();
private static UMLExtendedElementsListModel
    extendedElementsListModel =
        new UMLExtendedElementsListModel();
private JScrollPane generalizationScroll;
private JScrollPane specializationScroll;
private JScrollPane tagDefinitionScroll;
private JScrollPane extendedElementsScroll;
void initMetaClasses()
    { 
Collection<String> tmpMetaClasses =
            Model.getCoreHelper().getAllMetatypeNames();
if(tmpMetaClasses instanceof List)//1
{ 
metaClasses = (List<String>) tmpMetaClasses;
} 
else
{ 
metaClasses = new LinkedList<String>(tmpMetaClasses);
} 
try//1
{ 
Collections.sort(metaClasses);
} 
catch (UnsupportedOperationException e) //1
{ 
metaClasses = new LinkedList<String>(tmpMetaClasses);
Collections.sort(metaClasses);
} 
} 
protected JScrollPane getTagDefinitionScroll()
    { 
if(tagDefinitionScroll == null)//1
{ 
JList list = new UMLLinkedList(tagDefinitionListModel);
tagDefinitionScroll = new JScrollPane(list);
} 
return tagDefinitionScroll;
} 
protected JScrollPane getGeneralizationScroll()
    { 
if(generalizationScroll == null)//1
{ 
JList list = new UMLLinkedList(generalizationListModel);
generalizationScroll = new JScrollPane(list);
} 
return generalizationScroll;
} 
protected JScrollPane getSpecializationScroll()
    { 
if(specializationScroll == null)//1
{ 
JList list = new UMLLinkedList(specializationListModel);
specializationScroll = new JScrollPane(list);
} 
return specializationScroll;
} 
protected JScrollPane getExtendedElementsScroll()
    { 
if(extendedElementsScroll == null)//1
{ 
JList list = new UMLLinkedList(extendedElementsListModel);
extendedElementsScroll = new JScrollPane(list);
} 
return extendedElementsScroll;
} 
public PropPanelStereotype()
    { 
super("label.stereotype-title", lookupIcon("Stereotype"));
addField(Translator.localize("label.name"), getNameTextField());
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
JPanel modifiersPanel = createBorderPanel(
                                    Translator.localize("label.modifiers"));
modifiersPanel.add(new UMLGeneralizableElementAbstractCheckBox());
modifiersPanel.add(new UMLGeneralizableElementLeafCheckBox());
modifiersPanel.add(new UMLGeneralizableElementRootCheckBox());
add(modifiersPanel);
add(getVisibilityPanel());
addSeparator();
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
addField(Translator.localize("label.tagdefinitions"),
                 getTagDefinitionScroll());
addSeparator();
initMetaClasses();
UMLMutableLinkedList umll = new UMLMutableLinkedList(
            new UMLStereotypeBaseClassListModel(),
            new ActionAddStereotypeBaseClass(),
            null);
umll.setDeleteAction(new ActionDeleteStereotypeBaseClass());
umll.setCellRenderer(new DefaultListCellRenderer());
addField(Translator.localize("label.base-class"),
                 new JScrollPane(umll));
addField(Translator.localize("label.extended-elements"),
                 getExtendedElementsScroll());
addAction(new ActionNavigateNamespace());
addAction(new ActionNewStereotype());
addAction(new ActionNewTagDefinition());
addAction(getDeleteAction());
} 
class UMLStereotypeBaseClassListModel extends UMLModelElementListModel2
  { 
@Override
        protected void buildModelList()
        { 
removeAllElements();
if(Model.getFacade().isAStereotype(getTarget()))//1
{ 
LinkedList<String> lst = new LinkedList<String>(
                    Model.getFacade().getBaseClasses(getTarget()));
Collections.sort(lst);
addAll(lst);
} 
} 
UMLStereotypeBaseClassListModel()
        { 
super("baseClass");
} 
@Override
        protected boolean isValidElement(Object element)
        { 
if(Model.getFacade().isAStereotype(element))//1
{ 
return true;
} 
return false;
} 

 } 
class ActionAddStereotypeBaseClass extends AbstractActionAddModelElement2
  { 
@Override
        protected String getDialogTitle()
        { 
return Translator.localize("dialog.title.add-baseclasses");
} 
@Override
        protected List<String> getSelected()
        { 
List<String> result = new ArrayList<String>();
if(Model.getFacade().isAStereotype(getTarget()))//1
{ 
Collection<String> bases =
                    Model.getFacade().getBaseClasses(getTarget());
result.addAll(bases);
} 
return result;
} 
@Override
        protected List<String> getChoices()
        { 
return Collections.unmodifiableList(metaClasses);
} 
@Override
        protected void doIt(Collection selected)
        { 
Object stereo = getTarget();
Set<Object> oldSet = new HashSet<Object>(getSelected());
Set toBeRemoved = new HashSet<Object>(oldSet);
for (Object o : selected) //1
{ 
if(oldSet.contains(o))//1
{ 
toBeRemoved.remove(o);
} 
else
{ 
Model.getExtensionMechanismsHelper()
                    .addBaseClass(stereo, o);
} 
} 
for (Object o : toBeRemoved) //1
{ 
Model.getExtensionMechanismsHelper().removeBaseClass(stereo, o);
} 
} 

 } 
class ActionDeleteStereotypeBaseClass extends AbstractActionRemoveElement
  { 
@Override
        public void actionPerformed(ActionEvent e)
        { 
UndoManager.getInstance().startChain();
Object baseclass = getObjectToRemove();
if(baseclass != null)//1
{ 
Object st = getTarget();
if(Model.getFacade().isAStereotype(st))//1
{ 
Model.getExtensionMechanismsHelper().removeBaseClass(st,
                            baseclass);
} 
} 
} 
public ActionDeleteStereotypeBaseClass()
        { 
super(Translator.localize("menu.popup.remove"));
} 

 } 

 } 
