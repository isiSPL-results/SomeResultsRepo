
//#if 271114314 
// Compilation Unit of /GoStateMachineToTop.java 
 

//#if 859697678 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -2082247561 
import java.util.ArrayList;
//#endif 


//#if 1214433226 
import java.util.Collection;
//#endif 


//#if -1007273863 
import java.util.Collections;
//#endif 


//#if -429257990 
import java.util.HashSet;
//#endif 


//#if -1651008630 
import java.util.List;
//#endif 


//#if 1886608972 
import java.util.Set;
//#endif 


//#if -285933407 
import org.argouml.i18n.Translator;
//#endif 


//#if -1308015641 
import org.argouml.model.Model;
//#endif 


//#if 521046747 
public class GoStateMachineToTop extends 
//#if 1155866618 
AbstractPerspectiveRule
//#endif 

  { 

//#if 239418442 
public Collection getChildren(Object parent)
    { 

//#if -1973595381 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if 1033186792 
List list = new ArrayList();
//#endif 


//#if 1643516955 
list.add(Model.getFacade().getTop(parent));
//#endif 


//#if 1898296359 
return list;
//#endif 

} 

//#endif 


//#if 2056469600 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1651381670 
public Set getDependencies(Object parent)
    { 

//#if -1423116619 
if(Model.getFacade().isAStateMachine(parent))//1
{ 

//#if 1492360602 
Set set = new HashSet();
//#endif 


//#if 400735296 
set.add(parent);
//#endif 


//#if -522273734 
return set;
//#endif 

} 

//#endif 


//#if -1388979958 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 623959432 
public String getRuleName()
    { 

//#if 1267045932 
return Translator.localize("misc.state-machine.top-state");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

