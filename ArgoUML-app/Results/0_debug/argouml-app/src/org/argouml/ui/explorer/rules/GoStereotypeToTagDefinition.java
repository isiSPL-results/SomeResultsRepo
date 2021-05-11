
//#if 1704064562 
// Compilation Unit of /GoStereotypeToTagDefinition.java 
 

//#if 1974012623 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 139477590 
import java.util.ArrayList;
//#endif 


//#if 1368436171 
import java.util.Collection;
//#endif 


//#if -528149864 
import java.util.Collections;
//#endif 


//#if -712979303 
import java.util.HashSet;
//#endif 


//#if -2136582581 
import java.util.List;
//#endif 


//#if 624019307 
import java.util.Set;
//#endif 


//#if -431353274 
import org.argouml.model.Model;
//#endif 


//#if -1056124042 
public class GoStereotypeToTagDefinition extends 
//#if -1895781074 
AbstractPerspectiveRule
//#endif 

  { 

//#if 981850056 
public GoStereotypeToTagDefinition()
    { 

//#if 682702346 
super();
//#endif 

} 

//#endif 


//#if -945038048 
@Override
    public String getRuleName()
    { 

//#if 798833954 
return "Stereotype->TagDefinition";
//#endif 

} 

//#endif 


//#if 808000875 
@Override
    public String toString()
    { 

//#if -851315691 
return super.toString();
//#endif 

} 

//#endif 


//#if 1311873192 
@Override
    public Collection getChildren(final Object parent)
    { 

//#if 2087077273 
if(Model.getFacade().isAStereotype(parent))//1
{ 

//#if 1319251916 
final List list = new ArrayList();
//#endif 


//#if 1716205390 
if(Model.getFacade().getTagDefinitions(parent) != null
                    && Model.getFacade().getTagDefinitions(parent).size() > 0)//1
{ 

//#if -1725267404 
list.addAll(Model.getFacade().getTagDefinitions(parent));
//#endif 

} 

//#endif 


//#if 1510449633 
return list;
//#endif 

} 

//#endif 


//#if 1048562482 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -809308060 
public Set getDependencies(final Object parent)
    { 

//#if -1147832514 
if(Model.getFacade().isAStereotype(parent))//1
{ 

//#if 1729079156 
final Set set = new HashSet();
//#endif 


//#if 318408026 
set.add(parent);
//#endif 


//#if -635572942 
set.addAll(Model.getFacade().getTagDefinitions(parent));
//#endif 


//#if -681451308 
return set;
//#endif 

} 

//#endif 


//#if 1580567575 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

