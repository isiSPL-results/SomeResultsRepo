// Compilation Unit of /GoCompositeStateToSubvertex.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.Collection;
//#endif 


//#if STATE 
import java.util.Collections;
//#endif 


//#if STATE 
import java.util.HashSet;
//#endif 


//#if STATE 
import java.util.Set;
//#endif 


//#if STATE 
import org.argouml.i18n.Translator;
//#endif 


//#if STATE 
import org.argouml.model.Model;
//#endif 


//#if STATE 
public class GoCompositeStateToSubvertex extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.state.substates");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isACompositeState(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isACompositeState(parent))//1
{ 
return Model.getFacade().getSubvertices(parent);
} 

return Collections.EMPTY_SET;
} 

 } 

//#endif 


