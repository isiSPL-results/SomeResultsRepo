// Compilation Unit of /GoClassToSummary.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoClassToSummary extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAClass(parent))//1
{ 
ArrayList list = new ArrayList();
if(Model.getFacade().getAttributes(parent).size() > 0)//1
{ 
list.add(new AttributesNode(parent));
} 

if(Model.getFacade().getAssociationEnds(parent).size() > 0)//1
{ 
list.add(new AssociationsNode(parent));
} 

if(Model.getFacade().getOperations(parent).size() > 0)//1
{ 
list.add(new OperationsNode(parent));
} 

if(hasIncomingDependencies(parent))//1
{ 
list.add(new IncomingDependencyNode(parent));
} 

if(hasOutGoingDependencies(parent))//1
{ 
list.add(new OutgoingDependencyNode(parent));
} 

if(hasInheritance(parent))//1
{ 
list.add(new InheritanceNode(parent));
} 

return list;
} 

return Collections.EMPTY_SET;
} 

private boolean hasOutGoingDependencies(Object parent)
    { 
Iterator incomingIt =
            Model.getFacade().getClientDependencies(parent).iterator();
while (incomingIt.hasNext()) //1
{ 
if(!Model.getFacade().isAAbstraction(incomingIt.next()))//1
{ 
return true;
} 

} 

return false;
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAClass(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
set.addAll(Model.getFacade().getAttributes(parent));
set.addAll(Model.getFacade().getOperations(parent));
set.addAll(Model.getFacade().getAssociationEnds(parent));
set.addAll(Model.getFacade().getSupplierDependencies(parent));
set.addAll(Model.getFacade().getClientDependencies(parent));
set.addAll(Model.getFacade().getGeneralizations(parent));
set.addAll(Model.getFacade().getSpecializations(parent));
return set;
} 

return Collections.EMPTY_SET;
} 

private boolean hasIncomingDependencies(Object parent)
    { 
Iterator incomingIt =
            Model.getFacade().getSupplierDependencies(parent).iterator();
while (incomingIt.hasNext()) //1
{ 
if(!Model.getFacade().isAAbstraction(incomingIt.next()))//1
{ 
return true;
} 

} 

return false;
} 

public String getRuleName()
    { 
return Translator.localize("misc.class.summary");
} 

private boolean hasInheritance(Object parent)
    { 
Iterator incomingIt =
            Model.getFacade().getSupplierDependencies(parent).iterator();
Iterator outgoingIt =
            Model.getFacade().getClientDependencies(parent).iterator();
Iterator generalizationsIt =
            Model.getFacade().getGeneralizations(parent).iterator();
Iterator specializationsIt =
            Model.getFacade().getSpecializations(parent).iterator();
if(generalizationsIt.hasNext())//1
{ 
return true;
} 

if(specializationsIt.hasNext())//1
{ 
return true;
} 

while (incomingIt.hasNext()) //1
{ 
if(Model.getFacade().isAAbstraction(incomingIt.next()))//1
{ 
return true;
} 

} 

while (outgoingIt.hasNext()) //1
{ 
if(Model.getFacade().isAAbstraction(outgoingIt.next()))//1
{ 
return true;
} 

} 

return false;
} 

 } 


