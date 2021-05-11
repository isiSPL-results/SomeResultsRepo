
//#if 1066086471 
// Compilation Unit of /GoProfileToModel.java 
 

//#if -1046694083 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 2033085369 
import java.util.Collection;
//#endif 


//#if -1398861206 
import java.util.Collections;
//#endif 


//#if 1269414205 
import java.util.Set;
//#endif 


//#if -1365974574 
import org.argouml.i18n.Translator;
//#endif 


//#if 720470744 
import org.argouml.profile.Profile;
//#endif 


//#if -651742225 
import org.argouml.profile.ProfileException;
//#endif 


//#if 959728637 
public class GoProfileToModel extends 
//#if -705984676 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1908738966 
public String getRuleName()
    { 

//#if 317824602 
return Translator.localize("misc.profile.model");
//#endif 

} 

//#endif 


//#if 703042232 
public Set getDependencies(Object parent)
    { 

//#if 1018838518 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -229028052 
public Collection getChildren(Object parent)
    { 

//#if -1224090351 
if(parent instanceof Profile)//1
{ 

//#if 1635370310 
try //1
{ 

//#if 588390873 
Collection col = ((Profile) parent).getProfilePackages();
//#endif 


//#if 354867714 
return col;
//#endif 

} 

//#if 1237414349 
catch (ProfileException e) //1
{ 

//#if 159610700 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2025762123 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

