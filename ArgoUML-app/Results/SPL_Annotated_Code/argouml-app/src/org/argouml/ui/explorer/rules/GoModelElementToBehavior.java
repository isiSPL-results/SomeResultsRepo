// Compilation Unit of /GoModelElementToBehavior.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoModelElementToBehavior extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAModelElement(parent))//1
{ 
return Model.getFacade().getBehaviors(parent);
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.model-element.behavior");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAModelElement(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

 } 


