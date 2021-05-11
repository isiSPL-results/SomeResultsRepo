// Compilation Unit of /DnDExplorerTree.java 
 
package org.argouml.ui.explorer;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.Autoscroll;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.argouml.model.Model;
import org.argouml.ui.TransferableModelElements;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.Relocatable;
import org.argouml.uml.diagram.ui.ActionSaveDiagramToClipboard;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class DnDExplorerTree extends ExplorerTree
 implements DragGestureListener
, DragSourceListener
, Autoscroll
  { 
private static final String DIAGRAM_TO_CLIPBOARD_ACTION =
        "export Diagram as GIF";
private Point	clickOffset = new Point();
private TreePath		sourcePath;
private BufferedImage	ghostImage;
private TreePath selectedTreePath;
private DragSource dragSource;
private static final int AUTOSCROLL_MARGIN = 12;
private static final long serialVersionUID = 6207230394860016617L;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(DnDExplorerTree.class);
//#endif 

public void dragGestureRecognized(
        DragGestureEvent dragGestureEvent)
    { 
Collection targets = TargetManager.getInstance().getModelTargets();
if(targets.size() < 1)//1
{ 
return;
} 


//#if LOGGING 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("Drag: start transferring " + targets.size()
                      + " targets.");
} 

//#endif 

TransferableModelElements tf =
            new TransferableModelElements(targets);
Point ptDragOrigin = dragGestureEvent.getDragOrigin();
TreePath path =
            getPathForLocation(ptDragOrigin.x, ptDragOrigin.y);
if(path == null)//1
{ 
return;
} 

Rectangle raPath = getPathBounds(path);
clickOffset.setLocation(ptDragOrigin.x - raPath.x,
                                ptDragOrigin.y - raPath.y);
JLabel lbl =
            (JLabel) getCellRenderer().getTreeCellRendererComponent(
                this,                        // tree
                path.getLastPathComponent(), // value
                false,	// isSelected	(dont want a colored background)
                isExpanded(path), 		 // isExpanded
                getModel().isLeaf(path.getLastPathComponent()), // isLeaf
                0, 		// row	(not important for rendering)
                false	// hasFocus (dont want a focus rectangle)
            );
lbl.setSize((int) raPath.getWidth(), (int) raPath.getHeight());
ghostImage =
            new BufferedImage(
            (int) raPath.getWidth(), (int) raPath.getHeight(),
            BufferedImage.TYPE_INT_ARGB_PRE);
Graphics2D g2 = ghostImage.createGraphics();
g2.setComposite(AlphaComposite.getInstance(
                            AlphaComposite.SRC, 0.5f));
lbl.paint(g2);
Icon icon = lbl.getIcon();
int nStartOfText =
            (icon == null) ? 0
            : icon.getIconWidth() + lbl.getIconTextGap();
g2.setComposite(AlphaComposite.getInstance(
                            AlphaComposite.DST_OVER, 0.5f));
g2.setPaint(new GradientPaint(nStartOfText,	0,
                                      SystemColor.controlShadow,
                                      getWidth(), 0, new Color(255, 255, 255, 0)));
g2.fillRect(nStartOfText, 0, getWidth(), ghostImage.getHeight());
g2.dispose();
sourcePath = path;
dragGestureEvent.startDrag(null, ghostImage,
                                   new Point(5, 5), tf, this);
} 

public Insets getAutoscrollInsets()
    { 
Rectangle raOuter = getBounds();
Rectangle raInner = getParent().getBounds();
return new Insets(
                   raInner.y - raOuter.y + AUTOSCROLL_MARGIN,
                   raInner.x - raOuter.x + AUTOSCROLL_MARGIN,
                   raOuter.height - raInner.height
                   - raInner.y + raOuter.y + AUTOSCROLL_MARGIN,
                   raOuter.width - raInner.width
                   - raInner.x + raOuter.x + AUTOSCROLL_MARGIN);
} 

public void dragOver(DragSourceDragEvent dragSourceDragEvent)
    { 
} 

public DnDExplorerTree()
    { 
super();
this.addTreeSelectionListener(new DnDTreeSelectionListener());
dragSource = DragSource.getDefaultDragSource();
DragGestureRecognizer dgr =
            dragSource
            .createDefaultDragGestureRecognizer(
                this,
                DnDConstants.ACTION_COPY_OR_MOVE, //specifies valid actions
                this);
dgr.setSourceActions(
            dgr.getSourceActions() & ~InputEvent.BUTTON3_MASK);
new DropTarget(this, new ArgoDropTargetListener());
KeyStroke ctrlC = KeyStroke.getKeyStroke("control C");
this.getInputMap().put(ctrlC, DIAGRAM_TO_CLIPBOARD_ACTION);
this.getActionMap().put(DIAGRAM_TO_CLIPBOARD_ACTION,
                                new ActionSaveDiagramToClipboard());
} 

private boolean isValidDrag(TreePath destinationPath,
                                Transferable tf)
    { 
if(destinationPath == null)//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: no destination found.");
//#endif 

return false;
} 

if(selectedTreePath.isDescendant(destinationPath))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: move to descendent.");
//#endif 

return false;
} 

if(!tf.isDataFlavorSupported(
                    TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: flavor not supported.");
//#endif 

return false;
} 

Object dest =
            ((DefaultMutableTreeNode) destinationPath
             .getLastPathComponent()).getUserObject();
if(!Model.getFacade().isANamespace(dest))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: not a namespace.");
//#endif 

return false;
} 

if(Model.getModelManagementHelper().isReadOnly(dest))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: "
                      + "this is not an editable UML element (profile?).");
//#endif 

return false;
} 

if(Model.getFacade().isADataType(dest))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: destination is a DataType.");
//#endif 

return false;
} 

try //1
{ 
Collection transfers =
                (Collection) tf.getTransferData(
                    TransferableModelElements.UML_COLLECTION_FLAVOR);
for (Object element : transfers) //1
{ 
if(Model.getFacade().isAUMLElement(element))//1
{ 
if(!Model.getModelManagementHelper().isReadOnly(element))//1
{ 
if(Model.getFacade().isAModelElement(dest)
                                && Model.getFacade().isANamespace(element)
                                && Model.getCoreHelper().isValidNamespace(
                                    element, dest))//1
{ 

//#if LOGGING 
LOG.debug("Valid Drag: namespace " + dest);
//#endif 

return true;
} 

if(Model.getFacade().isAFeature(element)
                                && Model.getFacade().isAClassifier(dest))//1
{ 
return true;
} 

} 

} 

if(element instanceof Relocatable)//1
{ 
Relocatable d = (Relocatable) element;
if(d.isRelocationAllowed(dest))//1
{ 

//#if LOGGING 
LOG.debug("Valid Drag: diagram " + dest);
//#endif 

return true;
} 

} 

} 

} 
catch (UnsupportedFlavorException e) //1
{ 

//#if LOGGING 
LOG.debug(e);
//#endif 

} 

catch (IOException e) //1
{ 

//#if LOGGING 
LOG.debug(e);
//#endif 

} 



//#if LOGGING 
LOG.debug("No valid Drag: not a valid namespace.");
//#endif 

return false;
} 

public void autoscroll(Point pt)
    { 
int nRow = getRowForLocation(pt.x, pt.y);
if(nRow < 0)//1
{ 
return;
} 

Rectangle raOuter = getBounds();
nRow =
            (pt.y + raOuter.y <= AUTOSCROLL_MARGIN)
            ?
            // Yes, scroll up one row
            (nRow <= 0 ? 0 : nRow - 1)
            :
            // No, scroll down one row
            (nRow < getRowCount() - 1 ? nRow + 1 : nRow);
scrollRowToVisible(nRow);
} 

public void dragExit(DragSourceEvent dragSourceEvent)
    { 
} 

public void dragEnter(DragSourceDragEvent dragSourceDragEvent)
    { 
} 

public void dragDropEnd(
        DragSourceDropEvent dragSourceDropEvent)
    { 
sourcePath = null;
ghostImage = null;
} 

public void dropActionChanged(
        DragSourceDragEvent dragSourceDragEvent)
    { 
} 

class ArgoDropTargetListener implements DropTargetListener
  { 
private TreePath	 lastPath;
private Rectangle2D cueLine = new Rectangle2D.Float();
private Rectangle2D ghostRectangle = new Rectangle2D.Float();
private Color cueLineColor;
private Point lastMouseLocation = new Point();
private Timer hoverTimer;
public void dragEnter(
            DropTargetDragEvent dropTargetDragEvent)
        { 

//#if LOGGING 
LOG.debug("dragEnter");
//#endif 

if(!isDragAcceptable(dropTargetDragEvent))//1
{ 
dropTargetDragEvent.rejectDrag();
} 
else
{ 
dropTargetDragEvent.acceptDrag(
                    dropTargetDragEvent.getDropAction());
} 

} 

public boolean isDragAcceptable(
            DropTargetDragEvent dropTargetEvent)
        { 
if((dropTargetEvent.getDropAction()
                    & DnDConstants.ACTION_COPY_OR_MOVE) == 0)//1
{ 
return false;
} 

Point pt = dropTargetEvent.getLocation();
TreePath path = getPathForLocation(pt.x, pt.y);
if(path == null)//1
{ 
return false;
} 

if(path.equals(sourcePath))//1
{ 
return false;
} 

return true;
} 

public ArgoDropTargetListener()
        { 
cueLineColor =
                new Color(
                SystemColor.controlShadow.getRed(),
                SystemColor.controlShadow.getGreen(),
                SystemColor.controlShadow.getBlue(),
                64
            );
hoverTimer =
            new Timer(1000, new ActionListener() {
                /*
                 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
                 */
                public void actionPerformed(ActionEvent e) {
                    if (getPathForRow(0).equals/*isRootPath*/(lastPath)) {
                        return;
                    }
                    if (isExpanded(lastPath)) {
                        collapsePath(lastPath);
                    } else {
                        expandPath(lastPath);
                    }
                }
            });
hoverTimer.setRepeats(false);
} 

public boolean isDropAcceptable(
            DropTargetDropEvent dropTargetDropEvent)
        { 
if((dropTargetDropEvent.getDropAction()
                    & DnDConstants.ACTION_COPY_OR_MOVE) == 0)//1
{ 
return false;
} 

Point pt = dropTargetDropEvent.getLocation();
TreePath path = getPathForLocation(pt.x, pt.y);
if(path == null)//1
{ 
return false;
} 

if(path.equals(sourcePath))//1
{ 
return false;
} 

return true;
} 

public void drop(DropTargetDropEvent dropTargetDropEvent)
        { 

//#if LOGGING 
LOG.debug("dropping ... ");
//#endif 

hoverTimer.stop();
repaint(ghostRectangle.getBounds());
if(!isDropAcceptable(dropTargetDropEvent))//1
{ 
dropTargetDropEvent.rejectDrop();
return;
} 

try //1
{ 
Transferable tr = dropTargetDropEvent.getTransferable();
Point loc = dropTargetDropEvent.getLocation();
TreePath destinationPath = getPathForLocation(loc.x, loc.y);

//#if LOGGING 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug("Drop location: x=" + loc.x + " y=" + loc.y);
} 

//#endif 

if(!isValidDrag(destinationPath, tr))//1
{ 
dropTargetDropEvent.rejectDrop();
return;
} 

Collection modelElements =
                    (Collection) tr.getTransferData(
                        TransferableModelElements.UML_COLLECTION_FLAVOR);

//#if LOGGING 
if(LOG.isDebugEnabled())//2
{ 
LOG.debug("transfer data = " + modelElements);
} 

//#endif 

Object dest =
                    ((DefaultMutableTreeNode) destinationPath
                     .getLastPathComponent()).getUserObject();
Object src =
                    ((DefaultMutableTreeNode) sourcePath
                     .getLastPathComponent()).getUserObject();
int action = dropTargetDropEvent.getDropAction();
boolean copyAction =
                    (action == DnDConstants.ACTION_COPY);
boolean moveAction =
                    (action == DnDConstants.ACTION_MOVE);
if(!(moveAction || copyAction))//1
{ 
dropTargetDropEvent.rejectDrop();
return;
} 

if(Model.getFacade().isAUMLElement(dest))//1
{ 
if(Model.getModelManagementHelper().isReadOnly(dest))//1
{ 
dropTargetDropEvent.rejectDrop();
return;
} 

} 

if(Model.getFacade().isAUMLElement(src))//1
{ 
if(Model.getModelManagementHelper().isReadOnly(src))//1
{ 
dropTargetDropEvent.rejectDrop();
return;
} 

} 

Collection<Object> newTargets = new ArrayList<Object>();
try //1
{ 
dropTargetDropEvent.acceptDrop(action);
for (Object me : modelElements) //1
{ 
if(Model.getFacade().isAUMLElement(me))//1
{ 
if(Model.getModelManagementHelper().isReadOnly(me))//1
{ 
continue;
} 

} 


//#if LOGGING 
if(LOG.isDebugEnabled())//1
{ 
LOG.debug((moveAction ? "move " : "copy ") + me);
} 

//#endif 

if(Model.getCoreHelper().isValidNamespace(me, dest))//1
{ 
if(moveAction)//1
{ 
Model.getCoreHelper().setNamespace(me, dest);
newTargets.add(me);
} 

if(copyAction)//1
{ 
try //1
{ 
newTargets.add(Model.getCopyHelper()
                                                   .copy(me, dest));
} 
catch (RuntimeException e) //1
{ 

//#if LOGGING 
LOG.error("Exception", e);
//#endif 

} 


} 

} 

if(me instanceof Relocatable)//1
{ 
Relocatable d = (Relocatable) me;
if(d.isRelocationAllowed(dest))//1
{ 
if(d.relocate(dest))//1
{ 
ExplorerEventAdaptor.getInstance()
                                    .modelElementChanged(src);
ExplorerEventAdaptor.getInstance()
                                    .modelElementChanged(dest);
makeVisible(destinationPath);
expandPath(destinationPath);
newTargets.add(me);
} 

} 

} 

if(Model.getFacade().isAFeature(me)
                                && Model.getFacade().isAClassifier(dest))//1
{ 
if(moveAction)//1
{ 
Model.getCoreHelper().removeFeature(
                                    Model.getFacade().getOwner(me), me);
Model.getCoreHelper().addFeature(dest, me);
newTargets.add(me);
} 

if(copyAction)//1
{ 
newTargets.add(
                                    Model.getCopyHelper().copy(me, dest));
} 

} 

} 

dropTargetDropEvent.getDropTargetContext()
                    .dropComplete(true);
TargetManager.getInstance().setTargets(newTargets);
} 
catch (java.lang.IllegalStateException ils) //1
{ 

//#if LOGGING 
LOG.debug("drop IllegalStateException");
//#endif 

dropTargetDropEvent.rejectDrop();
} 


dropTargetDropEvent.getDropTargetContext()
                .dropComplete(true);
} 
catch (IOException io) //1
{ 

//#if LOGGING 
LOG.debug("drop IOException");
//#endif 

dropTargetDropEvent.rejectDrop();
} 

catch (UnsupportedFlavorException ufe) //1
{ 

//#if LOGGING 
LOG.debug("drop UnsupportedFlavorException");
//#endif 

dropTargetDropEvent.rejectDrop();
} 


} 

public void dragExit(DropTargetEvent dropTargetEvent)
        { 

//#if LOGGING 
LOG.debug("dragExit");
//#endif 

if(!DragSource.isDragImageSupported())//1
{ 
repaint(ghostRectangle.getBounds());
} 

} 

public void dropActionChanged(
            DropTargetDragEvent dropTargetDragEvent)
        { 
if(!isDragAcceptable(dropTargetDragEvent))//1
{ 
dropTargetDragEvent.rejectDrag();
} 
else
{ 
dropTargetDragEvent.acceptDrag(
                    dropTargetDragEvent.getDropAction());
} 

} 

public void dragOver(DropTargetDragEvent dropTargetDragEvent)
        { 
Point pt = dropTargetDragEvent.getLocation();
if(pt.equals(lastMouseLocation))//1
{ 
return;
} 

lastMouseLocation = pt;
Graphics2D g2 = (Graphics2D) getGraphics();
if(ghostImage != null)//1
{ 
if(!DragSource.isDragImageSupported())//1
{ 
paintImmediately(ghostRectangle.getBounds());
ghostRectangle.setRect(pt.x - clickOffset.x,
                                           pt.y - clickOffset.y,
                                           ghostImage.getWidth(),
                                           ghostImage.getHeight());
g2.drawImage(ghostImage,
                                 AffineTransform.getTranslateInstance(
                                     ghostRectangle.getX(),
                                     ghostRectangle.getY()), null);
} 
else
{ 
paintImmediately(cueLine.getBounds());
} 

} 

TreePath path = getPathForLocation(pt.x, pt.y);
if(!(path == lastPath))//1
{ 
lastPath = path;
hoverTimer.restart();
} 

Rectangle raPath = getPathBounds(path);
if(raPath != null)//1
{ 
cueLine.setRect(0,
                                raPath.y + (int) raPath.getHeight(),
                                getWidth(),
                                2);
} 

g2.setColor(cueLineColor);
g2.fill(cueLine);
ghostRectangle = ghostRectangle.createUnion(cueLine);
try //1
{ 
if(!dropTargetDragEvent.isDataFlavorSupported(
                            TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 
dropTargetDragEvent.rejectDrag();
return;
} 

} 
catch (NullPointerException e) //1
{ 
dropTargetDragEvent.rejectDrag();
return;
} 


if(path == null)//1
{ 
dropTargetDragEvent.rejectDrag();
return;
} 

if(path.equals(sourcePath))//1
{ 
dropTargetDragEvent.rejectDrag();
return;
} 

if(selectedTreePath.isDescendant(path))//1
{ 
dropTargetDragEvent.rejectDrag();
return;
} 

Object dest =
                ((DefaultMutableTreeNode) path
                 .getLastPathComponent()).getUserObject();
if(!Model.getFacade().isANamespace(dest))//1
{ 

//#if LOGGING 
if(LOG.isDebugEnabled())//1
{ 
String name;
if(Model.getFacade().isAUMLElement(dest))//1
{ 
name = Model.getFacade().getName(dest);
} 
else

//#if LOGGING 
if(dest == null)//1
{ 
name = "<null>";
} 
else
{ 
name = dest.toString();
} 

//#endif 


LOG.debug("No valid Drag: "
                              + (Model.getFacade().isAUMLElement(dest)
                                 ? name + " not a namespace."
                                 :  " not a UML element."));
} 

//#endif 

dropTargetDragEvent.rejectDrag();
return;
} 

if(Model.getModelManagementHelper().isReadOnly(dest))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: "
                          + "not an editable UML element (profile?).");
//#endif 

return;
} 

if(Model.getFacade().isADataType(dest))//1
{ 

//#if LOGGING 
LOG.debug("No valid Drag: destination is a DataType.");
//#endif 

dropTargetDragEvent.rejectDrag();
return;
} 

dropTargetDragEvent.acceptDrag(
                dropTargetDragEvent.getDropAction());
} 

 } 

class DnDTreeSelectionListener implements TreeSelectionListener
  { 
public void valueChanged(
            TreeSelectionEvent treeSelectionEvent)
        { 
selectedTreePath = treeSelectionEvent.getNewLeadSelectionPath();
} 

 } 

 } 


