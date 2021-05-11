// Compilation Unit of /GoClassifierToCollaboration.java 
 

//#if COLLABORATION 
package org.argouml.ui.explorer.rules;
//#endif 


//#if COLLABORATION 
import java.util.Collection;
//#endif 


//#if COLLABORATION 
import java.util.Collections;
//#endif 


//#if COLLABORATION 
import java.util.HashSet;
//#endif 


//#if COLLABORATION 
import java.util.Set;
//#endif 


//#if COLLABORATION 
import org.argouml.i18n.Translator;
//#endif 


//#if COLLABORATION 
import org.argouml.model.Model;
//#endif 


//#if COLLABORATION 
public class GoClassifierToCollaboration extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAClassifier(parent))//1
{ 
return Model.getFacade().getCollaborations(parent);
} 

return Collections.EMPTY_SET;
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

public String getRuleName()
    { 
return Translator.localize("misc.classifier.collaboration");
} 

 } 

//#endif 


