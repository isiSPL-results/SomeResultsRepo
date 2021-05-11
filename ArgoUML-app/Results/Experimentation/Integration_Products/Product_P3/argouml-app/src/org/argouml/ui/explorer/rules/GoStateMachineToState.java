package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoStateMachineToState extends AbstractPerspectiveRule
  { 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
if(Model.getFacade().getTop(parent) != null)//1
{ 
set.add(Model.getFacade().getTop(parent));
} 
return set;
} 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAStateMachine(parent))//1
{ 
if(Model.getFacade().getTop(parent) != null)//1
{ 
return Model.getFacade().getSubvertices(
                           Model.getFacade().getTop(parent));
} 
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.state-machine.state");
} 

 } 
