
//#if -114312820 
// Compilation Unit of /CrUnnavigableAssoc.java 
 

//#if -1953052092 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -768109681 
import java.util.Collection;
//#endif 


//#if 1680170325 
import java.util.HashSet;
//#endif 


//#if -1748608961 
import java.util.Iterator;
//#endif 


//#if 1062475303 
import java.util.Set;
//#endif 


//#if -639301807 
import org.argouml.cognitive.Designer;
//#endif 


//#if 2135679843 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1146496514 
import org.argouml.model.Model;
//#endif 


//#if 1695638020 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 1917005736 
public class CrUnnavigableAssoc extends 
//#if 1908087634 
CrUML
//#endif 

  { 

//#if 1265710335 
public CrUnnavigableAssoc()
    { 

//#if -322051857 
setupHeadAndDesc();
//#endif 


//#if -335009808 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if 1550300878 
addTrigger("end_navigable");
//#endif 

} 

//#endif 


//#if 2008984296 
public Class getWizardClass(ToDoItem item)
    { 

//#if 886608672 
return WizNavigable.class;
//#endif 

} 

//#endif 


//#if 1906222654 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -1850152093 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 164092939 
ret.add(Model.getMetaTypes().getAssociationClass());
//#endif 


//#if 1939157291 
return ret;
//#endif 

} 

//#endif 


//#if 1229201601 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -1151224670 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 

//#if 1845167162 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1778798797 
Object asc = /*(MAssociation)*/ dm;
//#endif 


//#if -1441872888 
Collection conn = Model.getFacade().getConnections(asc);
//#endif 


//#if -1257345790 
if(Model.getFacade().isAAssociationRole(asc))//1
{ 

//#if 1812584710 
conn = Model.getFacade().getConnections(asc);
//#endif 

} 

//#endif 


//#if 1203770384 
for (Iterator iter = conn.iterator(); iter.hasNext();) //1
{ 

//#if 1737611270 
Object ae = /*(MAssociationEnd)*/ iter.next();
//#endif 


//#if -86403612 
if(Model.getFacade().isNavigable(ae))//1
{ 

//#if 1872928148 
return NO_PROBLEM;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2055198160 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

