
//#if 770325549 
// Compilation Unit of /ChildGenSearch.java 
 

//#if -1563537238 
package org.argouml.uml.cognitive;
//#endif 


//#if 1910871485 
import java.util.ArrayList;
//#endif 


//#if -232262348 
import java.util.Iterator;
//#endif 


//#if 537280132 
import java.util.List;
//#endif 


//#if -1235742275 
import org.argouml.kernel.Project;
//#endif 


//#if 346642989 
import org.argouml.model.Model;
//#endif 


//#if -1521180564 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1215835282 
import org.argouml.util.ChildGenerator;
//#endif 


//#if -404719849 
public class ChildGenSearch implements 
//#if 1960514272 
ChildGenerator
//#endif 

  { 

//#if 23213244 
private static final ChildGenSearch INSTANCE = new ChildGenSearch();
//#endif 


//#if 2033532279 
private ChildGenSearch()
    { 

//#if 511770615 
super();
//#endif 

} 

//#endif 


//#if -725678000 
public static ChildGenSearch getInstance()
    { 

//#if -443757713 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 476261858 
public Iterator childIterator(Object parent)
    { 

//#if -1510493930 
List res = new ArrayList();
//#endif 


//#if 782956274 
if(parent instanceof Project)//1
{ 

//#if 1785885072 
Project p = (Project) parent;
//#endif 


//#if 1311793289 
res.addAll(p.getUserDefinedModelList());
//#endif 


//#if -1128603369 
res.addAll(p.getDiagramList());
//#endif 

} 
else

//#if 85893351 
if(parent instanceof ArgoDiagram)//1
{ 

//#if -1353592577 
ArgoDiagram d = (ArgoDiagram) parent;
//#endif 


//#if -2098591200 
res.addAll(d.getGraphModel().getNodes());
//#endif 


//#if 1955063621 
res.addAll(d.getGraphModel().getEdges());
//#endif 

} 
else

//#if -2080928170 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if -1384353788 
res.addAll(Model.getFacade().getModelElementContents(parent));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if 700595420 
return res.iterator();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

