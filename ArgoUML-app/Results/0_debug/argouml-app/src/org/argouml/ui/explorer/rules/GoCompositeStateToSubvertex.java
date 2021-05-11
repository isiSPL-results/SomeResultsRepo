
//#if -1047120655 
// Compilation Unit of /GoCompositeStateToSubvertex.java 
 

//#if -2037668986 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1164013378 
import java.util.Collection;
//#endif 


//#if 1724678145 
import java.util.Collections;
//#endif 


//#if 878794370 
import java.util.HashSet;
//#endif 


//#if 179154388 
import java.util.Set;
//#endif 


//#if -1911979479 
import org.argouml.i18n.Translator;
//#endif 


//#if -127153809 
import org.argouml.model.Model;
//#endif 


//#if 235763806 
public class GoCompositeStateToSubvertex extends 
//#if 266634072 
AbstractPerspectiveRule
//#endif 

  { 

//#if 769974630 
public String getRuleName()
    { 

//#if 893568678 
return Translator.localize("misc.state.substates");
//#endif 

} 

//#endif 


//#if -787505348 
public Set getDependencies(Object parent)
    { 

//#if -1673733813 
if(Model.getFacade().isACompositeState(parent))//1
{ 

//#if 1741160606 
Set set = new HashSet();
//#endif 


//#if -146194108 
set.add(parent);
//#endif 


//#if -591506370 
return set;
//#endif 

} 

//#endif 


//#if -1468701876 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 534889512 
public Collection getChildren(Object parent)
    { 

//#if 70918205 
if(Model.getFacade().isACompositeState(parent))//1
{ 

//#if -2005902640 
return Model.getFacade().getSubvertices(parent);
//#endif 

} 

//#endif 


//#if 760376254 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

