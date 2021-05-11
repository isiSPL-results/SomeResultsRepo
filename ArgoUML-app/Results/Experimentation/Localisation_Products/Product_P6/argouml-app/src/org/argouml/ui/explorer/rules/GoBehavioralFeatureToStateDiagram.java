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
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
public class GoBehavioralFeatureToStateDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize(
                   "misc.behavioral-feature.statechart-diagram");
} 
public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isABehavioralFeature(parent))//1
{ 
Collection col = Model.getFacade().getBehaviors(parent);
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
Project p = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 
if(diagram instanceof UMLStateDiagram
                        && col.contains(((UMLStateDiagram) diagram)
                                        .getStateMachine()))//1
{ 
ret.add(diagram);
} 
} 
return ret;
} 
return Collections.EMPTY_SET;
} 

 } 
