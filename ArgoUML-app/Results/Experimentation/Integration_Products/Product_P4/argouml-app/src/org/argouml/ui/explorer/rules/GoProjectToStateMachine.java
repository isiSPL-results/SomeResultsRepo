package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
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
