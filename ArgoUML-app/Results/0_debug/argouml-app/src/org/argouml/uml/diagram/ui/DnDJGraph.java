
//#if -311414950 
// Compilation Unit of /DnDJGraph.java 
 

//#if 1576845234 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -401791343 
import java.awt.datatransfer.Transferable;
//#endif 


//#if 1182677402 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if -268088642 
import java.awt.dnd.DnDConstants;
//#endif 


//#if 1894090291 
import java.awt.dnd.DropTarget;
//#endif 


//#if -1694379939 
import java.awt.dnd.DropTargetDragEvent;
//#endif 


//#if 627726808 
import java.awt.dnd.DropTargetDropEvent;
//#endif 


//#if 1852064265 
import java.awt.dnd.DropTargetEvent;
//#endif 


//#if 447348703 
import java.awt.dnd.DropTargetListener;
//#endif 


//#if -521462122 
import java.io.IOException;
//#endif 


//#if 664558997 
import java.util.Collection;
//#endif 


//#if 2109860805 
import java.util.Iterator;
//#endif 


//#if 841525961 
import org.apache.log4j.Logger;
//#endif 


//#if -1427056395 
import org.argouml.ui.TransferableModelElements;
//#endif 


//#if 616988155 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1675511965 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -1358501523 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -1785543639 
import org.tigris.gef.base.Editor;
//#endif 


//#if -1661799248 
import org.tigris.gef.base.Globals;
//#endif 


//#if -310397683 
import org.tigris.gef.graph.ConnectionConstrainer;
//#endif 


//#if 1322324328 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -1067961134 
import org.tigris.gef.graph.MutableGraphModel;
//#endif 


//#if 333724507 
import org.tigris.gef.graph.presentation.JGraph;
//#endif 


//#if -1345422767 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if 769606249 
class DnDJGraph extends 
//#if 2025028889 
JGraph
//#endif 

 implements 
//#if -657872695 
DropTargetListener
//#endif 

  { 

//#if -768739651 
private static final Logger LOG = Logger.getLogger(DnDJGraph.class);
//#endif 


//#if 221420868 
private static final long serialVersionUID = -5753683239435014182L;
//#endif 


//#if -180959519 
public DnDJGraph()
    { 

//#if -1565064180 
super();
//#endif 


//#if -1105875137 
makeDropTarget();
//#endif 

} 

//#endif 


//#if -1838681536 
public DnDJGraph(GraphModel gm)
    { 

//#if 81406767 
super(gm);
//#endif 


//#if -890825118 
makeDropTarget();
//#endif 

} 

//#endif 


//#if 1464601064 
public void dragEnter(DropTargetDragEvent dtde)
    { 

//#if -114000482 
try //1
{ 

//#if -824587956 
if(dtde.isDataFlavorSupported(
                        TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 

//#if -122733548 
dtde.acceptDrag(dtde.getDropAction());
//#endif 


//#if 1755817207 
return;
//#endif 

} 

//#endif 

} 

//#if -1214968734 
catch (NullPointerException e) //1
{ 
} 

//#endif 


//#endif 


//#if -1046192686 
dtde.rejectDrag();
//#endif 

} 

//#endif 


//#if -223802319 
private void makeDropTarget()
    { 

//#if 994097091 
new DropTarget(this,
                       DnDConstants.ACTION_COPY_OR_MOVE,
                       this);
//#endif 

} 

//#endif 


//#if 763594538 
public void dragExit(DropTargetEvent dte)
    { 
} 

//#endif 


//#if -1110267742 
public void drop(DropTargetDropEvent dropTargetDropEvent)
    { 

//#if -492952756 
Transferable tr = dropTargetDropEvent.getTransferable();
//#endif 


//#if -732177626 
if(!tr.isDataFlavorSupported(
                    TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 

//#if -1712848394 
dropTargetDropEvent.rejectDrop();
//#endif 


//#if 267720984 
return;
//#endif 

} 

//#endif 


//#if -1670340659 
dropTargetDropEvent.acceptDrop(dropTargetDropEvent.getDropAction());
//#endif 


//#if -1722103671 
Collection modelElements;
//#endif 


//#if -350360570 
try //1
{ 

//#if -1909701987 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if 1408478112 
modelElements =
                (Collection) tr.getTransferData(
                    TransferableModelElements.UML_COLLECTION_FLAVOR);
//#endif 


//#if -1802068638 
Iterator i = modelElements.iterator();
//#endif 


//#if 1872029024 
while (i.hasNext()) //1
{ 

//#if 1216431849 
FigNode figNode = ((UMLDiagram ) diagram).drop(i.next(),
                                  dropTargetDropEvent.getLocation());
//#endif 


//#if -1156327271 
if(figNode != null)//1
{ 

//#if -1664418724 
MutableGraphModel gm =
                        (MutableGraphModel) diagram.getGraphModel();
//#endif 


//#if 86628676 
if(!gm.getNodes().contains(figNode.getOwner()))//1
{ 

//#if 1958843421 
gm.getNodes().add(figNode.getOwner());
//#endif 

} 

//#endif 


//#if -1612472332 
Globals.curEditor().getLayerManager().getActiveLayer()
                    .add(figNode);
//#endif 


//#if -2106740872 
gm.addNodeRelatedEdges(figNode.getOwner());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1780740759 
dropTargetDropEvent.getDropTargetContext().dropComplete(true);
//#endif 

} 

//#if -1085953854 
catch (UnsupportedFlavorException e) //1
{ 

//#if 746347270 
LOG.debug("Exception caught", e);
//#endif 

} 

//#endif 


//#if 1635886867 
catch (IOException e) //1
{ 

//#if -785336010 
LOG.debug("Exception caught", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1455840544 
public void dragOver(DropTargetDragEvent dtde)
    { 

//#if -1407294819 
try //1
{ 

//#if -1578275679 
ArgoDiagram dia = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1493695471 
if(dia instanceof UMLDiagram)//1
{ 

//#if -68826343 
dtde.acceptDrag(dtde.getDropAction());
//#endif 


//#if 64496274 
return;
//#endif 

} 

//#endif 


//#if 771559419 
if(dtde.isDataFlavorSupported(
                        TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 

//#if 259168413 
dtde.acceptDrag(dtde.getDropAction());
//#endif 


//#if 625997198 
return;
//#endif 

} 

//#endif 

} 

//#if -1392046851 
catch (NullPointerException e) //1
{ 
} 

//#endif 


//#endif 


//#if -1520714671 
dtde.rejectDrag();
//#endif 

} 

//#endif 


//#if -1656929552 
public DnDJGraph(Diagram d)
    { 

//#if 1197844902 
super(d);
//#endif 


//#if -1099778583 
makeDropTarget();
//#endif 

} 

//#endif 


//#if 2067947357 
public void dropActionChanged(DropTargetDragEvent dtde)
    { 
} 

//#endif 


//#if -105574965 
public DnDJGraph(ConnectionConstrainer cc)
    { 

//#if -1216421093 
super(cc);
//#endif 


//#if 819794736 
makeDropTarget();
//#endif 

} 

//#endif 


//#if -413531787 
public DnDJGraph(Editor ed)
    { 

//#if -408834174 
super(ed);
//#endif 


//#if 331546184 
makeDropTarget();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

