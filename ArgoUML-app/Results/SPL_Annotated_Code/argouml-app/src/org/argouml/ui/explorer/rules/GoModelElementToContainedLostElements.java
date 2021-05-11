// Compilation Unit of /GoModelElementToContainedLostElements.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoModelElementToContainedLostElements extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
Set set = new HashSet();
if(Model.getFacade().isANamespace(parent))//1
{ 
set.add(parent);
} 

return set;
} 

public String getRuleName()
    { 
return Translator.localize(
                   "misc.model-element.contained-lost-elements");
} 

public Collection getChildren(Object parent)
    { 
Collection ret = new ArrayList();
if(Model.getFacade().isANamespace(parent))//1
{ 
Collection col =
                Model.getModelManagementHelper().getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getStateMachine());
Iterator it = col.iterator();
while (it.hasNext()) //1
{ 
Object machine = it.next();
if(Model.getFacade().getNamespace(machine) == parent)//1
{ 
Object context = Model.getFacade().getContext(machine);
if(context == null)//1
{ 
ret.add(machine);
} 

} 

} 

} 

return ret;
} 

 } 


