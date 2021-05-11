
//#if 385194330 
// Compilation Unit of /CrProfile.java 
 

//#if -223299367 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1225094551 
import org.argouml.cognitive.Translator;
//#endif 


//#if 1983109631 
public class CrProfile extends 
//#if 1310112296 
CrUML
//#endif 

  { 

//#if -1266735911 
private String localizationPrefix;
//#endif 


//#if 1505244024 
private static final long serialVersionUID = 1785043010468681602L;
//#endif 


//#if -1429464697 
@Override
    protected String getLocalizedString(String key, String suffix)
    { 

//#if 248451037 
return Translator.localize(localizationPrefix + "." + key + suffix);
//#endif 

} 

//#endif 


//#if -1204737020 
public CrProfile(final String prefix)
    { 

//#if -1136154296 
super();
//#endif 


//#if -1600004215 
if(prefix == null || "".equals(prefix))//1
{ 

//#if -1348867142 
this.localizationPrefix = "critics";
//#endif 

} 
else
{ 

//#if -1660752201 
this.localizationPrefix = prefix;
//#endif 

} 

//#endif 


//#if -258669498 
setupHeadAndDesc();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

