package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
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
