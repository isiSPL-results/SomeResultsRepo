package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrDupRoleNames extends CrUML
  { 
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
if(Model.getFacade().isAAssociationRole(dm))//1
{ 
return NO_PROBLEM;
} 
Collection<String>   namesSeen = new ArrayList<String>();
Iterator conns = Model.getFacade().getConnections(dm).iterator();
while (conns.hasNext()) //1
{ 
String name = Model.getFacade().getName(conns.next());
if((name == null) || name.equals(""))//1
{ 
continue;
} 
if(namesSeen.contains(name))//1
{ 
return PROBLEM_FOUND;
} 
namesSeen.add(name);
} 
return NO_PROBLEM;
} 
public CrDupRoleNames()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
addTrigger("connection");
addTrigger("end_name");
} 

 } 
