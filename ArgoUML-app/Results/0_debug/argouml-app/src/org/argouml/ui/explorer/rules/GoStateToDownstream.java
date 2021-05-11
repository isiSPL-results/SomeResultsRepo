
//#if -1436353648 
// Compilation Unit of /GoStateToDownstream.java 
 

//#if -261715296 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -293368100 
import java.util.Collection;
//#endif 


//#if -504474713 
import java.util.Collections;
//#endif 


//#if 1763372328 
import java.util.HashSet;
//#endif 


//#if -1453815942 
import java.util.Set;
//#endif 


//#if 2089517391 
import org.argouml.i18n.Translator;
//#endif 


//#if 845630357 
import org.argouml.model.Model;
//#endif 


//#if 985468211 
public class GoStateToDownstream extends 
//#if 1635279332 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1778076914 
public String getRuleName()
    { 

//#if 1160959530 
return Translator.localize("misc.state.outgoing-states");
//#endif 

} 

//#endif 


//#if -1935173708 
public Collection getChildren(Object parent)
    { 

//#if -1274823308 
if(Model.getFacade().isAStateVertex(parent))//1
{ 

//#if 161459163 
return Model.getStateMachinesHelper().getOutgoingStates(parent);
//#endif 

} 

//#endif 


//#if 313734058 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1589029072 
public Set getDependencies(Object parent)
    { 

//#if 1367375065 
if(Model.getFacade().isAStateVertex(parent))//1
{ 

//#if 352552163 
Set set = new HashSet();
//#endif 


//#if 1083420681 
set.add(parent);
//#endif 


//#if 1327528643 
return set;
//#endif 

} 

//#endif 


//#if -1922102171 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

