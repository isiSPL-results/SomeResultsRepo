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
import org.argouml.uml.diagram.collaboration.ui.UMLCollaborationDiagram;
public class GoCollaborationToDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.collaboration.diagram");
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(!Model.getFacade().isACollaboration(parent))//1
{ 
return Collections.EMPTY_SET;
} 
Project p = ProjectManager.getManager().getCurrentProject();
if(p == null)//1
{ 
return Collections.EMPTY_SET;
} 
Set<ArgoDiagram> res = new HashSet<ArgoDiagram>();
for (ArgoDiagram d : p.getDiagramList()) //1
{ 
if(d instanceof UMLCollaborationDiagram
                    && ((UMLCollaborationDiagram) d).getNamespace() == parent)//1
{ 
res.add(d);
} 
} 
return res;
} 

 } 
