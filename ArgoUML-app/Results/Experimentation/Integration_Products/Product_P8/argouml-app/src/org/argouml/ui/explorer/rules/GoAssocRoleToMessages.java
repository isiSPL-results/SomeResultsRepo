package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoAssocRoleToMessages extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(!Model.getFacade().isAAssociationRole(parent))//1
{ 
return Collections.EMPTY_SET;
} 
return Model.getFacade().getMessages(parent);
} 
public String getRuleName()
    { 
return Translator.localize("misc.association-role.messages");
} 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAAssociationRole(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 
return Collections.EMPTY_SET;
} 

 } 
