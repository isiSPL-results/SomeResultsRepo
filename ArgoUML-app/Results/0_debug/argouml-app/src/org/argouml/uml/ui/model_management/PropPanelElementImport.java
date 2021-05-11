
//#if 92094972 
// Compilation Unit of /PropPanelElementImport.java 
 

//#if 473738563 
package org.argouml.uml.ui.model_management;
//#endif 


//#if -1579981191 
import javax.swing.JComponent;
//#endif 


//#if 726147026 
import javax.swing.JPanel;
//#endif 


//#if 336608681 
import javax.swing.JTextField;
//#endif 


//#if 372933909 
import org.argouml.i18n.Translator;
//#endif 


//#if 51061339 
import org.argouml.model.Model;
//#endif 


//#if -11890211 
import org.argouml.uml.ui.ActionNavigateContainerElement;
//#endif 


//#if -172710236 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1353355095 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -852811871 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 1257290846 
import org.argouml.uml.ui.UMLTextField2;
//#endif 


//#if 1770576455 
import org.argouml.uml.ui.foundation.core.ActionSetElementOwnershipSpecification;
//#endif 


//#if 1516878743 
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
//#endif 


//#if 1638529576 
class UMLElementImportAliasDocument extends 
//#if 1858968544 
UMLPlainTextDocument
//#endif 

  { 

//#if -1412135313 
protected String getProperty()
    { 

//#if 459194820 
return Model.getFacade().getAlias(getTarget());
//#endif 

} 

//#endif 


//#if -1510258406 
protected void setProperty(String text)
    { 

//#if -181325357 
Object t = getTarget();
//#endif 


//#if 517606444 
if(t != null)//1
{ 

//#if -441249480 
Model.getModelManagementHelper().setAlias(getTarget(), text);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2052357260 
public UMLElementImportAliasDocument()
    { 

//#if 1563708270 
super("alias");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1906266823 
class UMLElementImportIsSpecificationCheckbox extends 
//#if 451546109 
UMLCheckBox2
//#endif 

  { 

//#if -1210282373 
public void buildModel()
    { 

//#if 326225782 
if(getTarget() != null)//1
{ 

//#if -943647611 
setSelected(Model.getFacade().isSpecification(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1163221243 
public UMLElementImportIsSpecificationCheckbox()
    { 

//#if -811191135 
super(Translator.localize("checkbox.is-specification"),
              ActionSetElementOwnershipSpecification.getInstance(),
              "isSpecification");
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -439935408 
class ElementImportPackageListModel extends 
//#if 1694743136 
UMLModelElementListModel2
//#endif 

  { 

//#if 1144787202 
protected boolean isValidElement(Object element)
    { 

//#if -1866734402 
return Model.getFacade().isAElementImport(getTarget());
//#endif 

} 

//#endif 


//#if 1200602224 
public ElementImportPackageListModel()
    { 

//#if 971591763 
super("package");
//#endif 

} 

//#endif 


//#if 866813134 
protected void buildModelList()
    { 

//#if 1839324273 
if(getTarget() != null)//1
{ 

//#if 1615028757 
removeAllElements();
//#endif 


//#if 1487749035 
addElement(Model.getFacade().getPackage(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1884530861 
public class PropPanelElementImport extends 
//#if -1943412368 
PropPanelModelElement
//#endif 

  { 

//#if 1704742682 
private JPanel modifiersPanel;
//#endif 


//#if -1471436068 
private JTextField aliasTextField;
//#endif 


//#if 457218137 
private static UMLElementImportAliasDocument aliasDocument =
        new UMLElementImportAliasDocument();
//#endif 


//#if -60772104 
public JPanel getModifiersPanel()
    { 

//#if -1934391521 
if(modifiersPanel == null)//1
{ 

//#if 876381725 
modifiersPanel = createBorderPanel(Translator.localize(
                                                   "label.modifiers"));
//#endif 


//#if 398803015 
modifiersPanel.add(
                new UMLElementImportIsSpecificationCheckbox());
//#endif 

} 

//#endif 


//#if -992321984 
return modifiersPanel;
//#endif 

} 

//#endif 


//#if -1246461970 
public PropPanelElementImport()
    { 

//#if 1090265699 
super("label.element-import", lookupIcon("ElementImport"));
//#endif 


//#if 2052851850 
addField(Translator.localize("label.alias"),
                 getAliasTextField());
//#endif 


//#if -172121317 
add(getVisibilityPanel());
//#endif 


//#if -1059810811 
add(getModifiersPanel());
//#endif 


//#if -245225519 
addSeparator();
//#endif 


//#if -212594446 
addField(Translator.localize("label.imported-element"),
                 getSingleRowScroll(
                     new ElementImportImportedElementListModel()));
//#endif 


//#if -926848357 
addField(Translator.localize("label.package"),
                 getSingleRowScroll(new ElementImportPackageListModel()));
//#endif 


//#if 679910879 
addAction(new ActionNavigateContainerElement());
//#endif 


//#if -1602993356 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if -1561067145 
protected JComponent getAliasTextField()
    { 

//#if -367175601 
if(aliasTextField == null)//1
{ 

//#if -103828573 
aliasTextField = new UMLTextField2(aliasDocument);
//#endif 

} 

//#endif 


//#if -525632602 
return aliasTextField;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1706937470 
class ElementImportImportedElementListModel extends 
//#if 2059057010 
UMLModelElementListModel2
//#endif 

  { 

//#if 1821944032 
protected void buildModelList()
    { 

//#if -1149927926 
if(getTarget() != null)//1
{ 

//#if 1057550311 
removeAllElements();
//#endif 


//#if 1769693099 
addElement(Model.getFacade().getImportedElement(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1447573456 
public ElementImportImportedElementListModel()
    { 

//#if -79950227 
super("importedElement");
//#endif 

} 

//#endif 


//#if 1884541204 
protected boolean isValidElement(Object element)
    { 

//#if -1731409247 
return Model.getFacade().isAElementImport(getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

