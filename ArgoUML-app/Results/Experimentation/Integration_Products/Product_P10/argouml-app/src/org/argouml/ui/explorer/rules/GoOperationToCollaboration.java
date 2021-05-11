package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoOperationToCollaboration extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAOperation(parent))//1
{ 
return Model.getFacade().getCollaborations(parent);
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.operation.collaboration");
} 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAOperation(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
if(Model.getFacade().getOwner(parent) != null)//1
{ 
set.add(Model.getFacade().getOwner(parent));
} 
return set;
} 
return Collections.EMPTY_SET;
} 

 } 
