
//#if 1791722566 
// Compilation Unit of /CrMergeClasses.java 
 

//#if -1700137807 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -25133755 
import java.util.ArrayList;
//#endif 


//#if 560451772 
import java.util.Collection;
//#endif 


//#if -284100792 
import java.util.HashSet;
//#endif 


//#if -1114979844 
import java.util.List;
//#endif 


//#if 656974234 
import java.util.Set;
//#endif 


//#if -1746898882 
import org.argouml.cognitive.Designer;
//#endif 


//#if 1028082768 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -2097857099 
import org.argouml.model.Model;
//#endif 


//#if -1402502025 
import org.argouml.uml.cognitive.UMLDecision;
//#endif 


//#if -204153328 
public class CrMergeClasses extends 
//#if 946783538 
CrUML
//#endif 

  { 

//#if -202377186 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -900750220 
Set<Object> ret = new HashSet<Object>();
//#endif 


//#if -37556695 
ret.add(Model.getMetaTypes().getUMLClass());
//#endif 


//#if -1355506308 
return ret;
//#endif 

} 

//#endif 


//#if -1332669727 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if -500547639 
if(!(Model.getFacade().isAClass(dm)))//1
{ 

//#if 2034598258 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -78152837 
Object cls = dm;
//#endif 


//#if -153154309 
Collection ends = Model.getFacade().getAssociationEnds(cls);
//#endif 


//#if -528829142 
if(ends == null || ends.size() != 1)//1
{ 

//#if -595661808 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1443168716 
Object myEnd = ends.iterator().next();
//#endif 


//#if 948925622 
Object asc = Model.getFacade().getAssociation(myEnd);
//#endif 


//#if -146921095 
List conns = new ArrayList(Model.getFacade().getConnections(asc));
//#endif 


//#if -1349294291 
if(conns == null || conns.size() != 2)//1
{ 

//#if 687884888 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 406931380 
Object ae0 = conns.get(0);
//#endif 


//#if 1914484150 
Object ae1 = conns.get(1);
//#endif 


//#if 1300085353 
if(!(Model.getFacade().isAClass(Model.getFacade().getType(ae0))
                && Model.getFacade().isAClass(Model.getFacade().getType(ae1))))//1
{ 

//#if 1911270620 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if 1613137081 
if(!(Model.getFacade().isNavigable(ae0)
                && Model.getFacade().isNavigable(ae1)))//1
{ 

//#if 1343144845 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -1768168842 
if(Model.getFacade().getLower(ae0) == 1
                && Model.getFacade().getUpper(ae0) == 1
                && Model.getFacade().getLower(ae1) == 1
                && Model.getFacade().getUpper(ae1) == 1)//1
{ 

//#if -709168252 
return PROBLEM_FOUND;
//#endif 

} 

//#endif 


//#if -1372169787 
return NO_PROBLEM;
//#endif 

} 

//#endif 


//#if -931620518 
public CrMergeClasses()
    { 

//#if 1459008045 
setupHeadAndDesc();
//#endif 


//#if 260961682 
setPriority(ToDoItem.LOW_PRIORITY);
//#endif 


//#if 749549020 
addSupportedDecision(UMLDecision.CLASS_SELECTION);
//#endif 


//#if -1426549113 
addTrigger("associationEnd");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

