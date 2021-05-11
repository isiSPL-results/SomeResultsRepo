
//#if -1993987732 
// Compilation Unit of /DnDExplorerTree.java 
 

//#if 1180995992 
package org.argouml.ui.explorer;
//#endif 


//#if -447965144 
import java.awt.AlphaComposite;
//#endif 


//#if 381924066 
import java.awt.Color;
//#endif 


//#if -1683259753 
import java.awt.GradientPaint;
//#endif 


//#if 1743457876 
import java.awt.Graphics2D;
//#endif 


//#if -37659749 
import java.awt.Insets;
//#endif 


//#if 754012757 
import java.awt.Point;
//#endif 


//#if -1556213418 
import java.awt.Rectangle;
//#endif 


//#if -410776975 
import java.awt.SystemColor;
//#endif 


//#if 186734823 
import java.awt.datatransfer.Transferable;
//#endif 


//#if -2130141840 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if 1588281665 
import java.awt.dnd.Autoscroll;
//#endif 


//#if 1904017320 
import java.awt.dnd.DnDConstants;
//#endif 


//#if 605023224 
import java.awt.dnd.DragGestureEvent;
//#endif 


//#if 1314806672 
import java.awt.dnd.DragGestureListener;
//#endif 


//#if -87525792 
import java.awt.dnd.DragGestureRecognizer;
//#endif 


//#if 2017305198 
import java.awt.dnd.DragSource;
//#endif 


//#if -1409923454 
import java.awt.dnd.DragSourceDragEvent;
//#endif 


//#if 912183293 
import java.awt.dnd.DragSourceDropEvent;
//#endif 


//#if 1785434798 
import java.awt.dnd.DragSourceEvent;
//#endif 


//#if -236211942 
import java.awt.dnd.DragSourceListener;
//#endif 


//#if 1471770013 
import java.awt.dnd.DropTarget;
//#endif 


//#if 487235635 
import java.awt.dnd.DropTargetDragEvent;
//#endif 


//#if -1485624914 
import java.awt.dnd.DropTargetDropEvent;
//#endif 


//#if -1211470625 
import java.awt.dnd.DropTargetEvent;
//#endif 


//#if -1560486583 
import java.awt.dnd.DropTargetListener;
//#endif 


//#if 1922493493 
import java.awt.event.ActionEvent;
//#endif 


//#if -1634527693 
import java.awt.event.ActionListener;
//#endif 


//#if -1371808755 
import java.awt.event.InputEvent;
//#endif 


//#if -348620586 
import java.awt.geom.AffineTransform;
//#endif 


//#if -870109662 
import java.awt.geom.Rectangle2D;
//#endif 


//#if 1687692572 
import java.awt.image.BufferedImage;
//#endif 


//#if -270578944 
import java.io.IOException;
//#endif 


//#if 1753128374 
import java.util.ArrayList;
//#endif 


//#if -147997077 
import java.util.Collection;
//#endif 


//#if -219919800 
import javax.swing.Icon;
//#endif 


//#if -673740105 
import javax.swing.JLabel;
//#endif 


//#if -260773378 
import javax.swing.KeyStroke;
//#endif 


//#if 2092816112 
import javax.swing.Timer;
//#endif 


//#if 548475169 
import javax.swing.event.TreeSelectionEvent;
//#endif 


//#if 318880199 
import javax.swing.event.TreeSelectionListener;
//#endif 


//#if -206467936 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if 1856895106 
import javax.swing.tree.TreePath;
//#endif 


//#if -2028225114 
import org.argouml.model.Model;
//#endif 


//#if -336629045 
import org.argouml.ui.TransferableModelElements;
//#endif 


//#if 1447341564 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 704229797 
import org.argouml.uml.diagram.Relocatable;
//#endif 


//#if -1858105494 
import org.argouml.uml.diagram.ui.ActionSaveDiagramToClipboard;
//#endif 


//#if 419205683 
import org.apache.log4j.Logger;
//#endif 


//#if -1426451915 
public class DnDExplorerTree extends 
//#if -65251906 
ExplorerTree
//#endif 

 implements 
//#if -532438808 
DragGestureListener
//#endif 

, 
//#if -942363452 
DragSourceListener
//#endif 

, 
//#if 1619144381 
Autoscroll
//#endif 

  { 

//#if 616924593 
private static final String DIAGRAM_TO_CLIPBOARD_ACTION =
        "export Diagram as GIF";
//#endif 


//#if 1285104186 
private Point	clickOffset = new Point();
//#endif 


//#if 1452251510 
private TreePath		sourcePath;
//#endif 


//#if -1228086699 
private BufferedImage	ghostImage;
//#endif 


//#if -433753288 
private TreePath selectedTreePath;
//#endif 


//#if 873041723 
private DragSource dragSource;
//#endif 


//#if -1871969627 
private static final int AUTOSCROLL_MARGIN = 12;
//#endif 


//#if 2122117943 
private static final long serialVersionUID = 6207230394860016617L;
//#endif 


//#if -116308894 
private static final Logger LOG =
        Logger.getLogger(DnDExplorerTree.class);
//#endif 


//#if -2137708700 
public void dragGestureRecognized(
        DragGestureEvent dragGestureEvent)
    { 

//#if 1487164574 
Collection targets = TargetManager.getInstance().getModelTargets();
//#endif 


//#if 135329840 
if(targets.size() < 1)//1
{ 

//#if -901151177 
return;
//#endif 

} 

//#endif 


//#if 1022824144 
if(LOG.isDebugEnabled())//1
{ 

//#if 1063350511 
LOG.debug("Drag: start transferring " + targets.size()
                      + " targets.");
//#endif 

} 

//#endif 


//#if 707779389 
TransferableModelElements tf =
            new TransferableModelElements(targets);
//#endif 


//#if -448349346 
Point ptDragOrigin = dragGestureEvent.getDragOrigin();
//#endif 


//#if 1923055913 
TreePath path =
            getPathForLocation(ptDragOrigin.x, ptDragOrigin.y);
//#endif 


//#if -755435047 
if(path == null)//1
{ 

//#if 913994343 
return;
//#endif 

} 

//#endif 


//#if -814519281 
Rectangle raPath = getPathBounds(path);
//#endif 


//#if -1972659358 
clickOffset.setLocation(ptDragOrigin.x - raPath.x,
                                ptDragOrigin.y - raPath.y);
//#endif 


//#if 742398299 
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
//#endif 


//#if -1557087144 
lbl.setSize((int) raPath.getWidth(), (int) raPath.getHeight());
//#endif 


//#if 859271389 
ghostImage =
            new BufferedImage(
            (int) raPath.getWidth(), (int) raPath.getHeight(),
            BufferedImage.TYPE_INT_ARGB_PRE);
//#endif 


//#if -885998496 
Graphics2D g2 = ghostImage.createGraphics();
//#endif 


//#if -1302718533 
g2.setComposite(AlphaComposite.getInstance(
                            AlphaComposite.SRC, 0.5f));
//#endif 


//#if -1654814267 
lbl.paint(g2);
//#endif 


//#if -1539323960 
Icon icon = lbl.getIcon();
//#endif 


//#if -882100034 
int nStartOfText =
            (icon == null) ? 0
            : icon.getIconWidth() + lbl.getIconTextGap();
//#endif 


//#if 1391589655 
g2.setComposite(AlphaComposite.getInstance(
                            AlphaComposite.DST_OVER, 0.5f));
//#endif 


//#if -373410888 
g2.setPaint(new GradientPaint(nStartOfText,	0,
                                      SystemColor.controlShadow,
                                      getWidth(), 0, new Color(255, 255, 255, 0)));
//#endif 


//#if -302866563 
g2.fillRect(nStartOfText, 0, getWidth(), ghostImage.getHeight());
//#endif 


//#if 1638258776 
g2.dispose();
//#endif 


//#if 1160542431 
sourcePath = path;
//#endif 


//#if 750833841 
dragGestureEvent.startDrag(null, ghostImage,
                                   new Point(5, 5), tf, this);
//#endif 

} 

//#endif 


//#if 591115753 
public Insets getAutoscrollInsets()
    { 

//#if -97655297 
Rectangle raOuter = getBounds();
//#endif 


//#if 2008538289 
Rectangle raInner = getParent().getBounds();
//#endif 


//#if -601402158 
return new Insets(
                   raInner.y - raOuter.y + AUTOSCROLL_MARGIN,
                   raInner.x - raOuter.x + AUTOSCROLL_MARGIN,
                   raOuter.height - raInner.height
                   - raInner.y + raOuter.y + AUTOSCROLL_MARGIN,
                   raOuter.width - raInner.width
                   - raInner.x + raOuter.x + AUTOSCROLL_MARGIN);
//#endif 

} 

//#endif 


//#if 1528604999 
public void dragOver(DragSourceDragEvent dragSourceDragEvent)
    { 
} 

//#endif 


//#if -713868626 
public DnDExplorerTree()
    { 

//#if -1151662790 
super();
//#endif 


//#if 1069545801 
this.addTreeSelectionListener(new DnDTreeSelectionListener());
//#endif 


//#if -1319393868 
dragSource = DragSource.getDefaultDragSource();
//#endif 


//#if 1227549252 
DragGestureRecognizer dgr =
            dragSource
            .createDefaultDragGestureRecognizer(
                this,
                DnDConstants.ACTION_COPY_OR_MOVE, //specifies valid actions
                this);
//#endif 


//#if 1288569896 
dgr.setSourceActions(
            dgr.getSourceActions() & ~InputEvent.BUTTON3_MASK);
//#endif 


//#if 1802453 
new DropTarget(this, new ArgoDropTargetListener());
//#endif 


//#if -2048780229 
KeyStroke ctrlC = KeyStroke.getKeyStroke("control C");
//#endif 


//#if 34533154 
this.getInputMap().put(ctrlC, DIAGRAM_TO_CLIPBOARD_ACTION);
//#endif 


//#if -1493099176 
this.getActionMap().put(DIAGRAM_TO_CLIPBOARD_ACTION,
                                new ActionSaveDiagramToClipboard());
//#endif 

} 

//#endif 


//#if 508561518 
private boolean isValidDrag(TreePath destinationPath,
                                Transferable tf)
    { 

//#if -261116465 
if(destinationPath == null)//1
{ 

//#if 859752668 
LOG.debug("No valid Drag: no destination found.");
//#endif 


//#if -1925806315 
return false;
//#endif 

} 

//#endif 


//#if -1456064830 
if(selectedTreePath.isDescendant(destinationPath))//1
{ 

//#if 1722105606 
LOG.debug("No valid Drag: move to descendent.");
//#endif 


//#if -957463933 
return false;
//#endif 

} 

//#endif 


//#if -1101271126 
if(!tf.isDataFlavorSupported(
                    TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 

//#if -1118935587 
LOG.debug("No valid Drag: flavor not supported.");
//#endif 


//#if -1272637096 
return false;
//#endif 

} 

//#endif 


//#if -975707033 
Object dest =
            ((DefaultMutableTreeNode) destinationPath
             .getLastPathComponent()).getUserObject();
//#endif 


//#if -1064989797 
if(!Model.getFacade().isANamespace(dest))//1
{ 

//#if -1290279873 
LOG.debug("No valid Drag: not a namespace.");
//#endif 


//#if -1711676830 
return false;
//#endif 

} 

//#endif 


//#if -79122716 
if(Model.getModelManagementHelper().isReadOnly(dest))//1
{ 

//#if 1353662367 
LOG.debug("No valid Drag: "
                      + "this is not an editable UML element (profile?).");
//#endif 


//#if -383649613 
return false;
//#endif 

} 

//#endif 


//#if 1377641837 
if(Model.getFacade().isADataType(dest))//1
{ 

//#if 1147090825 
LOG.debug("No valid Drag: destination is a DataType.");
//#endif 


//#if 827351456 
return false;
//#endif 

} 

//#endif 


//#if 965435918 
try //1
{ 

//#if -1172060322 
Collection transfers =
                (Collection) tf.getTransferData(
                    TransferableModelElements.UML_COLLECTION_FLAVOR);
//#endif 


//#if 1229979142 
for (Object element : transfers) //1
{ 

//#if -945670966 
if(Model.getFacade().isAUMLElement(element))//1
{ 

//#if -1150566212 
if(!Model.getModelManagementHelper().isReadOnly(element))//1
{ 

//#if 511919192 
if(Model.getFacade().isAModelElement(dest)
                                && Model.getFacade().isANamespace(element)
                                && Model.getCoreHelper().isValidNamespace(
                                    element, dest))//1
{ 

//#if 1816695619 
LOG.debug("Valid Drag: namespace " + dest);
//#endif 


//#if 1607935685 
return true;
//#endif 

} 

//#endif 


//#if -454183958 
if(Model.getFacade().isAFeature(element)
                                && Model.getFacade().isAClassifier(dest))//1
{ 

//#if -577737103 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -651977852 
if(element instanceof Relocatable)//1
{ 

//#if 2069099710 
Relocatable d = (Relocatable) element;
//#endif 


//#if 730803907 
if(d.isRelocationAllowed(dest))//1
{ 

//#if -68663659 
LOG.debug("Valid Drag: diagram " + dest);
//#endif 


//#if -650599317 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if 437425602 
catch (UnsupportedFlavorException e) //1
{ 

//#if -493727554 
LOG.debug(e);
//#endif 

} 

//#endif 


//#if -2045224429 
catch (IOException e) //1
{ 

//#if -201963327 
LOG.debug(e);
//#endif 

} 

//#endif 


//#endif 


//#if 247562153 
LOG.debug("No valid Drag: not a valid namespace.");
//#endif 


//#if 1362808320 
return false;
//#endif 

} 

//#endif 


//#if 1135083523 
public void autoscroll(Point pt)
    { 

//#if 984992642 
int nRow = getRowForLocation(pt.x, pt.y);
//#endif 


//#if 619967558 
if(nRow < 0)//1
{ 

//#if 1690159583 
return;
//#endif 

} 

//#endif 


//#if 1771239202 
Rectangle raOuter = getBounds();
//#endif 


//#if 1666862728 
nRow =
            (pt.y + raOuter.y <= AUTOSCROLL_MARGIN)
            ?
            // Yes, scroll up one row
            (nRow <= 0 ? 0 : nRow - 1)
            :
            // No, scroll down one row
            (nRow < getRowCount() - 1 ? nRow + 1 : nRow);
//#endif 


//#if -2147122737 
scrollRowToVisible(nRow);
//#endif 

} 

//#endif 


//#if -1152613999 
public void dragExit(DragSourceEvent dragSourceEvent)
    { 
} 

//#endif 


//#if -1916756697 
public void dragEnter(DragSourceDragEvent dragSourceDragEvent)
    { 
} 

//#endif 


//#if -1774104997 
public void dragDropEnd(
        DragSourceDropEvent dragSourceDropEvent)
    { 

//#if 1535250034 
sourcePath = null;
//#endif 


//#if -134983010 
ghostImage = null;
//#endif 

} 

//#endif 


//#if -1245889774 
public void dropActionChanged(
        DragSourceDragEvent dragSourceDragEvent)
    { 
} 

//#endif 


//#if -846759100 
class ArgoDropTargetListener implements 
//#if -217942473 
DropTargetListener
//#endif 

  { 

//#if -1476223843 
private TreePath	 lastPath;
//#endif 


//#if -923561708 
private Rectangle2D cueLine = new Rectangle2D.Float();
//#endif 


//#if 1820124431 
private Rectangle2D ghostRectangle = new Rectangle2D.Float();
//#endif 


//#if 240497660 
private Color cueLineColor;
//#endif 


//#if -1911543359 
private Point lastMouseLocation = new Point();
//#endif 


//#if -1074509011 
private Timer hoverTimer;
//#endif 


//#if -2022746043 
public void dragEnter(
            DropTargetDragEvent dropTargetDragEvent)
        { 

//#if 1745945893 
LOG.debug("dragEnter");
//#endif 


//#if -1280362929 
if(!isDragAcceptable(dropTargetDragEvent))//1
{ 

//#if -25883270 
dropTargetDragEvent.rejectDrag();
//#endif 

} 
else
{ 

//#if 1409467523 
dropTargetDragEvent.acceptDrag(
                    dropTargetDragEvent.getDropAction());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1110937001 
public boolean isDragAcceptable(
            DropTargetDragEvent dropTargetEvent)
        { 

//#if 1480428316 
if((dropTargetEvent.getDropAction()
                    & DnDConstants.ACTION_COPY_OR_MOVE) == 0)//1
{ 

//#if -936126242 
return false;
//#endif 

} 

//#endif 


//#if 755379627 
Point pt = dropTargetEvent.getLocation();
//#endif 


//#if 364636912 
TreePath path = getPathForLocation(pt.x, pt.y);
//#endif 


//#if -181456736 
if(path == null)//1
{ 

//#if 250279382 
return false;
//#endif 

} 

//#endif 


//#if 1701568197 
if(path.equals(sourcePath))//1
{ 

//#if 1250095647 
return false;
//#endif 

} 

//#endif 


//#if 164767262 
return true;
//#endif 

} 

//#endif 


//#if 275828634 
public ArgoDropTargetListener()
        { 

//#if 1977142505 
cueLineColor =
                new Color(
                SystemColor.controlShadow.getRed(),
                SystemColor.controlShadow.getGreen(),
                SystemColor.controlShadow.getBlue(),
                64
            );
//#endif 


//#if 523253839 
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
//#endif 


//#if -1353313721 
hoverTimer.setRepeats(false);
//#endif 

} 

//#endif 


//#if 389795864 
public boolean isDropAcceptable(
            DropTargetDropEvent dropTargetDropEvent)
        { 

//#if -1608264344 
if((dropTargetDropEvent.getDropAction()
                    & DnDConstants.ACTION_COPY_OR_MOVE) == 0)//1
{ 

//#if -1330484002 
return false;
//#endif 

} 

//#endif 


//#if -1297491337 
Point pt = dropTargetDropEvent.getLocation();
//#endif 


//#if 708589395 
TreePath path = getPathForLocation(pt.x, pt.y);
//#endif 


//#if -1705463101 
if(path == null)//1
{ 

//#if -2083667485 
return false;
//#endif 

} 

//#endif 


//#if -1399313022 
if(path.equals(sourcePath))//1
{ 

//#if 1854639102 
return false;
//#endif 

} 

//#endif 


//#if -1538998655 
return true;
//#endif 

} 

//#endif 


//#if -226109680 
public void drop(DropTargetDropEvent dropTargetDropEvent)
        { 

//#if 1948762981 
LOG.debug("dropping ... ");
//#endif 


//#if 1285527512 
hoverTimer.stop();
//#endif 


//#if 1562950738 
repaint(ghostRectangle.getBounds());
//#endif 


//#if 1962482744 
if(!isDropAcceptable(dropTargetDropEvent))//1
{ 

//#if -1951296929 
dropTargetDropEvent.rejectDrop();
//#endif 


//#if -761668927 
return;
//#endif 

} 

//#endif 


//#if 2124752763 
try //1
{ 

//#if 1428810840 
Transferable tr = dropTargetDropEvent.getTransferable();
//#endif 


//#if -1362232549 
Point loc = dropTargetDropEvent.getLocation();
//#endif 


//#if -1638327801 
TreePath destinationPath = getPathForLocation(loc.x, loc.y);
//#endif 


//#if -1161425230 
if(LOG.isDebugEnabled())//1
{ 

//#if 1733252151 
LOG.debug("Drop location: x=" + loc.x + " y=" + loc.y);
//#endif 

} 

//#endif 


//#if -2022326178 
if(!isValidDrag(destinationPath, tr))//1
{ 

//#if -223742658 
dropTargetDropEvent.rejectDrop();
//#endif 


//#if -1619224992 
return;
//#endif 

} 

//#endif 


//#if 640994568 
Collection modelElements =
                    (Collection) tr.getTransferData(
                        TransferableModelElements.UML_COLLECTION_FLAVOR);
//#endif 


//#if 237586111 
if(LOG.isDebugEnabled())//2
{ 

//#if -1568111810 
LOG.debug("transfer data = " + modelElements);
//#endif 

} 

//#endif 


//#if -1751530029 
Object dest =
                    ((DefaultMutableTreeNode) destinationPath
                     .getLastPathComponent()).getUserObject();
//#endif 


//#if -869396430 
Object src =
                    ((DefaultMutableTreeNode) sourcePath
                     .getLastPathComponent()).getUserObject();
//#endif 


//#if 790447966 
int action = dropTargetDropEvent.getDropAction();
//#endif 


//#if 276863751 
boolean copyAction =
                    (action == DnDConstants.ACTION_COPY);
//#endif 


//#if 145545663 
boolean moveAction =
                    (action == DnDConstants.ACTION_MOVE);
//#endif 


//#if 91764081 
if(!(moveAction || copyAction))//1
{ 

//#if -1855334443 
dropTargetDropEvent.rejectDrop();
//#endif 


//#if 550176695 
return;
//#endif 

} 

//#endif 


//#if 2068783837 
if(Model.getFacade().isAUMLElement(dest))//1
{ 

//#if 312604732 
if(Model.getModelManagementHelper().isReadOnly(dest))//1
{ 

//#if -1228108195 
dropTargetDropEvent.rejectDrop();
//#endif 


//#if -306128833 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1889543423 
if(Model.getFacade().isAUMLElement(src))//1
{ 

//#if 796027690 
if(Model.getModelManagementHelper().isReadOnly(src))//1
{ 

//#if -1898409828 
dropTargetDropEvent.rejectDrop();
//#endif 


//#if -1009800386 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -836166934 
Collection<Object> newTargets = new ArrayList<Object>();
//#endif 


//#if 1796308090 
try //1
{ 

//#if -468363685 
dropTargetDropEvent.acceptDrop(action);
//#endif 


//#if -1440930337 
for (Object me : modelElements) //1
{ 

//#if -1273138529 
if(Model.getFacade().isAUMLElement(me))//1
{ 

//#if 1800853988 
if(Model.getModelManagementHelper().isReadOnly(me))//1
{ 

//#if 1314408105 
continue;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1282491450 
if(LOG.isDebugEnabled())//1
{ 

//#if -1686497242 
LOG.debug((moveAction ? "move " : "copy ") + me);
//#endif 

} 

//#endif 


//#if 548806524 
if(Model.getCoreHelper().isValidNamespace(me, dest))//1
{ 

//#if 540041530 
if(moveAction)//1
{ 

//#if -2066005791 
Model.getCoreHelper().setNamespace(me, dest);
//#endif 


//#if -2136920828 
newTargets.add(me);
//#endif 

} 

//#endif 


//#if -1053124642 
if(copyAction)//1
{ 

//#if 453905030 
try //1
{ 

//#if 65618087 
newTargets.add(Model.getCopyHelper()
                                                   .copy(me, dest));
//#endif 

} 

//#if -2005852952 
catch (RuntimeException e) //1
{ 

//#if 2020302064 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -320057521 
if(me instanceof Relocatable)//1
{ 

//#if -622349199 
Relocatable d = (Relocatable) me;
//#endif 


//#if -134939466 
if(d.isRelocationAllowed(dest))//1
{ 

//#if -457967635 
if(d.relocate(dest))//1
{ 

//#if -1014071306 
ExplorerEventAdaptor.getInstance()
                                    .modelElementChanged(src);
//#endif 


//#if -1812334220 
ExplorerEventAdaptor.getInstance()
                                    .modelElementChanged(dest);
//#endif 


//#if -2108850892 
makeVisible(destinationPath);
//#endif 


//#if 762675049 
expandPath(destinationPath);
//#endif 


//#if -891195696 
newTargets.add(me);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 117985764 
if(Model.getFacade().isAFeature(me)
                                && Model.getFacade().isAClassifier(dest))//1
{ 

//#if -1169264354 
if(moveAction)//1
{ 

//#if 1880981790 
Model.getCoreHelper().removeFeature(
                                    Model.getFacade().getOwner(me), me);
//#endif 


//#if -1455757413 
Model.getCoreHelper().addFeature(dest, me);
//#endif 


//#if -743175886 
newTargets.add(me);
//#endif 

} 

//#endif 


//#if 1532536770 
if(copyAction)//1
{ 

//#if -1138897621 
newTargets.add(
                                    Model.getCopyHelper().copy(me, dest));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1695958870 
dropTargetDropEvent.getDropTargetContext()
                    .dropComplete(true);
//#endif 


//#if -518200179 
TargetManager.getInstance().setTargets(newTargets);
//#endif 

} 

//#if -403790796 
catch (java.lang.IllegalStateException ils) //1
{ 

//#if 1424250963 
LOG.debug("drop IllegalStateException");
//#endif 


//#if -2040205462 
dropTargetDropEvent.rejectDrop();
//#endif 

} 

//#endif 


//#endif 


//#if -570097261 
dropTargetDropEvent.getDropTargetContext()
                .dropComplete(true);
//#endif 

} 

//#if -1664842551 
catch (IOException io) //1
{ 

//#if -1102720123 
LOG.debug("drop IOException");
//#endif 


//#if -2050512495 
dropTargetDropEvent.rejectDrop();
//#endif 

} 

//#endif 


//#if -954720878 
catch (UnsupportedFlavorException ufe) //1
{ 

//#if -339436315 
LOG.debug("drop UnsupportedFlavorException");
//#endif 


//#if 2008131978 
dropTargetDropEvent.rejectDrop();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1618405619 
public void dragExit(DropTargetEvent dropTargetEvent)
        { 

//#if 1008568993 
LOG.debug("dragExit");
//#endif 


//#if -2138091199 
if(!DragSource.isDragImageSupported())//1
{ 

//#if 1299662492 
repaint(ghostRectangle.getBounds());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -285976528 
public void dropActionChanged(
            DropTargetDragEvent dropTargetDragEvent)
        { 

//#if 1616329140 
if(!isDragAcceptable(dropTargetDragEvent))//1
{ 

//#if -451355805 
dropTargetDragEvent.rejectDrag();
//#endif 

} 
else
{ 

//#if 560678743 
dropTargetDragEvent.acceptDrag(
                    dropTargetDragEvent.getDropAction());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 993578793 
public void dragOver(DropTargetDragEvent dropTargetDragEvent)
        { 

//#if 877944946 
Point pt = dropTargetDragEvent.getLocation();
//#endif 


//#if -361617211 
if(pt.equals(lastMouseLocation))//1
{ 

//#if 293988497 
return;
//#endif 

} 

//#endif 


//#if -1655422420 
lastMouseLocation = pt;
//#endif 


//#if 1186156864 
Graphics2D g2 = (Graphics2D) getGraphics();
//#endif 


//#if 872029904 
if(ghostImage != null)//1
{ 

//#if 560449083 
if(!DragSource.isDragImageSupported())//1
{ 

//#if -651823151 
paintImmediately(ghostRectangle.getBounds());
//#endif 


//#if 2074930606 
ghostRectangle.setRect(pt.x - clickOffset.x,
                                           pt.y - clickOffset.y,
                                           ghostImage.getWidth(),
                                           ghostImage.getHeight());
//#endif 


//#if 444440908 
g2.drawImage(ghostImage,
                                 AffineTransform.getTranslateInstance(
                                     ghostRectangle.getX(),
                                     ghostRectangle.getY()), null);
//#endif 

} 
else
{ 

//#if 1924813986 
paintImmediately(cueLine.getBounds());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1488166435 
TreePath path = getPathForLocation(pt.x, pt.y);
//#endif 


//#if 2052024689 
if(!(path == lastPath))//1
{ 

//#if -467429686 
lastPath = path;
//#endif 


//#if 888111418 
hoverTimer.restart();
//#endif 

} 

//#endif 


//#if -570367077 
Rectangle raPath = getPathBounds(path);
//#endif 


//#if 1709254712 
if(raPath != null)//1
{ 

//#if -1452415108 
cueLine.setRect(0,
                                raPath.y + (int) raPath.getHeight(),
                                getWidth(),
                                2);
//#endif 

} 

//#endif 


//#if 1459441444 
g2.setColor(cueLineColor);
//#endif 


//#if 1786847173 
g2.fill(cueLine);
//#endif 


//#if 1567258785 
ghostRectangle = ghostRectangle.createUnion(cueLine);
//#endif 


//#if 1882315304 
try //1
{ 

//#if -1178038718 
if(!dropTargetDragEvent.isDataFlavorSupported(
                            TransferableModelElements.UML_COLLECTION_FLAVOR))//1
{ 

//#if 1038830292 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if -94111040 
return;
//#endif 

} 

//#endif 

} 

//#if -1640094394 
catch (NullPointerException e) //1
{ 

//#if -161512199 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if -194635483 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -1063520819 
if(path == null)//1
{ 

//#if -1723788646 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if -2086081018 
return;
//#endif 

} 

//#endif 


//#if -375149896 
if(path.equals(sourcePath))//1
{ 

//#if 1610020954 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if 1074955206 
return;
//#endif 

} 

//#endif 


//#if -847703358 
if(selectedTreePath.isDescendant(path))//1
{ 

//#if 1471684277 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if 201156065 
return;
//#endif 

} 

//#endif 


//#if 1807450939 
Object dest =
                ((DefaultMutableTreeNode) path
                 .getLastPathComponent()).getUserObject();
//#endif 


//#if -1465180107 
if(!Model.getFacade().isANamespace(dest))//1
{ 

//#if 492903866 
if(LOG.isDebugEnabled())//1
{ 

//#if 1244511358 
String name;
//#endif 


//#if -437726982 
if(Model.getFacade().isAUMLElement(dest))//1
{ 

//#if -636503318 
name = Model.getFacade().getName(dest);
//#endif 

} 
else

//#if 438265017 
if(dest == null)//1
{ 

//#if -998954922 
name = "<null>";
//#endif 

} 
else
{ 

//#if -1511655184 
name = dest.toString();
//#endif 

} 

//#endif 


//#endif 


//#if -775025377 
LOG.debug("No valid Drag: "
                              + (Model.getFacade().isAUMLElement(dest)
                                 ? name + " not a namespace."
                                 :  " not a UML element."));
//#endif 

} 

//#endif 


//#if -2037241309 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if -1205870897 
return;
//#endif 

} 

//#endif 


//#if 243412094 
if(Model.getModelManagementHelper().isReadOnly(dest))//1
{ 

//#if -1958400678 
LOG.debug("No valid Drag: "
                          + "not an editable UML element (profile?).");
//#endif 


//#if -1384845805 
return;
//#endif 

} 

//#endif 


//#if 1475549319 
if(Model.getFacade().isADataType(dest))//1
{ 

//#if 1158290666 
LOG.debug("No valid Drag: destination is a DataType.");
//#endif 


//#if 1231582920 
dropTargetDragEvent.rejectDrag();
//#endif 


//#if -810143820 
return;
//#endif 

} 

//#endif 


//#if -2013659756 
dropTargetDragEvent.acceptDrag(
                dropTargetDragEvent.getDropAction());
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -173029345 
class DnDTreeSelectionListener implements 
//#if 927446725 
TreeSelectionListener
//#endif 

  { 

//#if -88669786 
public void valueChanged(
            TreeSelectionEvent treeSelectionEvent)
        { 

//#if -918526013 
selectedTreePath = treeSelectionEvent.getNewLeadSelectionPath();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

