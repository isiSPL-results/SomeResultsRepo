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
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
public class GoOperationToSequenceDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.operation.sequence-diagram");
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAOperation(parent))//1
{ 
Collection col = Model.getFacade().getCollaborations(parent);
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
Project p = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 
if(diagram instanceof UMLSequenceDiagram
                        && col.contains(
                            (
                                (SequenceDiagramGraphModel)
                                ((UMLSequenceDiagram) diagram)
                                .getGraphModel())
                            .getCollaboration()))//1
{ 
ret.add(diagram);
} 
} 
return ret;
} 
return Collections.EMPTY_SET;
} 

 } 
