// Compilation Unit of /GoStateToEntry.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoStateToEntry extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.state.entry");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAState(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAState(parent)
                && Model.getFacade().getEntry(parent) != null)//1
{ 
Collection children = new ArrayList();
children.add(Model.getFacade().getEntry(parent));
return children;
} 

return Collections.EMPTY_SET;
} 

 } 


