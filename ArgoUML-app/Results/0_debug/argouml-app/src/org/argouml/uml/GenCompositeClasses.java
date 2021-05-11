
//#if 1298856369 
// Compilation Unit of /GenCompositeClasses.java 
 

//#if -544797363 
package org.argouml.uml;
//#endif 


//#if -1877241114 
import java.util.ArrayList;
//#endif 


//#if -1020301509 
import java.util.Collection;
//#endif 


//#if -1564573912 
import java.util.Collections;
//#endif 


//#if 1103114422 
import java.util.Enumeration;
//#endif 


//#if -770101525 
import java.util.Iterator;
//#endif 


//#if 990833595 
import java.util.List;
//#endif 


//#if -2450730 
import org.argouml.model.Model;
//#endif 


//#if -55097066 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if -976113443 
public class GenCompositeClasses implements 
//#if 1202376194 
ChildGenerator
//#endif 

  { 

//#if -456170854 
private static final GenCompositeClasses SINGLETON =
        new GenCompositeClasses();
//#endif 


//#if -2105201135 
private static final long serialVersionUID = -6027679124153204193L;
//#endif 


//#if 79318115 
public static GenCompositeClasses getSINGLETON()
    { 

//#if -1966234358 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -1316172028 
public Enumeration gen(Object o)
    { 

//#if -756489514 
return Collections.enumeration(collectChildren(o));
//#endif 

} 

//#endif 


//#if 553365049 
protected Collection collectChildren(Object o)
    { 

//#if -1067613454 
List res = new ArrayList();
//#endif 


//#if -1405481815 
if(!(Model.getFacade().isAClassifier(o)))//1
{ 

//#if -1578605334 
return res;
//#endif 

} 

//#endif 


//#if 1248951572 
Object cls = o;
//#endif 


//#if 1721712596 
List ends = new ArrayList(Model.getFacade().getAssociationEnds(cls));
//#endif 


//#if -48967268 
if(ends == null)//1
{ 

//#if 1663554583 
return res;
//#endif 

} 

//#endif 


//#if 791851434 
Iterator assocEnds = ends.iterator();
//#endif 


//#if 729928584 
while (assocEnds.hasNext()) //1
{ 

//#if -1417896310 
Object ae = assocEnds.next();
//#endif 


//#if -777221570 
if(Model.getAggregationKind().getComposite().equals(
                        Model.getFacade().getAggregation(ae)))//1
{ 

//#if -1632712234 
Object asc = Model.getFacade().getAssociation(ae);
//#endif 


//#if 1498669738 
ArrayList conn =
                    new ArrayList(Model.getFacade().getConnections(asc));
//#endif 


//#if 1872947944 
if(conn == null || conn.size() != 2)//1
{ 

//#if -205242194 
continue;
//#endif 

} 

//#endif 


//#if 1779595798 
Object otherEnd =
                    (ae == conn.get(0)) ? conn.get(1) : conn.get(0);
//#endif 


//#if -1679476256 
if(Model.getFacade().getType(ae)
                        != Model.getFacade().getType(otherEnd))//1
{ 

//#if -612394437 
res.add(Model.getFacade().getType(otherEnd));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1621638657 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

