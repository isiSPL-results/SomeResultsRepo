package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoStateToExit extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAState(parent)
                && Model.getFacade().getExit(parent) != null)//1
{ 
Collection children = new ArrayList();
children.add(Model.getFacade().getExit(parent));
return children;
} 
return Collections.EMPTY_SET;
} 
public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAState(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 
return Collections.EMPTY_SET;
} 
public String getRuleName()
    { 
return Translator.localize("misc.state.exit");
} 

 } 
