// Compilation Unit of /GoUseCaseToExtensionPoint.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoUseCaseToExtensionPoint extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAUseCase(parent))//1
{ 
return Model.getFacade().getExtensionPoints(parent);
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.use-case.extension-point");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAUseCase(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

 } 


