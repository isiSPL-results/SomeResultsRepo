// Compilation Unit of /GoSummaryToInheritance.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoSummaryToInheritance extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.summary.inheritance");
} 

public Collection getChildren(Object parent)
    { 
if(parent instanceof InheritanceNode)//1
{ 
List list = new ArrayList();
Iterator it =
                Model.getFacade().getSupplierDependencies(
                    ((InheritanceNode) parent).getParent()).iterator();
while (it.hasNext()) //1
{ 
Object next = it.next();
if(Model.getFacade().isAAbstraction(next))//1
{ 
list.add(next);
} 

} 

it =
                Model.getFacade().getClientDependencies(
                    ((InheritanceNode) parent).getParent()).iterator();
while (it.hasNext()) //2
{ 
Object next = it.next();
if(Model.getFacade().isAAbstraction(next))//1
{ 
list.add(next);
} 

} 

Iterator generalizationsIt =
                Model.getFacade().getGeneralizations(
                    ((InheritanceNode) parent).getParent()).iterator();
Iterator specializationsIt =
                Model.getFacade().getSpecializations(
                    ((InheritanceNode) parent).getParent()).iterator();
while (generalizationsIt.hasNext()) //1
{ 
list.add(generalizationsIt.next());
} 

while (specializationsIt.hasNext()) //1
{ 
list.add(specializationsIt.next());
} 

return list;
} 

return Collections.EMPTY_SET;
} 

public Set getDependencies(Object parent)
    { 
if(parent instanceof InheritanceNode)//1
{ 
Set set = new HashSet();
set.add(((InheritanceNode) parent).getParent());
return set;
} 

return Collections.EMPTY_SET;
} 

 } 


