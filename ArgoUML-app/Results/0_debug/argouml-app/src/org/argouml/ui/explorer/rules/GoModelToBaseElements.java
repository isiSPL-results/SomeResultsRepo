
//#if -356107896 
// Compilation Unit of /GoModelToBaseElements.java 
 

//#if -1991723400 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 161957453 
import java.util.ArrayList;
//#endif 


//#if 2065311924 
import java.util.Collection;
//#endif 


//#if -399838001 
import java.util.Collections;
//#endif 


//#if 1508270672 
import java.util.HashSet;
//#endif 


//#if 624742562 
import java.util.Set;
//#endif 


//#if -184245129 
import org.argouml.i18n.Translator;
//#endif 


//#if -1677704515 
import org.argouml.model.Model;
//#endif 


//#if -894886151 
public class GoModelToBaseElements extends 
//#if 798468857 
AbstractPerspectiveRule
//#endif 

  { 

//#if 176562555 
public Set getDependencies(Object parent)
    { 

//#if -849506316 
if(Model.getFacade().isAPackage(parent))//1
{ 

//#if 186126933 
Set set = new HashSet();
//#endif 


//#if 1188873851 
set.add(parent);
//#endif 


//#if -1378890059 
return set;
//#endif 

} 

//#endif 


//#if 1026977339 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 762094791 
public String getRuleName()
    { 

//#if 945466272 
return Translator.localize("misc.package.base-class");
//#endif 

} 

//#endif 


//#if 635479433 
public Collection getChildren(Object parent)
    { 

//#if -119006690 
if(Model.getFacade().isAPackage(parent))//1
{ 

//#if -210288175 
Collection result = new ArrayList();
//#endif 


//#if 652913151 
Collection generalizableElements =
                Model.getModelManagementHelper()
                .getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getGeneralizableElement());
//#endif 


//#if 854425478 
for (Object element : generalizableElements) //1
{ 

//#if 39256552 
if(Model.getFacade().getGeneralizations(element).isEmpty())//1
{ 

//#if 373604831 
result.add(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1814219682 
return result;
//#endif 

} 

//#endif 


//#if 2001715525 
return Collections.EMPTY_LIST;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

