// Compilation Unit of /GoProjectToCollaboration.java 
 

//#if COLLABORATION 
package org.argouml.ui.explorer.rules;
//#endif 


//#if COLLABORATION 
import java.util.ArrayList;
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
import org.argouml.kernel.Project;
//#endif 


//#if COLLABORATION 
import org.argouml.model.Model;
//#endif 


//#if COLLABORATION 
public class GoProjectToCollaboration extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
Collection col = new ArrayList();
if(parent instanceof Project)//1
{ 
for (Object model : ((Project) parent).getUserDefinedModelList()) //1
{ 
col.addAll(Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                                      Model.getMetaTypes().getCollaboration()));
} 

} 

return col;
} 

public String getRuleName()
    { 
return Translator.localize("misc.project.collaboration");
} 

public Set getDependencies(Object parent)
    { 
if(parent instanceof Project)//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

 } 

//#endif 


