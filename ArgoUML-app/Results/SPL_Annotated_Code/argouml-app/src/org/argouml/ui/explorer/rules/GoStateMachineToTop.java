// Compilation Unit of /GoStateMachineToTop.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.ArrayList;
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
import java.util.List;
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
public class GoStateMachineToTop extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
List list = new ArrayList();
list.add(Model.getFacade().getTop(parent));
return list;
} 

return Collections.EMPTY_SET;
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

public String getRuleName()
    { 
return Translator.localize("misc.state-machine.top-state");
} 

 } 

//#endif 


