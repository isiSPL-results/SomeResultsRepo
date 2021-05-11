
//#if -1096935383 
// Compilation Unit of /CrDupRoleNames.java 
 

//#if -774421775 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 581465861 
import java.util.ArrayList;
//#endif 


//#if -2109796612 
import java.util.Collection;
//#endif 


//#if -60006136 
import java.util.HashSet;
//#endif 


//#if 140495596 
import java.util.Iterator;
//#endif 


//#if -1606489254 
import java.util.Set;
//#endif 


//#if -1267802498 
import org.argouml.cognitive.Designer;
//#endif 


//#if -83208331 
import org.argouml.model.Model;
//#endif 


//#if -1381200329 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 57170101 
public class CrDupRoleNames extends 
//#if -176906245 
CrUML
//#endif 

  { 

//#if 1399146407 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1962410314 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 1199850482 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if 957635026 
return ret;
//#endif 

} 

//#endif 


//#if -1696649672 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1148001972 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 

//#if 679780352 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1281462636 
if(Model.getFacade().isAAssociationRole(dm))//1
{ 

//#if 737316134 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 629357392 
Collection<String>   namesSeen = new ArrayList<String>();
//#endif 


//#if -1793071756 
Iterator conns = Model.getFacade().getConnections(dm).iterator();
//#endif 


//#if -2054763809 
while (conns.hasNext()) //1
{ 

//#if 95567019 
String name = Model.getFacade().getName(conns.next());
//#endif 


//#if 2057404445 
if((name == null) || name.equals(""))//1
{ 

//#if 967364746 
continue;
//#endif 

} 

//#endif 


//#if -1812326585 
if(namesSeen.contains(name))//1
{ 

//#if 2058936765 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1753721509 
namesSeen.add(name);
//#endif 

} 

//#endif 


//#if -846417039 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1091260202 
public CrDupRoleNames()
    { 

//#if 2032849508 
setupHeadAndDesc();
//#endif 


//#if 1944819820 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1237466310 
addTrigger("connection");
//#endif 


//#if -1777311223 
addTrigger("end_name");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

