// Compilation Unit of /CrNameConflict.java 
 
package org.argouml.uml.cognitive.critics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.argouml.cognitive.Critic;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.ToDoItem;
import org.argouml.model.Model;
import org.argouml.uml.cognitive.UMLDecision;
import org.argouml.uml.cognitive.UMLToDoItem;
public class CrNameConflict extends CrUML
  { 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 
if(!isActive())//1
{ 
return false;
} 

ListSet offs = i.getOffenders();
Object f = offs.get(0);
Object ns = Model.getFacade().getNamespace(f);
if(!predicate(ns, dsgr))//1
{ 
return false;
} 

ListSet newOffs = computeOffenders(ns);
boolean res = offs.equals(newOffs);
return res;
} 

public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getNamespace());
return ret;
} 

public CrNameConflict()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
addTrigger("name");
addTrigger("feature_name");
} 

@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 
ListSet offs = computeOffenders(dm);
return new UMLToDoItem(this, offs, dsgr);
} 

protected ListSet computeOffenders(Object dm)
    { 
ListSet offenderResult = new ListSet();
if(Model.getFacade().isANamespace(dm))//1
{ 
HashMap<String, Object> names = new HashMap<String, Object>();
for (Object name1Object :  Model.getFacade().getOwnedElements(dm)) //1
{ 
if(Model.getFacade().isAGeneralization(name1Object))//1
{ 
continue;
} 

String name = Model.getFacade().getName(name1Object);
if(name == null)//1
{ 
continue;
} 

if("".equals(name))//1
{ 
continue;
} 

if(names.containsKey(name))//1
{ 
Object offender = names.get(name);
if(!offenderResult.contains(offender))//1
{ 
offenderResult.add(offender);
} 

offenderResult.add(name1Object);
} 

names.put(name, name1Object);
} 

} 

return offenderResult;
} 

@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 
return computeOffenders(dm).size() > 1;
} 

 } 


