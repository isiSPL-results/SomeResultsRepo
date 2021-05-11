
//#if -1664822425 
// Compilation Unit of /PropPanelPackage.java 
 

//#if -1597362730 
package org.argouml.uml.ui.model_management;
//#endif 


//#if -1909072973 
import java.awt.event.ActionEvent;
//#endif 


//#if 815464440 
import java.util.ArrayList;
//#endif 


//#if -1847583895 
import java.util.List;
//#endif 


//#if -1919202263 
import javax.swing.Action;
//#endif 


//#if 630385763 
import javax.swing.ImageIcon;
//#endif 


//#if -1626921681 
import javax.swing.JList;
//#endif 


//#if 66203312 
import javax.swing.JOptionPane;
//#endif 


//#if 1212002085 
import javax.swing.JPanel;
//#endif 


//#if -1804859560 
import javax.swing.JScrollPane;
//#endif 


//#if -1881897119 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -152730846 
import org.argouml.i18n.Translator;
//#endif 


//#if -912819698 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 1238970088 
import org.argouml.model.Model;
//#endif 


//#if -1077878406 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1228320182 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 1649052951 
import org.argouml.uml.ui.UMLAddDialog;
//#endif 


//#if -1042162528 
import org.argouml.uml.ui.UMLDerivedCheckBox;
//#endif 


//#if -536589217 
import org.argouml.uml.ui.UMLLinkedList;
//#endif 


//#if 1095288259 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 1105116783 
import org.argouml.uml.ui.foundation.core.ActionAddDataType;
//#endif 


//#if 968488988 
import org.argouml.uml.ui.foundation.core.ActionAddEnumeration;
//#endif 


//#if 551992286 
import org.argouml.uml.ui.foundation.core.PropPanelNamespace;
//#endif 


//#if -2033388356 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementAbstractCheckBox;
//#endif 


//#if -295037050 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementGeneralizationListModel;
//#endif 


//#if -831947776 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementLeafCheckBox;
//#endif 


//#if 854724348 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementRootCheckBox;
//#endif 


//#if -167224363 
import org.argouml.uml.ui.foundation.core.UMLGeneralizableElementSpecializationListModel;
//#endif 


//#if -42117913 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if 1516851952 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewTagDefinition;
//#endif 


//#if 969209954 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1653555383 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 950088389 
public class PropPanelPackage extends 
//#if 425494258 
PropPanelNamespace
//#endif 

  { 

//#if 1276250464 
private static final long serialVersionUID = -699491324617952412L;
//#endif 


//#if 1220143214 
private JPanel modifiersPanel;
//#endif 


//#if -564993474 
private JScrollPane generalizationScroll;
//#endif 


//#if -816277425 
private JScrollPane specializationScroll;
//#endif 


//#if 943297313 
private static UMLGeneralizableElementGeneralizationListModel
    generalizationListModel =
        new UMLGeneralizableElementGeneralizationListModel();
//#endif 


//#if 957302480 
private static UMLGeneralizableElementSpecializationListModel
    specializationListModel =
        new UMLGeneralizableElementSpecializationListModel();
//#endif 


//#if -1542135563 
protected void placeElements()
    { 

//#if 1655583490 
addField("label.name", getNameTextField());
//#endif 


//#if -1739913330 
addField("label.namespace", getNamespaceSelector());
//#endif 


//#if -274447081 
add(getVisibilityPanel());
//#endif 


//#if -2032942967 
add(getModifiersPanel());
//#endif 


//#if -1177752747 
addSeparator();
//#endif 


//#if -798126881 
addField("label.generalizations",
                 getGeneralizationScroll());
//#endif 


//#if 1762908157 
addField("label.specializations",
                 getSpecializationScroll());
//#endif 


//#if -844198179 
addSeparator();
//#endif 


//#if 53275133 
addField("label.owned-elements",
                 getOwnedElementsScroll());
//#endif 


//#if 552430159 
JList importList =
            new UMLMutableLinkedList(new UMLClassifierPackageImportsListModel(),
                                     new ActionAddPackageImport(),
                                     null,
                                     new ActionRemovePackageImport(),
                                     true);
//#endif 


//#if 924866827 
addField("label.imported-elements",
                 new JScrollPane(importList));
//#endif 


//#if 1029586361 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 1867172220 
addAction(new ActionAddPackage());
//#endif 


//#if 332408852 
addAction(new ActionAddDataType());
//#endif 


//#if 1315364221 
addAction(new ActionAddEnumeration());
//#endif 


//#if 1693008296 
addAction(new ActionDialogElementImport());
//#endif 


//#if 322974145 
addAction(new ActionNewStereotype());
//#endif 


//#if -1277837084 
addAction(new ActionNewTagDefinition());
//#endif 


//#if -563048520 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1982643714 
public JScrollPane getGeneralizationScroll()
    { 

//#if 555259895 
if(generalizationScroll == null)//1
{ 

//#if -1098433607 
JList list = new UMLLinkedList(generalizationListModel);
//#endif 


//#if -647534205 
generalizationScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 1568624374 
return generalizationScroll;
//#endif 

} 

//#endif 


//#if -1378441436 
public JPanel getModifiersPanel()
    { 

//#if 643448625 
if(modifiersPanel == null)//1
{ 

//#if 1451249874 
modifiersPanel = createBorderPanel(Translator.localize(
                                                   "label.modifiers"));
//#endif 


//#if -1368584913 
modifiersPanel.add(
                new UMLGeneralizableElementAbstractCheckBox());
//#endif 


//#if -20036117 
modifiersPanel.add(
                new UMLGeneralizableElementLeafCheckBox());
//#endif 


//#if 806814063 
modifiersPanel.add(
                new UMLGeneralizableElementRootCheckBox());
//#endif 


//#if 1629282917 
modifiersPanel.add(
                new UMLDerivedCheckBox());
//#endif 

} 

//#endif 


//#if 1873349586 
return modifiersPanel;
//#endif 

} 

//#endif 


//#if 1318055651 
public PropPanelPackage(String title, ImageIcon icon)
    { 

//#if -767273458 
super(title, icon);
//#endif 


//#if 932266046 
placeElements();
//#endif 

} 

//#endif 


//#if -1512191471 
public JScrollPane getSpecializationScroll()
    { 

//#if -124712423 
if(specializationScroll == null)//1
{ 

//#if -681242562 
JList list = new UMLLinkedList(specializationListModel);
//#endif 


//#if 2141767686 
specializationScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 1973417050 
return specializationScroll;
//#endif 

} 

//#endif 


//#if 702331271 
public PropPanelPackage()
    { 

//#if -1494576735 
this("label.package", lookupIcon("Package"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1277816762 

//#if -1241220092 
@UmlModelMutator
//#endif 

class ActionDialogElementImport extends 
//#if -815163477 
UndoableAction
//#endif 

  { 

//#if 960845357 
protected List getSelected(Object target)
    { 

//#if 183484269 
List result = new ArrayList();
//#endif 


//#if 1034240398 
result.addAll(Model.getFacade().getImportedElements(target));
//#endif 


//#if -440400062 
return result;
//#endif 

} 

//#endif 


//#if 1045440251 
protected void doIt(Object target, List selected)
    { 

//#if 1013876654 
Model.getModelManagementHelper().setImportedElements(target, selected);
//#endif 

} 

//#endif 


//#if 1713730180 
public ActionDialogElementImport()
    { 

//#if -2075456949 
super();
//#endif 


//#if 2131140916 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIcon("ElementImport"));
//#endif 


//#if 2035744785 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.add-element-import"));
//#endif 

} 

//#endif 


//#if 470104067 
protected String getDialogTitle()
    { 

//#if -662161892 
return Translator.localize("dialog.title.add-imported-elements");
//#endif 

} 

//#endif 


//#if -1691657651 
public boolean isExclusive()
    { 

//#if 422416644 
return true;
//#endif 

} 

//#endif 


//#if 139491106 
protected List getChoices(Object target)
    { 

//#if 748895510 
List result = new ArrayList();
//#endif 


//#if -340971108 
result.addAll(Model.getModelManagementHelper()
                      .getAllPossibleImports(target));
//#endif 


//#if -1371239687 
return result;
//#endif 

} 

//#endif 


//#if -449917436 
public boolean isMultiSelect()
    { 

//#if -956150001 
return true;
//#endif 

} 

//#endif 


//#if 1244416120 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 17465184 
super.actionPerformed(e);
//#endif 


//#if 1618637219 
Object target = TargetManager.getInstance().getSingleModelTarget();
//#endif 


//#if -449409471 
if(target != null)//1
{ 

//#if 1173425667 
UMLAddDialog dialog =
                new UMLAddDialog(getChoices(target),
                                 getSelected(target),
                                 getDialogTitle(),
                                 isMultiSelect(),
                                 isExclusive());
//#endif 


//#if 1990910657 
int result = dialog.showDialog(ArgoFrame.getInstance());
//#endif 


//#if -1869947066 
if(result == JOptionPane.OK_OPTION)//1
{ 

//#if 1918368855 
doIt(target, dialog.getSelected());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

