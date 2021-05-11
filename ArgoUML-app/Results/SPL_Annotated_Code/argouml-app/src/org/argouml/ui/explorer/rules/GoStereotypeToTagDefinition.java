// Compilation Unit of /GoStereotypeToTagDefinition.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.argouml.model.Model;
public class GoStereotypeToTagDefinition extends AbstractPerspectiveRule
  { 
public GoStereotypeToTagDefinition()
    { 
super();
} 

@Override
    public String getRuleName()
    { 
return "Stereotype->TagDefinition";
} 

@Override
    public String toString()
    { 
return super.toString();
} 

@Override
    public Collection getChildren(final Object parent)
    { 
if(Model.getFacade().isAStereotype(parent))//1
{ 
final List list = new ArrayList();
if(Model.getFacade().getTagDefinitions(parent) != null
                    && Model.getFacade().getTagDefinitions(parent).size() > 0)//1
{ 
list.addAll(Model.getFacade().getTagDefinitions(parent));
} 

return list;
} 

return Collections.EMPTY_SET;
} 

public Set getDependencies(final Object parent)
    { 
if(Model.getFacade().isAStereotype(parent))//1
{ 
final Set set = new HashSet();
set.add(parent);
set.addAll(Model.getFacade().getTagDefinitions(parent));
return set;
} 

return Collections.EMPTY_SET;
} 

 } 


