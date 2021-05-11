// Compilation Unit of /CrOppEndVsAttr.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrOppEndVsAttr extends CrUML
  { 
private static final long serialVersionUID = 5784567698177480475L;
public CrOppEndVsAttr()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.INHERITANCE);
addSupportedDecision(UMLDecision.RELATIONSHIPS);
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("associationEnd");
addTrigger("structuralFeature");
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getClassifier());
return ret;
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 

Object cls = /*(MClassifier)*/ dm;
Collection<String> namesSeen = new ArrayList<String>();
Collection str = Model.getFacade().getFeatures(cls);
Iterator features = str.iterator();
while (features.hasNext()) //1
{ 
Object o = features.next();
if(!(Model.getFacade().isAStructuralFeature(o)))//1
{ 
continue;
} 

Object sf = /*(MStructuralFeature)*/ o;
String sfName = Model.getFacade().getName(sf);
if("".equals(sfName))//1
{ 
continue;
} 

String nameStr = sfName;
if(nameStr.length() == 0)//1
{ 
continue;
} 

namesSeen.add(nameStr);
} 

Collection assocEnds = Model.getFacade().getAssociationEnds(cls);
Iterator myEnds = assocEnds.iterator();
while (myEnds.hasNext()) //1
{ 
Object myAe = /*(MAssociationEnd)*/ myEnds.next();
Object asc =
                /*(MAssociation)*/
                Model.getFacade().getAssociation(myAe);
Collection conn = Model.getFacade().getConnections(asc);
if(Model.getFacade().isAAssociationRole(asc))//1
{ 
conn = Model.getFacade().getConnections(asc);
} 

if(conn == null)//1
{ 
continue;
} 

Iterator ascEnds = conn.iterator();
while (ascEnds.hasNext()) //1
{ 
Object ae = /*(MAssociationEnd)*/ ascEnds.next();
if(Model.getFacade().getType(ae) == cls)//1
{ 
continue;
} 

String aeName = Model.getFacade().getName(ae);
if("".equals(aeName))//1
{ 
continue;
} 

String aeNameStr = aeName;
if(aeNameStr == null || aeNameStr.length() == 0)//1
{ 
continue;
} 

if(namesSeen.contains(aeNameStr))//1
{ 
return PROBLEM_FOUND;
} 

} 

} 

return NO_PROBLEM;
} 

 } 


