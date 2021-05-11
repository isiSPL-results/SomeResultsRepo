
//#if -601892345 
// Compilation Unit of /ChildGenFind.java 
 

//#if -453478351 
package org.argouml.uml.cognitive;
//#endif 


//#if 1300744214 
import java.util.ArrayList;
//#endif 


//#if -1242421160 
import java.util.Collections;
//#endif 


//#if 1425267174 
import java.util.Enumeration;
//#endif 


//#if 683817099 
import java.util.List;
//#endif 


//#if -125683388 
import org.argouml.kernel.Project;
//#endif 


//#if 348698630 
import org.argouml.model.Model;
//#endif 


//#if 1364055607 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -1206645274 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if 866069295 

//#if 1502498368 
@Deprecated
//#endif 

public class ChildGenFind implements 
//#if 1560750570 
ChildGenerator
//#endif 

  { 

//#if -596750364 
private static final ChildGenFind SINGLETON = new ChildGenFind();
//#endif 


//#if -20961764 
public Enumeration gen(Object o)
    { 

//#if -1823960138 
List res = new ArrayList();
//#endif 


//#if 79221375 
if(o instanceof Project)//1
{ 

//#if -918634661 
Project p = (Project) o;
//#endif 


//#if -310853801 
res.addAll(p.getUserDefinedModelList());
//#endif 


//#if -1294204279 
res.addAll(p.getDiagramList());
//#endif 

} 
else

//#if -1556583031 
if(o instanceof Diagram)//1
{ 

//#if 1394994034 
Diagram d = (Diagram) o;
//#endif 


//#if -1859981446 
res.addAll(d.getGraphModel().getNodes());
//#endif 


//#if -2101293921 
res.addAll(d.getGraphModel().getEdges());
//#endif 

} 
else

//#if 1633717661 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -1644835308 
res.addAll(Model.getFacade().getModelElementContents(o));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1653716330 
return Collections.enumeration(res);
//#endif 

} 

//#endif 


//#if 771244525 
public static ChildGenFind getSingleton()
    { 

//#if -126268204 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

