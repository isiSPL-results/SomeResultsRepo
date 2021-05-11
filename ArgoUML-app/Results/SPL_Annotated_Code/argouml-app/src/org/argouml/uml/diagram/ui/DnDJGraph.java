// Compilation Unit of /DnDJGraph.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.apache.log4j.Logger;
import org.argouml.ui.TransferableModelElements;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.tigris.gef.base.Diagram;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.graph.ConnectionConstrainer;
import org.tigris.gef.graph.GraphModel;
import org.tigris.gef.graph.MutableGraphModel;
import org.tigris.gef.graph.presentation.JGraph;
import org.tigris.gef.presentation.FigNode;
class DnDJGraph extends JGraph
 implements DropTargetListener
  { 
private static final Logger LOG = Logger.getLogger(DnDJGraph.class);
private static final long serialVersionUID = -5753683239435014182L;
public DnDJGraph()
    { 
super();
makeDropTarget();
} 

public DnDJGraph(GraphModel gm)
    { 
super(gm);
makeDropTarget();
} 

public void dragEnter(DropTargetDragEvent dtde)
    { 
try //1
{ 
if(dtde.isDataFlavorSupported(
                        TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 
dtde.acceptDrag(dtde.getDropAction());
return;
} 

} 
catch (NullPointerException e) //1
{ 
} 


dtde.rejectDrag();
} 

private void makeDropTarget()
    { 
new DropTarget(this,
                       DnDConstants.ACTION_COPY_OR_MOVE,
                       this);
} 

public void dragExit(DropTargetEvent dte)
    { 
} 

public void drop(DropTargetDropEvent dropTargetDropEvent)
    { 
Transferable tr = dropTargetDropEvent.getTransferable();
if(!tr.isDataFlavorSupported(
                    TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 
dropTargetDropEvent.rejectDrop();
return;
} 

dropTargetDropEvent.acceptDrop(dropTargetDropEvent.getDropAction());
Collection modelElements;
try //1
{ 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
modelElements =
                (Collection) tr.getTransferData(
                    TransferableModelElements.UML_COLLECTION_FLAVOR);
Iterator i = modelElements.iterator();
while (i.hasNext()) //1
{ 
FigNode figNode = ((UMLDiagram ) diagram).drop(i.next(),
                                  dropTargetDropEvent.getLocation());
if(figNode != null)//1
{ 
MutableGraphModel gm =
                        (MutableGraphModel) diagram.getGraphModel();
if(!gm.getNodes().contains(figNode.getOwner()))//1
{ 
gm.getNodes().add(figNode.getOwner());
} 

Globals.curEditor().getLayerManager().getActiveLayer()
                    .add(figNode);
gm.addNodeRelatedEdges(figNode.getOwner());
} 

} 

dropTargetDropEvent.getDropTargetContext().dropComplete(true);
} 
catch (UnsupportedFlavorException e) //1
{ 
LOG.debug("Exception caught", e);
} 

catch (IOException e) //1
{ 
LOG.debug("Exception caught", e);
} 


} 

public void dragOver(DropTargetDragEvent dtde)
    { 
try //1
{ 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
if(dia instanceof UMLDiagram)//1
{ 
dtde.acceptDrag(dtde.getDropAction());
return;
} 

if(dtde.isDataFlavorSupported(
                        TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 
dtde.acceptDrag(dtde.getDropAction());
return;
} 

} 
catch (NullPointerException e) //1
{ 
} 


dtde.rejectDrag();
} 

public DnDJGraph(Diagram d)
    { 
super(d);
makeDropTarget();
} 

public void dropActionChanged(DropTargetDragEvent dtde)
    { 
} 

public DnDJGraph(ConnectionConstrainer cc)
    { 
super(cc);
makeDropTarget();
} 

public DnDJGraph(Editor ed)
    { 
super(ed);
makeDropTarget();
} 

 } 


