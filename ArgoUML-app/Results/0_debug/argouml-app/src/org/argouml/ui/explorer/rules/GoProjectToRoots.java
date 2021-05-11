
//#if 1622688883 
// Compilation Unit of /GoProjectToRoots.java 
 

//#if 85736442 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -850638666 
import java.util.Collection;
//#endif 


//#if -599993075 
import java.util.Collections;
//#endif 


//#if 1721356000 
import java.util.Set;
//#endif 


//#if 468770357 
import org.argouml.i18n.Translator;
//#endif 


//#if -421513809 
import org.argouml.kernel.Project;
//#endif 


//#if -271611342 
public class GoProjectToRoots extends 
//#if 1194733596 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1964197868 
public Collection getChildren(Object parent)
    { 

//#if -1827305342 
if(parent instanceof Project)//1
{ 

//#if 2096176397 
return ((Project) parent).getRoots();
//#endif 

} 

//#endif 


//#if -505675530 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -679580374 
public String getRuleName()
    { 

//#if -1606310868 
return Translator.localize("misc.project.roots");
//#endif 

} 

//#endif 


//#if -1570876936 
public Set getDependencies(Object parent)
    { 

//#if 740356889 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

