// Compilation Unit of /GoStimulusToAction.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoStimulusToAction extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.stimulus.action");
} 

public Collection getChildren(Object parent)
    { 
if(!Model.getFacade().isAStimulus(parent))//1
{ 
return Collections.EMPTY_SET;
} 

Object ms = parent;
Object action = Model.getFacade().getDispatchAction(ms);
Collection result = new ArrayList();
result.add(action);
return result;
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAStimulus(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

 } 


