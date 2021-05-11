
//#if -507930403 
// Compilation Unit of /GoElementToMachine.java 
 

//#if -1872622516 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1249441672 
import java.util.Collection;
//#endif 


//#if 77987963 
import java.util.Collections;
//#endif 


//#if 716317692 
import java.util.HashSet;
//#endif 


//#if -1423685554 
import java.util.Set;
//#endif 


//#if -126140637 
import org.argouml.i18n.Translator;
//#endif 


//#if -2048453783 
import org.argouml.model.Model;
//#endif 


//#if -1878377417 
public class GoElementToMachine extends 
//#if 355591130 
AbstractPerspectiveRule
//#endif 

  { 

//#if 358361448 
public String getRuleName()
    { 

//#if 1422465194 
return Translator.localize("misc.class.state-machine");
//#endif 

} 

//#endif 


//#if 661187194 
public Set getDependencies(Object parent)
    { 

//#if 1584977736 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if 384025758 
Set set = new HashSet();
//#endif 


//#if -219740860 
set.add(parent);
//#endif 


//#if 1124014142 
return set;
//#endif 

} 

//#endif 


//#if -1427928320 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1591949270 
public Collection getChildren(Object parent)
    { 

//#if -1276887107 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if 495377706 
return Model.getFacade().getBehaviors(parent);
//#endif 

} 

//#endif 


//#if -340918283 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

