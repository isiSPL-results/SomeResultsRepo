package org.argouml.uml.cognitive.critics;
import java.util.Collection;
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
public class CrAssocNameConflict extends CrUML
  { 
public Collection getAllTypes(Object assoc)
    { 
Set list = new HashSet();
if(assoc == null)//1
{ 
return list;
} 
Collection assocEnds = Model.getFacade().getConnections(assoc);
if(assocEnds == null)//1
{ 
return list;
} 
for (Object element : assocEnds) //1
{ 
if(Model.getFacade().isAAssociationEnd(element))//1
{ 
Object type = Model.getFacade().getType(element);
list.add(type);
} 
} 
return list;
} 
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
for (Object name1Object : Model.getFacade().getOwnedElements(dm)) //1
{ 
if(!Model.getFacade().isAAssociation(name1Object))//1
{ 
continue;
} 
String name = Model.getFacade().getName(name1Object);
Collection typ1 = getAllTypes(name1Object);
if(name == null || "".equals(name))//1
{ 
continue;
} 
if(names.containsKey(name))//1
{ 
Object offender = names.get(name);
Collection typ2 = getAllTypes(offender);
if(typ1.containsAll(typ2) && typ2.containsAll(typ1))//1
{ 
if(!offenderResult.contains(offender))//1
{ 
offenderResult.add(offender);
} 
offenderResult.add(name1Object);
} 
} 
names.put(name, name1Object);
} 
} 
return offenderResult;
} 
public Set<Object> getCriticizedDesignMaterials()
    { 
Set<Object> ret = new HashSet<Object>();
ret.add(Model.getMetaTypes().getNamespace());
return ret;
} 
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
public boolean predicate2(Object dm, Designer dsgr)
    { 
return computeOffenders(dm).size() > 1;
} 
public CrAssocNameConflict()
    { 
setupHeadAndDesc();
addSupportedDecision(UMLDecision.NAMING);
setKnowledgeTypes(Critic.KT_SYNTAX);
} 

 } 
