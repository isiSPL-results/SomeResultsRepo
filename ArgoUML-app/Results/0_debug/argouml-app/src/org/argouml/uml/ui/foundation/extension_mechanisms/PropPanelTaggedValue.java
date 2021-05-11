
//#if 1657192762 
// Compilation Unit of /PropPanelTaggedValue.java 
 

//#if 2060256723 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 397890616 
import java.awt.AWTEvent;
//#endif 


//#if 777903858 
import java.awt.event.ActionEvent;
//#endif 


//#if -502914803 
import javax.swing.Box;
//#endif 


//#if 1384627587 
import javax.swing.BoxLayout;
//#endif 


//#if -554922229 
import javax.swing.JComponent;
//#endif 


//#if -2068467952 
import javax.swing.JList;
//#endif 


//#if -1280711559 
import javax.swing.JScrollPane;
//#endif 


//#if 1539172291 
import org.argouml.i18n.Translator;
//#endif 


//#if -1079721375 
import org.argouml.kernel.Project;
//#endif 


//#if 981266792 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1763118089 
import org.argouml.model.Model;
//#endif 


//#if 1525587467 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if 1327536524 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 468873647 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 782146855 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if 2038867038 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 870973371 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -1764343895 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if -541256824 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1728225635 
public class PropPanelTaggedValue extends 
//#if -2121927451 
PropPanelModelElement
//#endif 

  { 

//#if 689273794 
private JComponent modelElementSelector;
//#endif 


//#if 1654820091 
private JComponent typeSelector;
//#endif 


//#if 37214540 
private JScrollPane referenceValuesScroll;
//#endif 


//#if 457273815 
private JScrollPane dataValuesScroll;
//#endif 


//#if -1408411753 
protected JComponent getModelElementSelector()
    { 

//#if -893153638 
if(modelElementSelector == null)//1
{ 

//#if -531054789 
modelElementSelector = new Box(BoxLayout.X_AXIS);
//#endif 


//#if -607091351 
modelElementSelector.add(new UMLComboBoxNavigator(
                                         Translator.localize("label.modelelement.navigate.tooltip"),
                                         new UMLComboBox2(
                                             new UMLTaggedValueModelElementComboBoxModel(),
                                             new ActionSetTaggedValueModelElement())
                                     ));
//#endif 

} 

//#endif 


//#if 1662719271 
return modelElementSelector;
//#endif 

} 

//#endif 


//#if -293470587 
protected JScrollPane getReferenceValuesScroll()
    { 

//#if -1236781629 
if(referenceValuesScroll == null)//1
{ 

//#if -288006213 
JList list = new UMLLinkedList(new UMLReferenceValueListModel());
//#endif 


//#if 623948761 
referenceValuesScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 201079958 
return referenceValuesScroll;
//#endif 

} 

//#endif 


//#if 1348336254 
protected JComponent getTypeSelector()
    { 

//#if -2063453745 
if(typeSelector == null)//1
{ 

//#if -1051550926 
typeSelector = new Box(BoxLayout.X_AXIS);
//#endif 


//#if -2080335801 
typeSelector.add(new UMLComboBoxNavigator(
                                 Translator.localize("label.type.navigate.tooltip"),
                                 new UMLComboBox2(
                                     new UMLTaggedValueTypeComboBoxModel(),
                                     new ActionSetTaggedValueType())
                             ));
//#endif 

} 

//#endif 


//#if -204808146 
return typeSelector;
//#endif 

} 

//#endif 


//#if -1944059267 
public PropPanelTaggedValue()
    { 

//#if -30625057 
super("label.tagged-value", lookupIcon("TaggedValue"));
//#endif 


//#if -136364640 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -1448424926 
addField(Translator.localize("label.modelelement"),
                 getModelElementSelector());
//#endif 


//#if -1073328752 
addField(Translator.localize("label.type"),
                 getTypeSelector());
//#endif 


//#if -3671297 
addSeparator();
//#endif 


//#if 1142680991 
addField(Translator.localize("label.reference-values"),
                 getReferenceValuesScroll());
//#endif 


//#if 1430493449 
addField(Translator.localize("label.data-values"),
                 getDataValuesScroll());
//#endif 


//#if -811321075 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if 359068302 
addAction(new ActionNewTagDefinition());
//#endif 


//#if 404352482 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 516219216 
protected JScrollPane getDataValuesScroll()
    { 

//#if -1212521639 
if(dataValuesScroll == null)//1
{ 

//#if -134661248 
JList list = new UMLLinkedList(new UMLDataValueListModel());
//#endif 


//#if -1884689850 
dataValuesScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 1001295480 
return dataValuesScroll;
//#endif 

} 

//#endif 


//#if 1490483015 
static class ActionSetTaggedValueModelElement extends 
//#if 1026100403 
UndoableAction
//#endif 

  { 

//#if 1052979406 
public void actionPerformed(ActionEvent e)
        { 

//#if 1420529610 
super.actionPerformed(e);
//#endif 


//#if -709314311 
Object source = e.getSource();
//#endif 


//#if 1724687806 
if(source instanceof UMLComboBox2
                    && e.getModifiers() == AWTEvent.MOUSE_EVENT_MASK)//1
{ 

//#if 1163906971 
UMLComboBox2 combo = (UMLComboBox2) source;
//#endif 


//#if 730333240 
Object o = combo.getSelectedItem();
//#endif 


//#if 981756683 
final Object taggedValue = combo.getTarget();
//#endif 


//#if -1877075276 
if(Model.getFacade().isAModelElement(o)
                        && Model.getFacade().isATaggedValue(taggedValue))//1
{ 

//#if 622933150 
Object oldME =
                        Model.getFacade().getModelElement(taggedValue);
//#endif 


//#if -1208225561 
Model.getExtensionMechanismsHelper()
                    .removeTaggedValue(oldME, taggedValue);
//#endif 


//#if 1600868946 
Model.getExtensionMechanismsHelper()
                    .addTaggedValue(o, taggedValue);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -316989003 
public ActionSetTaggedValueModelElement()
        { 

//#if 1528532814 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 254209774 
static class ActionSetTaggedValueType extends 
//#if 131062270 
UndoableAction
//#endif 

  { 

//#if 756571619 
public void actionPerformed(ActionEvent e)
        { 

//#if 1155482969 
super.actionPerformed(e);
//#endif 


//#if -2016065848 
Object source = e.getSource();
//#endif 


//#if 254384975 
if(source instanceof UMLComboBox2
                    && e.getModifiers() == AWTEvent.MOUSE_EVENT_MASK)//1
{ 

//#if -652644308 
UMLComboBox2 combo = (UMLComboBox2) source;
//#endif 


//#if -63409977 
Object o = combo.getSelectedItem();
//#endif 


//#if -967300260 
final Object taggedValue = combo.getTarget();
//#endif 


//#if 66054787 
if(Model.getFacade().isAModelElement(o)
                        && Model.getFacade().isATaggedValue(taggedValue))//1
{ 

//#if -1566012802 
Model.getExtensionMechanismsHelper()
                    .setType(taggedValue, o);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -596346585 
public ActionSetTaggedValueType()
        { 

//#if 1266603150 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 353403405 
static class UMLTaggedValueModelElementComboBoxModel extends 
//#if -1351592409 
UMLComboBoxModel2
//#endif 

  { 

//#if 867188873 
protected void buildModelList()
        { 

//#if -16992096 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1568742535 
Object model = p.getRoot();
//#endif 


//#if -653462878 
setElements(Model.getModelManagementHelper()
                        .getAllModelElementsOfKindWithModel(model,
                                Model.getMetaTypes().getModelElement()));
//#endif 

} 

//#endif 


//#if 2080452939 
protected Object getSelectedModelElement()
        { 

//#if 1353019842 
Object me = null;
//#endif 


//#if 1789444141 
if(getTarget() != null
                    && Model.getFacade().isATaggedValue(getTarget()))//1
{ 

//#if 2058904700 
me = Model.getFacade().getModelElement(getTarget());
//#endif 

} 

//#endif 


//#if -963704417 
return me;
//#endif 

} 

//#endif 


//#if -1686047043 
protected boolean isValidElement(Object element)
        { 

//#if 576307907 
return Model.getFacade().isAModelElement(element);
//#endif 

} 

//#endif 


//#if -417782195 
public UMLTaggedValueModelElementComboBoxModel()
        { 

//#if -1885708607 
super("modelelement", true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -884804547 
static class UMLDataValueListModel extends 
//#if -1178239189 
UMLModelElementListModel2
//#endif 

  { 

//#if -943816115 
protected boolean isValidElement(Object element)
        { 

//#if -294444298 
return Model.getFacade().isAModelElement(element)
                   && Model.getFacade().getDataValue(
                       getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if 353823769 
protected void buildModelList()
        { 

//#if -410846921 
if(getTarget() != null)//1
{ 

//#if -205912781 
setAllElements(
                    Model.getFacade().getDataValue(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1545779 
public UMLDataValueListModel()
        { 

//#if 1102438379 
super("dataValue");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -2115814970 
static class UMLTaggedValueTypeComboBoxModel extends 
//#if 611365299 
UMLComboBoxModel2
//#endif 

  { 

//#if -979068865 
protected Object getSelectedModelElement()
        { 

//#if -345814636 
Object me = null;
//#endif 


//#if -613171045 
if(getTarget() != null
                    && Model.getFacade().isATaggedValue(getTarget()))//1
{ 

//#if -647910276 
me = Model.getFacade().getType(getTarget());
//#endif 

} 

//#endif 


//#if -956688755 
return me;
//#endif 

} 

//#endif 


//#if -1410290350 
public UMLTaggedValueTypeComboBoxModel()
        { 

//#if 1341060878 
super("type", true);
//#endif 

} 

//#endif 


//#if -1905538999 
protected boolean isValidElement(Object element)
        { 

//#if 934458886 
return Model.getFacade().isATagDefinition(element);
//#endif 

} 

//#endif 


//#if 732408341 
protected void buildModelList()
        { 

//#if -723609335 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1635413488 
Object model = p.getRoot();
//#endif 


//#if -1648548599 
setElements(Model.getModelManagementHelper()
                        .getAllModelElementsOfKindWithModel(model,
                                Model.getMetaTypes().getTagDefinition()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 2125984588 
static class UMLReferenceValueListModel extends 
//#if -1498385332 
UMLModelElementListModel2
//#endif 

  { 

//#if 508861678 
protected boolean isValidElement(Object element)
        { 

//#if -1147958325 
return Model.getFacade().isAModelElement(element)
                   && Model.getFacade().getReferenceValue(
                       getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if -78616390 
protected void buildModelList()
        { 

//#if 1738236152 
if(getTarget() != null)//1
{ 

//#if 1880078757 
setAllElements(
                    Model.getFacade().getReferenceValue(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1568740061 
public UMLReferenceValueListModel()
        { 

//#if -1969066064 
super("referenceValue");
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

