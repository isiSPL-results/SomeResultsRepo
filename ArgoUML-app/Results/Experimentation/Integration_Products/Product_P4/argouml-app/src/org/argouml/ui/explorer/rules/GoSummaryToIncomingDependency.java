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
public class GoSummaryToIncomingDependency extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(parent instanceof IncomingDependencyNode)//1
{ 
Set set = new HashSet();
set.add(((IncomingDependencyNode) parent).getParent());
return set;
} 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(parent instanceof IncomingDependencyNode)//1
{ 
List list = new ArrayList();
Iterator it =
                Model.getFacade().getSupplierDependencies(
                    ((IncomingDependencyNode) parent)
                    .getParent()).iterator();
while (it.hasNext()) //1
{ 
Object next = it.next();
if(!Model.getFacade().isAAbstraction(next))//1
{ 
list.add(next);
} 
} 
return list;
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.summary.incoming-dependency");
} 

 } 
