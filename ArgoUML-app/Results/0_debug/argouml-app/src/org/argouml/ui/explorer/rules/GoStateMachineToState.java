
//#if -1437443095 
// Compilation Unit of /GoStateMachineToState.java 
 

//#if 1334347471 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 425404875 
import java.util.Collection;
//#endif 


//#if 302651032 
import java.util.Collections;
//#endif 


//#if 2049429657 
import java.util.HashSet;
//#endif 


//#if 502975339 
import java.util.Set;
//#endif 


//#if 839617408 
import org.argouml.i18n.Translator;
//#endif 


//#if -895609274 
import org.argouml.model.Model;
//#endif 


//#if -600507594 
public class GoStateMachineToState extends 
//#if -1554397223 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1368741733 
public Set getDependencies(Object parent)
    { 

//#if -1869582899 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if -1024770098 
Set set = new HashSet();
//#endif 


//#if 382441588 
set.add(parent);
//#endif 


//#if -1456980439 
if(Model.getFacade().getTop(parent) != null)//1
{ 

//#if 1823400810 
set.add(Model.getFacade().getTop(parent));
//#endif 

} 

//#endif 


//#if 98422638 
return set;
//#endif 

} 

//#endif 


//#if 314166306 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -2065085847 
public Collection getChildren(Object parent)
    { 

//#if -752562946 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if 2001485159 
if(Model.getFacade().getTop(parent) != null)//1
{ 

//#if 8155291 
return Model.getFacade().getSubvertices(
                           Model.getFacade().getTop(parent));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2140738093 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1189410393 
public String getRuleName()
    { 

//#if -1620503603 
return Translator.localize("misc.state-machine.state");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

