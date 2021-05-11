// Compilation Unit of /GoStateToInternalTrans.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoStateToInternalTrans extends AbstractPerspectiveRule
  { 
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

public String getRuleName()
    { 
return Translator.localize("misc.state.internal-transitions");
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAState(parent))//1
{ 
return Model.getFacade().getInternalTransitions(parent);
} 

return Collections.EMPTY_SET;
} 

 } 


