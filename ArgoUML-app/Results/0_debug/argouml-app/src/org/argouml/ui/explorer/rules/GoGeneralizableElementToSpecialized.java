
//#if 1741904123 
// Compilation Unit of /GoGeneralizableElementToSpecialized.java 
 

//#if 1529576164 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1176026080 
import java.util.Collection;
//#endif 


//#if -2097068317 
import java.util.Collections;
//#endif 


//#if 1564532324 
import java.util.HashSet;
//#endif 


//#if -37718346 
import java.util.Set;
//#endif 


//#if 2018645899 
import org.argouml.i18n.Translator;
//#endif 


//#if -628465711 
import org.argouml.model.Model;
//#endif 


//#if -363628282 
public class GoGeneralizableElementToSpecialized extends 
//#if 1288133763 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1116333103 
public String getRuleName()
    { 

//#if 1000115212 
return Translator.localize("misc.classifier.specialized-classifier");
//#endif 

} 

//#endif 


//#if 2088757937 
public Set getDependencies(Object parent)
    { 

//#if -1093285548 
if(Model.getFacade().isAGeneralizableElement(parent))//1
{ 

//#if -2130080227 
Set set = new HashSet();
//#endif 


//#if -1942788541 
set.add(parent);
//#endif 


//#if -513022851 
return set;
//#endif 

} 

//#endif 


//#if -948884970 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1598109549 
public Collection getChildren(Object parent)
    { 

//#if 645170282 
if(Model.getFacade().isAGeneralizableElement(parent))//1
{ 

//#if -1705310992 
return Model.getFacade().getChildren(parent);
//#endif 

} 

//#endif 


//#if 105267756 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

