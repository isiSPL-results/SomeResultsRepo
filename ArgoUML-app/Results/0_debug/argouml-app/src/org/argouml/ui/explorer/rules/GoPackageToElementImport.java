
//#if 477958444 
// Compilation Unit of /GoPackageToElementImport.java 
 

//#if 1677284016 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 2136877804 
import java.util.Collection;
//#endif 


//#if 1818704279 
import java.util.Collections;
//#endif 


//#if 139353450 
import java.util.Set;
//#endif 


//#if -673434817 
import org.argouml.i18n.Translator;
//#endif 


//#if 37647749 
import org.argouml.model.Model;
//#endif 


//#if -1347317109 
public class GoPackageToElementImport extends 
//#if -163951805 
AbstractPerspectiveRule
//#endif 

  { 

//#if 945522515 
public Collection getChildren(Object parent)
    { 

//#if 1263135188 
if(Model.getFacade().isAPackage(parent))//1
{ 

//#if -1889733807 
return Model.getFacade().getElementImports(parent);
//#endif 

} 

//#endif 


//#if -2044882853 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -706192751 
public String getRuleName()
    { 

//#if -1057937995 
return Translator.localize("misc.package.element-import");
//#endif 

} 

//#endif 


//#if 1249485809 
public Set getDependencies(Object parent)
    { 

//#if -1674837918 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

