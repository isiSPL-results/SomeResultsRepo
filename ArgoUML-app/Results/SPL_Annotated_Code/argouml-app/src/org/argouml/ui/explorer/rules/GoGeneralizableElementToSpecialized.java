// Compilation Unit of /GoGeneralizableElementToSpecialized.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoGeneralizableElementToSpecialized extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.classifier.specialized-classifier");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAGeneralizableElement(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAGeneralizableElement(parent))//1
{ 
return Model.getFacade().getChildren(parent);
} 

return Collections.EMPTY_SET;
} 

 } 


