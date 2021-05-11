// Compilation Unit of /ChildGenSearch.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Iterator;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if COGNITIVE 
import org.argouml.kernel.Project;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if COGNITIVE 
import org.argouml.util.ChildGenerator;
//#endif 


//#if COGNITIVE 
public class ChildGenSearch implements ChildGenerator
  { 
private static final ChildGenSearch INSTANCE = new ChildGenSearch();
private ChildGenSearch()
    { 
super();
} 

public static ChildGenSearch getInstance()
    { 
return INSTANCE;
} 

public Iterator childIterator(Object parent)
    { 
List res = new ArrayList();
if(parent instanceof Project)//1
{ 
Project p = (Project) parent;
res.addAll(p.getUserDefinedModelList());
res.addAll(p.getDiagramList());
} 
else

//#if COGNITIVE 
if(parent instanceof ArgoDiagram)//1
{ 
ArgoDiagram d = (ArgoDiagram) parent;
res.addAll(d.getGraphModel().getNodes());
res.addAll(d.getGraphModel().getEdges());
} 
else

//#if COGNITIVE 
if(Model.getFacade().isAModelElement(parent))//1
{ 
res.addAll(Model.getFacade().getModelElementContents(parent));
} 

//#endif 


//#endif 


return res.iterator();
} 

 } 

//#endif 


