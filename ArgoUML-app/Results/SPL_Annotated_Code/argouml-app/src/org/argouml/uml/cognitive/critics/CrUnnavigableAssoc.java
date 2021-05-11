// Compilation Unit of /CrUnnavigableAssoc.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrUnnavigableAssoc extends CrUML
  { 
public CrUnnavigableAssoc()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.RELATIONSHIPS);
addTrigger("end_navigable");
} 

public Class getWizardClass(ToDoItem item)
    { 
return WizNavigable.class;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getAssociationClass());
return ret;
} 

public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAAssociation(dm)))//1
{ 
return NO_PROBLEM;
} 

Object asc = /*(MAssociation)*/ dm;
Collection conn = Model.getFacade().getConnections(asc);
if(Model.getFacade().isAAssociationRole(asc))//1
{ 
conn = Model.getFacade().getConnections(asc);
} 

for (Iterator iter = conn.iterator(); iter.hasNext();) //1
{ 
Object ae = /*(MAssociationEnd)*/ iter.next();
if(Model.getFacade().isNavigable(ae))//1
{ 
return NO_PROBLEM;
} 

} 

return PROBLEM_FOUND;
} 

 } 


