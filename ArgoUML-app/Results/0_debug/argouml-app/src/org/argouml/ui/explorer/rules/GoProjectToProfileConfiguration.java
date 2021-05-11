
//#if 136868908 
// Compilation Unit of /GoProjectToProfileConfiguration.java 
 

//#if 1092830881 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1364904508 
import java.util.ArrayList;
//#endif 


//#if 1977231389 
import java.util.Collection;
//#endif 


//#if 1164632710 
import java.util.Collections;
//#endif 


//#if -1654299303 
import java.util.Set;
//#endif 


//#if 477310190 
import org.argouml.i18n.Translator;
//#endif 


//#if 132950998 
import org.argouml.kernel.Project;
//#endif 


//#if -1361854715 
public class GoProjectToProfileConfiguration extends 
//#if -1591591928 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1721183766 
public String getRuleName()
    { 

//#if 907943209 
return Translator.localize("misc.project.profileconfiguration");
//#endif 

} 

//#endif 


//#if -1757105960 
public Collection getChildren(Object parent)
    { 

//#if -1473141 
if(parent instanceof Project)//1
{ 

//#if -1505421428 
Collection l = new ArrayList();
//#endif 


//#if -1048042938 
l.add(((Project) parent).getProfileConfiguration());
//#endif 


//#if 1092075687 
return l;
//#endif 

} 

//#endif 


//#if -521730025 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 


//#if -369921908 
public Set getDependencies(Object parent)
    { 

//#if 303932004 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

