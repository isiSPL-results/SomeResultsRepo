
//#if 1111685714 
// Compilation Unit of /GoClassifierToInstance.java 
 

//#if -309939211 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1951559281 
import java.util.Collection;
//#endif 


//#if 368797362 
import java.util.Collections;
//#endif 


//#if -450282061 
import java.util.HashSet;
//#endif 


//#if -1901931131 
import java.util.Set;
//#endif 


//#if 253943834 
import org.argouml.i18n.Translator;
//#endif 


//#if -1753495584 
import org.argouml.model.Model;
//#endif 


//#if -1029461919 
public class GoClassifierToInstance extends 
//#if 1303043377 
AbstractPerspectiveRule
//#endif 

  { 

//#if 2035365955 
public Set getDependencies(Object parent)
    { 

//#if 1821188504 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if 11087375 
Set set = new HashSet();
//#endif 


//#if -847982795 
set.add(parent);
//#endif 


//#if -429692177 
return set;
//#endif 

} 

//#endif 


//#if 704359106 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 326904063 
public String getRuleName()
    { 

//#if 1632814034 
return Translator.localize("misc.classifier.instance");
//#endif 

} 

//#endif 


//#if 1234221505 
public Collection getChildren(Object parent)
    { 

//#if -291264153 
if(!Model.getFacade().isAClassifier(parent))//1
{ 

//#if 1225701082 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1131324690 
return Model.getFacade().getInstances(parent);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

