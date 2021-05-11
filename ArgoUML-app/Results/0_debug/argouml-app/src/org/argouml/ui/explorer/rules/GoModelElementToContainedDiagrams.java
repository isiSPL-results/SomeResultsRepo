
//#if 381720494 
// Compilation Unit of /GoModelElementToContainedDiagrams.java 
 

//#if 1525223094 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1774053774 
import java.util.Collection;
//#endif 


//#if 838909649 
import java.util.Collections;
//#endif 


//#if -1633321646 
import java.util.HashSet;
//#endif 


//#if -1472873308 
import java.util.Set;
//#endif 


//#if -542677767 
import org.argouml.i18n.Translator;
//#endif 


//#if -1701067157 
import org.argouml.kernel.Project;
//#endif 


//#if -14340578 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -947153857 
import org.argouml.model.Model;
//#endif 


//#if -1981395074 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1836460876 
public class GoModelElementToContainedDiagrams extends 
//#if -1946001642 
AbstractPerspectiveRule
//#endif 

  { 

//#if 435864996 
public String getRuleName()
    { 

//#if 670206535 
return Translator.localize("misc.model-element.contained-diagrams");
//#endif 

} 

//#endif 


//#if 711135166 
public Set getDependencies(Object parent)
    { 

//#if -883700990 
Set set = new HashSet();
//#endif 


//#if -864580299 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if 1042700685 
set.add(parent);
//#endif 

} 

//#endif 


//#if 749538210 
return set;
//#endif 

} 

//#endif 


//#if 349400166 
public Collection getChildren(Object parent)
    { 

//#if -1204290115 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if 295276294 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -908266360 
Set<ArgoDiagram> ret = new HashSet<ArgoDiagram>();
//#endif 


//#if 1160966436 
for (ArgoDiagram diagram : p.getDiagramList()) //1
{ 

//#if -1230924948 
if(diagram.getNamespace() == parent)//1
{ 

//#if 1146962563 
ret.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 760308778 
return ret;
//#endif 

} 

//#endif 


//#if 617397749 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

