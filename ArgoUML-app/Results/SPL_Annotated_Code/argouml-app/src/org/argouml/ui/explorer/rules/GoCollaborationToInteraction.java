// Compilation Unit of /GoCollaborationToInteraction.java 
 

//#if COLLABORATION 
package org.argouml.ui.explorer.rules;
//#endif 


//#if COLLABORATION 
import java.util.Collection;
//#endif 


//#if COLLABORATION 
import java.util.Collections;
//#endif 


//#if COLLABORATION 
import java.util.HashSet;
//#endif 


//#if COLLABORATION 
import java.util.Set;
//#endif 


//#if COLLABORATION 
import org.argouml.i18n.Translator;
//#endif 


//#if COLLABORATION 
import org.argouml.model.Model;
//#endif 


//#if COLLABORATION 
public class GoCollaborationToInteraction extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isACollaboration(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.collaboration.interaction");
} 

public Collection getChildren(Object parent)
    { 
if(!Model.getFacade().isACollaboration(parent))//1
{ 
return Collections.EMPTY_SET;
} 

return Model.getFacade().getInteractions(parent);
} 

 } 

//#endif 


