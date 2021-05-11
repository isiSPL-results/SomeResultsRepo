
//#if -1865608632 
// Compilation Unit of /GoStateToIncomingTrans.java 
 

//#if 473241074 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 567720110 
import java.util.Collection;
//#endif 


//#if 419456021 
import java.util.Collections;
//#endif 


//#if -1330486122 
import java.util.HashSet;
//#endif 


//#if 1916855784 
import java.util.Set;
//#endif 


//#if -1128331459 
import org.argouml.i18n.Translator;
//#endif 


//#if -315164541 
import org.argouml.model.Model;
//#endif 


//#if 363775555 
public class GoStateToIncomingTrans extends 
//#if -867375514 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1251426378 
public Collection getChildren(Object parent)
    { 

//#if 726696937 
if(Model.getFacade().isAStateVertex(parent))//1
{ 

//#if -181865618 
return Model.getFacade().getIncomings(parent);
//#endif 

} 

//#endif 


//#if 1963376469 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1986985582 
public Set getDependencies(Object parent)
    { 

//#if 1002387940 
if(Model.getFacade().isAStateVertex(parent))//1
{ 

//#if -1212413645 
Set set = new HashSet();
//#endif 


//#if -1369777063 
set.add(parent);
//#endif 


//#if -1147985133 
return set;
//#endif 

} 

//#endif 


//#if 810790202 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1908455668 
public String getRuleName()
    { 

//#if -1054105906 
return Translator.localize("misc.state.incoming-transitions");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

