
//#if -90175548 
// Compilation Unit of /PropPanelModelElement.java 
 

//#if -246283604 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1144996839 
import java.awt.Component;
//#endif 


//#if 109574455 
import java.util.ArrayList;
//#endif 


//#if 2080249546 
import java.util.List;
//#endif 


//#if -140857590 
import javax.swing.Action;
//#endif 


//#if 874942946 
import javax.swing.ImageIcon;
//#endif 


//#if -1110075185 
import javax.swing.JComboBox;
//#endif 


//#if -472113491 
import javax.swing.JComponent;
//#endif 


//#if -1419494634 
import javax.swing.JLabel;
//#endif 


//#if 370106926 
import javax.swing.JList;
//#endif 


//#if -1304620538 
import javax.swing.JPanel;
//#endif 


//#if 1286359319 
import javax.swing.JScrollPane;
//#endif 


//#if 1444476381 
import javax.swing.JTextField;
//#endif 


//#if 765513057 
import org.argouml.i18n.Translator;
//#endif 


//#if 1105132271 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 35221671 
import org.argouml.model.Model;
//#endif 


//#if -2001866405 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1595869738 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 572878944 
import org.argouml.uml.ui.ScrollList;
//#endif 


//#if -1490025019 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -892296161 
import org.argouml.uml.ui.UMLDerivedCheckBox;
//#endif 


//#if -912021118 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1538566675 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if -1049180584 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if 1105707922 
import org.argouml.uml.ui.UMLTextField2;
//#endif 


//#if 1135367445 
public abstract class PropPanelModelElement extends 
//#if 958844318 
PropPanel
//#endif 

  { 

//#if 1558635272 
private JComboBox namespaceSelector;
//#endif 


//#if -34554856 
private JScrollPane supplierDependencyScroll;
//#endif 


//#if 734919737 
private JScrollPane clientDependencyScroll;
//#endif 


//#if 210056176 
private JScrollPane targetFlowScroll;
//#endif 


//#if -2088721626 
private JScrollPane sourceFlowScroll;
//#endif 


//#if 735316658 
private JScrollPane constraintScroll;
//#endif 


//#if -198097309 
private JPanel visibilityPanel;
//#endif 


//#if 235293637 
private JScrollPane elementResidenceScroll;
//#endif 


//#if -355868036 
private JTextField nameTextField;
//#endif 


//#if 147840558 
private UMLModelElementNamespaceComboBoxModel namespaceComboBoxModel =
        new UMLModelElementNamespaceComboBoxModel();
//#endif 


//#if 1231426064 
private static UMLModelElementClientDependencyListModel
    clientDependencyListModel =
        new UMLModelElementClientDependencyListModel();
//#endif 


//#if 584642327 
private static UMLModelElementConstraintListModel constraintListModel =
        new UMLModelElementConstraintListModel();
//#endif 


//#if -1100417916 
private static UMLModelElementElementResidenceListModel
    elementResidenceListModel =
        new UMLModelElementElementResidenceListModel();
//#endif 


//#if 747605237 
private static UMLModelElementNameDocument nameDocument =
        new UMLModelElementNameDocument();
//#endif 


//#if 704392099 
private static UMLModelElementSourceFlowListModel sourceFlowListModel =
        new UMLModelElementSourceFlowListModel();
//#endif 


//#if -1074263719 
private static UMLModelElementTargetFlowListModel targetFlowListModel =
        new UMLModelElementTargetFlowListModel();
//#endif 


//#if -52965444 
protected JComponent getClientDependencyScroll()
    { 

//#if 953396313 
if(clientDependencyScroll == null)//1
{ 

//#if 1916888308 
JList list = new UMLMutableLinkedList(
                clientDependencyListModel,
                new ActionAddClientDependencyAction(),
                null,
                null,
                true);
//#endif 


//#if -411389902 
clientDependencyScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 2059513060 
return clientDependencyScroll;
//#endif 

} 

//#endif 


//#if -1422016005 
protected JComponent getVisibilityPanel()
    { 

//#if -818203201 
if(visibilityPanel == null)//1
{ 

//#if 1412486138 
visibilityPanel =
                new UMLModelElementVisibilityRadioButtonPanel(
                Translator.localize("label.visibility"), true);
//#endif 

} 

//#endif 


//#if 908586914 
return visibilityPanel;
//#endif 

} 

//#endif 


//#if 497975075 
protected JComponent getConstraintScroll()
    { 

//#if -2075124411 
if(constraintScroll == null)//1
{ 

//#if 260605470 
JList constraintList = new UMLMutableLinkedList(
                constraintListModel, null,
                ActionNewModelElementConstraint.getInstance());
//#endif 


//#if 1805549061 
constraintScroll = new JScrollPane(constraintList);
//#endif 

} 

//#endif 


//#if -226981726 
return constraintScroll;
//#endif 

} 

//#endif 


//#if 1318531453 
protected JComponent getSupplierDependencyScroll()
    { 

//#if -885613120 
if(supplierDependencyScroll == null)//1
{ 

//#if 1106600060 
JList list = new UMLMutableLinkedList(
                new UMLModelElementSupplierDependencyListModel(),
                new ActionAddSupplierDependencyAction(),
                null,
                null,
                true);
//#endif 


//#if -448755997 
supplierDependencyScroll = new JScrollPane(list);
//#endif 

} 

//#endif 


//#if 2134127337 
return supplierDependencyScroll;
//#endif 

} 

//#endif 


//#if 1123537676 
public PropPanelModelElement(String name, ImageIcon icon)
    { 

//#if -194643924 
super(name, icon);
//#endif 

} 

//#endif 


//#if 1638494640 
protected JComponent getElementResidenceScroll()
    { 

//#if -414332795 
if(elementResidenceScroll == null)//1
{ 

//#if 2002218391 
elementResidenceScroll = new ScrollList(elementResidenceListModel);
//#endif 

} 

//#endif 


//#if 279360680 
return elementResidenceScroll;
//#endif 

} 

//#endif 


//#if 1394769317 
protected JComponent getTargetFlowScroll()
    { 

//#if 364468693 
if(targetFlowScroll == null)//1
{ 

//#if 536801287 
targetFlowScroll = new ScrollList(targetFlowListModel);
//#endif 

} 

//#endif 


//#if 1622226030 
return targetFlowScroll;
//#endif 

} 

//#endif 


//#if -1316469548 
protected UMLPlainTextDocument getNameDocument()
    { 

//#if -1101459342 
return nameDocument;
//#endif 

} 

//#endif 


//#if -618011959 
public PropPanelModelElement()
    { 

//#if -795604640 
this("label.model-element-title", (ImageIcon) null);
//#endif 


//#if -1468511482 
addField("label.name",
                 getNameTextField());
//#endif 


//#if -377375734 
addField("label.namespace",
                 getNamespaceSelector());
//#endif 


//#if -330422831 
addSeparator();
//#endif 


//#if -1479381 
addField("label.supplier-dependencies",
                 getSupplierDependencyScroll());
//#endif 


//#if -1381625175 
addField("label.client-dependencies",
                 getClientDependencyScroll());
//#endif 


//#if -1789672048 
addField("label.source-flows",
                 getSourceFlowScroll());
//#endif 


//#if 1500467280 
addField("label.target-flows",
                 getTargetFlowScroll());
//#endif 


//#if 438530785 
addSeparator();
//#endif 


//#if -1872158043 
addField("label.constraints",
                 getConstraintScroll());
//#endif 


//#if -871963365 
add(getVisibilityPanel());
//#endif 


//#if -425323126 
addField("label.derived",
                 new UMLDerivedCheckBox());
//#endif 

} 

//#endif 


//#if 1689616235 
protected JComponent getNameTextField()
    { 

//#if -54360220 
if(nameTextField == null)//1
{ 

//#if -1029019870 
nameTextField = new UMLTextField2(nameDocument);
//#endif 

} 

//#endif 


//#if -1008682265 
return nameTextField;
//#endif 

} 

//#endif 


//#if 1390068766 
@Override
    public void setTarget(Object target)
    { 

//#if -2034303389 
super.setTarget(target);
//#endif 


//#if -245092446 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if -539591040 
boolean enable =
                !Model.getModelManagementHelper().isReadOnly(target);
//#endif 


//#if 2042653192 
for (final Component component : getComponents()) //1
{ 

//#if 1533916541 
if(component instanceof JScrollPane)//1
{ 

//#if -857870144 
Component c =
                        ((JScrollPane) component).getViewport().getView();
//#endif 


//#if -788853084 
if(c.getClass().isAnnotationPresent(
                                UmlModelMutator.class))//1
{ 

//#if -1324063081 
c.setEnabled(enable);
//#endif 

} 

//#endif 

} 
else

//#if 965475326 
if(!(component instanceof JLabel)
                           && component.isEnabled() != enable)//1
{ 

//#if 277047821 
component.setEnabled(enable);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1748760041 
@Override
    protected final List getActions()
    { 

//#if -2078882847 
List actions = super.getActions();
//#endif 


//#if 1015924023 
if(Model.getFacade().isAUMLElement(getTarget())
                && Model.getModelManagementHelper().isReadOnly(getTarget()))//1
{ 

//#if 1107297797 
final List<Action> filteredActions = new ArrayList<Action>(2);
//#endif 


//#if -489080533 
for (Object o : actions) //1
{ 

//#if -871660963 
if(o instanceof Action && !o.getClass().isAnnotationPresent(
                            UmlModelMutator.class))//1
{ 

//#if 709998462 
filteredActions.add((Action) o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1982339542 
return filteredActions;
//#endif 

} 
else
{ 

//#if -729085929 
return actions;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1147865809 
protected JComponent getSourceFlowScroll()
    { 

//#if -863280842 
if(sourceFlowScroll == null)//1
{ 

//#if 1634167030 
sourceFlowScroll = new ScrollList(sourceFlowListModel);
//#endif 

} 

//#endif 


//#if -482784581 
return sourceFlowScroll;
//#endif 

} 

//#endif 


//#if 1385489987 
protected JComponent getNamespaceSelector()
    { 

//#if 456166510 
if(namespaceSelector == null)//1
{ 

//#if 887580527 
namespaceSelector = new UMLSearchableComboBox(
                namespaceComboBoxModel,
                new ActionSetModelElementNamespace(), true);
//#endif 

} 

//#endif 


//#if 1042347535 
return new UMLComboBoxNavigator(
                   Translator.localize("label.namespace.navigate.tooltip"),
                   namespaceSelector);
//#endif 

} 

//#endif 


//#if 4346797 
public void navigateUp()
    { 

//#if 2003083040 
TargetManager.getInstance().setTarget(
            Model.getFacade().getModelElementContainer(getTarget()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

