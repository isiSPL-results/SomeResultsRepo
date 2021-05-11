
//#if 811488332 
// Compilation Unit of /GoPackageToClass.java 
 

//#if -777202138 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1874630174 
import java.util.Collection;
//#endif 


//#if 2016008545 
import java.util.Collections;
//#endif 


//#if 1244292916 
import java.util.Set;
//#endif 


//#if 1184256905 
import org.argouml.i18n.Translator;
//#endif 


//#if 668486351 
import org.argouml.model.Model;
//#endif 


//#if 2106168120 
public class GoPackageToClass extends 
//#if 400900661 
AbstractPerspectiveRule
//#endif 

  { 

//#if 679830981 
public Collection getChildren(Object parent)
    { 

//#if -1937128958 
if(Model.getFacade().isAPackage(parent))//1
{ 

//#if 1332151978 
return Model.getModelManagementHelper()
                   .getAllModelElementsOfKind(parent,
                                              Model.getMetaTypes().getUMLClass());
//#endif 

} 

//#endif 


//#if -314957331 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 951147779 
public String getRuleName()
    { 

//#if -107632442 
return Translator.localize("misc.package.class");
//#endif 

} 

//#endif 


//#if -962090305 
public Set getDependencies(Object parent)
    { 

//#if -851390534 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

