
//#if -1014013089 
// Compilation Unit of /DeferredBufferedImage.java 
 

//#if -945813523 
package org.argouml.gefext;
//#endif 


//#if -853925783 
import java.awt.AlphaComposite;
//#endif 


//#if -770921087 
import java.awt.Color;
//#endif 


//#if 334987869 
import java.awt.Composite;
//#endif 


//#if 612425493 
import java.awt.Graphics2D;
//#endif 


//#if 1178248309 
import java.awt.Rectangle;
//#endif 


//#if -689267333 
import java.awt.image.BufferedImage;
//#endif 


//#if -114360455 
import java.awt.image.ColorModel;
//#endif 


//#if -1407861662 
import java.awt.image.Raster;
//#endif 


//#if 542807249 
import java.awt.image.RenderedImage;
//#endif 


//#if 1488688376 
import java.awt.image.SampleModel;
//#endif 


//#if -1656264542 
import java.awt.image.WritableRaster;
//#endif 


//#if 161965637 
import java.util.Vector;
//#endif 


//#if 1779740830 
import org.tigris.gef.base.Editor;
//#endif 


//#if 13245044 
import org.apache.log4j.Logger;
//#endif 


//#if 745909052 
public class DeferredBufferedImage implements 
//#if 779992035 
RenderedImage
//#endif 

  { 

//#if -1651494180 
public static final int TRANSPARENT_BG_COLOR = 0x00efefef;
//#endif 


//#if 1752423349 
public static final Color BACKGROUND_COLOR =
        new Color(TRANSPARENT_BG_COLOR, true);
//#endif 


//#if -954455682 
private static final int BUFFER_HEIGHT = 32;
//#endif 


//#if 653056869 
private int x, y;
//#endif 


//#if 549563972 
private int width;
//#endif 


//#if -681323835 
private int height;
//#endif 


//#if 429409088 
private int scale;
//#endif 


//#if 478899004 
private BufferedImage image;
//#endif 


//#if 1615093921 
private Editor editor;
//#endif 


//#if -338243925 
private int scaledBufferHeight;
//#endif 


//#if 553439933 
private int y1, y2;
//#endif 


//#if 1278820362 
private static final Logger LOG =
        Logger.getLogger(DeferredBufferedImage.class);
//#endif 


//#if -1444872788 
public DeferredBufferedImage(Rectangle drawingArea, int imageType,
                                 Editor ed, int scaleFactor)
    { 

//#if 2088879898 
editor = ed;
//#endif 


//#if 616626147 
scale = scaleFactor;
//#endif 


//#if 1666390873 
x = drawingArea.x;
//#endif 


//#if 1155856727 
y = drawingArea.y;
//#endif 


//#if -902600259 
width = drawingArea.width;
//#endif 


//#if 412579113 
height = drawingArea.height;
//#endif 


//#if -650298058 
x = x  * scale;
//#endif 


//#if 895998772 
y = y  * scale;
//#endif 


//#if -596368102 
width = width  * scale;
//#endif 


//#if 225522220 
height = height  * scale;
//#endif 


//#if -153997277 
scaledBufferHeight = BUFFER_HEIGHT * scale;
//#endif 


//#if 1003770878 
image = new BufferedImage(width, scaledBufferHeight, imageType);
//#endif 


//#if 749855545 
y1 = y;
//#endif 


//#if 1771608685 
y2 = y1;
//#endif 

} 

//#endif 


//#if 1055585737 
public Raster getTile(int tileX, int tileY)
    { 

//#if -2090551799 
LOG.debug("getTile x=" + tileX + " y = " + tileY);
//#endif 


//#if 1288776145 
if(tileX < getMinTileX()
                || tileX >= getMinTileX() + getNumXTiles()
                || tileY < getMinTileY()
                || tileY >= getMinTileY() + getNumYTiles())//1
{ 

//#if -146852333 
throw new IndexOutOfBoundsException();
//#endif 

} 

//#endif 


//#if -809102590 
Rectangle tileBounds = new Rectangle(0, (tileY - getMinTileY()
                                             * scaledBufferHeight), width, scaledBufferHeight);
//#endif 


//#if 2100338744 
return getData(tileBounds);
//#endif 

} 

//#endif 


//#if -551916419 
public SampleModel getSampleModel()
    { 

//#if -146897897 
return image.getSampleModel();
//#endif 

} 

//#endif 


//#if 321169792 
public int getNumYTiles()
    { 

//#if 1775525813 
int tiles = (getHeight() + scaledBufferHeight - 1) / scaledBufferHeight;
//#endif 


//#if -70253500 
LOG.debug("getNumYTiles = " + tiles);
//#endif 


//#if -1070307662 
return tiles;
//#endif 

} 

//#endif 


//#if 2104335450 
public int getMinX()
    { 

//#if 1351787883 
LOG.debug("getMinX = 0");
//#endif 


//#if 1123311256 
return 0;
//#endif 

} 

//#endif 


//#if -173114971 
public Object getProperty(String name)
    { 

//#if -1129349204 
return image.getProperty(name);
//#endif 

} 

//#endif 


//#if -509983765 
public ColorModel getColorModel()
    { 

//#if -1611020464 
return image.getColorModel();
//#endif 

} 

//#endif 


//#if 1086652180 
public int getWidth()
    { 

//#if -1440885297 
LOG.debug("getWidth = " + width);
//#endif 


//#if 1434884571 
return width;
//#endif 

} 

//#endif 


//#if 1209414845 
public String[] getPropertyNames()
    { 

//#if 856323979 
return image.getPropertyNames();
//#endif 

} 

//#endif 


//#if 456331845 
public int getTileGridXOffset()
    { 

//#if 1046770360 
LOG.debug("getTileGridXOffset = 0");
//#endif 


//#if 1070468374 
return 0;
//#endif 

} 

//#endif 


//#if 94492166 
public int getTileWidth()
    { 

//#if -634837430 
LOG.debug("getTileWidth = " + width);
//#endif 


//#if 1581249970 
return width;
//#endif 

} 

//#endif 


//#if -2000794816 
private Rectangle offsetWindow(Rectangle clip)
    { 

//#if -812491332 
int baseY = clip.y - y1;
//#endif 


//#if -798430246 
return new Rectangle(clip.x, baseY, clip.width,
                             Math.min(clip.height, scaledBufferHeight - baseY));
//#endif 

} 

//#endif 


//#if 2104336411 
public int getMinY()
    { 

//#if -527606987 
LOG.debug("getMinY = 0");
//#endif 


//#if -1910296371 
return 0;
//#endif 

} 

//#endif 


//#if -1351122618 
public int getTileGridYOffset()
    { 

//#if -779835477 
LOG.debug("getTileGridYOffset = 0");
//#endif 


//#if 1270279594 
return 0;
//#endif 

} 

//#endif 


//#if 725486459 
public Raster getData(Rectangle clip)
    { 

//#if -1446355970 
if(!isRasterValid(clip))//1
{ 

//#if 2097233638 
LOG.debug("Raster not valid, computing new raster");
//#endif 


//#if -1826434568 
computeRaster(clip);
//#endif 

} 

//#endif 


//#if -1694763756 
Rectangle oClip = offsetWindow(clip);
//#endif 


//#if -964770458 
Raster ras = image.getData(oClip);
//#endif 


//#if 1526728516 
Raster translatedRaster = ras.createTranslatedChild(clip.x, clip.y);
//#endif 


//#if 2110872734 
return translatedRaster;
//#endif 

} 

//#endif 


//#if 962942477 
public int getMinTileY()
    { 

//#if -1467746139 
LOG.debug("getMinTileY = 0");
//#endif 


//#if -1630934933 
return 0;
//#endif 

} 

//#endif 


//#if -861895799 
public int getTileHeight()
    { 

//#if -1236457785 
LOG.debug("getTileHeight = " + scaledBufferHeight);
//#endif 


//#if 919270592 
return scaledBufferHeight;
//#endif 

} 

//#endif 


//#if 1641399963 
public WritableRaster copyData(WritableRaster outRaster)
    { 

//#if 373516516 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 1874659845 
private boolean isRasterValid(Rectangle clip)
    { 

//#if -1665314947 
if(clip.height > scaledBufferHeight)//1
{ 

//#if 879043802 
throw new IndexOutOfBoundsException(
                "clip rectangle must fit in band buffer");
//#endif 

} 

//#endif 


//#if 1687354757 
return (clip.y >= y1 && (clip.y + clip.height - 1) < y2);
//#endif 

} 

//#endif 


//#if -169706437 
public int getHeight()
    { 

//#if -1344324028 
LOG.debug("getHeight = " + height);
//#endif 


//#if -775377181 
return height;
//#endif 

} 

//#endif 


//#if -965390344 
public Raster getData()
    { 

//#if 619941512 
LOG.debug("getData with no params");
//#endif 


//#if -1330598136 
return getData(new Rectangle(x, y, width, height));
//#endif 

} 

//#endif 


//#if -1214217422 
private void computeRaster(Rectangle clip)
    { 

//#if -547322074 
LOG.debug("Computing raster for rectangle " + clip);
//#endif 


//#if 810522834 
Graphics2D graphics = image.createGraphics();
//#endif 


//#if -1639203246 
graphics.scale(1.0 * scale, 1.0 * scale);
//#endif 


//#if -717822001 
graphics.setColor(BACKGROUND_COLOR);
//#endif 


//#if -1947747616 
Composite c = graphics.getComposite();
//#endif 


//#if 737434232 
graphics.setComposite(AlphaComposite.Src);
//#endif 


//#if 750301718 
graphics.fillRect(0, 0, width, scaledBufferHeight);
//#endif 


//#if 1800861230 
graphics.setComposite(c);
//#endif 


//#if -2004379677 
graphics.setClip(0, 0, width, scaledBufferHeight);
//#endif 


//#if -40204381 
graphics.translate(0, -clip.y / scale);
//#endif 


//#if -322891870 
y1 = clip.y;
//#endif 


//#if 328358756 
y2 = y1 + scaledBufferHeight;
//#endif 


//#if -1565995342 
editor.print(graphics);
//#endif 


//#if 1917017751 
graphics.dispose();
//#endif 

} 

//#endif 


//#if -1421640543 
public int getNumXTiles()
    { 

//#if 1056381666 
LOG.debug("getNumXTiles = 1");
//#endif 


//#if 1811554844 
return 1;
//#endif 

} 

//#endif 


//#if 962941516 
public int getMinTileX()
    { 

//#if -1441089269 
LOG.debug("getMinTileX = 0");
//#endif 


//#if -742454394 
return 0;
//#endif 

} 

//#endif 


//#if -344831928 
public Vector<RenderedImage> getSources()
    { 

//#if -2132897128 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

