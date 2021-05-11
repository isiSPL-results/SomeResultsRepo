
//#if -175108759 
// Compilation Unit of /GoBehavioralFeatureToStateDiagram.java 
 

//#if -1104877096 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1688015892 
import java.util.Collection;
//#endif 


//#if 788886895 
import java.util.Collections;
//#endif 


//#if -1772473616 
import java.util.HashSet;
//#endif 


//#if 946991426 
import java.util.Set;
//#endif 


//#if 1575234839 
import org.argouml.i18n.Translator;
//#endif 


//#if -1078558067 
import org.argouml.kernel.Project;
//#endif 


//#if -240719940 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1774380195 
import org.argouml.model.Model;
//#endif 


//#if -488629860 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1079976825 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if 1932315459 
public class GoBehavioralFeatureToStateDiagram extends 
//#if 2019133326 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1294577692 
public String getRuleName()
    { 

//#if 756830928 
return Translator.localize(
                   "misc.behavioral-feature.statechart-diagram");
//#endif 

} 

//#endif 


//#if -1405687738 
public Set getDependencies(Object parent)
    { 

//#if -1953689018 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1083074270 
public Collection getChildren(Object parent)
    { 

//#if 1224683156 
if(Model.getFacade().isABehavioralFeature(parent))//1
{ 

//#if -1874083679 
Collection col = Model.getFacade().getBehaviors(parent);
//#endif 


//#if 1571551331 
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
//#endif 


//#if 5448779 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -975796759 
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 

//#if -945952028 
if(diagram instanceof UMLStateDiagram
                        && col.contains(((UMLStateDiagram) diagram)
                                        .getStateMachine()))//1
{ 

//#if -1021874578 
ret.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -37832315 
return ret;
//#endif 

} 

//#endif 


//#if 2002031022 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

