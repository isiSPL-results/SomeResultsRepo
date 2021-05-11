
//#if 2085847781 
// Compilation Unit of /GoStateToOutgoingTrans.java 
 

//#if 282955660 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 732138184 
import java.util.Collection;
//#endif 


//#if 1221449019 
import java.util.Collections;
//#endif 


//#if 1870813372 
import java.util.HashSet;
//#endif 


//#if 1405934862 
import java.util.Set;
//#endif 


//#if -1725922333 
import org.argouml.i18n.Translator;
//#endif 


//#if 1600960553 
import org.argouml.model.Model;
//#endif 


//#if 148045143 
public class GoStateToOutgoingTrans extends 
//#if 507454306 
AbstractPerspectiveRule
//#endif 

  { 

//#if -36460046 
public Set getDependencies(Object parent)
    { 

//#if -628356732 
if(Model.getFacade().isAStateVertex(parent))//1
{ 

//#if -44069311 
Set set = new HashSet();
//#endif 


//#if -1279846297 
set.add(parent);
//#endif 


//#if 429457825 
return set;
//#endif 

} 

//#endif 


//#if 1041678746 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1854130766 
public Collection getChildren(Object parent)
    { 

//#if -1579434639 
if(Model.getFacade().isAStateVertex(parent))//1
{ 

//#if 965368373 
return Model.getFacade().getOutgoings(parent);
//#endif 

} 

//#endif 


//#if 222241485 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 269985520 
public String getRuleName()
    { 

//#if -239180569 
return Translator.localize("misc.state.outgoing-transitions");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

