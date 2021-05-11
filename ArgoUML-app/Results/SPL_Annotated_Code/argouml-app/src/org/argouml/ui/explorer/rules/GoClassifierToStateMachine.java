// Compilation Unit of /GoClassifierToStateMachine.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.Collection;
//#endif 


//#if STATE 
import java.util.Collections;
//#endif 


//#if STATE 
import java.util.HashSet;
//#endif 


//#if STATE 
import java.util.Set;
//#endif 


//#if STATE 
import org.argouml.i18n.Translator;
//#endif 


//#if STATE 
import org.argouml.model.Model;
//#endif 


//#if STATE 
public class GoClassifierToStateMachine extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.classifier.statemachine");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAClassifier(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAClassifier(parent))//1
{ 
return Model.getFacade().getBehaviors(parent);
} 

return Collections.EMPTY_SET;
} 

 } 

//#endif 


