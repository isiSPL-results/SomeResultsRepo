// Compilation Unit of /GoStateMachineToState.java 
 

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
public class GoStateMachineToState extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
if(Model.getFacade().getTop(parent) != null)//1
{ 
set.add(Model.getFacade().getTop(parent));
} 

return set;
} 

return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
if(Model.getFacade().getTop(parent) != null)//1
{ 
return Model.getFacade().getSubvertices(
                           Model.getFacade().getTop(parent));
} 

} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.state-machine.state");
} 

 } 

//#endif 


