// Compilation Unit of /GraphChangeAdapter.java 
 
package org.argouml.uml.diagram;
import org.argouml.model.DiDiagram;
import org.argouml.model.DiElement;
import org.argouml.model.Model;
import org.tigris.gef.graph.GraphEvent;
import org.tigris.gef.graph.GraphListener;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.presentation.Fig;
public final class GraphChangeAdapter implements GraphListener
  { 
private static final GraphChangeAdapter INSTANCE =
        new GraphChangeAdapter();
public void removeDiagram(DiDiagram dd)
    { 
if(Model.getDiagramInterchangeModel() != null)//1
{ 
Model.getDiagramInterchangeModel().deleteDiagram(dd);
} 

} 

public void removeElement(DiElement element)
    { 
if(Model.getDiagramInterchangeModel() != null)//1
{ 
Model.getDiagramInterchangeModel().deleteElement(element);
} 

} 

public void edgeRemoved(GraphEvent e)
    { 
Object source = e.getSource();
Object arg = e.getArg();
if(source instanceof Fig)//1
{ 
source = ((Fig) source).getOwner();
} 

if(arg instanceof Fig)//1
{ 
arg = ((Fig) arg).getOwner();
} 

Model.getDiagramInterchangeModel().edgeRemoved(source, arg);
} 

public void nodeAdded(GraphEvent e)
    { 
Object source = e.getSource();
Object arg = e.getArg();
if(source instanceof Fig)//1
{ 
source = ((Fig) source).getOwner();
} 

if(arg instanceof Fig)//1
{ 
arg = ((Fig) arg).getOwner();
} 

Model.getDiagramInterchangeModel().nodeAdded(source, arg);
} 

public DiElement createElement(GraphModel gm, Object node)
    { 
if(Model.getDiagramInterchangeModel() != null)//1
{ 
return Model.getDiagramInterchangeModel().createElement(
                       ((UMLMutableGraphSupport) gm).getDiDiagram(), node);
} 

return null;
} 

public DiDiagram createDiagram(Class type, Object owner)
    { 
if(Model.getDiagramInterchangeModel() != null)//1
{ 
return Model.getDiagramInterchangeModel()
                   .createDiagram(type, owner);
} 

return null;
} 

private GraphChangeAdapter()
    { 
} 

public void edgeAdded(GraphEvent e)
    { 
Object source = e.getSource();
Object arg = e.getArg();
if(source instanceof Fig)//1
{ 
source = ((Fig) source).getOwner();
} 

if(arg instanceof Fig)//1
{ 
arg = ((Fig) arg).getOwner();
} 

Model.getDiagramInterchangeModel().edgeAdded(source, arg);
} 

public void graphChanged(GraphEvent e)
    { 
Object source = e.getSource();
Object arg = e.getArg();
if(source instanceof Fig)//1
{ 
source = ((Fig) source).getOwner();
} 

if(arg instanceof Fig)//1
{ 
arg = ((Fig) arg).getOwner();
} 

Model.getDiagramInterchangeModel().graphChanged(source, arg);
} 

public static GraphChangeAdapter getInstance()
    { 
return INSTANCE;
} 

public void nodeRemoved(GraphEvent e)
    { 
Object source = e.getSource();
Object arg = e.getArg();
if(source instanceof Fig)//1
{ 
source = ((Fig) source).getOwner();
} 

if(arg instanceof Fig)//1
{ 
arg = ((Fig) arg).getOwner();
} 

Model.getDiagramInterchangeModel().nodeRemoved(source, arg);
} 

 } 


