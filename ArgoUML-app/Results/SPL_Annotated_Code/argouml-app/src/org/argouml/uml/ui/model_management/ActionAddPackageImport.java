// Compilation Unit of /ActionAddPackageImport.java 
 
package org.argouml.uml.ui.model_management;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.ui.AbstractActionAddModelElement2;
class ActionAddPackageImport extends AbstractActionAddModelElement2
  { 
@Override
    protected void doIt(Collection selected)
    { 
Object pack = getTarget();
Model.getModelManagementHelper().setImportedElements(pack, selected);
} 

protected List getSelected()
    { 
List vec = new ArrayList();
vec.addAll(Model.getFacade().getImportedElements(getTarget()));
return vec;
} 

protected List getChoices()
    { 
List vec = new ArrayList();
vec.addAll(Model.getModelManagementHelper()
                   .getAllPossibleImports(getTarget()));
return vec;
} 

ActionAddPackageImport()
    { 
super();
} 

protected String getDialogTitle()
    { 
return Translator.localize("dialog.title.add-imported-elements");
} 

 } 


