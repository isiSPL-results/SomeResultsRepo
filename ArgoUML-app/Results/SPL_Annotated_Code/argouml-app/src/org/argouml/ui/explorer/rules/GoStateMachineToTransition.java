// Compilation Unit of /GoStateMachineToTransition.java 
 

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
public class GoStateMachineToTransition extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
return Model.getFacade().getTransitions(parent);
} 

return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.state-machine.transition");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

 } 

//#endif 


