// Compilation Unit of /GoBehavioralFeatureToStateMachine.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
public class GoBehavioralFeatureToStateMachine extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.behavioral-feature.statemachine");
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isABehavioralFeature(parent))//1
{ 
return Model.getFacade().getBehaviors(parent);
} 

return Collections.EMPTY_SET;
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isABehavioralFeature(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

 } 


