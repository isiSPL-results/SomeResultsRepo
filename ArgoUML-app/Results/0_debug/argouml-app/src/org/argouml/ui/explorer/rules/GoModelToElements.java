
//#if 625287437 
// Compilation Unit of /GoModelToElements.java 
 

//#if -341304740 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1488561768 
import java.util.Collection;
//#endif 


//#if 1099227243 
import java.util.Collections;
//#endif 


//#if 1180597228 
import java.util.HashSet;
//#endif 


//#if 1461327934 
import java.util.Set;
//#endif 


//#if -1135711469 
import org.argouml.i18n.Translator;
//#endif 


//#if 109950809 
import org.argouml.model.Model;
//#endif 


//#if -1641500380 
public class GoModelToElements extends 
//#if -1535288847 
AbstractPerspectiveRule
//#endif 

  { 

//#if -6130241 
public String getRuleName()
    { 

//#if -1966964302 
return Translator.localize("misc.model.elements");
//#endif 

} 

//#endif 


//#if 386238081 
public Collection getChildren(Object parent)
    { 

//#if -1630909376 
if(Model.getFacade().isANamespace(parent))//1
{ 

//#if 1243043948 
return Model.getFacade().getOwnedElements(parent);
//#endif 

} 

//#endif 


//#if -763225372 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 958243715 
public Set getDependencies(Object parent)
    { 

//#if -616430581 
if(Model.getFacade().isANamespace(parent))//1
{ 

//#if 1642821207 
Set set = new HashSet();
//#endif 


//#if -1686733955 
set.add(parent);
//#endif 


//#if 286125367 
return set;
//#endif 

} 

//#endif 


//#if -1079965767 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

