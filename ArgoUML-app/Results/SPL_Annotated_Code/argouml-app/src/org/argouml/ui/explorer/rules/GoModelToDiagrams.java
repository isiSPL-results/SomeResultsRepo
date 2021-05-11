// Compilation Unit of /GoModelToDiagrams.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
public class GoModelToDiagrams extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.model.diagram");
} 

public Set getDependencies(Object parent)
    { 
if(Model.getFacade().isAModel(parent))//1
{ 
Set set = new HashSet();
set.add(parent);
return set;
} 

return Collections.EMPTY_SET;
} 

public Collection getChildren(Object model)
    { 
if(Model.getFacade().isAModel(model))//1
{ 
List returnList = new ArrayList();
Project proj = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : proj.getDiagramList()) //1
{ 
if(isInPath(diagram.getNamespace(), model))//1
{ 
returnList.add(diagram);
} 

} 

return returnList;
} 

return Collections.EMPTY_SET;
} 

private boolean isInPath(Object namespace, Object model)
    { 
if(namespace == model)//1
{ 
return true;
} 

Object ns = Model.getFacade().getNamespace(namespace);
while (ns != null) //1
{ 
if(model == ns)//1
{ 
return true;
} 

ns = Model.getFacade().getNamespace(ns);
} 

return false;
} 

 } 


