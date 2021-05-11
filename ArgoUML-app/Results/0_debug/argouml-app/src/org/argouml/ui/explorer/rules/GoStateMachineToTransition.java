
//#if -1060885015 
// Compilation Unit of /GoStateMachineToTransition.java 
 

//#if 1760092599 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -931363149 
import java.util.Collection;
//#endif 


//#if 1192515248 
import java.util.Collections;
//#endif 


//#if 63298737 
import java.util.HashSet;
//#endif 


//#if -1779260541 
import java.util.Set;
//#endif 


//#if 2080070040 
import org.argouml.i18n.Translator;
//#endif 


//#if -434589602 
import org.argouml.model.Model;
//#endif 


//#if 376631480 
public class GoStateMachineToTransition extends 
//#if -1340918260 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1683272156 
public Collection getChildren(Object parent)
    { 

//#if -595273246 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if 397679961 
return Model.getFacade().getTransitions(parent);
//#endif 

} 

//#endif 


//#if 1371231415 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 2100410138 
public String getRuleName()
    { 

//#if 1953597675 
return Translator.localize("misc.state-machine.transition");
//#endif 

} 

//#endif 


//#if 368487944 
public Set getDependencies(Object parent)
    { 

//#if -405095703 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if -2139228419 
Set set = new HashSet();
//#endif 


//#if -117489885 
set.add(parent);
//#endif 


//#if 1724114269 
return set;
//#endif 

} 

//#endif 


//#if 1463861054 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

