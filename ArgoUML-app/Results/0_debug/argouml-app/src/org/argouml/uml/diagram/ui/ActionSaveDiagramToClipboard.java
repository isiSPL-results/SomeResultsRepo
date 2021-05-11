
//#if 1216465711 
// Compilation Unit of /ActionSaveDiagramToClipboard.java 
 

//#if 7435673 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1676818501 
import java.awt.Color;
//#endif 


//#if 477181155 
import java.awt.Graphics;
//#endif 


//#if -990417199 
import java.awt.Graphics2D;
//#endif 


//#if 1846410573 
import java.awt.Image;
//#endif 


//#if 18165049 
import java.awt.Rectangle;
//#endif 


//#if 455804298 
import java.awt.Toolkit;
//#endif 


//#if 1935023153 
import java.awt.datatransfer.Clipboard;
//#endif 


//#if 1989819858 
import java.awt.datatransfer.ClipboardOwner;
//#endif 


//#if -2019663609 
import java.awt.datatransfer.DataFlavor;
//#endif 


//#if 1275219658 
import java.awt.datatransfer.Transferable;
//#endif 


//#if 1680345619 
import java.awt.datatransfer.UnsupportedFlavorException;
//#endif 


//#if -1177455336 
import java.awt.event.ActionEvent;
//#endif 


//#if 872931084 
import javax.swing.AbstractAction;
//#endif 


//#if -348571940 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1465139959 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1052579421 
import org.argouml.i18n.Translator;
//#endif 


//#if 409191722 
import org.argouml.uml.ui.SaveGraphicsManager;
//#endif 


//#if -836857270 
import org.tigris.gef.base.SaveGIFAction;
//#endif 


//#if -1974717086 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1063758487 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1943814762 
import org.tigris.gef.base.Layer;
//#endif 


//#if 1161972863 
class ImageSelection implements 
//#if -452539871 
Transferable
//#endif 

  { 

//#if -262227487 
private DataFlavor[] supportedFlavors = {
        DataFlavor.imageFlavor,
    };
//#endif 


//#if -216798817 
private Image diagramImage;
//#endif 


//#if 439171626 
public ImageSelection(Image newDiagramImage)
    { 

//#if 99757671 
diagramImage = newDiagramImage;
//#endif 

} 

//#endif 


//#if 838063649 
public boolean isDataFlavorSupported(DataFlavor parFlavor)
    { 

//#if 1822079345 
return (parFlavor.getMimeType().equals(
                    DataFlavor.imageFlavor.getMimeType()) && parFlavor
                .getHumanPresentableName().equals(
                    DataFlavor.imageFlavor.getHumanPresentableName()));
//#endif 

} 

//#endif 


//#if -2006694386 
public synchronized DataFlavor[] getTransferDataFlavors()
    { 

//#if 779104338 
return (supportedFlavors);
//#endif 

} 

//#endif 


//#if 1972394800 
public synchronized Object getTransferData(DataFlavor parFlavor)
    throws UnsupportedFlavorException
    { 

//#if -900861705 
if(isDataFlavorSupported(parFlavor))//1
{ 

//#if -912861995 
return (diagramImage);
//#endif 

} 

//#endif 


//#if 928924581 
throw new UnsupportedFlavorException(DataFlavor.imageFlavor);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -2059759488 
public class ActionSaveDiagramToClipboard extends 
//#if -1471479264 
AbstractAction
//#endif 

 implements 
//#if -186975259 
ClipboardOwner
//#endif 

  { 

//#if -1558708084 
private static final long serialVersionUID = 4916652432210626558L;
//#endif 


//#if 487362049 
public boolean isEnabled()
    { 

//#if -1463127838 
Editor ce = Globals.curEditor();
//#endif 


//#if 950083969 
if(ce == null || ce.getLayerManager() == null
                || ce.getLayerManager().getActiveLayer() == null)//1
{ 

//#if 422400630 
return false;
//#endif 

} 

//#endif 


//#if 1672513284 
Layer layer = ce.getLayerManager().getActiveLayer();
//#endif 


//#if 19670252 
if(layer == null)//1
{ 

//#if -342113727 
return false;
//#endif 

} 

//#endif 


//#if -472813397 
Rectangle drawingArea = layer.calcDrawingArea();
//#endif 


//#if 2065603020 
if(drawingArea.x < 0 || drawingArea.y < 0 || drawingArea.width <= 0
                || drawingArea.height <= 0)//1
{ 

//#if -1518172875 
return false;
//#endif 

} 

//#endif 


//#if 2024659069 
return super.isEnabled();
//#endif 

} 

//#endif 


//#if -819420907 
public void lostOwnership(Clipboard clipboard, Transferable transferable)
    { 
} 

//#endif 


//#if 806216710 
private Image getImage()
    { 

//#if -2114546177 
int scale =
            Configuration.getInteger(
                SaveGraphicsManager.KEY_GRAPHICS_RESOLUTION, 1);
//#endif 


//#if 317399664 
Editor ce = Globals.curEditor();
//#endif 


//#if 1341271565 
Rectangle drawingArea =
            ce.getLayerManager().getActiveLayer()
            .calcDrawingArea();
//#endif 


//#if 1751957630 
if(drawingArea.x < 0 || drawingArea.y < 0 || drawingArea.width <= 0
                || drawingArea.height <= 0)//1
{ 

//#if -1049329066 
return null;
//#endif 

} 

//#endif 


//#if 2131757820 
boolean isGridHidden = ce.getGridHidden();
//#endif 


//#if 1068520281 
ce.setGridHidden(true);
//#endif 


//#if 35967477 
Image diagramGifImage =
            ce.createImage(drawingArea.width * scale,
                           drawingArea.height * scale);
//#endif 


//#if -1721093305 
Graphics g = diagramGifImage.getGraphics();
//#endif 


//#if -1814582218 
if(g instanceof Graphics2D)//1
{ 

//#if 81024429 
((Graphics2D) g).scale(scale, scale);
//#endif 

} 

//#endif 


//#if 1214230470 
g.setColor(new Color(SaveGIFAction.TRANSPARENT_BG_COLOR));
//#endif 


//#if 781568814 
g.fillRect(0, 0, drawingArea.width * scale, drawingArea.height * scale);
//#endif 


//#if -1795562315 
g.translate(-drawingArea.x, -drawingArea.y);
//#endif 


//#if 1329802747 
ce.print(g);
//#endif 


//#if 512685861 
ce.setGridHidden(isGridHidden);
//#endif 


//#if -1797735638 
return diagramGifImage;
//#endif 

} 

//#endif 


//#if -1572655411 
public ActionSaveDiagramToClipboard()
    { 

//#if -2001434512 
super(Translator.localize("menu.popup.copy-diagram-to-clip"),
              ResourceLoaderWrapper.lookupIcon("action.copy"));
//#endif 

} 

//#endif 


//#if 996884838 
public void actionPerformed(ActionEvent actionEvent)
    { 

//#if 142773157 
Image diagramGifImage = getImage();
//#endif 


//#if -1747506964 
if(diagramGifImage == null)//1
{ 

//#if -486895818 
return;
//#endif 

} 

//#endif 


//#if 1397855328 
Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//#endif 


//#if -2095216924 
clipboard.setContents(new ImageSelection(diagramGifImage), this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

