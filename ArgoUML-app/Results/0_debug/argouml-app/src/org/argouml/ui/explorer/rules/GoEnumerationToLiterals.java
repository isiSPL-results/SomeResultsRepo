
//#if 2009396580 
// Compilation Unit of /GoEnumerationToLiterals.java 
 

//#if 1443714936 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1769817421 
import java.util.ArrayList;
//#endif 


//#if 369363380 
import java.util.Collection;
//#endif 


//#if -1434635313 
import java.util.Collections;
//#endif 


//#if 1697653072 
import java.util.HashSet;
//#endif 


//#if -2044521228 
import java.util.List;
//#endif 


//#if -1589768286 
import java.util.Set;
//#endif 


//#if -630480009 
import org.argouml.i18n.Translator;
//#endif 


//#if 314491325 
import org.argouml.model.Model;
//#endif 


//#if 1467487507 
public class GoEnumerationToLiterals extends 
//#if -1206916855 
AbstractPerspectiveRule
//#endif 

  { 

//#if -270007957 
public Set getDependencies(Object parent)
    { 

//#if 459468539 
if(Model.getFacade().isAEnumeration(parent))//1
{ 

//#if -1182488874 
Set set = new HashSet();
//#endif 


//#if 973194108 
set.add(parent);
//#endif 


//#if 1388412207 
set.addAll(Model.getFacade().getEnumerationLiterals(parent));
//#endif 


//#if -1414340490 
return set;
//#endif 

} 

//#endif 


//#if 1700015605 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 2026741463 
public String getRuleName()
    { 

//#if -1849616619 
return Translator.localize("misc.enumeration.literal");
//#endif 

} 

//#endif 


//#if -1632927847 
public Collection getChildren(Object parent)
    { 

//#if -1826279456 
if(Model.getFacade().isAEnumeration(parent))//1
{ 

//#if 32923845 
List list = new ArrayList();
//#endif 


//#if 1043046252 
if(Model.getFacade().getEnumerationLiterals(parent) != null
                    && (Model.getFacade().getEnumerationLiterals(parent).size()
                        > 0))//1
{ 

//#if 488291712 
list.addAll(Model.getFacade().getEnumerationLiterals(parent));
//#endif 

} 

//#endif 


//#if -61202902 
return list;
//#endif 

} 

//#endif 


//#if 448984368 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 75001161 
public GoEnumerationToLiterals()
    { 

//#if -1736071361 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

