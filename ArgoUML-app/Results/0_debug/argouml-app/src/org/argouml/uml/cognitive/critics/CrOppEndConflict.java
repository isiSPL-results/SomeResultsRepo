
//#if -1846682826 
// Compilation Unit of /CrOppEndConflict.java 
 

//#if 1438552427 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -882818101 
import java.util.ArrayList;
//#endif 


//#if -257959178 
import java.util.Collection;
//#endif 


//#if -597842098 
import java.util.HashSet;
//#endif 


//#if 647449958 
import java.util.Iterator;
//#endif 


//#if 826113974 
import java.util.List;
//#endif 


//#if 1135232160 
import java.util.Set;
//#endif 


//#if 22903695 
import org.argouml.cognitive.Critic;
//#endif 


//#if 1810135544 
import org.argouml.cognitive.Designer;
//#endif 


//#if -849129157 
import org.argouml.model.Model;
//#endif 


//#if 1880225149 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if 983135898 
public class CrOppEndConflict extends 
//#if -1074027347 
CrUML
//#endif 

  { 

//#if -848586298 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 2120832368 
boolean problem = NO_PROBLEM;
//#endif 


//#if 421518119 
if(Model.getFacade().isAClassifier(dm))//1
{ 

//#if 1633105673 
Collection col = Model.getCoreHelper().getAssociations(dm);
//#endif 


//#if -1121960468 
List names = new ArrayList();
//#endif 


//#if 1616438078 
Iterator it = col.iterator();
//#endif 


//#if -180040745 
String name = null;
//#endif 


//#if -472985426 
while (it.hasNext()) //1
{ 

//#if 101501668 
name = Model.getFacade().getName(it.next());
//#endif 


//#if -1939114524 
if(name == null || name.equals(""))//1
{ 

//#if -27269447 
continue;
//#endif 

} 

//#endif 


//#if 1272957240 
if(names.contains(name))//1
{ 

//#if -628527882 
problem = PROBLEM_FOUND;
//#endif 


//#if 1057011259 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2050493144 
return problem;
//#endif 

} 

//#endif 


//#if 465053199 
public CrOppEndConflict()
    { 

//#if -611668249 
setupHeadAndDesc();
//#endif 


//#if 1802304391 
addSupportedDecision(UMLDecision.INHERITANCE);
//#endif 


//#if -1283408648 
addSupportedDecision(UMLDecision.RELATIONSHIPS);
//#endif 


//#if -870326097 
addSupportedDecision(UMLDecision.NAMING);
//#endif 


//#if -1825376572 
setKnowledgeTypes(Critic.KT_SYNTAX);
//#endif 


//#if 569078465 
addTrigger("associationEnd");
//#endif 

} 

//#endif 


//#if 1919307225 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -642802675 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -1429849832 
ret.add(Model.getMetaTypes().getAssociationEnd());
//#endif 


//#if -129342891 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

