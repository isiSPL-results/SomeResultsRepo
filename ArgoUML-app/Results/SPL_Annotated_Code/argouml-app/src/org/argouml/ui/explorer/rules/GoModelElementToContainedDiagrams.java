// Compilation Unit of /GoModelElementToContainedDiagrams.java 
 
package org.argouml.ui.explorer.rules;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
public class GoModelElementToContainedDiagrams extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.model-element.contained-diagrams");
} 

public Set getDependencies(Object parent)
    { 
Set set = new HashSet();
if(Model.getFacade().isAModelElement(parent))//1
{ 
set.add(parent);
} 

return set;
} 

public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAModelElement(parent))//1
{ 
Project p = ProjectManager.getManager().getCurrentProject();
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 
if(diagram.getNamespace() == parent)//1
{ 
ret.add(diagram);
} 

} 

return ret;
} 

return Collections.EMPTY_SET;
} 

 } 


