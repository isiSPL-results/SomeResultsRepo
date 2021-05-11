
//#if -974481931 
// Compilation Unit of /GoSubmachineStateToStateMachine.java 
 

//#if -349781015 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1830079108 
import java.util.ArrayList;
//#endif 


//#if 441720677 
import java.util.Collection;
//#endif 


//#if 808440894 
import java.util.Collections;
//#endif 


//#if 1953124671 
import java.util.HashSet;
//#endif 


//#if 920486757 
import java.util.List;
//#endif 


//#if -1355575535 
import java.util.Set;
//#endif 


//#if -1485179738 
import org.argouml.i18n.Translator;
//#endif 


//#if -162856340 
import org.argouml.model.Model;
//#endif 


//#if 427015511 
public class GoSubmachineStateToStateMachine extends 
//#if 1018157180 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1314363468 
public Collection getChildren(Object parent)
    { 

//#if -1821243868 
if(Model.getFacade().isASubmachineState(parent))//1
{ 

//#if -717635183 
List list = new ArrayList();
//#endif 


//#if -1998267876 
list.add(Model.getFacade().getSubmachine(parent));
//#endif 


//#if -1012047394 
return list;
//#endif 

} 

//#endif 


//#if 1482683151 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1429175690 
public String getRuleName()
    { 

//#if -79868959 
return Translator.localize("misc.submachine-state.state-machine");
//#endif 

} 

//#endif 


//#if 1007869336 
public Set getDependencies(Object parent)
    { 

//#if 1200288423 
if(Model.getFacade().isASubmachineState(parent))//1
{ 

//#if -475055879 
Set set = new HashSet();
//#endif 


//#if -768024801 
set.add(parent);
//#endif 


//#if -1815858599 
return set;
//#endif 

} 

//#endif 


//#if 756030956 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

