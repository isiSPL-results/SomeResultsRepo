
//#if 642049487 
// Compilation Unit of /GoClassifierToSequenceDiagram.java 
 

//#if -162407542 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1719067578 
import java.util.Collection;
//#endif 


//#if -1751485571 
import java.util.Collections;
//#endif 


//#if 1548511230 
import java.util.HashSet;
//#endif 


//#if 284482896 
import java.util.Set;
//#endif 


//#if 1524230309 
import org.argouml.i18n.Translator;
//#endif 


//#if 443817279 
import org.argouml.kernel.Project;
//#endif 


//#if 668549322 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 764071403 
import org.argouml.model.Model;
//#endif 


//#if 1440769834 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -139368718 
import org.argouml.uml.diagram.sequence.SequenceDiagramGraphModel;
//#endif 


//#if 1984571399 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if -655030063 
public class GoClassifierToSequenceDiagram extends 
//#if -266330099 
AbstractPerspectiveRule
//#endif 

  { 

//#if -307485477 
public String getRuleName()
    { 

//#if 958569290 
return Translator.localize("misc.classifier.sequence-diagram");
//#endif 

} 

//#endif 


//#if 1925865959 
public Set getDependencies(Object parent)
    { 

//#if 1282329863 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -999981667 
public Collection getChildren(Object parent)
    { 

//#if 1814833047 
if(Model.getFacade().isAClassifier(parent))//1
{ 

//#if -1045744154 
Collection col = Model.getFacade().getCollaborations(parent);
//#endif 


//#if -1865579407 
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
//#endif 


//#if -793173123 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -2056503269 
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 

//#if 1050766672 
if(diagram instanceof UMLSequenceDiagram
                        && col.contains(((SequenceDiagramGraphModel)
                                         ((UMLSequenceDiagram) diagram).getGraphModel())
                                        .getCollaboration()))//1
{ 

//#if 2120008542 
ret.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 26490003 
return ret;
//#endif 

} 

//#endif 


//#if -81558911 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

