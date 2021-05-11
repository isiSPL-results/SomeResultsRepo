
//#if 1327775841 
// Compilation Unit of /ChildGenSearch.java 
 

//#if -906782037 
package org.argouml.ui;
//#endif 


//#if -1869102960 
import java.util.ArrayList;
//#endif 


//#if 199992321 
import java.util.Iterator;
//#endif 


//#if -1822204975 
import java.util.List;
//#endif 


//#if -1688558710 
import org.argouml.kernel.Project;
//#endif 


//#if -439098496 
import org.argouml.model.Model;
//#endif 


//#if 2054473023 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1883855297 
import org.argouml.util.ChildGenerator;
//#endif 


//#if 27534820 
public class ChildGenSearch implements 
//#if 1387617884 
ChildGenerator
//#endif 

  { 

//#if 966510867 
public Iterator childIterator(Object o)
    { 

//#if 1450496914 
List res = new ArrayList();
//#endif 


//#if -1378579621 
if(o instanceof Project)//1
{ 

//#if 1851494295 
Project p = (Project) o;
//#endif 


//#if 669456787 
res.addAll(p.getUserDefinedModelList());
//#endif 


//#if 675280077 
res.addAll(p.getDiagramList());
//#endif 

} 
else

//#if -1996804700 
if(o instanceof ArgoDiagram)//1
{ 

//#if -600399694 
ArgoDiagram d = (ArgoDiagram) o;
//#endif 


//#if 931748524 
res.addAll(d.getGraphModel().getNodes());
//#endif 


//#if 690436049 
res.addAll(d.getGraphModel().getEdges());
//#endif 

} 
else

//#if 1277657568 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -341157775 
res.addAll(Model.getFacade().getModelElementContents(o));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -1294086568 
return res.iterator();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

