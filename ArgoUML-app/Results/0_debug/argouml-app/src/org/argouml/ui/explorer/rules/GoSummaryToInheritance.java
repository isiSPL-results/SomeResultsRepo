
//#if 1035839726 
// Compilation Unit of /GoSummaryToInheritance.java 
 

//#if -659422914 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -396297401 
import java.util.ArrayList;
//#endif 


//#if 1939280634 
import java.util.Collection;
//#endif 


//#if -11840695 
import java.util.Collections;
//#endif 


//#if -878899766 
import java.util.HashSet;
//#endif 


//#if 524596842 
import java.util.Iterator;
//#endif 


//#if 737151674 
import java.util.List;
//#endif 


//#if 716720412 
import java.util.Set;
//#endif 


//#if -207700111 
import org.argouml.i18n.Translator;
//#endif 


//#if 1820519095 
import org.argouml.model.Model;
//#endif 


//#if -398166462 
public class GoSummaryToInheritance extends 
//#if 205889810 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1770686304 
public String getRuleName()
    { 

//#if 1926776709 
return Translator.localize("misc.summary.inheritance");
//#endif 

} 

//#endif 


//#if -522147998 
public Collection getChildren(Object parent)
    { 

//#if 39138356 
if(parent instanceof InheritanceNode)//1
{ 

//#if -281478545 
List list = new ArrayList();
//#endif 


//#if 325258120 
Iterator it =
                Model.getFacade().getSupplierDependencies(
                    ((InheritanceNode) parent).getParent()).iterator();
//#endif 


//#if 1691759767 
while (it.hasNext()) //1
{ 

//#if -1362744075 
Object next = it.next();
//#endif 


//#if -1476433224 
if(Model.getFacade().isAAbstraction(next))//1
{ 

//#if -153756549 
list.add(next);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -963649737 
it =
                Model.getFacade().getClientDependencies(
                    ((InheritanceNode) parent).getParent()).iterator();
//#endif 


//#if 2069043898 
while (it.hasNext()) //2
{ 

//#if -206059729 
Object next = it.next();
//#endif 


//#if 1798600434 
if(Model.getFacade().isAAbstraction(next))//1
{ 

//#if 862229197 
list.add(next);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2001775425 
Iterator generalizationsIt =
                Model.getFacade().getGeneralizations(
                    ((InheritanceNode) parent).getParent()).iterator();
//#endif 


//#if 454891617 
Iterator specializationsIt =
                Model.getFacade().getSpecializations(
                    ((InheritanceNode) parent).getParent()).iterator();
//#endif 


//#if -169399962 
while (generalizationsIt.hasNext()) //1
{ 

//#if -941902947 
list.add(generalizationsIt.next());
//#endif 

} 

//#endif 


//#if -1628357065 
while (specializationsIt.hasNext()) //1
{ 

//#if 717278646 
list.add(specializationsIt.next());
//#endif 

} 

//#endif 


//#if -2008213440 
return list;
//#endif 

} 

//#endif 


//#if -41592043 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -794028478 
public Set getDependencies(Object parent)
    { 

//#if -1714311072 
if(parent instanceof InheritanceNode)//1
{ 

//#if -121869912 
Set set = new HashSet();
//#endif 


//#if 7119797 
set.add(((InheritanceNode) parent).getParent());
//#endif 


//#if -1566137912 
return set;
//#endif 

} 

//#endif 


//#if 1685773889 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

