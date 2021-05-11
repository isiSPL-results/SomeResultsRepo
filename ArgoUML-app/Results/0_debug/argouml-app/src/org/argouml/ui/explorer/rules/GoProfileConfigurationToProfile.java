
//#if -305569283 
// Compilation Unit of /GoProfileConfigurationToProfile.java 
 

//#if -1540268548 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1908300488 
import java.util.Collection;
//#endif 


//#if 972228811 
import java.util.Collections;
//#endif 


//#if -421093218 
import java.util.Set;
//#endif 


//#if -103494797 
import org.argouml.i18n.Translator;
//#endif 


//#if 1286127615 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if -90066806 
public class GoProfileConfigurationToProfile extends 
//#if 1808567844 
AbstractPerspectiveRule
//#endif 

  { 

//#if -580832268 
public Collection getChildren(Object parent)
    { 

//#if 861082059 
if(parent instanceof ProfileConfiguration)//1
{ 

//#if 2002130181 
return ((ProfileConfiguration) parent).getProfiles();
//#endif 

} 

//#endif 


//#if 637969951 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 804612402 
public String getRuleName()
    { 

//#if 2010102018 
return Translator.localize("misc.profileconfiguration.profile");
//#endif 

} 

//#endif 


//#if -1693506832 
public Set getDependencies(Object parent)
    { 

//#if -400923831 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

