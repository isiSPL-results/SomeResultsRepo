package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoStateMachineToTop extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
List list = new ArrayList();
list.add(Model.getFacade().getTop(parent));
return list;
} 
return Collections.EMPTY_SET;
} 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.state-machine.top-state");
} 

 } 
