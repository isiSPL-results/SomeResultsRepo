package org.argouml.uml.cognitive;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.util.ChildGenerator;
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
if(parent instanceof ArgoDiagram)//1
{ 
ArgoDiagram d = (ArgoDiagram) parent;
res.addAll(d.getGraphModel().getNodes());
res.addAll(d.getGraphModel().getEdges());
} 
else
if(Model.getFacade().isAModelElement(parent))//1
{ 
res.addAll(Model.getFacade().getModelElementContents(parent));
} 
return res.iterator();
} 

 } 
