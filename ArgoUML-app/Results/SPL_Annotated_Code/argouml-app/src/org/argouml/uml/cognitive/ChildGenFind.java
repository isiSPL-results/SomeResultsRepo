// Compilation Unit of /ChildGenFind.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.Collections;
//#endif 


//#if COGNITIVE 
import java.util.Enumeration;
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
import org.tigris.gef.base.Diagram;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if COGNITIVE 
@Deprecated
public class ChildGenFind implements ChildGenerator
  { 
private static final ChildGenFind SINGLETON = new ChildGenFind();
public Enumeration gen(Object o)
    { 
List res = new ArrayList();
if(o instanceof Project)//1
{ 
Project p = (Project) o;
res.addAll(p.getUserDefinedModelList());
res.addAll(p.getDiagramList());
} 
else

//#if COGNITIVE 
if(o instanceof Diagram)//1
{ 
Diagram d = (Diagram) o;
res.addAll(d.getGraphModel().getNodes());
res.addAll(d.getGraphModel().getEdges());
} 
else

//#if COGNITIVE 
if(Model.getFacade().isAModelElement(o))//1
{ 
res.addAll(Model.getFacade().getModelElementContents(o));
} 

//#endif 


//#endif 


return Collections.enumeration(res);
} 

public static ChildGenFind getSingleton()
    { 
return SINGLETON;
} 

 } 

//#endif 


