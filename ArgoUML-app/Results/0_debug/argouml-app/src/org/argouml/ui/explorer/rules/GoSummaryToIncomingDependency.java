
//#if -1615587966 
// Compilation Unit of /GoSummaryToIncomingDependency.java 
 

//#if 1393649729 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 809228324 
import java.util.ArrayList;
//#endif 


//#if 655872445 
import java.util.Collection;
//#endif 


//#if -1142788890 
import java.util.Collections;
//#endif 


//#if 659783143 
import java.util.HashSet;
//#endif 


//#if 979126765 
import java.util.Iterator;
//#endif 


//#if 1133238205 
import java.util.List;
//#endif 


//#if 868044729 
import java.util.Set;
//#endif 


//#if -1880002738 
import org.argouml.i18n.Translator;
//#endif 


//#if 1606029588 
import org.argouml.model.Model;
//#endif 


//#if 1711773110 
public class GoSummaryToIncomingDependency extends 
//#if 581121331 
AbstractPerspectiveRule
//#endif 

  { 

//#if -54420479 
public Set getDependencies(Object parent)
    { 

//#if -2050766347 
if(parent instanceof IncomingDependencyNode)//1
{ 

//#if 1682222257 
Set set = new HashSet();
//#endif 


//#if 844573673 
set.add(((IncomingDependencyNode) parent).getParent());
//#endif 


//#if 103574545 
return set;
//#endif 

} 

//#endif 


//#if 576684251 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -42478269 
public Collection getChildren(Object parent)
    { 

//#if 854312228 
if(parent instanceof IncomingDependencyNode)//1
{ 

//#if -538118691 
List list = new ArrayList();
//#endif 


//#if -1209863261 
Iterator it =
                Model.getFacade().getSupplierDependencies(
                    ((IncomingDependencyNode) parent)
                    .getParent()).iterator();
//#endif 


//#if 596521861 
while (it.hasNext()) //1
{ 

//#if 869320835 
Object next = it.next();
//#endif 


//#if 1673523081 
if(!Model.getFacade().isAAbstraction(next))//1
{ 

//#if -354350525 
list.add(next);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1461771758 
return list;
//#endif 

} 

//#endif 


//#if -618535476 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1950447487 
public String getRuleName()
    { 

//#if -1667982637 
return Translator.localize("misc.summary.incoming-dependency");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

