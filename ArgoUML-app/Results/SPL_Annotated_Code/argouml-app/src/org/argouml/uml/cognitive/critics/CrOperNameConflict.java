// Compilation Unit of /CrOperNameConflict.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Icon;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
public class CrOperNameConflict extends CrUML
  { 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
if(!(Model.getFacade().isAClassifier(dm)))//1
{ 
return NO_PROBLEM;
} 

Collection operSeen = new ArrayList();
for (Object op : Model.getFacade().getOperations(dm)) //1
{ 
for (Object o : operSeen) //1
{ 
if(signaturesMatch(op, o))//1
{ 
return PROBLEM_FOUND;
} 

} 

operSeen.add(op);
} 

return NO_PROBLEM;
} 

public CrOperNameConflict()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.METHODS);
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("behavioralFeature");
addTrigger("feature_name");
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getClassifier());
return ret;
} 

private boolean signaturesMatch(Object op1, Object op2)
    { 
String name1 = Model.getFacade().getName(op1);
if(name1 == null)//1
{ 
return false;
} 

String name2 = Model.getFacade().getName(op2);
if(name2 == null)//1
{ 
return false;
} 

if(!name1.equals(name2))//1
{ 
return false;
} 

Iterator params1 = Model.getFacade().getParameters(op1).iterator();
Iterator params2 = Model.getFacade().getParameters(op2).iterator();
while (params1.hasNext()
                && params2.hasNext()) //1
{ 
Object p1 = null;
while (p1 == null && params1.hasNext()) //1
{ 
p1 = params1.next();
if(Model.getFacade().isReturn(p1))//1
{ 
p1 = null;
} 

} 

Object p2 = null;
while (p2 == null && params1.hasNext()) //1
{ 
p2 = params1.next();
if(Model.getFacade().isReturn(p2))//1
{ 
p2 = null;
} 

} 

if(p1 == null && p2 == null)//1
{ 
return true;
} 

if(p1 == null || p2 == null)//1
{ 
return false;
} 

Object p1type = Model.getFacade().getType(p1);
if(p1type == null)//1
{ 
continue;
} 

Object p2type = Model.getFacade().getType(p2);
if(p2type == null)//1
{ 
continue;
} 

if(!p1type.equals(p2type))//1
{ 
return false;
} 

} 

if(!params1.hasNext() && !params2.hasNext())//1
{ 
return true;
} 

return false;
} 

@Override
    public Icon getClarifier()
    { 
return ClOperationCompartment.getTheInstance();
} 

 } 


