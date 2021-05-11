
//#if -1944383959 
// Compilation Unit of /GoModelToDiagrams.java 
 

//#if -362724264 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1180476525 
import java.util.ArrayList;
//#endif 


//#if -720335212 
import java.util.Collection;
//#endif 


//#if -855553297 
import java.util.Collections;
//#endif 


//#if -358823824 
import java.util.HashSet;
//#endif 


//#if -1767063084 
import java.util.List;
//#endif 


//#if -195344702 
import java.util.Set;
//#endif 


//#if 1443488407 
import org.argouml.i18n.Translator;
//#endif 


//#if -112976627 
import org.argouml.kernel.Project;
//#endif 


//#if -1257341636 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1533439779 
import org.argouml.model.Model;
//#endif 


//#if 1790463772 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 468649137 
public class GoModelToDiagrams extends 
//#if 698023942 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1276188012 
public String getRuleName()
    { 

//#if -320579953 
return Translator.localize("misc.model.diagram");
//#endif 

} 

//#endif 


//#if 1295413454 
public Set getDependencies(Object parent)
    { 

//#if 1830550418 
if(Model.getFacade().isAModel(parent))//1
{ 

//#if -2102633811 
Set set = new HashSet();
//#endif 


//#if 1205009107 
set.add(parent);
//#endif 


//#if 1597646093 
return set;
//#endif 

} 

//#endif 


//#if 392050912 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -2042669399 
public Collection getChildren(Object model)
    { 

//#if -1392063310 
if(Model.getFacade().isAModel(model))//1
{ 

//#if 1072774965 
List returnList = new ArrayList();
//#endif 


//#if -2024745878 
Project proj = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -243130282 
for (ArgoDiagram diagram : proj.getDiagramList()) //1
{ 

//#if -1100504047 
if(isInPath(diagram.getNamespace(), model))//1
{ 

//#if -62040088 
returnList.add(diagram);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1120877766 
return returnList;
//#endif 

} 

//#endif 


//#if 1269762965 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1875992622 
private boolean isInPath(Object namespace, Object model)
    { 

//#if -1059705571 
if(namespace == model)//1
{ 

//#if -1919962377 
return true;
//#endif 

} 

//#endif 


//#if -852076543 
Object ns = Model.getFacade().getNamespace(namespace);
//#endif 


//#if -20880181 
while (ns != null) //1
{ 

//#if -225851307 
if(model == ns)//1
{ 

//#if 1623524126 
return true;
//#endif 

} 

//#endif 


//#if 2141722378 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 

//#endif 


//#if -1685951348 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

