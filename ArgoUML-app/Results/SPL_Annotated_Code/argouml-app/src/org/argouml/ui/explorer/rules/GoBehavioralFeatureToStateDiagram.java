// Compilation Unit of /GoBehavioralFeatureToStateDiagram.java 
 

//#if STATE 
package org.argouml.ui.explorer.rules;
//#endif 


//#if STATE 
import java.util.Collection;
//#endif 


//#if STATE 
import java.util.Collections;
//#endif 


//#if STATE 
import java.util.HashSet;
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
import org.argouml.kernel.ProjectManager;
//#endif 


//#if STATE 
import org.argouml.model.Model;
//#endif 


//#if STATE 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if STATE 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if STATE 
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

//#endif 


