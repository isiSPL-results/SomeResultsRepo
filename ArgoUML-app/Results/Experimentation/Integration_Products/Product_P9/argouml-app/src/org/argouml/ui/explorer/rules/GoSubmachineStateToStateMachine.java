package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoSubmachineStateToStateMachine extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isASubmachineState(parent))//1
{ 
List list = new ArrayList();
list.add(Model.getFacade().getSubmachine(parent));
return list;
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.submachine-state.state-machine");
} 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isASubmachineState(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 
return Collections.EMPTY_SET;
} 

 } 
