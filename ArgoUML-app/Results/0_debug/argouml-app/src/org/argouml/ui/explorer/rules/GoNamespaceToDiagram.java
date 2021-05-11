
//#if 758180415 
// Compilation Unit of /GoNamespaceToDiagram.java 
 

//#if -1417844717 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1863419794 
import java.util.ArrayList;
//#endif 


//#if -1023930353 
import java.util.Collection;
//#endif 


//#if -1677068076 
import java.util.Collections;
//#endif 


//#if 1657125775 
import java.util.List;
//#endif 


//#if -223434329 
import java.util.Set;
//#endif 


//#if -1492135748 
import org.argouml.i18n.Translator;
//#endif 


//#if 207967816 
import org.argouml.kernel.Project;
//#endif 


//#if 514882465 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -735159934 
import org.argouml.model.Model;
//#endif 


//#if -204191679 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -2024217648 
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
//#endif 


//#if 1114302864 
import org.argouml.uml.diagram.sequence.ui.UMLSequenceDiagram;
//#endif 


//#if 1230660098 
import org.argouml.uml.diagram.state.ui.UMLStateDiagram;
//#endif 


//#if 161801355 
public class GoNamespaceToDiagram extends 
//#if 1697961744 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1886332702 
public String getRuleName()
    { 

//#if -442400021 
return Translator.localize("misc.package.diagram");
//#endif 

} 

//#endif 


//#if -1652136828 
public Set getDependencies(Object parent)
    { 

//#if 1175317881 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1651222893 
public Collection getChildren(Object namespace)
    { 

//#if -1164640550 
if(Model.getFacade().isANamespace(namespace))//1
{ 

//#if -1233873427 
List returnList = new ArrayList();
//#endif 


//#if 824809762 
Project proj = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -57526002 
for (ArgoDiagram diagram : proj.getDiagramList()) //1
{ 

//#if 555345926 
if(diagram instanceof UMLStateDiagram




                        || diagram instanceof UMLActivityDiagram





                        || diagram instanceof UMLSequenceDiagram)//1
{ 

//#if 694621070 
continue;
//#endif 

} 

//#endif 


//#if 284623625 
if(diagram.getNamespace() == namespace)//1
{ 

//#if 1193737987 
returnList.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -546381438 
return returnList;
//#endif 

} 

//#endif 


//#if -1551602271 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

