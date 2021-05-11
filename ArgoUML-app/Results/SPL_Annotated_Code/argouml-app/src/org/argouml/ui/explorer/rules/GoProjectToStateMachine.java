// Compilation Unit of /GoProjectToStateMachine.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.ArrayList;
//#endif 


//#if STATE 
import java.util.Collection;
//#endif 


//#if STATE 
import java.util.Collections;
//#endif 


//#if STATE 
import java.util.Set;
//#endif 


//#if STATE 
import org.argouml.i18n.Translator;
//#endif 


//#if STATE 
import org.argouml.kernel.Project;
//#endif 


//#if STATE 
import org.argouml.model.Model;
//#endif 


//#if STATE 
public class GoProjectToStateMachine extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.project.state-machine");
} 

public Collection getChildren(Object parent)
    { 
Collection col = new ArrayList();
if(parent instanceof Project)//1
{ 
for (Object model : ((Project) parent).getUserDefinedModelList()) //1
{ 
col.addAll(Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                                      Model.getMetaTypes().getStateMachine()));
} 

} 

return col;
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

 } 

//#endif 


