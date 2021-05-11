
//#if -1191229823 
// Compilation Unit of /ChildGenRelated.java 
 

//#if 55077125 
package org.argouml.uml;
//#endif 


//#if 1919679534 
import java.util.ArrayList;
//#endif 


//#if 848934512 
import java.util.Collections;
//#endif 


//#if -778344450 
import java.util.Enumeration;
//#endif 


//#if 1617155443 
import java.util.List;
//#endif 


//#if 96804894 
import org.argouml.model.Model;
//#endif 


//#if 522744399 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 1970153166 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if -530440435 
public class ChildGenRelated implements 
//#if 1569437218 
ChildGenerator
//#endif 

  { 

//#if -1456088982 
private static final ChildGenRelated SINGLETON = new ChildGenRelated();
//#endif 


//#if 1849101488 
private static final long serialVersionUID = -893946595629032267L;
//#endif 


//#if -1020082389 
public static ChildGenRelated getSingleton()
    { 

//#if 87336928 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -2097503516 
public Enumeration gen(Object o)
    { 

//#if 1254875990 
if(Model.getFacade().isAPackage(o))//1
{ 

//#if 886497972 
return null;
//#endif 

} 

//#endif 


//#if -767269437 
if(o instanceof Diagram)//1
{ 

//#if 1640813097 
List res = new ArrayList();
//#endif 


//#if 1513870909 
Diagram d = (Diagram) o;
//#endif 


//#if 1515235720 
res.add(d.getGraphModel().getNodes());
//#endif 


//#if 1273923245 
res.add(d.getGraphModel().getEdges());
//#endif 


//#if -1503562615 
return Collections.enumeration(res);
//#endif 

} 

//#endif 


//#if -1635414928 
if(Model.getFacade().isAUMLElement(o))//1
{ 

//#if 1483866846 
return Collections.enumeration(Model.getFacade()
                                           .getModelElementAssociated(o));
//#endif 

} 

//#endif 


//#if 239101748 
throw new IllegalArgumentException("Unknown element type " + o);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

