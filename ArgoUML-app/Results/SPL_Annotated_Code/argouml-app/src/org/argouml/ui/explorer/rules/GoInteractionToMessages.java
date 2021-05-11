// Compilation Unit of /GoInteractionToMessages.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoInteractionToMessages extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAInteraction(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.interaction.messages");
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAInteraction(parent))//1
{ 
return Model.getFacade().getMessages(parent);
} 

return Collections.EMPTY_SET;
} 

 } 


