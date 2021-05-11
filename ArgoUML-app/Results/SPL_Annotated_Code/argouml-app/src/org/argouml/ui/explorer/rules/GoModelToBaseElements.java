// Compilation Unit of /GoModelToBaseElements.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoModelToBaseElements extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAPackage(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.package.base-class");
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAPackage(parent))//1
{ 
Collection result = new ArrayList();
Collection generalizableElements =
                Model.getModelManagementHelper()
                .getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getGeneralizableElement());
for (Object element : generalizableElements) //1
{ 
if(Model.getFacade().getGeneralizations(element).isEmpty())//1
{ 
result.add(element);
} 

} 

return result;
} 

return Collections.EMPTY_LIST;
} 

 } 


