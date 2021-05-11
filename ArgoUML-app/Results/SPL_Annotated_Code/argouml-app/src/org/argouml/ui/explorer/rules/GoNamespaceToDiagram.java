// Compilation Unit of /GoNamespaceToDiagram.java 
 
package org.argouml.ui.explorer.rules;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
public class GoNamespaceToDiagram extends AbstractPerspectiveRule
  { 
public String getRuleName()
    { 
return Translator.localize("misc.package.diagram");
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

public Collection getChildren(Object namespace)
    { 
if(Model.getFacade().isANamespace(namespace))//1
{ 
List returnList = new ArrayList();
Project proj = ProjectManager.getManager().getCurrentProject();
for (ArgoDiagram diagram : proj.getDiagramList()) //1
{ 
if(diagram instanceof UMLStateDiagram




                        || diagram instanceof UMLActivityDiagram





                        || diagram instanceof UMLSequenceDiagram)//1
{ 
continue;
} 

if(diagram.getNamespace() == namespace)//1
{ 
returnList.add(diagram);
} 

} 

return returnList;
} 

return Collections.EMPTY_SET;
} 

 } 


