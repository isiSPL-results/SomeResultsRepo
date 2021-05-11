
//#if -978517967 
// Compilation Unit of /CrAssocNameConflict.java 
 

//#if 2031538177 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1906554892 
import java.util.Collection;
//#endif 


//#if 1796999230 
import java.util.HashMap;
//#endif 


//#if 1797181944 
import java.util.HashSet;
//#endif 


//#if -1070640054 
import java.util.Set;
//#endif 


//#if -1592401243 
import org.argouml.cognitive.Critic;
//#endif 


//#if -14716018 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1568634169 
import org.argouml.cognitive.ListSet;
//#endif 


//#if -1534701664 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1845515365 
import org.argouml.model.Model;
//#endif 


//#if -1976752345 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 2102443530 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 523585248 
public class CrAssocNameConflict extends 
//#if 1118708299 
CrUML
//#endif 

  { 

//#if 577324942 
public Collection getAllTypes(Object assoc)
    { 

//#if 593180511 
Set list = new HashSet();
//#endif 


//#if -336542141 
if(assoc == null)//1
{ 

//#if 669999203 
return list;
//#endif 

} 

//#endif 


//#if 256978488 
Collection assocEnds = Model.getFacade().getConnections(assoc);
//#endif 


//#if 1830430043 
if(assocEnds == null)//1
{ 

//#if -1110501002 
return list;
//#endif 

} 

//#endif 


//#if 1626140367 
for (Object element : assocEnds) //1
{ 

//#if 1551613528 
if(Model.getFacade().isAAssociationEnd(element))//1
{ 

//#if -1033756456 
Object type = Model.getFacade().getType(element);
//#endif 


//#if 1498226299 
list.add(type);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1009597475 
return list;
//#endif 

} 

//#endif 


//#if -151359341 
public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if 1738143490 
ListSet offs = computeOffenders(dm);
//#endif 


//#if 1679184328 
return new UMLToDoItem(this, offs, dsgr);
//#endif 

} 

//#endif 


//#if 226349964 
protected ListSet computeOffenders(Object dm)
    { 

//#if -1539671373 
ListSet offenderResult = new ListSet();
//#endif 


//#if 717635441 
if(Model.getFacade().isANamespace(dm))//1
{ 

//#if 202806652 
HashMap<String, Object> names = new HashMap<String, Object>();
//#endif 


//#if -940059768 
for (Object name1Object : Model.getFacade().getOwnedElements(dm)) //1
{ 

//#if -1774026238 
if(!Model.getFacade().isAAssociation(name1Object))//1
{ 

//#if -1213770586 
continue;
//#endif 

} 

//#endif 


//#if -1339673763 
String name = Model.getFacade().getName(name1Object);
//#endif 


//#if 1660071540 
Collection typ1 = getAllTypes(name1Object);
//#endif 


//#if -1391711522 
if(name == null || "".equals(name))//1
{ 

//#if -917553611 
continue;
//#endif 

} 

//#endif 


//#if -1647670851 
if(names.containsKey(name))//1
{ 

//#if 244057826 
Object offender = names.get(name);
//#endif 


//#if 1314493349 
Collection typ2 = getAllTypes(offender);
//#endif 


//#if 1992281349 
if(typ1.containsAll(typ2) && typ2.containsAll(typ1))//1
{ 

//#if 742246174 
if(!offenderResult.contains(offender))//1
{ 

//#if -1511315279 
offenderResult.add(offender);
//#endif 

} 

//#endif 


//#if 2007643787 
offenderResult.add(name1Object);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2106914843 
names.put(name, name1Object);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 233027893 
return offenderResult;
//#endif 

} 

//#endif 


//#if -401676809 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 2034146948 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -911668 
ret.add(Model.getMetaTypes().getNamespace());
//#endif 


//#if -207615092 
return ret;
//#endif 

} 

//#endif 


//#if 510930849 
@Override
    public boolean stillValid(ToDoItem i, Designer dsgr)
    { 

//#if -662406822 
if(!isActive())//1
{ 

//#if -1489332597 
return false;
//#endif 

} 

//#endif 


//#if -1375537871 
ListSet offs = i.getOffenders();
//#endif 


//#if 271509543 
Object f = offs.get(0);
//#endif 


//#if -1536819995 
Object ns = Model.getFacade().getNamespace(f);
//#endif 


//#if -494029342 
if(!predicate(ns, dsgr))//1
{ 

//#if -977201727 
return false;
//#endif 

} 

//#endif 


//#if 338377226 
ListSet newOffs = computeOffenders(ns);
//#endif 


//#if -1843655491 
boolean res = offs.equals(newOffs);
//#endif 


//#if -1844889098 
return res;
//#endif 

} 

//#endif 


//#if 1986037224 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -393990708 
return computeOffenders(dm).size() > 1;
//#endif 

} 

//#endif 


//#if -1512208159 
public CrAssocNameConflict()
    { 

//#if 694192278 
setupHeadAndDesc();
//#endif 


//#if -1627079394 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if 308531445 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

