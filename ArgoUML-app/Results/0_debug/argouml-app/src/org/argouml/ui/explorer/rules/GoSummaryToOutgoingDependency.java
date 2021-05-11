
//#if 1224699768 
// Compilation Unit of /GoSummaryToOutgoingDependency.java 
 

//#if 916023318 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1642763409 
import java.util.ArrayList;
//#endif 


//#if 1953540050 
import java.util.Collection;
//#endif 


//#if 430201201 
import java.util.Collections;
//#endif 


//#if 813656050 
import java.util.HashSet;
//#endif 


//#if 1454219586 
import java.util.Iterator;
//#endif 


//#if -1678903484 
import java.util.Set;
//#endif 


//#if -795572327 
import org.argouml.i18n.Translator;
//#endif 


//#if 1421018847 
import org.argouml.model.Model;
//#endif 


//#if 890004871 
public class GoSummaryToOutgoingDependency extends 
//#if -543076439 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1379367221 
public Set getDependencies(Object parent)
    { 

//#if -2049218848 
if(parent instanceof OutgoingDependencyNode)//1
{ 

//#if -1452280206 
Set set = new HashSet();
//#endif 


//#if 1646286256 
set.add(((OutgoingDependencyNode) parent).getParent());
//#endif 


//#if 1785971474 
return set;
//#endif 

} 

//#endif 


//#if 1153758998 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 27254135 
public String getRuleName()
    { 

//#if -1673919993 
return Translator.localize("misc.summary.outgoing-dependency");
//#endif 

} 

//#endif 


//#if -781418951 
public Collection getChildren(Object parent)
    { 

//#if -604547464 
if(parent instanceof OutgoingDependencyNode)//1
{ 

//#if 151357119 
Collection list = new ArrayList();
//#endif 


//#if 1072494782 
Iterator it =
                Model.getFacade().getClientDependencies(
                    ((OutgoingDependencyNode) parent).getParent())
                .iterator();
//#endif 


//#if 734492839 
while (it.hasNext()) //1
{ 

//#if 1208469434 
Object next = it.next();
//#endif 


//#if 935767090 
if(!Model.getFacade().isAAbstraction(next))//1
{ 

//#if 353191313 
list.add(next);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -646070736 
return list;
//#endif 

} 

//#endif 


//#if -875002754 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

