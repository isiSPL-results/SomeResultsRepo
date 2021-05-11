
//#if -2068141622 
// Compilation Unit of /CrNameConflict.java 
 

//#if 257267320 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1209764071 
import java.util.HashMap;
//#endif 


//#if 1209946785 
import java.util.HashSet;
//#endif 


//#if 1901302131 
import java.util.Set;
//#endif 


//#if -441676196 
import org.argouml.cognitive.Critic;
//#endif 


//#if 2025459077 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1413595038 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 505473431 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1499263566 
import org.argouml.model.Model;
//#endif 


//#if -1117341360 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -1333112781 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -772751226 
public class CrNameConflict extends 
//#if 25037949 
CrUML
//#endif 

  { 

//#if 1689136175 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if 2023724696 
if(!isActive())//1
{ 

//#if -7112901 
return false;
//#endif 

} 

//#endif 


//#if 2076820787 
ListSet offs = i.getOffenders();
//#endif 


//#if 368553445 
Object f = offs.get(0);
//#endif 


//#if -642277017 
Object ns = Model.getFacade().getNamespace(f);
//#endif 


//#if -523324128 
if(!predicate(ns, dsgr))//1
{ 

//#if 1190634885 
return false;
//#endif 

} 

//#endif 


//#if 534561736 
ListSet newOffs = computeOffenders(ns);
//#endif 


//#if 86254971 
boolean res = offs.equals(newOffs);
//#endif 


//#if 654079284 
return res;
//#endif 

} 

//#endif 


//#if 1243738537 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 1737697441 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if 862625103 
ret.add(Model.getMetaTypes().getNamespace());
//#endif 


//#if 476741609 
return ret;
//#endif 

} 

//#endif 


//#if 420566110 
public CrNameConflict()
    { 

//#if -1430089253 
setupHeadAndDesc();
//#endif 


//#if -928492381 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 1569118800 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if -652861724 
addTrigger("name");
//#endif 


//#if -1469169765 
addTrigger("feature_name");
//#endif 

} 

//#endif 


//#if 1135477161 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1986814137 
ListSet offs = computeOffenders(dm);
//#endif 


//#if -1952512001 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 962248858 
protected ListSet computeOffenders(Object dm)
    { 

//#if -79662013 
ListSet offenderResult = new ListSet();
//#endif 


//#if 456051969 
if(Model.getFacade().isANamespace(dm))//1
{ 

//#if 2032242685 
HashMap<String, Object> names = new HashMap<String, Object>();
//#endif 


//#if 367312137 
for (Object name1Object :  Model.getFacade().getOwnedElements(dm)) //1
{ 

//#if 192491251 
if(Model.getFacade().isAGeneralization(name1Object))//1
{ 

//#if 1722794502 
continue;
//#endif 

} 

//#endif 


//#if -2081204888 
String name = Model.getFacade().getName(name1Object);
//#endif 


//#if -426397014 
if(name == null)//1
{ 

//#if 1659908939 
continue;
//#endif 

} 

//#endif 


//#if 1747362459 
if("".equals(name))//1
{ 

//#if -520652549 
continue;
//#endif 

} 

//#endif 


//#if -955850936 
if(names.containsKey(name))//1
{ 

//#if 1761429119 
Object offender = names.get(name);
//#endif 


//#if 1271579414 
if(!offenderResult.contains(offender))//1
{ 

//#if -425475367 
offenderResult.add(offender);
//#endif 

} 

//#endif 


//#if -1402248301 
offenderResult.add(name1Object);
//#endif 

} 

//#endif 


//#if -112901072 
names.put(name, name1Object);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -565268795 
return offenderResult;
//#endif 

} 

//#endif 


//#if -1071704174 
@Override
    public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1079452503 
return computeOffenders(dm).size() > 1;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

