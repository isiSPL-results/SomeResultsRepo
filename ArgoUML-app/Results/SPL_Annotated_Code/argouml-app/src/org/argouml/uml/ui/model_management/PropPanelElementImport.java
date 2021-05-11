// Compilation Unit of /PropPanelElementImport.java 
 
package org.argouml.uml.ui.model_management;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.UMLCheckBox2;
import org.argouml.uml.ui.UMLModelElementListModel2;
import org.argouml.uml.ui.UMLPlainTextDocument;
import org.argouml.uml.ui.UMLTextField2;
import org.argouml.uml.ui.foundation.core.ActionSetElementOwnershipSpecification;
import org.argouml.uml.ui.foundation.core.PropPanelModelElement;
class UMLElementImportAliasDocument extends UMLPlainTextDocument
  { 
protected String getProperty()
    { 
return Model.getFacade().getAlias(getTarget());
} 

protected void setProperty(String text)
    { 
Object t = getTarget();
if(t != null)//1
{ 
Model.getModelManagementHelper().setAlias(getTarget(), text);
} 

} 

public UMLElementImportAliasDocument()
    { 
super("alias");
} 

 } 

class UMLElementImportIsSpecificationCheckbox extends UMLCheckBox2
  { 
public void buildModel()
    { 
if(getTarget() != null)//1
{ 
setSelected(Model.getFacade().isSpecification(getTarget()));
} 

} 

public UMLElementImportIsSpecificationCheckbox()
    { 
super(Translator.localize("checkbox.is-specification"),
              ActionSetElementOwnershipSpecification.getInstance(),
              "isSpecification");
} 

 } 

class ElementImportPackageListModel extends UMLModelElementListModel2
  { 
protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAElementImport(getTarget());
} 

public ElementImportPackageListModel()
    { 
super("package");
} 

protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
removeAllElements();
addElement(Model.getFacade().getPackage(getTarget()));
} 

} 

 } 

public class PropPanelElementImport extends PropPanelModelElement
  { 
private JPanel modifiersPanel;
private JTextField aliasTextField;
private static UMLElementImportAliasDocument aliasDocument =
        new UMLElementImportAliasDocument();
public JPanel getModifiersPanel()
    { 
if(modifiersPanel == null)//1
{ 
modifiersPanel = createBorderPanel(Translator.localize(
                                                   "label.modifiers"));
modifiersPanel.add(
                new UMLElementImportIsSpecificationCheckbox());
} 

return modifiersPanel;
} 

public PropPanelElementImport()
    { 
super("label.element-import", lookupIcon("ElementImport"));
addField(Translator.localize("label.alias"),
                 getAliasTextField());
add(getVisibilityPanel());
add(getModifiersPanel());
addSeparator();
addField(Translator.localize("label.imported-element"),
                 getSingleRowScroll(
                     new ElementImportImportedElementListModel()));
addField(Translator.localize("label.package"),
                 getSingleRowScroll(new ElementImportPackageListModel()));
addAction(new ActionNavigateContainerElement());
addAction(getDeleteAction());
} 

protected JComponent getAliasTextField()
    { 
if(aliasTextField == null)//1
{ 
aliasTextField = new UMLTextField2(aliasDocument);
} 

return aliasTextField;
} 

 } 

class ElementImportImportedElementListModel extends UMLModelElementListModel2
  { 
protected void buildModelList()
    { 
if(getTarget() != null)//1
{ 
removeAllElements();
addElement(Model.getFacade().getImportedElement(getTarget()));
} 

} 

public ElementImportImportedElementListModel()
    { 
super("importedElement");
} 

protected boolean isValidElement(Object element)
    { 
return Model.getFacade().isAElementImport(getTarget());
} 

 } 


