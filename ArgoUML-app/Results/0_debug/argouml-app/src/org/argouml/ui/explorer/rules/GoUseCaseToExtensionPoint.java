
//#if 527277062 
// Compilation Unit of /GoUseCaseToExtensionPoint.java 
 

//#if -929940088 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -365018172 
import java.util.Collection;
//#endif 


//#if 1569340351 
import java.util.Collections;
//#endif 


//#if 1415487808 
import java.util.HashSet;
//#endif 


//#if 1208616850 
import java.util.Set;
//#endif 


//#if 858716007 
import org.argouml.i18n.Translator;
//#endif 


//#if 917081517 
import org.argouml.model.Model;
//#endif 


//#if -116036032 
public class GoUseCaseToExtensionPoint extends 
//#if -1014212111 
AbstractPerspectiveRule
//#endif 

  { 

//#if 810845825 
public Collection getChildren(Object parent)
    { 

//#if 126354021 
if(Model.getFacade().isAUseCase(parent))//1
{ 

//#if -2136186971 
return Model.getFacade().getExtensionPoints(parent);
//#endif 

} 

//#endif 


//#if -2018350245 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1762560577 
public String getRuleName()
    { 

//#if -1210184418 
return Translator.localize("misc.use-case.extension-point");
//#endif 

} 

//#endif 


//#if 976135043 
public Set getDependencies(Object parent)
    { 

//#if -682830116 
if(Model.getFacade().isAUseCase(parent))//1
{ 

//#if 639889568 
Set set = new HashSet();
//#endif 


//#if -2054061498 
set.add(parent);
//#endif 


//#if -763101504 
return set;
//#endif 

} 

//#endif 


//#if -1682696252 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

